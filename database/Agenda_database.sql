-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-10-27 01:49:04.28

-- tables
-- Table: address
CREATE TABLE address (
    address_id int NOT NULL AUTO_INCREMENT,
    street varchar(100) NOT NULL,
    city varchar(100) NOT NULL,
    country varchar(100) NOT NULL,
    contact_contact_id int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (address_id)
);

-- Table: contact
CREATE TABLE contact (
    contact_id int NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de la tabla.',
    first_name varchar(50) NOT NULL,
    second_name varchar(50) NULL,
    first_surname varchar(50) NOT NULL,
    second_surname varchar(50) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (contact_id)
);

-- Table: email
CREATE TABLE email (
    email_id int NOT NULL AUTO_INCREMENT,
    email_address varchar(100) NOT NULL,
    contact_contact_id int NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT email_pk PRIMARY KEY (email_id)
);

-- Table: h_contact
CREATE TABLE h_contact (
    h_contact_id int NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de la tabla.',
    contact_id int NOT NULL,
    first_name varchar(50) NOT NULL,
    second_name varchar(50) NULL,
    first_surname varchar(50) NOT NULL,
    second_surname varchar(50) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_contact_pk PRIMARY KEY (h_contact_id)
);

-- Table: phone
CREATE TABLE phone (
    phone_id int NOT NULL AUTO_INCREMENT,
    phone_number varchar(50) NOT NULL,
    contact_contact_id int NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT phone_pk PRIMARY KEY (phone_id)
);

-- Table: transaction
CREATE TABLE transaction (
    tx_id int NOT NULL AUTO_INCREMENT,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT transaction_pk PRIMARY KEY (tx_id)
);

-- foreign keys
-- Reference: address_contact (table: address)
ALTER TABLE address ADD CONSTRAINT address_contact FOREIGN KEY address_contact (contact_contact_id)
    REFERENCES contact (contact_id);

-- Reference: email_contact (table: email)
ALTER TABLE email ADD CONSTRAINT email_contact FOREIGN KEY email_contact (contact_contact_id)
    REFERENCES contact (contact_id);

-- Reference: phone_contact (table: phone)
ALTER TABLE phone ADD CONSTRAINT phone_contact FOREIGN KEY phone_contact (contact_contact_id)
    REFERENCES contact (contact_id);

-- End of file.

