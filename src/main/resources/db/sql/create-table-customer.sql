DROP TABLE CUSTOMER IF EXISTS;

CREATE TABLE CUSTOMER(
ID VARCHAR(25) PRIMARY KEY,
NAME VARCHAR(40),
ADDRESS VARCHAR(60),
NO_OF_ORDERS_MADE BIGINT
);