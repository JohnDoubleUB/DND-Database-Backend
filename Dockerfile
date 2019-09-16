FROM maven as build
WORKDIR /build
COPY . .
RUN mvn package -Dmaven.test.skip=true
CMD mvn spring-boot:run
EXPOSE 9000
