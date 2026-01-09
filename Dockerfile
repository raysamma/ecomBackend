# 1. Build Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# 2. Run Stage
FROM eclipse-temurin:21-jdk-alpine
# CAUTION: Your pom.xml says artifactId is 'demo' and version is '0.0.1-SNAPSHOT'
# So the jar file name will be:
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]