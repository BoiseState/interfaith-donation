-- DROP DATABASE IF EXISTS charity;
-- CREATE DATABASE charity;
--
-- -- need, callout, users
DROP TABLE IF EXISTS "users" cascade;
CREATE TABLE users(
  user_id BIGSERIAL PRIMARY KEY NOT NULL,
  user_email VARCHAR(100) NOT NULL UNIQUE,
  user_password VARCHAR(100) NOT NULL,
  user_permission BOOLEAN NOT NULL,
  user_active BOOLEAN NOT NULL
);

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

DROP TABLE IF EXISTS callouts cascade;
CREATE TABLE callouts (
  callout_id BIGSERIAL PRIMARY KEY,
  callout_name VARCHAR(100) NOT NULL,
  callout_description_message VARCHAR(500) NULL,
  callout_created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  callout_end_date TIMESTAMP NULL,
  callout_active BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS needs cascade;
CREATE TABLE needs (
  need_id BIGSERIAL PRIMARY KEY,
  need_name VARCHAR(100) NOT NULL,
  need_amazonurl VARCHAR(3000) NULL,
  need_description VARCHAR(500) NULL,
  need_units VARCHAR (50) NULL,
  need_created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  need_active BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS needcallouts cascade;
CREATE TABLE needcallouts (
  needcallout_id BIGSERIAL PRIMARY KEY,
  needcallout_quantity INT NOT NULL,
  need_id BIGINT REFERENCES needs,
  callout_id BIGINT REFERENCES callouts,
  needcallout_active BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS donations cascade;
CREATE TABLE donations (
  donation_id BIGSERIAL PRIMARY KEY,
  donation_quantity INT NOT NULL,
  donation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  needcallout_id BIGINT REFERENCES users NOT NULL,
  donor_id BIGINT REFERENCES donors NOT NULL
);

-- transaction stuff, activations, 
