# Connecting to Docker

For some situations, you'll want to connect to a specific Docker container for
debugging or knowing what services are running.

## Port Numbers

As of now, when using Docker Compose the following services are accessible at
the following ports on the localhost of the computer being run:

* donation-api (back-end): localhost:8800/donation-api OR localhost:8080/donation-api
* front-end-client: localhost:8081
* front-end-admin: localhost:8082
* database: localhost:5050/charity

## Connecting to Docker Database via JetBrains

For connecting to a database, refer to [the JetBrains documentation](https://www.jetbrains.com/help/datagrip/connecting-to-a-database.html). The
only difference to be aware of is that **instead of using port 5432, you will
want to use port 5050** as this is the default port the Docker database runs
on when using Docker Compose. You will also want to make sure you connect to
the table "charity" and not the default postgres database. Credentials for the
development database can be found in the Dockerfile for the database under docker/postgres.
