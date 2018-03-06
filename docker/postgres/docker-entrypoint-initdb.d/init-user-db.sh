#!/bin/bash

# stops the execution if a command|pipeline has an error; opposite behavior of shell
set -e

psql $POSTGRES_DB $POSTGRES_USER <<-EOSQL
    ALTER USER $POSTGRES_USER WITH PASSWORD '$POSTGRES_PASSWORD';
    \du
    \list
    GRANT ALL PRIVILEGES ON DATABASE "$POSTGRES_DB" TO "$POSTGRES_USER";
    \connect charity
    \include /docker-entrypoint-initdb.d/mock-data/interfaith_DDL.sql
    \include /docker-entrypoint-initdb.d/mock-data/need.sql
    \dt
EOSQL
