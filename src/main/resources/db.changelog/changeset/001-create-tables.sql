--liquibase formatted sql

--changeset vpetrovaa:create_user_tables

create schema if not exists notes_schema;
set schema 'notes_schema';

create table if not exists users
(
    id bigserial,
	email varchar(45) not null unique,
	first_name varchar(45) not null,
	last_name varchar(45) not null,
	primary key (id)
);