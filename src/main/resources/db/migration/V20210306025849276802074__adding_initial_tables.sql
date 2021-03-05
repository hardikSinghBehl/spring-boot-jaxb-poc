CREATE TABLE master_countries(
 id SERIAL PRIMARY KEY,
 name CHARACTER VARYING (255) NOT NULL UNIQUE,
 iso_code CHARACTER VARYING (255) NOT NULL UNIQUE
);

CREATE TABLE master_platforms(
 id SERIAL PRIMARY KEY,
 name CHARACTER VARYING (255) NOT NULL UNIQUE
);

CREATE TABLE streamers(
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  full_name CHARACTER VARYING (255) NOT NULL,
  date_of_birth TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  country_id INTEGER NOT NULL,
  platform_id INTEGER NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT streamers_country_id_fkey FOREIGN KEY (country_id) 
    REFERENCES master_countries (id) MATCH SIMPLE
      ON UPDATE NO ACTION
      ON DELETE NO ACTION,
  CONSTRAINT streamers_platform_id_fkey FOREIGN KEY (platform_id) 
    REFERENCES master_platforms (id) MATCH SIMPLE
      ON UPDATE NO ACTION
      ON DELETE NO ACTION  
);

CREATE trigger streamers_creation_timestamp_trigger
   BEFORE INSERT ON streamers
   for each row EXECUTE procedure creation_timestamp_handler();
   
CREATE trigger streamers_updation_timestamp_trigger
   BEFORE UPDATE ON streamers
   for each row EXECUTE procedure updation_timestamp_handler();
