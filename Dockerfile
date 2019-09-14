FROM maven as maven
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
COPY --from=maven /build/target/dnd-database-1.0-SNAPSHOT.jar /opt/dnddatabase/app.jar
ENTRYPOINT ["java", "-jar", "/opt/dnddatabase/app.jar"]
