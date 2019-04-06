DROP TABLE IF EXISTS cities;
CREATE TABLE cities(id serial PRIMARY KEY, name VARCHAR(100), population integer);
INSERT INTO cities(name, population) VALUES('Bratislava', 432000);
INSERT INTO cities(name, population) VALUES('Budapest', 1759000);
INSERT INTO cities(name, population) VALUES('Prague', 1280000);
INSERT INTO cities(name, population) VALUES('Warsaw', 1748000);
INSERT INTO cities(name, population) VALUES('Los Angeles', 3971000);
INSERT INTO cities(name, population) VALUES('New York', 8550000);
INSERT INTO cities(name, population) VALUES('Edinburgh', 464000);
INSERT INTO cities(name, population) VALUES('Berlin', 3671000);

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

--TWORZENIE TABELI Z UZYTKOWNIKAMI
CREATE TABLE UZYTKOWNICY
(
id_uzytkownika SERIAL PRIMARY KEY,
login VARCHAR(25),
salt VARCHAR(25),
haslo VARCHAR(5)
);
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam1','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam2','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam3','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam4','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam5','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam6','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam7','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam8','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam9','Koliweszka','test');
INSERT INTO UZYTKOWNICY(login,salt,haslo)VALUES('Adam10','Koliweszka','test');

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
id_uzytkownika INT,
CONSTRAINT FK_KLIENT_UZYTKOWNIK FOREIGN KEY (id_uzytkownika)
REFERENCES UZYTKOWNICY(id_uzytkownika)
);
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,id_uzytkownika) VALUES ('Jan', 'Kowalski', 'Warszawa', 'Szkolna',1);
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,id_uzytkownika) VALUES ('Barbara', 'Witek', 'Gdańsk', 'Długa',2);
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,id_uzytkownika) VALUES ('Piotr', 'Nowak', 'Łódź', 'Ogrodowa',3); 
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,id_uzytkownika) VALUES ('Michał', 'Wygoda', 'Rzeszów', 'Polna',4); 
INSERT INTO KLIENCI ( imie, nazwisko, miejscowosc, ulica,id_uzytkownika) VALUES ('Magdalena', 'Zalewska', 'Wrocław', 'Kołątaja',5);
--TWORZENIE TABELI PRACOWNICY

CREATE TABLE PRACOWNICY
(
id_pracownika SERIAL PRIMARY KEY,
imie VARCHAR(20),
nazwisko VARCHAR(20),
data_zatrudnienia DATE,
data_zwolnienia DATE,
id_uzytkownika INT,
CONSTRAINT FK_PRACOWNICY_UZYTKOWNIK FOREIGN KEY (id_uzytkownika)
REFERENCES UZYTKOWNICY(id_uzytkownika)
);
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,id_uzytkownika) VALUES ('Mateusz', 'Król',NOW() ,null,6);
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,id_uzytkownika) VALUES ('Piotr', 'Rudy',NOW() ,null,7);
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,id_uzytkownika) VALUES ('Zbigniew', 'Bomba',NOW() ,null,8);
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,id_uzytkownika) VALUES ('Jan', 'Pchełka',NOW(),null,9);
INSERT INTO PRACOWNICY (imie, nazwisko,data_zatrudnienia, data_zwolnienia,id_uzytkownika) VALUES ('Roksana', 'Kóska',NOW() ,null,10);
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

