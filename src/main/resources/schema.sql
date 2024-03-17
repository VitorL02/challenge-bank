CREATE TABLE IF NOT EXISTS persons(
    id SERIAL primary key,
    first_name VARCHAR(255) NOT NULL ,
    last_name VARCHAR(255) NOT NULL,
    participation decimal NOT NULL
);