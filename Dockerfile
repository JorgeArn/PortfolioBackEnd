FROM amazoncorretto:17-alpine-jdk
MAINTAINER jlarn
COPY target/miportfolio-0.0.1-SNAPSHOT.jar miportfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/miportfolio-0.0.1-SNAPSHOT.jar"]