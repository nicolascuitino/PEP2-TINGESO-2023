FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} acopio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/acopio-0.0.1-SNAPSHOT.jar"]
