#!/bin/bash
host_port=9000
container_port=9000

imageName=dnddb:latest
containerName=dnddb-container

# Check if the image exists, only build if it does!

docker rm -f $containerName

echo Run new container...
docker run -d -p ${host_port}:${container_port} --name $containerName $imageName
