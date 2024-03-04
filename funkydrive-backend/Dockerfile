# FROM maven:3.8.2-jdk-8 # for Java 8
FROM maven:3.8.5-openjdk-17

WORKDIR /app
COPY . .
RUN mvn clean install
EXPOSE 3000
CMD mvn spring-boot:run