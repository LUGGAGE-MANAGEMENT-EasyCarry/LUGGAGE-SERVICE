FROM openjdk:17-alpine AS build
WORKDIR /app
ADD build/libs/lugagge-system-backoffice-api-0.0.1-SNAPSHOT.jar lugagge-system-backoffice-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","lugagge-system-backoffice-api-0.0.1-SNAPSHOT.jar"]