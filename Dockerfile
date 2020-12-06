FROM openjdk:15

ARG PROFILE
ARG ADITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADITIONAL_OPTS=${ADITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /build/libs/BancoDigital-0.0.1-SNAPSHOT.jar BancoDigital-0.0.1-SNAPSHOT.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8080
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar BancoDigital-0.0.1-SNAPSHOT.jar --spring.profiles.active=${PROFILE}