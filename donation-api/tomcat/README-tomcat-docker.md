## Building & Running Docker Container for Apache Tomcat
***
Step 1: Place the Dockerfile and tomcat directory containing postgresql-42.2.1.jar, run.sh, and tomcat-users.xml
Step 2: Run the following command:
	$ sudo docker build -t <image-Name> <path (usually .[dot])>
Step 3: To run the container simple run the following command:
	$ sudo docker run -d -p 8080:8080 <image name>
     	    TAG: '-d' is to detach and output the container ID that you may need
	    TAG: '-p' is to specify the port number
Step 4: This should run the tomcat server at localhost:8080

## Testing Using RESTFUL API
Step 5: 

## Accessing the container

Step 5: If you need to get into the container simply copy the ID from step 3 and run this
	$ sudo docker exec -it <container ID> bash

## Finding Container's IP Address

Step 6: If you need to get the IP address of the container, then run the following
	$ sudo docker inspect <container ID>
Step 7: You will see the IPAddress towards the end of the output

## Installing VIM in the container

Step 8: simply run following once you are inside the container:
	$ apt -y update && apt -y install vim
