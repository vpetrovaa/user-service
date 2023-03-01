--liquibase formatted sql

--changeset vpetrovaa:create_tables

create schema if not exists notes-schema;
set schema 'notes-schema';

create table users
(
    id bigserial,
	email varchar(45) not null unique,
	first_name varchar(45) not null,
	last_name varchar(45) not null,
	primary key (id)
);