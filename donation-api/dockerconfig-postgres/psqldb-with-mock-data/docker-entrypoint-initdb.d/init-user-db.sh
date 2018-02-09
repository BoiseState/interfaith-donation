#!/bin/bash

# stops the execution if a command|pipeline has an error; opposite behavior of shell
set -e

psql <<-EOSQL
    \du
    \list
    GRANT ALL PRIVILEGES ON DATABASE "$POSTGRES_DB" TO "$POSTGRES_USER";
    \connect charity
    \dt
    \include /docker-entrypoint-initdb.d/mock-data/interfaith_DDL.sql
    \include /docker-entrypoint-initdb.d/mock-data/insert-data-sql/Users.sql
    \include /docker-entrypoint-initdb.d/mock-data/insert-data-sql/Callouts.sql
    \include /docker-entrypoint-initdb.d/mock-data/insert-data-sql/Donors.sql
    \include /docker-entrypoint-initdb.d/mock-data/insert-data-sql/Needs.sql
    \include /docker-entrypoint-initdb.d/mock-data/insert-data-sql/Alerts.sql
    \include /docker-entrypoint-initdb.d/mock-data/insert-data-sql/Gifts.sql
EOSQL
