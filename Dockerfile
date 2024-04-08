FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app
COPY pom.xml .
RUN mvn clean install -DskipTests
COPY . .

CMD ["mvn", "spring-boot:run"]