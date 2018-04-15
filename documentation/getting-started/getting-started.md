# Getting Started

## Prerequisites

For information on the prerequisites of this project, you
can read the [installation-instructions.md](installation-instructions.md).

You will need to install the proper prerequisite tools mentioned above in order to
run the commands below.

## Entire Project

Using docker compose, you can start up the database and the back-end server of the application with
just one command. Use the following command:

`docker-compose up`

For more information about Docker, please read the [Docker documentation](../docker-and-docker-compose).

## Back-End

If the back-end has been started via Docker, you can access the back-end server Swagger documentation
at `http://localhost:8080/donation-api` OR `http://localhost:8080/donation-api`

## Front-End (Admin)

The administrative front-end that allows users to modify the database tables is a Vue application.
To start the application, use the following command:

```bash
cd front-end-admin/

# You can use NPM or Yarn, whichever one you prefer.
yarn
npm i

yarn start
npm run start
```

This will install the front-end admin dependencies, and then start a development
server for the front-end admin. Once the start is finished, it will provide
the localhost URL for the front-end admin application. This development environment
features code reload, so as you change the Vue code it will automatically reload.
