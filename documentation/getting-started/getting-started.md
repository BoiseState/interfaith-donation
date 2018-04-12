## If Docker has been installed, continue with these commands;

######if not please go read installation-instructions.md

######if no root permissions have been given to a docker group, run the following commands with sudo

###To build or reload the current Docker database and server:

    docker-compose up --build

###To build and run docker database and server:

    docker-compose up

###Swagger allows us to check our API. To navigate to swagger, as part of the Docker build go to:

    http://localhost:8080/donation-api

###To build the front-end-admin application run:

    sudo npm install
    sudo npm run start || sudo npm run dev

###alternatively you can use yarn instead of npm

    sudo yarn start || sudo yarn run dev
