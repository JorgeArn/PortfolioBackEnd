FROM amazoncorretto:17
MAINTAINER jlarn
COPY target/miportfolio-0.0.1-SNAPSHOT.jar miportfolio-app.jar
ENTRYPOINT ["java","-jar","/miportfolio-app.jar"]