FROM amazoncorretto:8-alpine-jdk

COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 10000

ENTRYPOINT ["java", "-jar", "app.jar"]
