FROM java:8-jdk-alpine
COPY ./target/dnd-database1.0-SNAPSHOT.jar /usr/app/
ENTRYPOINT ["java","-jar","usr/app/dnd-database1.0-SNAPSHOT.jar"]
