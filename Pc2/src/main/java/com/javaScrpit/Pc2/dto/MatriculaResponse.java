package com.javaScrpit.Pc2.dto;

public record MatriculaResponse(
    Long id,
    String nombre,
    String codigoEstudiante,
    String turno,
    CursoResponse curso
) {
    public record CursoResponse(
        Long id,
        String codigo,
        String nombre,
        int creditos,
        String modalidad,
        int vacantes
    ) {}
}