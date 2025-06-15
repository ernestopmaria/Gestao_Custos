# Etapa 1: Build com Maven
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final mais leve com apenas o JAR
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
