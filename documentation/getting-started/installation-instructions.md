# Installation Instructions

## Prerequisite Software need to run and develop on this project

* [Node.js](https://nodejs.org/en/download/)
* [npm](https://www.npmjs.com/) (which npm should come with Node) or [Yarn](https://yarnpkg.com/en/docs/getting-started). Either of these work.
* [Docker CE (Community Edition)](https://docs.docker.com/install/)
* [docker-compose](https://docs.docker.com/compose/install/)
* [Maven](https://maven.apache.org/download.cgi)

Node is used for managing the dependencies of the front-end codebases, while Maven is used for managing the dependencies and
built of the back-end server.

Docker allows for the easy startup of the applications. Docker compose allows you start multiple Docker containers with just
one command. For more information, read the [Docker documentation](../docker-and-docker-compose).

## Importing a Spring Project in Eclipse (Using Eclipse Oxygen)

1. Open Eclipse and select 'File -> Import'.
2. Open the "Maven" folder and select "Import Existing Maven Projects" and click "Next".
3. Choose the Spring project directory (in this case donation-api/) and select the project's pom.xml file in the checkbox menu.
4. Click "Finish". Your project should have imported successfully!

## IntelliJ (Using Github project) - Setting up the back-end

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

## Connecting to Docker Database

For testing and ensuring that the Docker database works, you can connect to it. **It is strongly recommended
that the database is ran via docker-compose**, so that your port number and host are always consistent.

For connecting to the database, use the following information:

* Host: localhost
* Port: 5050
* Username: docker
* Password: docker
