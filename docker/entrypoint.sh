#!/bin/bash

# you can do some thing when container startup
# echo "Welcome, you can do some thing when container startup in /home/entrypoint.sh" > /home/zoltar/readme
# echo "Welcome to zoltar-centos, enjoy it !"


# after prepared
cd /opt/
java -jar *.jar
