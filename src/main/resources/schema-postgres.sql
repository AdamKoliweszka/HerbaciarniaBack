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

CREATE TABLE DOSTAWCY
(
id_dostawcy SERIAL PRIMARY KEY,
imie VARCHAR(20),
nazwisko VARCHAR(20),
numer_konta VARCHAR(20),
miejscowosc VARCHAR(20),
ulica VARCHAR(20)
);
INSERT INTO DOSTAWCY (imie, nazwisko, numer_konta,miejscowosc, ulica) VALUES ('Bogdan', 'Wąsik', 1234000040001111, 'Kraków', 'Pawia');
INSERT INTO DOSTAWCY (imie, nazwisko, numer_konta,miejscowosc, ulica) VALUES ('Grzegorz', 'Krzywy', 1111900040001234, 'Gniezno', 'Słoneczna');
INSERT INTO DOSTAWCY (imie, nazwisko, numer_konta,miejscowosc, ulica) VALUES ('Piotr', 'Robak',2345600067891000, 'Wrocław', 'Reja');
INSERT INTO DOSTAWCY (imie, nazwisko, numer_konta,miejscowosc, ulica) VALUES ('Robert', 'Pszczółka', 4321000040007890, 'Oława', 'Lipowa');
INSERT INTO DOSTAWCY (imie, nazwisko, numer_konta,miejscowosc, ulica) VALUES ('Helena', 'Czech', 894500034005690, 'Wrocław', 'Opolska');

--TWORZENIE TABELI Z KLIENTAMI
CREATE TABLE KLIENCI
(
id_klienta SERIAL PRIMARY KEY,
imie VARCHAR(20),
nazwisko VARCHAR(20),
miejscowosc VARCHAR(20),
ulica VARCHAR(20),
data_usuniecia_konta DATE,
username varchar(50),
CONSTRAINT FK_KLIENT_UZYTKOWNIK FOREIGN KEY (username)
REFERENCES users(username)
);
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,username) VALUES ('Jan', 'Kowalski', 'Warszawa', 'Szkolna','Jan');
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,username) VALUES ('Barbara', 'Witek', 'Gdańsk', 'Długa','Barbara');
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,username) VALUES ('Piotrek', 'Nowak', 'Łódź', 'Ogrodowa','Piotrek');
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,username) VALUES ('Michał', 'Wygoda', 'Rzeszów', 'Polna','Michal');
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,username) VALUES ('Magdalena', 'Zalewska', 'Wrocław', 'Kołątaja','Magdalena');
--TWORZENIE TABELI PRACOWNICY

CREATE TABLE PRACOWNICY
(
id_pracownika SERIAL PRIMARY KEY,
imie VARCHAR(20),
nazwisko VARCHAR(20),
data_zatrudnienia DATE,
data_zwolnienia DATE,
username varchar(50),
CONSTRAINT FK_PRACOWNIK_UZYTKOWNIK FOREIGN KEY (username)
REFERENCES users(username)
);
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,username) VALUES ('Mateusz', 'Król',NOW() ,null,'Mateusz');
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,username) VALUES ('Piotr', 'Rudy',NOW() ,null,'Piotr');
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,username) VALUES ('Zbigniew', 'Bomba',NOW() ,null,'Zbigniew');
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,username) VALUES ('Janek', 'Pchełka',NOW(),null,'Janek');
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,username) VALUES ('Roksana', 'Kóska',NOW() ,null,'Roksana');
--TWORZENIE TABELI Z GATUNKAMI HERBAT

CREATE TABLE GATUNKI_HERBAT
(
id_gatunku SERIAL PRIMARY KEY,
nazwa_gatunku VARCHAR(20)
);
INSERT INTO GATUNKI_HERBAT(nazwa_gatunku) VALUES ('Niezdefiniowany');
INSERT INTO GATUNKI_HERBAT(nazwa_gatunku) VALUES ('Czarna');
INSERT INTO GATUNKI_HERBAT(nazwa_gatunku) VALUES ('Zielona');
INSERT INTO GATUNKI_HERBAT(nazwa_gatunku) VALUES ('Biala');
INSERT INTO GATUNKI_HERBAT(nazwa_gatunku) VALUES ('Pu-erh');
INSERT INTO GATUNKI_HERBAT(nazwa_gatunku) VALUES ('oolong');
INSERT INTO GATUNKI_HERBAT(nazwa_gatunku) VALUES ('Yerba mate');
INSERT INTO GATUNKI_HERBAT(nazwa_gatunku) VALUES ('Roibos');
--TWORZENIE TABELI ZE STATUSAMI TRANSAKCJI

CREATE TABLE STATUSY_TRANSAKCJI
(
id_statusu SERIAL PRIMARY KEY,
nazwa VARCHAR(20)
);
INSERT INTO STATUSY_TRANSAKCJI(nazwa) VALUES ('Zamówiono');
INSERT INTO STATUSY_TRANSAKCJI(nazwa) VALUES ('Opłacono');
INSERT INTO STATUSY_TRANSAKCJI(nazwa) VALUES ('Spakowano');
INSERT INTO STATUSY_TRANSAKCJI(nazwa) VALUES ('Dostarczono');

--TWORZENIE TABELI ZE KRAJAMI POCHODZENIA

CREATE TABLE KRAJE_POCHODZENIA
(
id_kraju SERIAL PRIMARY KEY,
nazwa_kraju VARCHAR(20)
);
INSERT INTO KRAJE_POCHODZENIA(nazwa_kraju) VALUES ('Niezdefiniowany');
INSERT INTO KRAJE_POCHODZENIA(nazwa_kraju) VALUES ('Indie');
INSERT INTO KRAJE_POCHODZENIA(nazwa_kraju) VALUES ('Chiny');
INSERT INTO KRAJE_POCHODZENIA(nazwa_kraju) VALUES ('Brazylia');
INSERT INTO KRAJE_POCHODZENIA(nazwa_kraju) VALUES ('Indonezja');
INSERT INTO KRAJE_POCHODZENIA(nazwa_kraju) VALUES ('Cejlon');
INSERT INTO KRAJE_POCHODZENIA(nazwa_kraju) VALUES ('Kenia');
--TWORZENIE TABELI MAGAZYNU Z HERBATAMI

CREATE TABLE HERBATY
(
id_herbaty SERIAL PRIMARY KEY,
nazwa_herbaty VARCHAR(20),
opis VARCHAR(200),
cena_sprzedazy INT,
cena_dostawy INT,
ilosc_dostepna INT,
id_gatunku INT DEFAULT 1,
id_kraju INT DEFAULT 1,
CONSTRAINT FK_HERBATA_GATUNEK FOREIGN KEY (id_gatunku)
REFERENCES GATUNKI_HERBAT(id_gatunku) ON DELETE SET DEFAULT,
CONSTRAINT FK_HERBATA_KRAJ FOREIGN KEY (id_kraju)
REFERENCES KRAJE_POCHODZENIA(id_kraju) ON DELETE SET DEFAULT
);
INSERT INTO HERBATY(nazwa_herbaty,opis,cena_sprzedazy,cena_dostawy,ilosc_dostepna,id_gatunku,id_kraju) VALUES ('Lipton','Herbata odświerzająca',35,30,72,2,4);
INSERT INTO HERBATY(nazwa_herbaty,opis,cena_sprzedazy,cena_dostawy,ilosc_dostepna,id_gatunku,id_kraju) VALUES ('Pajarito','Herbata o piorującym smaku.',95,80,0,1,6);
INSERT INTO HERBATY(nazwa_herbaty,opis,cena_sprzedazy,cena_dostawy,ilosc_dostepna,id_gatunku,id_kraju) VALUES ('Minutka','Herbata o delikatnym smaku',15,12,0,3,2);
INSERT INTO HERBATY(nazwa_herbaty,opis,cena_sprzedazy,cena_dostawy,ilosc_dostepna,id_gatunku,id_kraju) VALUES ('Basilur','Herbata o orzeźwiającym smaku z posmakiem ananasu.',115,100,0,1,2);
INSERT INTO HERBATY(nazwa_herbaty,opis,cena_sprzedazy,cena_dostawy,ilosc_dostepna,id_gatunku,id_kraju) VALUES ('Lipton Earl Grey','Herbata o delikatnym smaku.',25,23,5,5,4);
--TWORZENIE TABELI Z HISTORI• DOSTAW

CREATE TABLE HISTORIA_DOSTAW
(
id_dostawy SERIAL PRIMARY KEY,
id_dostawcy INT,
id_pracownika INT,
id_herbaty INT,
ilosc INT,
id_statusu INT,
data_dostawy DATE,
CONSTRAINT FK_DOSTAWA_STATUS FOREIGN KEY (id_statusu)
REFERENCES STATUSY_TRANSAKCJI(id_statusu),
CONSTRAINT FK_DOSTAWA_HERBATA FOREIGN KEY (id_herbaty)
REFERENCES HERBATY(id_herbaty),
CONSTRAINT FK_DOSTAWA_PRACOWNIK FOREIGN KEY (id_pracownika)
REFERENCES PRACOWNICY(id_pracownika),
CONSTRAINT FK_DOSTAWA_DOSTAWCA FOREIGN KEY (id_dostawcy)
REFERENCES DOSTAWCY(id_dostawcy)
);
INSERT INTO HISTORIA_DOSTAW(id_dostawcy,id_pracownika,id_herbaty,ilosc,id_statusu,data_dostawy)VALUES(1,1,1,100,4,NOW());
INSERT INTO HISTORIA_DOSTAW(id_dostawcy,id_pracownika,id_herbaty,ilosc,id_statusu,data_dostawy)VALUES(1,2,1,20,1,NOW());
INSERT INTO HISTORIA_DOSTAW(id_dostawcy,id_pracownika,id_herbaty,ilosc,id_statusu,data_dostawy)VALUES(3,2,4,50,2,NOW());
INSERT INTO HISTORIA_DOSTAW(id_dostawcy,id_pracownika,id_herbaty,ilosc,id_statusu,data_dostawy)VALUES(5,1,5,10,4,NOW());
INSERT INTO HISTORIA_DOSTAW(id_dostawcy,id_pracownika,id_herbaty,ilosc,id_statusu,data_dostawy)VALUES(2,3,3,200,2,NOW());
--TWORZENIE TABELI Z HISTORII ZAKUPOW

CREATE TABLE HISTORIA_ZAKUPOW
(
id_zakupu SERIAL PRIMARY KEY,
id_klienta INT,
id_pracownika INT,
id_herbaty INT,
ilosc INT,
id_statusu INT,
data_zakupu DATE,
CONSTRAINT FK_ZAKUP_STATUS FOREIGN KEY (id_statusu)
REFERENCES STATUSY_TRANSAKCJI(id_statusu),
CONSTRAINT FK_ZAKUP_HERBATA FOREIGN KEY (id_herbaty)
REFERENCES HERBATY(id_herbaty),
CONSTRAINT FK_ZAKUP_PRACOWNIK FOREIGN KEY (id_pracownika)
REFERENCES PRACOWNICY(id_pracownika),
CONSTRAINT FK_ZAKUP_KLIENT FOREIGN KEY (id_klienta)
REFERENCES KLIENCI(id_klienta)
);
INSERT INTO HISTORIA_ZAKUPOW(id_klienta,id_pracownika,id_herbaty,ilosc,id_statusu,data_zakupu)VALUES(1,4,1,10,4,NOW());
INSERT INTO HISTORIA_ZAKUPOW(id_klienta,id_pracownika,id_herbaty,ilosc,id_statusu,data_zakupu)VALUES(2,4,5,2,1,NOW());
INSERT INTO HISTORIA_ZAKUPOW(id_klienta,id_pracownika,id_herbaty,ilosc,id_statusu,data_zakupu)VALUES(3,5,1,4,2,NOW());
INSERT INTO HISTORIA_ZAKUPOW(id_klienta,id_pracownika,id_herbaty,ilosc,id_statusu,data_zakupu)VALUES(1,4,5,3,4,NOW());
INSERT INTO HISTORIA_ZAKUPOW(id_klienta,id_pracownika,id_herbaty,ilosc,id_statusu,data_zakupu)VALUES(5,5,1,14,3,NOW());

