#!/bin/bash
host_port=9000
container_port=9000

imageName=dnddb:latest
containerName=dnddb-container

docker build -t $imageName -f Dockerfile  .

## Logic to ensure docker is correctly handled!
if [ ! "$(docker ps -q -f name=$containerName)" ]; then
    if [ "$(docker ps -aq -f status=exited -f name=$containerName)" ]; then
        # cleanup
        echo Delete old container...
        docker rm -f $containerName
    fi
    # run your container
    echo Run new container...
    docker run -d -p ${host_port}:${container_port} --name $containerName $imageName
fi