FROM eclipse-temurin:17-jre-alpine AS builder

LABEL maintainer="Sebastian Dyjach"
ARG USER_NAME=fullstejk
ARG USER_WORKDIR=/homedir

RUN apk add curl
COPY build/libs/fullstejk-0.0.1-SNAPSHOT.jar .

RUN  --mount=type=cache,target=/var/cache/apt
RUN addgroup -S ${USER_NAME} \
    && adduser -S ${USER_NAME} -s /bin/false -G ${USER_NAME} \
    && mkdir -p ${USER_WORKDIR} \
    && chown -R ${USER_NAME}:${USER_NAME} ${USER_WORKDIR}

EXPOSE 8085
CMD ["java", "-jar", "fullstejk-0.0.1-SNAPSHOT.jar"]


