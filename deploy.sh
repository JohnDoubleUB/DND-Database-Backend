#!/bin/bash
host_port=9000
container_port=9000

imageName=dnddb:latest
containerName=dnddb-container

docker build -t $imageName -f Dockerfile  .

# run your container
echo Run new container...
docker run -d -p ${host_port}:${container_port} --name $containerName $imageName