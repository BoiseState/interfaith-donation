#!/bin/bash

set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    GRANT ALL PRIVILEGES ON DATABASE docker TO docker;
    CREATE TABLE department(
    DEPT           CHAR(50) NOT NULL,
    STD_ID         INT      NOT NULL,
    Enrolled       boolean  NOT NULL
    );
    ALTER TABLE department ADD COLUMN last_update DATE;
    ALTER TABLE department ALTER COLUMN last_update SET DEFAULT CURRENT_DATE;
    SELECT * FROM department;
    CREATE DATABASE admin;
    \connect admin
    DROP DATABASE docker
EOSQL
