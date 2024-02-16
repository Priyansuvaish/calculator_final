FROM openjdk:8
COPY ./target/Calculator-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "Calculator-1.0-SNAPSHOT.jar"]
