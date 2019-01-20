FROM gradle:latest
EXPOSE 8080
WORKDIR /src
USER root
ADD src src
ADD gradle gradle
ADD build.gradle build.gradle
ADD gradlew gradlew
ADD .gradle .gradle
ADD settings.gradle settings.gradle
RUN "ls"
EXPOSE 8090
ENTRYPOINT ["./gradlew", "bootRun"]

