-- DROP DATABASE IF EXISTS charity;
CREATE DATABASE charity;
--
-- -- need, callout, user
-- DROP TABLE IF EXISTS user cascade;
-- CREATE TABLE user
-- (
--     user_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
--     user_name  VARCHAR(100) NOT NULL UNIQUE,
--     user_email VARCHAR(100) NOT NULL,
--     user_password VARCHAR(100) NOT NULL,
--     user_permissions BOOLEAN NOT NULL
-- );

-- DROP TABLE IF EXISTS donor cascade;
-- CREATE TABLE donor (
--   donor_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
--   user_id BIGINT REFERENCES user NOT NULL,
--   donor_name VARCHAR(100) NOT NULL,
--   donor_email VARCHAR(100) NOT NULL,
--   donor_address VARCHAR(100) NOT NULL,
--   donor_city VARCHAR(50) NOT NULL,
--   donor_state VARCHAR(25) NOT NULL,
--   donor_zip VARCHAR(10) NOT NULL,
--   donor_phone VARCHAR(15) NOT NULL,
--   donor_join_date DATE NOT NULL
-- );

-- DROP TABLE IF EXISTS callout cascade;
-- CREATE TABLE callout (
--   callout_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
--   callout_message VARCHAR(500) NOT NULL,
--   create_date DATE NOT NULL,
--   active BOOLEAN NOT NULL,
--   pinned BOOLEAN NOT NULL
-- );

DROP TABLE IF EXISTS need cascade;
CREATE TABLE need (
  need_id BIGSERIAL PRIMARY KEY,
  need_name VARCHAR(100) NOT NULL,
  need_amazonurl VARCHAR(300) NULL,
  need_description VARCHAR(300) NULL,
  need_units VARCHAR (50) NULL,
  need_create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  need_active BOOLEAN NOT NULL
);

-- DROP TABLE IF EXISTS needcallout cascade;
-- CREATE TABLE needcallout (
--   needcallout_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
--   needcallout_quantity INT NOT NULL,
--   user_id BIGINT REFERENCES user,
--   callout_id BIGINT REFERENCES callout,
--   active BOOLEAN NOT NULL
-- );

-- transaction stuff, activations, 
