#!/bin/bash

#Change this to match where your deploy file is!
source /home/johndoubleub/backend/deploy.sh

#Put this inside /etc/init.d/
#Then run this to setup the file properly
# chmod +x /etc/init.d/boot-deploy.sh

#If it still doesn't work then create a sim link
# ln -s /etc/init.d/boot-deploy.sh /etc/rc.d/
