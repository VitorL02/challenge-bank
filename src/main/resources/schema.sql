CREATE TABLE IF NOT EXISTS persons(
    id SERIAL primary key,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    participation decimal
);