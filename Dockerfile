FROM adoptopenjdk/openjdk8:alpine-slim
COPY ./data /data
COPY build/libs/mapviewer-*.jar /mapviewer.jar
EXPOSE 8080
CMD ["java", "-jar", "mapviewer.jar"]
