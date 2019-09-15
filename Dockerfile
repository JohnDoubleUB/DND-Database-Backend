FROM maven as build
WORKDIR /build
COPY . .
RUN mvn package
CMD mvn spring-boot:run
EXPOSE 9000
