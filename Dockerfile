FROM amazoncorretto:8-alpine-jdk

COPY target/portfolio-0.0.1-SNAPSHOT.jar /opt/portfolio-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/opt/portfolio-0.0.1-SNAPSHOT.jar"]