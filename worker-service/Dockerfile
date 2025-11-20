FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/worker-service-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
