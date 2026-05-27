# Paso 1: Compilar la aplicación usando Maven y Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Paso 2: Ejecutar la aplicación con Java 21 de Eclipse Temurin
FROM eclipse-temurin:21-jr-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
