CREATE DATABASE IF NOT EXISTS `it_marathon_db`;
USE `it_marathon_db`;

CREATE TABLE IF NOT EXISTS users (
    id BIGINT,
    username varchar(20) NOT NULL UNIQUE,
    password varchar(20) NOT NULL,
    PRIMARY KEY (id)
);