FROM amazoncorretto:11-alpine-jdk
MAINTAINER jlarn
COPY target/miportfolio-0.0.1-SNAPSHOT.jar miportfolio-app.jar
ENTRYPOINT ["java","-jar","/miportfolio-app.jar"]
EXPOSE 8080