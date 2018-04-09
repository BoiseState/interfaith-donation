## To get the project up and running all you need is docker.

To install docker see [Docker](https://www.docker.com/community-edition).
Once docker has been setup, read getting-started.md for how to get docker running.

## Importing a Spring Project

1. Eclipse (Using Eclipse Oxygen)
   Open Eclipse and select 'File -> Import'.
2. Open the "Maven" folder and select "Import Existing Maven Projects" and click "Next".
3. Choose the Spring project directory (in this case donation-api/) and select the project's pom.xml file in the checkbox menu.
4. Click "Finish". Your project should have imported successfully!

## IntelliJ (Using Github project)

1. Clone the Github project.
2. Open IntelliJ and click Import Project.
3. Navigate to the cloned directory and select the pom.xml file inside the donation-api folder then hit ok.
4. A window called Import Project from Maven will pop up. Simply hit next.
5. Select the project shown on the list. (Eg. org.interfaithsanctuary:donation-api:0.0.1-SNAPSHOT) and hit Next.
6. If you do not see default SDK on the list that means you have to click on the + icon to add your JAVA_HOME path.
7. Click + then select JDK. Select the folder where Java is installed (eg. jdk1.8.0_162) then click next.
8. Name the project OR leave it as donation-api.
9. Then click on finish.
10. Your project should be imported. Expand & select org.interfaithsanctuary:donation-api then do build & run.

## Starting Docker Container for Windows (for PostgreSQL database)

1. Install Docker (this requires Windows Pro) otherwise you should probably use a Linux VM
2. Create a new docker image using docker build -t [container name] .
3. Run your new image docker run -d [container name]
4. Continue with next set of steps

## Configuring IntelliJ with Docker Container Running PSQL DB

1. Make sure that you have the container ID by running docker ps.
2. Run docker inspect <container-ID> to get the IP address of your the docker container. Make sure to save it.

* INFO: You will see a long output but if you look at the end, there will be IPAddress label (e.g: "IPAddress": "172.17.0.2").
* INFO: You may see the link at step 10 for configuration with pictures.

3. Open IntelliJ and follow this path: View -> Tool Windows -> Database. (An attached window will pop up).
4. Click on the + sign, select Data Source -> PostgreSQL (another separate window will pop up).
5. If there is the message Download missing driver files in the lower part of the Data Sources and Drivers dialog that opens, click the Download link.
6. Use the following information to fill the page and click Test Connection

* The Name & URL field will automatically change based on your input below
* Host: IP address obtained from step 8
* Port: 5432 (Should be filled already)
* Database: charity
* User: docker
* Password: (empty)

7. Once you click on Test Connection you will see a green text saying Successful.
8. Click apply and then ok.
9. You should see the charity@containerIP on the Database window which you can expand to see the content of the charity database.
10. FYI: The tab on the left named charity@containerIP is where you execute the queries and the bottom window is the console.

* MORE HELP: You may - Click here to see the configuration with pictures.
