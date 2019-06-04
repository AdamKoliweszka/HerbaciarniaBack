DROP TABLE IF EXISTS cities;

--TWORZENIE TABELI Z DOSTAWCAMI
DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS deliveries;
DROP TABLE IF EXISTS tea;
DROP TABLE IF EXISTS providers;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tea_species;
DROP TABLE IF EXISTS transaction_statuses;
DROP TABLE IF EXISTS country_of_origin;


create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    id_authority SERIAL PRIMARY KEY,
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);


insert into users(username, password, enabled)values('Jan','$2a$10$zqT/plKSzO.1rne2Rvk89ugARZeQp8JorW5zyNolu3ftmOqTmx1FC',true);--Kowalski
insert into users(username, password, enabled)values('Barbara','$2a$10$PWwPIVBQbgKAUIZpPPdjvuOpx25FbaOD0PE5btlxtEfJ12lUFE5Xa',true);--Witek
insert into users(username, password, enabled)values('Piotrek','$2a$10$4UJDXT0MR/B5UB/1r1/16.Yud55u1b12MzUSxvy6FdRw9MnOXws82',true);--Nowak
insert into users(username, password, enabled)values('Michal','$2a$10$tltb73Ypw.QIXzxs8xegrufGG5Z4BtasBN0t7S48mkt3X.yzj1opq',true);--Wygoda
insert into users(username, password, enabled)values('Magdalena','$2a$10$BogIgO3AJb7HW42obGVy3e6TJRp9HDy3RN2w4xT5/WoFib3dCwkY6',true);--Zalewska

insert into users(username, password, enabled)values('Mateusz','$2a$10$kXn5H65aXXTqbF5KXgiCU.uxiVUerYMdi3YlOX3nE9EZngc6hIDfu',true);--Krol
insert into users(username, password, enabled)values('Piotr','$2a$10$29euTng3RAB/U25/TTGhyubKFyocsrc1eVHn1JoG4XIeFtooLAhTi',true);--Rudy
insert into users(username, password, enabled)values('Zbigniew','$2a$10$FqF2PMQcFnViMG/8LZrjae4E/EHTZ80l2zeTQA8bEAnAEnHua5ADa',true);--Bomba
insert into users(username, password, enabled)values('Janek','$2a$10$cG4ur/W8t0xcW8/GlLPlxuTGwrlPA7GkeHyH1Y46JlK2zOS7QuFzS',true);--Pchelka
insert into users(username, password, enabled)values('Roksana','$2a$10$thhIOCMeIllNrvq3tfy16u2LG/57mNjX6hG3Pmn5O4virMsftVvCC',true);--Koska

insert into authorities(username,authority)values('Mateusz','PRACOWNIK');
insert into authorities(username,authority)values('Piotr','PRACOWNIK');
insert into authorities(username,authority)values('Zbigniew','PRACOWNIK');
insert into authorities(username,authority)values('Janek','PRACOWNIK');
insert into authorities(username,authority)values('Roksana','PRACOWNIK');
insert into authorities(username,authority)values('Jan','KLIENT');
insert into authorities(username,authority)values('Barbara','KLIENT');
insert into authorities(username,authority)values('Piotrek','KLIENT');
insert into authorities(username,authority)values('Michal','KLIENT');
insert into authorities(username,authority)values('Magdalena','KLIENT');

CREATE TABLE providers
(
id_provider SERIAL PRIMARY KEY,
name VARCHAR(20),
surname VARCHAR(20),
account_number VARCHAR(20),
city VARCHAR(20),
street VARCHAR(20)
);
INSERT INTO providers (name, surname, account_number,city, street) VALUES ('Bogdan', 'Wąsik', 1234000040001111, 'Kraków', 'Pawia');
INSERT INTO providers (name, surname, account_number,city, street) VALUES ('Grzegorz', 'Krzywy', 1111900040001234, 'Gniezno', 'Słoneczna');
INSERT INTO providers (name, surname, account_number,city, street) VALUES ('Piotr', 'Robak',2345600067891000, 'Wrocław', 'Reja');
INSERT INTO providers (name, surname, account_number,city, street) VALUES ('Robert', 'Pszczółka', 4321000040007890, 'Oława', 'Lipowa');
INSERT INTO providers (name, surname, account_number,city, street) VALUES ('Helena', 'Czech', 894500034005690, 'Wrocław', 'Opolska');

--TWORZENIE TABELI Z KLIENTAMI
CREATE TABLE customers
(
id_customer SERIAL PRIMARY KEY,
name VARCHAR(20),
surname VARCHAR(20),
city VARCHAR(20),
street VARCHAR(20),
username varchar(50),
CONSTRAINT FK_CUSTOMERS_USERS FOREIGN KEY (username)
REFERENCES users(username)
);
INSERT INTO customers ( name, surname, city, street,username) VALUES ('Jan', 'Kowalski', 'Warszawa', 'Szkolna','Jan');
INSERT INTO customers ( name, surname, city, street,username) VALUES ('Barbara', 'Witek', 'Gdańsk', 'Długa','Barbara');
INSERT INTO customers ( name, surname, city, street,username) VALUES ('Piotrek', 'Nowak', 'Łódź', 'Ogrodowa','Piotrek');
INSERT INTO customers ( name, surname, city, street,username) VALUES ('Michał', 'Wygoda', 'Rzeszów', 'Polna','Michal');
INSERT INTO customers ( name, surname, city, street,username) VALUES ('Magdalena', 'Zalewska', 'Wrocław', 'Kołątaja','Magdalena');
--TWORZENIE TABELI PRACOWNICY

CREATE TABLE employees
(
id_employee SERIAL PRIMARY KEY,
name VARCHAR(20),
surname VARCHAR(20),
date_of_employment DATE,
date_of_dismissal DATE,
username varchar(50),
CONSTRAINT FK_EMPLOYEES_USERS FOREIGN KEY (username)
REFERENCES users(username)
);
INSERT INTO employees (name, surname,date_of_employment, date_of_dismissal,username) VALUES ('Mateusz', 'Król',NOW() ,null,'Mateusz');
INSERT INTO employees (name, surname,date_of_employment, date_of_dismissal,username) VALUES ('Piotr', 'Rudy',NOW() ,null,'Piotr');
INSERT INTO employees (name, surname,date_of_employment, date_of_dismissal,username) VALUES ('Zbigniew', 'Bomba',NOW() ,null,'Zbigniew');
INSERT INTO employees (name, surname,date_of_employment, date_of_dismissal,username) VALUES ('Janek', 'Pchełka',NOW(),null,'Janek');
INSERT INTO employees (name, surname,date_of_employment, date_of_dismissal,username) VALUES ('Roksana', 'Kóska',NOW() ,null,'Roksana');
--TWORZENIE TABELI Z GATUNKAMI HERBAT_o
CREATE TABLE tea_species
(
id_species SERIAL PRIMARY KEY,
name VARCHAR(20)
);
INSERT INTO tea_species(name) VALUES ('Niezdefiniowany');
INSERT INTO tea_species(name) VALUES ('Czarna');
INSERT INTO tea_species(name) VALUES ('Zielona');
INSERT INTO tea_species(name) VALUES ('Biala');
INSERT INTO tea_species(name) VALUES ('Pu-erh');
INSERT INTO tea_species(name) VALUES ('oolong');
INSERT INTO tea_species(name) VALUES ('Yerba mate');
INSERT INTO tea_species(name) VALUES ('Roibos');
--TWORZENIE TABELI ZE STATUSAMI TRANSAKCJI

CREATE TABLE transaction_statuses
(
id_status SERIAL PRIMARY KEY,
name VARCHAR(20)
);
INSERT INTO transaction_statuses(name) VALUES ('Zamówiono');
INSERT INTO transaction_statuses(name) VALUES ('Opłacono');
INSERT INTO transaction_statuses(name) VALUES ('Spakowano');
INSERT INTO transaction_statuses(name) VALUES ('Dostarczono');

--TWORZENIE TABELI ZE KRAJAMI POCHODZENIA

CREATE TABLE country_of_origin
(
id_country SERIAL PRIMARY KEY,
name VARCHAR(20)
);
INSERT INTO country_of_origin(name) VALUES ('Niezdefiniowany');
INSERT INTO country_of_origin(name) VALUES ('Indie');
INSERT INTO country_of_origin(name) VALUES ('Chiny');
INSERT INTO country_of_origin(name) VALUES ('Brazylia');
INSERT INTO country_of_origin(name) VALUES ('Indonezja');
INSERT INTO country_of_origin(name) VALUES ('Cejlon');
INSERT INTO country_of_origin(name) VALUES ('Kenia');
--TWORZENIE TABELI MAGAZYNU Z HERBATAMI

CREATE TABLE tea
(
id_tea SERIAL PRIMARY KEY,
name VARCHAR(20),
description VARCHAR(200),
price_of_selling INT,
price_of_delivery INT,
available_quantity INT,
id_species INT DEFAULT 1,
id_country INT DEFAULT 1,
image bytea,
CONSTRAINT FK_TEA_SPECIES FOREIGN KEY (id_species)
REFERENCES tea_species(id_species) ON DELETE SET DEFAULT,
CONSTRAINT FK_TEA_COUNTRY FOREIGN KEY (id_country)
REFERENCES country_of_origin(id_country) ON DELETE SET DEFAULT
);
INSERT INTO tea(name,description,price_of_selling,price_of_delivery,available_quantity,id_species,id_country,image) VALUES ('Lipton','Herbata odświerzająca',35,30,72,2,4,pg_read_binary_file('/Users/user/Documents/HerbaciarniaBackend/src/main/resources/image1.png')::bytea);
INSERT INTO tea(name,description,price_of_selling,price_of_delivery,available_quantity,id_species,id_country,image) VALUES ('Pajarito','Herbata o piorującym smaku.',95,80,0,1,6,pg_read_binary_file('/Users/user/Documents/HerbaciarniaBackend/src/main/resources/image2.png')::bytea);
INSERT INTO tea(name,description,price_of_selling,price_of_delivery,available_quantity,id_species,id_country,image) VALUES ('Minutka','Herbata o delikatnym smaku',15,12,0,3,2,pg_read_binary_file('/Users/user/Documents/HerbaciarniaBackend/src/main/resources/image3.png')::bytea);
INSERT INTO tea(name,description,price_of_selling,price_of_delivery,available_quantity,id_species,id_country,image) VALUES ('Basilur','Herbata o orzeźwiającym smaku z posmakiem ananasu.',115,100,0,1,2,pg_read_binary_file('/Users/user/Documents/HerbaciarniaBackend/src/main/resources/image4.jpg')::bytea);
INSERT INTO tea(name,description,price_of_selling,price_of_delivery,available_quantity,id_species,id_country,image) VALUES ('Lipton Earl Grey','Herbata o delikatnym smaku.',25,23,5,5,4,pg_read_binary_file('/Users/user/Documents/HerbaciarniaBackend/src/main/resources/image5.png')::bytea);
--TWORZENIE TABELI Z HISTORI• DOSTAW

CREATE TABLE deliveries
(
id_delivery SERIAL PRIMARY KEY,
id_provider INT,
id_employee INT,
id_tea INT,
amount INT,
id_status INT,
date_of_delivery DATE,
CONSTRAINT FK_DELIVERY_STATUS FOREIGN KEY (id_status)
REFERENCES transaction_statuses(id_status),
CONSTRAINT FK_DELIVERY_TEA FOREIGN KEY (id_tea)
REFERENCES tea(id_tea),
CONSTRAINT FK_DELIVERY_EMPLOYEE FOREIGN KEY (id_employee)
REFERENCES employees(id_employee),
CONSTRAINT FK_DELIVERY_PROVIDER FOREIGN KEY (id_provider)
REFERENCES providers(id_provider)
);
INSERT INTO deliveries(id_provider,id_employee,id_tea,amount,id_status,date_of_delivery)VALUES(1,1,1,100,4,NOW());
INSERT INTO deliveries(id_provider,id_employee,id_tea,amount,id_status,date_of_delivery)VALUES(1,2,1,20,1,NOW());
INSERT INTO deliveries(id_provider,id_employee,id_tea,amount,id_status,date_of_delivery)VALUES(3,2,4,50,2,NOW());
INSERT INTO deliveries(id_provider,id_employee,id_tea,amount,id_status,date_of_delivery)VALUES(5,1,5,10,4,NOW());
INSERT INTO deliveries(id_provider,id_employee,id_tea,amount,id_status,date_of_delivery)VALUES(2,3,3,200,2,NOW());
--TWORZENIE TABELI Z HISTORII ZAKUPOW

CREATE TABLE purchases
(
id_purchase SERIAL PRIMARY KEY,
id_customer INT,
id_employee INT,
id_tea INT,
amount INT,
id_status INT,
date_of_purchases DATE,
CONSTRAINT FK_PURCHASE_STATUS FOREIGN KEY (id_status)
REFERENCES transaction_statuses(id_status),
CONSTRAINT FK_PURCHASE_TEA FOREIGN KEY (id_tea)
REFERENCES tea(id_tea),
CONSTRAINT FK_PURCHASE_EMPLOYEE FOREIGN KEY (id_employee)
REFERENCES employees(id_employee),
CONSTRAINT FK_PURCHASE_CUSTOMER FOREIGN KEY (id_customer)
REFERENCES customers(id_customer)
);
INSERT INTO purchases(id_customer,id_employee,id_tea,amount,id_status,date_of_purchases)VALUES(1,1,1,10,4,NOW());
INSERT INTO purchases(id_customer,id_employee,id_tea,amount,id_status,date_of_purchases)VALUES(2,1,5,2,1,NOW());
INSERT INTO purchases(id_customer,id_employee,id_tea,amount,id_status,date_of_purchases)VALUES(3,1,1,4,2,NOW());
INSERT INTO purchases(id_customer,id_employee,id_tea,amount,id_status,date_of_purchases)VALUES(1,1,5,3,4,NOW());
INSERT INTO purchases(id_customer,id_employee,id_tea,amount,id_status,date_of_purchases)VALUES(5,1,1,14,3,NOW());

