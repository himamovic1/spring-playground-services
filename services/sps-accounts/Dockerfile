FROM amazoncorretto:17.0.4-alpine AS base_stage

FROM gradle:7.5-jdk17-alpine as build_stage

ENV APP_HOME /usr/app
WORKDIR $APP_HOME

COPY ./src $APP_HOME/src
COPY ./gradle $APP_HOME/gradle
COPY ./build.gradle ./settings.gradle $APP_HOME/

RUN gradle build --no-daemon

FROM base_stage AS final_stage

ENV ARTIFACT_NAME sps-accounts-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/app
WORKDIR $APP_HOME

COPY entrypoint.sh .
COPY --from=build_stage $APP_HOME/build/libs/$ARTIFACT_NAME ./$ARTIFACT_NAME

ENTRYPOINT [ "./entrypoint.sh" ]