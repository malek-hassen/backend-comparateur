FROM ubuntu:latest
LABEL authors="Malek Fradi"

ENTRYPOINT ["top", "-b"]
FROM eclipse_temurin:17-jdk-jammy AS build
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:resolve
#RUN mvn dependency:go-offline -B

COPY src ./src
RUN ./mvnw package -DskipTests
FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache bash



FROM eclipse_temurin:17-jdk-jammy
WORKDIR /app

COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar  ./app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
#CMD ["java", "-jar", "/app/app.jar"]