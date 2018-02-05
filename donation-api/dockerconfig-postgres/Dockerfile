# Dockerfile configuration to run postgresql

FROM postgres

ENV POSTGRES_USER docker
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB docker

# Contents of /docker-entrypoint-initdb.d are run on psql startup
ADD  /docker-entrypoint-initdb.d/ /docker-entrypoint-initdb.d/
RUN chmod 755 /docker-entrypoint-initdb.d/*
