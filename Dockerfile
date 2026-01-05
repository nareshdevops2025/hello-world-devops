FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/hello-world.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]