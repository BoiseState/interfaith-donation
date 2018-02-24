# Using Docker / Docker-Compose on the Interfaith Donation Application

Docker is a great way to help automate both developer and production environments,
and helps solve the issue of working on a team of developers that have different
environments and systems. For more information on Docker, check out [their about page](https://www.docker.com/what-docker).

Docker is being used for this exact purpose on the interfaith application. It helps
the developers not only ensure that what they work on will match what's in production,
but also help setup an environment for new developers automatically.

## How to start the application using Docker

Docker allows you to build all the containers and images for an application seperately
one-by-one and run them. This is very error-prone, and having to start up the containers
everytime manually can take a lot of time.

With that comes Docker Compose! Docker Compose is a tool developed by the Docker team
that lets us easily automate the building and running of several Docker containers, and
ensures that these containers are able to connect to each other. For more info on Docker Compose,
check out the [overview page](https://docs.docker.com/compose/overview/).

Docker Compose is the tool we use to help with running the Docker environment, and it is very easy
to run. Assuming you have Docker Compose installed (if not, [you can install it here](https://docs.docker.com/compose/install/))
, simply open up the top-level directory of this project and run the following line in a terminal:

`docker-compose up`

This will go and build all the docker containers for you. If you have already built the containers,
Docker Compose is actually smart enough to cache built containers so that it starts up faster
everytime since the initial build.

In the terminal, you will see logs for each of the services that are running. You can now access
the appropriate localhost ports to see the apps running as they should!

When you are finished and don't want to run compose anymore, you can either hit Ctrl-C or open
another terminal and type:

`docker-compose down`

## Common Issues

### The Docker container is not updating to reflect the new changes in an app
If you are working on an application and everytime you try to start docker-compose it doesn't
reflect the newest changes because of the caching, you can force a rebuild everytime of the
compose start by providing the following flag:

`docker-compose up --build`
