-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-03-16 21:58:29.83

-- tables
-- Table: address
CREATE TABLE address (
    address_id int NOT NULL AUTO_INCREMENT,
    number varchar(45) NULL,
    street varchar(150) NOT NULL,
    zone varchar(150) NOT NULL,
    city varchar(150) NOT NULL,
    country varchar(150) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (address_id)
);

-- Table: admin
CREATE TABLE admin (
    admin_id int NOT NULL AUTO_INCREMENT,
    person_id int NOT NULL,
    email varchar(150) NOT NULL,
    user_name varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    picture varchar(300) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT admin_pk PRIMARY KEY (admin_id)
);

-- Table: bank_account
CREATE TABLE bank_account (
    bank_account_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of bank_account table.
Example: 4',
    pharmacy_id int NOT NULL,
    account_number int NOT NULL COMMENT 'Contains the number of the account that de user wants to register.
Example: 1273748493',
    bank varchar(45) NOT NULL COMMENT 'Name of the bank from which the credit card comes
Example: Banco Unión ',
    account_type varchar(45) NOT NULL COMMENT 'Type of accout that the user has
Example: Caja de ahorros',
    status int NOT NULL COMMENT 'Tells us if the bank account is active or not
Example: 1',
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT bank_account_pk PRIMARY KEY (bank_account_id)
);

-- Table: brand
CREATE TABLE brand (
    brand_id int NOT NULL AUTO_INCREMENT,
    name varchar(150) NOT NULL,
    phone varchar(45) NOT NULL,
    email varchar(150) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT brand_pk PRIMARY KEY (brand_id)
);

-- Table: card
CREATE TABLE card (
    card_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of card
Example: 3',
    client_id int NOT NULL,
    account_number varchar(45) NOT NULL COMMENT 'Contains the number of the account that de user wants to register.
Example: 1273748493',
    bank varchar(45) NOT NULL COMMENT 'Name of the bank from which the credit card comes
Example: Banco Unión ',
    type_account varchar(45) NOT NULL COMMENT 'Type of accout that the user has
Example: Caja de ahorros',
    cvv_code varchar(45) NOT NULL COMMENT 'Code of security that each card has on the reverse
Example: 1234',
    month int NOT NULL,
    year int NOT NULL,
    status int NOT NULL COMMENT 'Tells us if the card is active or not
Example: 1',
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT card_pk PRIMARY KEY (card_id)
);

-- Table: client
CREATE TABLE client (
    client_id int NOT NULL AUTO_INCREMENT,
    person_id int NOT NULL,
    address_id int NOT NULL,
    email varchar(150) NOT NULL,
    user_name varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    birthdate date NOT NULL,
    picture varchar(300) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT client_pk PRIMARY KEY (client_id)
);

-- Table: payment
CREATE TABLE payment (
    payment_id int NOT NULL AUTO_INCREMENT,
    card_id int NOT NULL,
    bank_account_id int NOT NULL,
    payment_date date NOT NULL,
    amount numeric(12,6) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT payment_pk PRIMARY KEY (payment_id)
);

-- Table: person
CREATE TABLE person (
    person_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of person table.',
    first_name varchar(150) NOT NULL,
    first_surname varchar(150) NOT NULL,
    second_surname varchar(150) NULL,
    ci varchar(45) NOT NULL,
    phone varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);

-- Table: pharmacy
CREATE TABLE pharmacy (
    pharmacy_id int NOT NULL AUTO_INCREMENT,
    name varchar(150) NOT NULL,
    phone varchar(45) NOT NULL,
    email varchar(150) NOT NULL,
    picture varchar(300) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT pharmacy_pk PRIMARY KEY (pharmacy_id)
);

-- Table: pharmacy_admin
CREATE TABLE pharmacy_admin (
    pharmacy_id int NOT NULL AUTO_INCREMENT,
    person_id int NOT NULL,
    subsidiary_id int NOT NULL,
    email varchar(150) NOT NULL,
    user_name varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    picture varchar(300) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT pharmacy_admin_pk PRIMARY KEY (pharmacy_id)
);

-- Table: product
CREATE TABLE product (
    product_id int NOT NULL AUTO_INCREMENT,
    subsidiary_id int NOT NULL,
    brand_id int NOT NULL,
    name varchar(150) NOT NULL,
    stock int NOT NULL,
    price numeric(12,6) NOT NULL,
    type varchar(150) NOT NULL,
    dose varchar(45) NOT NULL,
    description varchar(300) NOT NULL,
    picture varchar(300) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

-- Table: purchase
CREATE TABLE purchase (
    purchase_id int NOT NULL,
    payment_id int NOT NULL,
    purchase_Date date NOT NULL,
    total_amount numeric(12,6) NOT NULL,
    CONSTRAINT purchase_pk PRIMARY KEY (purchase_id)
);

-- Table: reserve
CREATE TABLE reserve (
    client_id int NOT NULL,
    product_id int NOT NULL,
    purchase_id int NOT NULL,
    cant int NOT NULL,
    status_reserve varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL
);

-- Table: subsidiary
CREATE TABLE subsidiary (
    subsidiary_id int NOT NULL AUTO_INCREMENT,
    pharmacy_id int NOT NULL,
    address_id int NOT NULL,
    subsidiary_name varchar(100) NOT NULL,
    phone varchar(45) NOT NULL,
    email varchar(150) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT subsidiary_pk PRIMARY KEY (subsidiary_id)
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
-- Reference: admin_person (table: admin)
ALTER TABLE admin ADD CONSTRAINT admin_person FOREIGN KEY admin_person (person_id)
    REFERENCES person (person_id);

-- Reference: bank_account_pharmacy (table: bank_account)
ALTER TABLE bank_account ADD CONSTRAINT bank_account_pharmacy FOREIGN KEY bank_account_pharmacy (pharmacy_id)
    REFERENCES pharmacy (pharmacy_id);

-- Reference: card_client (table: card)
ALTER TABLE card ADD CONSTRAINT card_client FOREIGN KEY card_client (client_id)
    REFERENCES client (client_id);

-- Reference: client_address (table: client)
ALTER TABLE client ADD CONSTRAINT client_address FOREIGN KEY client_address (address_id)
    REFERENCES address (address_id);

-- Reference: client_person (table: client)
ALTER TABLE client ADD CONSTRAINT client_person FOREIGN KEY client_person (person_id)
    REFERENCES person (person_id);

-- Reference: payment_bank_account (table: payment)
ALTER TABLE payment ADD CONSTRAINT payment_bank_account FOREIGN KEY payment_bank_account (bank_account_id)
    REFERENCES bank_account (bank_account_id);

-- Reference: payment_card (table: payment)
ALTER TABLE payment ADD CONSTRAINT payment_card FOREIGN KEY payment_card (card_id)
    REFERENCES card (card_id);

-- Reference: pharmacy_admin_person (table: pharmacy_admin)
ALTER TABLE pharmacy_admin ADD CONSTRAINT pharmacy_admin_person FOREIGN KEY pharmacy_admin_person (person_id)
    REFERENCES person (person_id);

-- Reference: pharmacy_admin_subsidiary (table: pharmacy_admin)
ALTER TABLE pharmacy_admin ADD CONSTRAINT pharmacy_admin_subsidiary FOREIGN KEY pharmacy_admin_subsidiary (subsidiary_id)
    REFERENCES subsidiary (subsidiary_id);

-- Reference: product_brand (table: product)
ALTER TABLE product ADD CONSTRAINT product_brand FOREIGN KEY product_brand (brand_id)
    REFERENCES brand (brand_id);

-- Reference: product_subsidiary (table: product)
ALTER TABLE product ADD CONSTRAINT product_subsidiary FOREIGN KEY product_subsidiary (subsidiary_id)
    REFERENCES subsidiary (subsidiary_id);

-- Reference: purchase_payment (table: purchase)
ALTER TABLE purchase ADD CONSTRAINT purchase_payment FOREIGN KEY purchase_payment (payment_id)
    REFERENCES payment (payment_id);

-- Reference: reserve_client (table: reserve)
ALTER TABLE reserve ADD CONSTRAINT reserve_client FOREIGN KEY reserve_client (client_id)
    REFERENCES client (client_id);

-- Reference: reserve_product (table: reserve)
ALTER TABLE reserve ADD CONSTRAINT reserve_product FOREIGN KEY reserve_product (product_id)
    REFERENCES product (product_id);

-- Reference: reserve_purchase (table: reserve)
ALTER TABLE reserve ADD CONSTRAINT reserve_purchase FOREIGN KEY reserve_purchase (purchase_id)
    REFERENCES purchase (purchase_id);

-- Reference: subsidiary_address (table: subsidiary)
ALTER TABLE subsidiary ADD CONSTRAINT subsidiary_address FOREIGN KEY subsidiary_address (address_id)
    REFERENCES address (address_id);

-- Reference: subsidiary_pharmacy (table: subsidiary)
ALTER TABLE subsidiary ADD CONSTRAINT subsidiary_pharmacy FOREIGN KEY subsidiary_pharmacy (pharmacy_id)
    REFERENCES pharmacy (pharmacy_id);

-- End of file.

