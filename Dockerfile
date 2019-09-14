FROM maven as maven
WORKDIR /build
COPY . .
RUN mvn package
CMD mvn spring-boot:run
EXPOSE 9000
