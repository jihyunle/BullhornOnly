-- SQL is case insensitive
-- DDL to create the database
create database testdb; -- use to create
use testdb; --  must "use" to call it to action

-- DDL: Data Definiteion Language to create a table
CREATE TABLE person (
    id bigint PRIMARY KEY,
    first_name VARCHAR(50), -- string type with max, as long as under 255
    last_name VARCHAR(255),
    age INTEGER
);

-- READ
select id, first_name, last_name, age from person; -- null means no value

-- CREATE
insert into person values (1, 'Bart', 'Simpson', 10);

-- READ
select id, first_name, last_name, age from person;

-- UPDATE
update person set age = 11 where id = 1;

select id, first_name, last_name, age from person;

select * from person where id=1; -- select * means select every field

-- DELETE
delete from person where id=1;

select id, first_name, last_name, age from person;
