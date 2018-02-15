DROP TABLE IF EXISTS users cascade;
CREATE TABLE users
(
    user_id SERIAL PRIMARY KEY NOT NULL,
    user_name  VARCHAR(100) NOT NULL UNIQUE,
    user_email VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL,
	  permissions INTEGER NOT NULL

);

DROP TABLE IF EXISTS donors cascade;
CREATE TABLE donors (
  donor_id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users NOT NULL,
  donor_name VARCHAR(100) NOT NULL,
  donor_email VARCHAR(100) NOT NULL,
  donor_address VARCHAR(100) NOT NULL,
  donor_city VARCHAR(50) NOT NULL,
  donor_state VARCHAR(25) NOT NULL,
  donor_zip VARCHAR(10) NOT NULL,
  donor_phone VARCHAR(15) NOT NULL,
  donor_join_date DATE NOT NULL
);
DROP TABLE IF EXISTS callouts cascade;
CREATE TABLE callouts (
  callout_id SERIAL PRIMARY KEY,
  callout_title VARCHAR(100) NOT NULL,
  callout_body VARCHAR(8000) NULL,
  callout_url VARCHAR(8000) NULL,
  create_date DATE NOT NULL,
  update_date DATE NOT NULL,
  active BOOLEAN NULL,
  pinned BOOLEAN NULL
);

DROP TABLE IF EXISTS needs cascade;
CREATE TABLE needs (
  need_id SERIAL PRIMARY KEY,
  need_name VARCHAR(100) NOT NULL,
  need_url VARCHAR(8000) NULL,
	need_description VARCHAR(1000) NULL,
	need_quantity INTEGER NULL,
	need_unit VARCHAR (50) NULL,
	callout_id INTEGER REFERENCES callouts NULL,
	create_date DATE NOT NULL,
	active BOOLEAN NULL
	
);

DROP TABLE IF EXISTS gifts cascade;
CREATE TABLE gifts (
	gift_id SERIAL PRIMARY KEY,
	gift_quantity INTEGER NOT NULL,
	gift_date DATE NOT NULL,
	donor_id INTEGER REFERENCES donors,
	need_id INTEGER REFERENCES needs
);

DROP TABLE IF EXISTS alerts cascade;
CREATE TABLE alerts (
  alert_id SERIAL PRIMARY KEY,
  alert_title VARCHAR(100) NOT NULL,
  alert_body VARCHAR(8000) NULL,
  callout_id INT NULL REFERENCES callouts,
  need_id INT NULL REFERENCES needs,
  create_date DATE NOT NULL,
  last_pushed_date DATE NULL
);

CREATE UNIQUE INDEX u_ix_donorname ON donors (donor_name);


