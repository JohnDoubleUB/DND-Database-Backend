FROM maven as maven
WORKDIR /build
COPY . .
RUN mvn spring-boot:run
EXPOSE 9000
