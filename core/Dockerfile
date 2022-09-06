ARG LOGSTASH_PATH=defaultHost

FROM amazoncorretto:17.0.4-alpine AS base_stage
EXPOSE 8080

FROM gradle:7.5-jdk17-alpine as build_stage
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY ./src $APP_HOME/src
COPY ./gradle $APP_HOME/gradle
COPY ./build.gradle ./settings.gradle $APP_HOME/

RUN gradle build --no-daemon

FROM base_stage AS final_stage
ENV LOGSTASH_DESTINATION=${LOGSTASH_PATH}
ENV ARTIFACT_NAME=core-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY --from=build_stage $APP_HOME/build/libs/$ARTIFACT_NAME ./$ARTIFACT_NAME
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}