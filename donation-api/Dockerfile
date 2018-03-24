FROM maven:latest
WORKDIR /usr/src/donation-api
COPY pom.xml .
RUN mvn -B -f pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
COPY . .
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package -DskipTests

FROM java:8-jdk-alpine
WORKDIR /app
COPY --from=0 /usr/src/donation-api/target/donation-api-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "/app/donation-api-0.0.1-SNAPSHOT.jar"]
CMD ["--spring.profiles.active=docker"]
