#!/bin/bash
project=${PWD##*/}
host_port=9000
container_port=9000
mvn clean package
docker stop ${project}
docker rm ${project}
docker build -t dnddb .
docker run -d -p ${host_port}:${container_port} dnddb

##I don't know how much of this will work but I did manage to get docker to work so thats a start!