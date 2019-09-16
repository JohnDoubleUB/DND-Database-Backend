#!/bin/bash
host_port=9000
container_port=9000

imageName=dnddb:latest
containerName=dnddb-container

# Check if the image exists, only build if it does!

if [ "$(docker images -q $imageName)" ]; then
  echo Run new container...
  docker run -d -p ${host_port}:${container_port} --name $containerName $imageName
fi


#
#if [ "$(docker ps -q -f name=$containerName)" ]; then
#    if [ ! "$(docker ps -aq -f status=exited -f name=$containerName)" ]; then
#        # cleanup
#        echo Delete old container...
#        docker rm -f $containerName
#    fi
#fi
#
#if [[ "$(docker images -q $imageName 2> /dev/null)" != "" ]]; then
#  echo Run new container...
#  docker run -d -p ${host_port}:${container_port} --name $containerName $imageName
#fi