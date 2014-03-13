DROP TABLE events_has_employees;
DROP TABLE users;
DROP TABLE events;
DROP TABLE employees;

CREATE TABLE users(
id INTEGER GENERATED ALWAYS AS IDENTITY,
username VARCHAR(30),
CONSTRAINT users_pk PRIMARY KEY(id)
);

CREATE TABLE events(
event_id INTEGER GENERATED ALWAYS AS IDENTITY, 
contractor VARCHAR(30), 
phone INTEGER, 
mail VARCHAR(30),
address VARCHAR(30), 
postnr INTEGER, 
postplace VARCHAR(30), 
responsible VARCHAR(30), 
checkup_date VARCHAR(30), 
tid VARCHAR(30), 
subject VARCHAR(30),
description VARCHAR(30), 
status VARCHAR(30),
CONSTRAINT events_pk PRIMARY KEY(event_id)
);

CREATE TABLE events_has_employees(
event_id INTEGER, 
employee_id INTEGER,
CONSTRAINT events_has_employees_pk PRIMARY KEY(event_id, employee_id)
);

CREATE TABLE employees(
id INTEGER GENERATED ALWAYS AS IDENTITY, 
firstName VARCHAR(30),
lastName VARCHAR(30),
lastWorkDate VARCHAR(30),
lastRegDate VARCHAR(30),
CONSTRAINT employees_pk PRIMARY KEY(id)
);

ALTER TABLE events_has_employees ADD CONSTRAINT event_id_fk FOREIGN KEY(event_id) REFERENCES events(event_id);

ALTER TABLE events_has_employees ADD CONSTRAINT employee_id_fk FOREIGN KEY(employee_id) REFERENCES employees(id);