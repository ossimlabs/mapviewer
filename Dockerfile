FROM adoptopenjdk/openjdk8:alpine-slim
COPY ./data /data
COPY build/libs/mapviewer-0.1.jar /mapviewer.jar
EXPOSE 8080
CMD ["java", "-jar", "mapviewer.jar"]
