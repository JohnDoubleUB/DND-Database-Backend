#!/bin/bash
java -jar App.jar & echo $! > ./pid.file &
#Starts the app and saves the process id in a file
