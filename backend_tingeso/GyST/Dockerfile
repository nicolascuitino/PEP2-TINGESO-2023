FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} GyST-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/GyST-0.0.1-SNAPSHOT.jar"]
