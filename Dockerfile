FROM openjdk:8
COPY ./data /data
COPY build/libs/mapviewer-*.jar /mapviewer.jar
EXPOSE 8080
CMD ["java", "-jar", "mapviewer.jar"]
