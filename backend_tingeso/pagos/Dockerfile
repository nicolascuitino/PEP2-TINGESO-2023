FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pagos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/pagos-0.0.1-SNAPSHOT.jar"]
