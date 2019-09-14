#!/bin/bash
kill $(cat ./pid.file)
#Kills the app using the saved process id