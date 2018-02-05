## Building & Running Docker Container for Apache Tomcat
***
  1. Place the `Dockerfile` & the `tomcat` directory containing `run.sh`, and `tomcat-users.xml` in a folder.
  2. Run the following command:
        * $ `sudo docker build -t <image-Name> <path (usually .[dot])>`
  3. Run the container using the following command:
        * $ `sudo docker run -d -p 8080:8080 <image name>`
     	   - TAG: '-d' is to detach and output the container ID that you may need
	   - TAG: '-p' is to specify the port number
           - TAG: <image name> is when you entered in step 2
  4. This should run the tomcat server at localhost:8080

## Testing Using RESTFUL API
  5. Currently, the container's IP address along with the port can be used to access the running server. However, modification to `context.xml` is needed to access the resources. As it is, a 403: Access Denied Error will display.
     Useful Link: https://tomcat.apache.org/tomcat-8.0-doc/config/context.html

## PostgreSQL Access
  * PosgreSQL plugin is already downloaded and and can be found under `${CATALINA_HOME}/lib/postgres-*.jar`
  * Testing using PostgreSQL queries is needed to confirm the functionality.
## Accessing the Container

  6. To get into the container simply copy the container ID from **step 3** and run this
      - $ `sudo docker exec -it <container ID> bash`

## Finding Container's IP Address

  7. If you need to get the IP address of the container, then run the following
      - $ `sudo docker inspect <container ID>`
  8. You will see the IPAddress towards the end of the output

## Installing VIM in the container (It is installed already)

  9. simply run following once you are inside the container:
      - $ `apt -y update && apt -y install vim`
