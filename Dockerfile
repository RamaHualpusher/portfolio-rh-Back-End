FROM amazoncorretto:8
MAINTAINER portfolio
COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
