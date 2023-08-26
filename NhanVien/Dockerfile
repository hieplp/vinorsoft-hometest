FROM adoptopenjdk/openjdk11:latest

WORKDIR /app
COPY . .
RUN ./gradlew clean build

CMD ./gradlew bootRun
