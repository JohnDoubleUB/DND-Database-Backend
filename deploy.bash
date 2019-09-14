#!/bin/bash
project=${PWD##*/}
author=johndoubleub
host_port=9000
container_port=9000
mvn clean package
docker stop ${project}
docker rm ${project}
docker build -t ${author}/${project} .
docker run -d -p ${host_port}:${container_port} --name ${project} ${author}/${project}
docker rmi $(docker images --quiet --filter "dangling=true")
