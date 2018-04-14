# Getting Started

## Prerequisites

For information on the prerequisites of this project, you
can read the [installation-instructions.md](installation-instructions.md).

You will need to install the proper prerequisite tools mentioned above in order to
run the commands below.

### To build or reload the current Docker database and server:

    `docker-compose up --build`

### To build and run docker database and server:

    `docker-compose up`

For more information about Docker, please read the [Docker documentation](../docker-and-docker-compose).

### Swagger allows us to check our API. To navigate to swagger, as part of the Docker build go to:

    `http://localhost:8080/donation-api`

### To build the front-end-admin application run:

    ```bash
    sudo npm install
    sudo npm run start || sudo npm run dev
    ```

### Alternatively you can use yarn instead of npm

    `sudo yarn start || sudo yarn run dev`
