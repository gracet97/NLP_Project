#Dockerfile

#FROM creates a layer from the ubuntu:18.04 Docker image.
FROM ubuntu:18.04

MAINTAINER Grace Turkington "graceturkington97@gmail.com"

#COPY adds files from your Docker client’s current directory.
COPY . /app

WORKDIR .

#Inform Docker that the container is listening on the specified port at runtime.
EXPOSE 8080

#CMD specifies what command to run within the container.
CMD python NLP_Project.py

#Copy the rest of your app's source code from your host to your image filesystem.
COPY . .