package com.javaScrpit.Pc2.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> home() {
        String html = """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Pc2</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        margin: 0;
                        min-height: 100vh;
                        display: grid;
                        place-items: center;
                        background: #f5f7fb;
                        color: #1f2937;
                    }
                    main {
                        max-width: 640px;
                        padding: 2rem;
                        background: white;
                        border-radius: 16px;
                        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
                        text-align: center;
                    }
                    a {
                        color: #2563eb;
                        text-decoration: none;
                    }
                </style>
            </head>
            <body>
                <main>
                    <h1>Sistema de Matrículas</h1>
                    <p>La API está activa. Los endpoints disponibles están bajo <strong>/api</strong>.</p>
                    <p><a href="/api/cursos">Ver catálogo de cursos</a></p>
                </main>
            </body>
            </html>
            """;

        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_HTML)
            .body(html);
    }
}