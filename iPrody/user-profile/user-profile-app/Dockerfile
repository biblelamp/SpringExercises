FROM maven:3.9.8-amazoncorretto-21-al2023 AS build

WORKDIR /build

COPY e2e/pom.xml e2e/

COPY pom.xml .
COPY user-profile-app/pom.xml user-profile-app/
COPY user-profile-app/src user-profile-app/src

RUN mvn -B -pl user-profile-app dependency:resolve
RUN mvn -B -pl user-profile-app dependency:resolve-plugins

RUN mvn -B -pl user-profile-app clean package -Dcheckstyle.skip

RUN VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout) && \
    cp user-profile-app/target/user-profile-app-${VERSION}.jar user-profile-app.jar

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /build/user-profile-app.jar ./user-profile-app.jar

EXPOSE 8080 8443

CMD ["java", "-jar", "user-profile-app.jar"]