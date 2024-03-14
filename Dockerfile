FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /FiapTravel-1

COPY . /FiapTravel-1

RUN mvn package

FROM openjdk:17-jdk-slim

COPY --from=build /FiapTravel-1/target/*.jar /FiapTravel-1/FiapTravel-1.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./unrandom", "-jar", "/FiapTravel-1/FiapTravel-1.jar"] 

EXPOSE 8082

