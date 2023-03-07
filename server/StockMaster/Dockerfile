#FROM ubuntu:latest
FROM eclipse-temurin:11-alpine
LABEL authors="Rosa"

RUN mkdir /app

WORKDIR /app

COPY target/stockmaster.jar /app/stockmaster.jar

EXPOSE 8080

CMD java -jar stockmaster.jar

# Build the image