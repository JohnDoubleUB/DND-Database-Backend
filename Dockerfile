FROM java:8-jdk-alpine
COPY ./target/dnd-database0.0.1.jar /usr/app/
ENTRYPOINT ["java","-jar","usr/app/dnd-database0.0.1.jar"]
