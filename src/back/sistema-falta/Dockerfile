FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . /app
EXPOSE 8080
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
ARG JAR_FILE=target/*.jar
COPY --from=build /app/${JAR_FILE} /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]