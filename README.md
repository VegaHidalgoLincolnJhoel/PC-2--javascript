# PC 2- javascript

CONTEXTO DEL PROYECTO:
Estoy desarrollando una aplicación Fullstack para la universidad y necesito ayuda para continuar. 

Mi arquitectura actual es:
1. BACKEND: Desarrollado en Spring Boot (Java). Está configurado en el puerto local 8085 (debido a que el puerto 8080 estaba ocupado y bloqueado por restricciones de administrador en las PCs de la universidad). Está conectado a una base de datos PostgreSQL alojada en Render.
2. FRONTEND: Desarrollado en JavaScript / HTML puro.

Estado actual del despliegue:
- La base de datos (PostgreSQL) y el Backend (Java - Web Service) ya están configurados en Render.
- Las URLs del Frontend en local apuntaban a 'http://localhost:8080/api/...', pero ya sé que debo cambiarlas por la URL pública del "Web Service" de Java en Render para que funcione en producción.
- Mi objetivo actual es desplegar el Frontend en Vercel conectándolo a ese repositorio de GitHub y vinculándolo al Backend de Render.
