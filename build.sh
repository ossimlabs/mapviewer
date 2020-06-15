#!/bin/sh
gradle assemble
docker build -t mapviewer .
