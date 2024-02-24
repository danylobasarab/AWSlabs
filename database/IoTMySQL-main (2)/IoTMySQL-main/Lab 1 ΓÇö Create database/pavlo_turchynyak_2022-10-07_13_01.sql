-- Table: Information_about_owner
CREATE TABLE Information_about_owner (
    id int NOT NULL,
    name varchar(30) NULL,
    surname varchar(40) NULL,
    age int NULL,
    fortunes int NULL,
    CONSTRAINT Information_about_owner_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
    id int NOT NULL,
    name int NULL,
    country_name varchar(45) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: country
CREATE TABLE country (
    name varchar(45) NOT NULL,
    CONSTRAINT country_pk PRIMARY KEY (name)
);

-- Table: credential
CREATE TABLE credential (
    id int NOT NULL,
    login varchar(30) NULL,
    password varchar(45) NULL,
    CONSTRAINT credential_pk PRIMARY KEY (id)
);

-- Table: establishment
CREATE TABLE establishment (
    id int NOT NULL,
    name varchar(30) NULL,
    type_of_establishment_id int NOT NULL,
    rating float(1,1) NOT NULL,
    street_id int NOT NULL,
    CONSTRAINT establishment_pk PRIMARY KEY (id)
);

-- Table: establishment_review_of_establishment
CREATE TABLE establishment_review_of_establishment (
    review_of_establishment_id int NOT NULL,
    establishment_id int NOT NULL,
    CONSTRAINT establishment_review_of_establishment_pk PRIMARY KEY (review_of_establishment_id,establishment_id)
);

-- Table: review_of_establishment
CREATE TABLE review_of_establishment (
    id int NOT NULL,
    review int NOT NULL,
    user_account_nickname varchar(30) NOT NULL,
    CONSTRAINT review_of_establishment_pk PRIMARY KEY (id)
);

-- Table: street
CREATE TABLE street (
    id int NOT NULL,
    name varchar(45) NULL,
    city_id int NOT NULL,
    CONSTRAINT street_pk PRIMARY KEY (id)
);

-- Table: type_of_establishment
CREATE TABLE type_of_establishment (
    id int NOT NULL,
    type_name varchar(30) NULL,
    CONSTRAINT type_of_establishment_pk PRIMARY KEY (id)
);

-- Table: user_account
CREATE TABLE user_account (
    nickname varchar(30) NOT NULL,
    name varchar(30) NULL,
    surname varchar(40) NULL,
    credential_id int NOT NULL,
    CONSTRAINT user_account_pk PRIMARY KEY (nickname)
);

-- foreign keys
-- Reference: city_country (table: city)
ALTER TABLE city ADD CONSTRAINT city_country FOREIGN KEY city_country (country_name)
    REFERENCES country (name);

-- Reference: establishment_review_of_establishment_establishment (table: establishment_review_of_establishment)
ALTER TABLE establishment_review_of_establishment ADD CONSTRAINT establishment_review_of_establishment_establishment FOREIGN KEY establishment_review_of_establishment_establishment (establishment_id)
    REFERENCES establishment (id);

-- Reference: establishment_review_of_establishment_review_of_establishment (table: establishment_review_of_establishment)
ALTER TABLE establishment_review_of_establishment ADD CONSTRAINT establishment_review_of_establishment_review_of_establishment FOREIGN KEY establishment_review_of_establishment_review_of_establishment (review_of_establishment_id)
    REFERENCES review_of_establishment (id);

-- Reference: establishment_street (table: establishment)
ALTER TABLE establishment ADD CONSTRAINT establishment_street FOREIGN KEY establishment_street (street_id)
    REFERENCES street (id);

-- Reference: establishment_type_of_establishment (table: establishment)
ALTER TABLE establishment ADD CONSTRAINT establishment_type_of_establishment FOREIGN KEY establishment_type_of_establishment (type_of_establishment_id)
    REFERENCES type_of_establishment (id);

-- Reference: review_of_establishment_user_account (table: review_of_establishment)
ALTER TABLE review_of_establishment ADD CONSTRAINT review_of_establishment_user_account FOREIGN KEY review_of_establishment_user_account (user_account_nickname)
    REFERENCES user_account (nickname);

-- Reference: street_city (table: street)
ALTER TABLE street ADD CONSTRAINT street_city FOREIGN KEY street_city (city_id)
    REFERENCES city (id);

-- Reference: user_account_credential (table: user_account)
ALTER TABLE user_account ADD CONSTRAINT user_account_credential FOREIGN KEY user_account_credential (credential_id)
    REFERENCES credential (id);


