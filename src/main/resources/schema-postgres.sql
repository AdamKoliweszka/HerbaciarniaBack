DROP TABLE IF EXISTS cities;

--TWORZENIE TABELI Z DOSTAWCAMI
DROP TABLE IF EXISTS HISTORIA_ZAKUPOW;
DROP TABLE IF EXISTS HISTORIA_DOSTAW;
DROP TABLE IF EXISTS HERBATY;
DROP TABLE IF EXISTS DOSTAWCY;
DROP TABLE IF EXISTS KLIENCI;
DROP TABLE IF EXISTS PRACOWNICY;
DROP TABLE IF EXISTS UZYTKOWNICY;
DROP TABLE IF EXISTS GATUNKI_HERBAT;
DROP TABLE IF EXISTS STATUSY_TRANSAKCJI;
DROP TABLE IF EXISTS KRAJE_POCHODZENIA;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;



create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);


insert into users(username, password, enabled)values('Jan','Kowalski',true);
insert into users(username, password, enabled)values('Barbara','Witek',true);
insert into users(username, password, enabled)values('Piotrek','Nowak',true);
insert into users(username, password, enabled)values('Michal','Wygoda',true);
insert into users(username, password, enabled)values('Magdalena','Zalewska',true);

insert into users(username, password, enabled)values('bill','abc123',true);
insert into users(username, password, enabled)values('Mateusz','Krol',true);
insert into users(username, password, enabled)values('Piotr','Rudy',true);
insert into users(username, password, enabled)values('Zbigniew','Bomba',true);
insert into users(username, password, enabled)values('Janek','Pchelka',true);
insert into users(username, password, enabled)values('Roksana','Koska',true);


insert into authorities(username,authority)values('bill','PRACOWNIK');
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
idProvider SERIAL PRIMARY KEY,
name VARCHAR(20),
surname VARCHAR(20),
accountNumber VARCHAR(20),
city VARCHAR(20),
street VARCHAR(20)
);
INSERT INTO providers (name, surname, accountNumber,city, street) VALUES ('Bogdan', 'Wąsik', 1234000040001111, 'Kraków', 'Pawia');
INSERT INTO providers (name, surname, accountNumber,city, street) VALUES ('Grzegorz', 'Krzywy', 1111900040001234, 'Gniezno', 'Słoneczna');
INSERT INTO providers (name, surname, accountNumber,city, street) VALUES ('Piotr', 'Robak',2345600067891000, 'Wrocław', 'Reja');
INSERT INTO providers (name, surname, accountNumber,city, street) VALUES ('Robert', 'Pszczółka', 4321000040007890, 'Oława', 'Lipowa');
INSERT INTO providers (name, surname, accountNumber,city, street) VALUES ('Helena', 'Czech', 894500034005690, 'Wrocław', 'Opolska');

--TWORZENIE TABELI Z KLIENTAMI
CREATE TABLE customers
(
idCustomer SERIAL PRIMARY KEY,
name VARCHAR(20),
surname VARCHAR(20),
city VARCHAR(20),
street VARCHAR(20),
dateOfDeleteAccount DATE,
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
idEmployee SERIAL PRIMARY KEY,
name VARCHAR(20),
surname VARCHAR(20),
dateOfEmployment DATE,
dateOfDismissal DATE,
username varchar(50),
CONSTRAINT FK_EMPLOYEES_USERS FOREIGN KEY (username)
REFERENCES users(username)
);
INSERT INTO employees (name, surname,dateOfEmployment, dateOfDismissal,username) VALUES ('Mateusz', 'Król',NOW() ,null,'Mateusz');
INSERT INTO employees (name, surname,dateOfEmployment, dateOfDismissal,username) VALUES ('Piotr', 'Rudy',NOW() ,null,'Piotr');
INSERT INTO employees (name, surname,dateOfEmployment, dateOfDismissal,username) VALUES ('Zbigniew', 'Bomba',NOW() ,null,'Zbigniew');
INSERT INTO employees (name, surname,dateOfEmployment, dateOfDismissal,username) VALUES ('Janek', 'Pchełka',NOW(),null,'Janek');
INSERT INTO employees (name, surname,dateOfEmployment, dateOfDismissal,username) VALUES ('Roksana', 'Kóska',NOW() ,null,'Roksana');
--TWORZENIE TABELI Z GATUNKAMI HERBAT

CREATE TABLE teaSpecies
(
idSpecies SERIAL PRIMARY KEY,
name VARCHAR(20)
);
INSERT INTO teaSpecies(name) VALUES ('Niezdefiniowany');
INSERT INTO teaSpecies(name) VALUES ('Czarna');
INSERT INTO teaSpecies(name) VALUES ('Zielona');
INSERT INTO teaSpecies(name) VALUES ('Biala');
INSERT INTO teaSpecies(name) VALUES ('Pu-erh');
INSERT INTO teaSpecies(name) VALUES ('oolong');
INSERT INTO teaSpecies(name) VALUES ('Yerba mate');
INSERT INTO teaSpecies(name) VALUES ('Roibos');
--TWORZENIE TABELI ZE STATUSAMI TRANSAKCJI

CREATE TABLE transactionStatuses
(
idStatus SERIAL PRIMARY KEY,
name VARCHAR(20)
);
INSERT INTO transactionStatuses(name) VALUES ('Zamówiono');
INSERT INTO transactionStatuses(name) VALUES ('Opłacono');
INSERT INTO transactionStatuses(name) VALUES ('Spakowano');
INSERT INTO transactionStatuses(name) VALUES ('Dostarczono');

--TWORZENIE TABELI ZE KRAJAMI POCHODZENIA

CREATE TABLE countryOfOrigin
(
idCountry SERIAL PRIMARY KEY,
name VARCHAR(20)
);
INSERT INTO countryOfOrigin(name) VALUES ('Niezdefiniowany');
INSERT INTO countryOfOrigin(name) VALUES ('Indie');
INSERT INTO countryOfOrigin(name) VALUES ('Chiny');
INSERT INTO countryOfOrigin(name) VALUES ('Brazylia');
INSERT INTO countryOfOrigin(name) VALUES ('Indonezja');
INSERT INTO countryOfOrigin(name) VALUES ('Cejlon');
INSERT INTO countryOfOrigin(name) VALUES ('Kenia');
--TWORZENIE TABELI MAGAZYNU Z HERBATAMI

CREATE TABLE tea
(
idTea SERIAL PRIMARY KEY,
name VARCHAR(20),
description VARCHAR(200),
priceOfSelling INT,
priceOfDelivery INT,
availableQuantity INT,
idSpecies INT DEFAULT 1,
idCountry INT DEFAULT 1,
CONSTRAINT FK_TEA_SPECIES FOREIGN KEY (idSpecies)
REFERENCES teaSpecies(idSpecies) ON DELETE SET DEFAULT,
CONSTRAINT FK_TEA_COUNTRY FOREIGN KEY (idCountry)
REFERENCES countryOfOrigin(idCountry) ON DELETE SET DEFAULT
);
INSERT INTO tea(name,description,priceOfSelling,priceOfDelivery,availableQuantity,idSpecies,idCountry) VALUES ('Lipton','Herbata odświerzająca',35,30,72,2,4);
INSERT INTO tea(name,description,priceOfSelling,priceOfDelivery,availableQuantity,idSpecies,idCountry) VALUES ('Pajarito','Herbata o piorującym smaku.',95,80,0,1,6);
INSERT INTO tea(name,description,priceOfSelling,priceOfDelivery,availableQuantity,idSpecies,idCountry) VALUES ('Minutka','Herbata o delikatnym smaku',15,12,0,3,2);
INSERT INTO tea(name,description,priceOfSelling,priceOfDelivery,availableQuantity,idSpecies,idCountry) VALUES ('Basilur','Herbata o orzeźwiającym smaku z posmakiem ananasu.',115,100,0,1,2);
INSERT INTO tea(name,description,priceOfSelling,priceOfDelivery,availableQuantity,idSpecies,idCountry) VALUES ('Lipton Earl Grey','Herbata o delikatnym smaku.',25,23,5,5,4);
--TWORZENIE TABELI Z HISTORI• DOSTAW

CREATE TABLE deliveries
(
idDelivery SERIAL PRIMARY KEY,
idProvider INT,
idEmployee INT,
idTea INT,
amount INT,
idStatus INT,
dateOfDelivery DATE,
CONSTRAINT FK_DELIVERY_STATUS FOREIGN KEY (idStatus)
REFERENCES transactionStatuses(idStatus),
CONSTRAINT FK_DELIVERY_TEA FOREIGN KEY (idTea)
REFERENCES tea(idTea),
CONSTRAINT FK_DELIVERY_EMPLOYEE FOREIGN KEY (idEmployee)
REFERENCES employees(idEmployee),
CONSTRAINT FK_DELIVERY_PROVIDER FOREIGN KEY (idProvider)
REFERENCES providers(idProvider)
);
INSERT INTO deliveries(idProvider,idEmployee,idTea,amount,idStatus,dateOfDelivery)VALUES(1,1,1,100,4,NOW());
INSERT INTO deliveries(idProvider,idEmployee,idTea,amount,idStatus,dateOfDelivery)VALUES(1,2,1,20,1,NOW());
INSERT INTO deliveries(idProvider,idEmployee,idTea,amount,idStatus,dateOfDelivery)VALUES(3,2,4,50,2,NOW());
INSERT INTO deliveries(idProvider,idEmployee,idTea,amount,idStatus,dateOfDelivery)VALUES(5,1,5,10,4,NOW());
INSERT INTO deliveries(idProvider,idEmployee,idTea,amount,idStatus,dateOfDelivery)VALUES(2,3,3,200,2,NOW());
--TWORZENIE TABELI Z HISTORII ZAKUPOW

CREATE TABLE purchases
(
idPurchase SERIAL PRIMARY KEY,
idCustomer INT,
idEmployee INT,
idTea INT,
amount INT,
idStatus INT,
dateOfPurchases DATE,
CONSTRAINT FK_PURCHASE_STATUS FOREIGN KEY (idStatus)
REFERENCES transactionStatuses(idStatus),
CONSTRAINT FK_PURCHASE_TEA FOREIGN KEY (idTea)
REFERENCES tea(idTea),
CONSTRAINT FK_PURCHASE_EMPLOYEE FOREIGN KEY (idEmployee)
REFERENCES employees(idEmployee),
CONSTRAINT FK_PURCHASE_CUSTOMER FOREIGN KEY (idCustomer)
REFERENCES customers(idCustomer)
);
INSERT INTO purchases(idCustomer,idCustomer,idTea,amount,idStatus,dateOfPurchases)VALUES(1,4,1,10,4,NOW());
INSERT INTO purchases(idCustomer,idCustomer,idTea,amount,idStatus,dateOfPurchases)VALUES(2,4,5,2,1,NOW());
INSERT INTO purchases(idCustomer,idCustomer,idTea,amount,idStatus,dateOfPurchases)VALUES(3,5,1,4,2,NOW());
INSERT INTO purchases(idCustomer,idCustomer,idTea,amount,idStatus,dateOfPurchases)VALUES(1,4,5,3,4,NOW());
INSERT INTO purchases(idCustomer,idCustomer,idTea,amount,idStatus,dateOfPurchases)VALUES(5,5,1,14,3,NOW());

