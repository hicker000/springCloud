#!/bin/bash

echo $(pwd)
git checkout -B now $1
echo "use maven to build the project"
mvn install
echo "install result:"$?
mkdir -p target/docker
cp target/$2.jar target/docker/
cp dockerfile/Dockerfile target/docker/
cd target/docker
echo "stop & delete old container which name is "$2
docker stop $2 && docker rm $2
echo "build image for "$2
# netip=$(curl ident.me) && echo "server public network ip is "$netip
docker build --build-arg netip=$5 --build-arg profile=$4 --build-arg registerip=$7 --build-arg projectname=$2 -t $2 .
echo "image "$2" build success, getting started launch"
docker run -d -p $6:$6 -v /home/logs/$3/$2/:/home/logs/$2/ -v /etc/localtime:/etc/localtime:ro --privileged --name $2 $2
echo "container "$2" is starting, please wait a moment"