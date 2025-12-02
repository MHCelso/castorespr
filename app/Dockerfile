FROM openjdk:17.0.2-jdk
WORKDIR /app
COPY target/app-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
