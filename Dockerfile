FROM gradle:6.7.1-jdk15 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:15

ARG PROFILE
ARG ADITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADITIONAL_OPTS=${ADITIONAL_OPTS}

EXPOSE 8080
EXPOSE 5005

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]