FROM openjdk:17-jdk

WORKDIR /app

COPY app/build/libs/serviceRestDispositivo-0.0.1-SNAPSHOT.jar /app/serviceRestDispositivo.jar

CMD [ "java", "-jar", "serviceRestDispositivo.jar" ]