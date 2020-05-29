#Dockerfile

#FROM creates a layer from the ubuntu:18.04 Docker image.
FROM ubuntu:18.04

#MAINTAINER sets the Author field of the image 
MAINTAINER Grace Turkington "graceturkington97@gmail.com"

#&& \ isn’t Docker specific, but tells Linux to run the next command as part of the existing line 
#instead of using multiple RUN directives, you can use just one
RUN apt-get update -y && \
    apt-get install -y python-pip python-dev

#COPY copies files from the first parameter - the source . - 
#to the destination parameter - in this case, /app
#Copy the requirements.txt file first to leverage Docker cache
COPY ./requirements.txt /app/requirements.txt

#WORKDIR sets the working directory 
#All following instructions operate within this directory
WORKDIR /app

RUN pip install -r requirements.txt

COPY . /app

#ENTRYPOINT configures the container to run as an executable
#Only the last ENTRYPOINT instruction executes
ENTRYPOINT [ "python" ]

CMD [ "app.py" ]