#!/bin/bash

containerName=dnddb-container

# Check if docker is already running. kill if it is!
if [ ! "$(docker ps -q -f name=$containerName)" ]; then
    if [ "$(docker ps -aq -f status=exited -f name=$containerName)" ]; then
        # cleanup
        echo Delete old container...
        docker rm -f $containerName
    fi
fi