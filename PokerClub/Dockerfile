FROM openjdk:17.0.1-jdk-slim

ARG JAR_FILE=build/libs/*SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} poker_club.jar

ENTRYPOINT ["java","-jar","poker_club.jar"]
