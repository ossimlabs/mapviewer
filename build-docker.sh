#!/bin/sh
gradle assemble
docker build -t nexus-docker-public-hosted.ossim.io/mapviewer . 
docker push nexus-docker-public-hosted.ossim.io/mapviewer 


