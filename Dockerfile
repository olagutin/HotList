FROM maven:3.8.4-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
COPY --from=build /target/HotList-0.0.1-SNAPSHOT.jar hotlist.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","hotlist.jar"]