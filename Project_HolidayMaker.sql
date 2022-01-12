--
-- File generated with SQLiteStudio v3.3.3 on ons jan 12 20:33:17 2022
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Bed_Size
DROP TABLE IF EXISTS Bed_Size;

CREATE TABLE Bed_Size (
    Bed_Size_Id INTEGER PRIMARY KEY
                        NOT NULL,
    Bed_Name    VARCHAR,
    Bed_Price   INT
);

INSERT INTO Bed_Size (Bed_Size_Id, Bed_Name, Bed_Price) VALUES (1, 'Solo', '250kr');
INSERT INTO Bed_Size (Bed_Size_Id, Bed_Name, Bed_Price) VALUES (2, 'Queen', '350kr');
INSERT INTO Bed_Size (Bed_Size_Id, Bed_Name, Bed_Price) VALUES (3, 'King', '500kr');

-- Table: Booking
DROP TABLE IF EXISTS Booking;

CREATE TABLE Booking (
    Booking_Id     INTEGER  NOT NULL
                            PRIMARY KEY,
    Customer_Id    INT      REFERENCES Customer (Customer_Id),
    Start_Date     DATETIME,
    End_Date       DATETIME,
    Hotel_Rooms_Id INT      REFERENCES Hotel_Rooms (Hotel_Rooms_Id) 
);

INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (1, 1, '2022-06-09', '2022-07-13', 1);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (2, 2, '2022-06-29', '2022-07-06', 2);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (3, 3, '2022-06-07', '2022-07-13', 3);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (4, 4, '2022-06-05', '2022-07-14', 4);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (5, 5, '2022-06-19', '2022-07-16', 5);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (6, 6, '2022-06-20', '2022-07-13', 6);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (7, 7, '2022-06-18', '2022-07-15', 7);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (8, 8, '2022-06-06', '2022-07-23', 8);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (9, 9, '2022-06-02', '2022-07-18', 9);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (10, 10, '2022-06-21', '2022-07-06', 10);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (11, 11, '2022-06-27', '2022-07-21', 11);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (12, 12, '2022-06-01', '2022-07-14', 12);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (13, 13, '2022-06-03', '2022-07-16', 13);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (14, 14, '2022-06-25', '2022-07-21', 14);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (15, 15, '2022-06-24', '2022-07-28', 15);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (16, 16, '2022-06-02', '2022-07-16', 16);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (17, 17, '2022-06-14', '2022-07-10', 17);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (18, 18, '2022-06-20', '2022-07-01', 18);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (19, 19, '2022-06-22', '2022-07-16', 19);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (20, 20, '2022-06-17', '2022-07-08', 20);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (21, 21, '2022-06-18', '2022-07-04', 21);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (22, 22, '2022-06-15', '2022-07-08', 22);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (23, 23, '2022-06-29', '2022-07-18', 23);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (24, 24, '2022-06-28', '2022-07-27', 24);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (25, 25, '2022-06-06', '2022-07-27', 25);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (26, 26, '2022-06-28', '2022-07-01', 26);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (27, 27, '2022-06-05', '2022-07-28', 27);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (28, 28, '2022-06-08', '2022-07-26', 28);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (29, 29, '2022-06-05', '2022-07-20', 29);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (30, 30, '2022-06-11', '2022-07-10', 30);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (31, 31, '2022-06-13', '2022-07-13', 31);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (32, 32, '2022-06-09', '2022-07-24', 32);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (33, 33, '2022-06-29', '2022-07-08', 33);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (34, 34, '2022-06-13', '2022-07-12', 34);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (35, 35, '2022-06-19', '2022-07-26', 35);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (36, 36, '2022-06-01', '2022-07-09', 36);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (37, 37, '2022-06-01', '2022-07-14', 37);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (38, 38, '2022-06-22', '2022-07-11', 38);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (39, 39, '2022-06-26', '2022-07-16', 39);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (40, 40, '2022-06-21', '2022-07-27', 40);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (41, 41, '2022-06-02', '2022-07-05', 41);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (42, 42, '2022-06-01', '2022-07-04', 42);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (43, 1, '2022-06-26', '2022-07-26', 43);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (44, 2, '2022-06-18', '2022-07-11', 44);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (45, 3, '2022-06-21', '2022-07-16', 45);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (46, 4, '2022-06-09', '2022-07-09', 46);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (47, 5, '2022-06-13', '2022-07-28', 47);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (48, 6, '2022-06-15', '2022-07-20', 48);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (49, 7, '2022-06-26', '2022-07-16', 49);
INSERT INTO Booking (Booking_Id, Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES (50, 8, '2022-06-25', '2022-07-17', 50);

-- Table: Company
DROP TABLE IF EXISTS Company;

CREATE TABLE Company (
    First_Name   VARCHAR (50) NOT NULL,
    Last_Name    VARCHAR (50) NOT NULL,
    Company_Id   INTEGER      PRIMARY KEY,
    Email        VARCHAR (50),
    Phone_Number VARCHAR (50),
    Birth_Date   VARCHAR (50) NOT NULL,
    Customer_Id  INT          REFERENCES Customer (Customer_Id) 
);

INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Georgia', 'Berthelet', 1, NULL, '562-789-0013', '2008', 1);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Siobhan', 'Sargeant', 2, 'ssargeant1@privacy.gov.au', '639-469-6800', '1994', 2);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Justinn', 'Pretorius', 3, NULL, '130-625-9080', '2009', 3);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Abra', 'Skelton', 4, 'askelton3@bizjournals.com', '883-849-5471', '2004', 4);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Kesley', 'Degoe', 5, NULL, '548-156-0416', '2004', 5);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Asia', 'Tineman', 6, 'atineman5@sbwire.com', '869-456-5010', '1993', 6);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Prissie', 'Linkleter', 7, 'plinkleter6@comsenz.com', '282-505-3880', '1993', 7);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Camile', 'Swenson', 8, 'cswenson7@moonfruit.com', '532-878-3312', '1984', 8);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Sheffy', 'Surpliss', 9, 'ssurpliss8@epa.gov', '532-360-3065', '2012', 9);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Tabor', 'Duggary', 10, NULL, '963-180-8910', '2012', 10);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Cheston', 'Gynne', 11, 'cgynnea@yahoo.co.jp', '297-246-9015', '1996', 11);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Tabina', 'O''Driscoll', 12, NULL, '376-986-4862', '2006', 12);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Cahra', 'Skamal', 13, 'cskamalc@java.com', '108-737-3959', '1999', 13);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Hallsy', 'Geach', 14, 'hgeachd@npr.org', '426-179-2126', '2011', 14);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Mindy', 'Louthe', 15, 'mlouthee@cbslocal.com', '673-688-7930', '2007', 15);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Algernon', 'Ticehurst', 16, 'aticehurstf@seesaa.net', '204-430-4549', '2011', 16);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Kassia', 'Perrycost', 17, 'kperrycostg@friendfeed.com', '157-840-6728', '1994', 17);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Terrye', 'Hedditch', 18, 'thedditchh@wsj.com', '396-618-6350', '2009', 18);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Rory', 'Duferie', 19, NULL, '481-911-4635', '1994', 19);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Nil', 'Doogue', 20, 'ndooguej@abc.net.au', '568-227-1879', '1999', 20);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Margalit', 'Pauwel', 21, 'mpauwelk@amazon.de', '687-171-4955', '2006', 21);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Janeen', 'Fradgley', 22, 'jfradgleyl@google.com.br', '278-320-0912', '2011', 22);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Nico', 'Poor', 23, 'npoorm@tumblr.com', '597-913-7617', '2007', 23);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Mallory', 'Riguard', 24, NULL, '536-167-9427', '2011', 24);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Kaleena', 'Alecock', 25, NULL, '356-324-0880', '1997', 25);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Barth', 'Malan', 26, NULL, '928-666-5391', '1996', 26);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Aluino', 'Phillpotts', 27, NULL, '637-144-2786', '1983', 27);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Koenraad', 'Tarborn', 28, NULL, '247-690-4660', '1985', 28);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Briant', 'Sinnock', 29, 'bsinnocks@google.com.br', '686-630-5314', '1999', 29);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Jorry', 'Medling', 30, NULL, '833-173-8463', '1999', 30);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Merl', 'Rosendahl', 31, NULL, '265-624-8054', '2008', 31);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Brynne', 'McErlaine', 32, 'bmcerlainev@networkadvertising.org', '249-407-5638', '2008', 32);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Lewie', 'Sizeland', 33, 'lsizelandw@ehow.com', '410-672-0390', '2011', 33);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Conrad', 'Schankelborg', 34, 'cschankelborgx@purevolume.com', '102-764-7610', '2008', 34);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Herbert', 'Vertey', 35, NULL, '688-894-5329', '1966', 35);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Chloette', 'Shillabeare', 36, 'cshillabearez@aol.com', '702-333-7077', '1997', 36);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Dorene', 'Roxburch', 37, NULL, '317-286-2477', '1997', 37);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Des', 'Penhale', 38, 'dpenhale11@mapquest.com', '418-773-9165', '2001', 38);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('Rowena', 'Mobberley', 39, NULL, '465-343-9456', '1992', 39);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('test', 'test', 40, 'test', 'test', 'test', 40);
INSERT INTO Company (First_Name, Last_Name, Company_Id, Email, Phone_Number, Birth_Date, Customer_Id) VALUES ('benji', 'benji', 41, 'benji', 'benji', 'benji', 40);

-- Table: Customer
DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
    First_Name      VARCHAR (50) NOT NULL,
    Last_Name       VARCHAR (50) NOT NULL,
    Birth_Date      VARCHAR (50) NOT NULL,
    Email           VARCHAR (50) NOT NULL,
    Phone_Number    VARCHAR (50) NOT NULL,
    Creditcard_Type VARCHAR (50) NOT NULL,
    Customer_Id     INTEGER      PRIMARY KEY
                                 NOT NULL
);

INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Alyson', 'Vellacott', '2003', 'avellacott0@npr.org', '294-178-1683', 'diners-club-us-ca', 1);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Marylee', 'Goodluck', '1966', 'mgoodluck1@about.me', '692-784-7730', 'jcb', 2);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Daria', 'Anglim', '2000', 'danglim2@illinois.edu', '919-838-7179', 'jcb', 3);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Jill', 'Allchin', '1986', 'jallchin3@jiathis.com', '309-705-1368', 'jcb', 4);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Somerset', 'Lehemann', '2011', 'slehemann4@cnet.com', '630-125-0253', 'jcb', 5);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Paule', 'Charrette', '2000', 'pcharrette5@mediafire.com', '990-902-4227', 'diners-club-enroute', 6);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Berkeley', 'Holston', '2012', 'bholston6@theguardian.com', '113-395-9843', 'jcb', 7);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Malva', 'Reed', '1984', 'mreed7@loc.gov', '350-999-1255', 'jcb', 8);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Adria', 'Heberden', '1992', 'aheberden8@google.com.au', '747-327-3850', 'jcb', 9);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Robenia', 'Yousef', '2007', 'ryousef9@ehow.com', '421-798-8410', 'bankcard', 10);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Carlo', 'Lindsley', '1993', 'clindsleya@liveinternet.ru', '804-947-9338', 'jcb', 11);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Neils', 'Halfhyde', '1958', 'nhalfhydeb@go.com', '722-430-9457', 'maestro', 12);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Fayette', 'O''Mannion', '1994', 'fomannionc@hostgator.com', '470-229-8554', 'switch', 13);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Casper', 'Housbie', '2000', 'chousbied@shop-pro.jp', '427-408-3432', 'americanexpress', 14);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Elberta', 'Dallosso', '2000', 'edallossoe@technorati.com', '503-143-8761', 'diners-club-enroute', 15);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Freddie', 'Gerhts', '1988', 'fgerhtsf@mozilla.com', '697-737-0478', 'china-unionpay', 16);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Serena', 'Laybourne', '2003', 'slaybourneg@economist.com', '538-411-3496', 'jcb', 17);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Cosetta', 'Gush', '1993', 'cgushh@google.cn', '581-745-6962', 'laser', 18);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Quintina', 'Coultard', '1995', 'qcoultardi@fc2.com', '788-180-4535', 'laser', 19);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Lothaire', 'Oxherd', '2011', 'loxherdj@berkeley.edu', '452-705-9906', 'diners-club-enroute', 20);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Chrysler', 'Dimitrijevic', '2002', 'cdimitrijevick@china.com.cn', '395-112-2076', 'china-unionpay', 21);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Anetta', 'Ruf', '2009', 'arufl@prweb.com', '959-110-9841', 'switch', 22);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Brock', 'von Nassau', '2005', 'bvonnassaum@meetup.com', '134-172-0948', 'diners-club-carte-blanche', 23);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Harlene', 'Pruckner', '2001', 'hprucknern@goo.gl', '961-821-1407', 'switch', 24);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Fallon', 'Leon', '1986', 'fleono@tripadvisor.com', '152-296-1983', 'jcb', 25);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Kahlil', 'Pargent', '2007', 'kpargentp@utexas.edu', '230-283-3013', 'laser', 26);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Gabie', 'Braddock', '2006', 'gbraddockq@princeton.edu', '217-117-3558', 'jcb', 27);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Zea', 'Petow', '2008', 'zpetowr@fotki.com', '263-200-9624', 'jcb', 28);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Conant', 'McOwan', '2012', 'cmcowans@live.com', '492-418-6744', 'mastercard', 29);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Piper', 'La Batie', '2006', 'plabatiet@foxnews.com', '154-692-6424', 'maestro', 30);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Shandee', 'Konert', '2009', 'skonertu@com.com', '387-888-8128', 'jcb', 31);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Ferdie', 'Marsy', '1999', 'fmarsyv@free.fr', '277-439-4819', 'jcb', 32);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Zenia', 'Cheek', '2005', 'zcheekw@tinypic.com', '746-517-8235', 'diners-club-carte-blanche', 33);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Brnaba', 'Greyes', '2002', 'bgreyesx@devhub.com', '776-139-6431', 'mastercard', 34);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Giovanna', 'Butlin', '1979', 'gbutliny@reverbnation.com', '335-977-9121', 'maestro', 35);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Ulrikaumeko', 'Wiltshire', '2005', 'uwiltshirez@alexa.com', '123-946-5036', 'maestro', 36);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Stanwood', 'Heggman', '2008', 'sheggman10@jiathis.com', '846-277-0737', 'maestro', 37);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Brockie', 'Cluer', '1998', 'bcluer11@netlog.com', '813-700-7169', 'instapayment', 38);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('Malvin', 'Gillatt', '2010', 'mgillatt12@cnn.com', '627-511-4647', 'americanexpress', 39);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('fghs', 'sfhfs', 'sfhfs', 'sfhs', 'sgsh', 'sgsh', 40);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('test', 'test', 'test', 'test', 'test', 'tets', 41);
INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type, Customer_Id) VALUES ('kjg', 'sdgsdg', 'sgdsgdsgg', 'sdgdsgdsgsdgds', 'sdgsgsdgsdgdsgds', 'sdgsdg', 42);

-- Table: Extras
DROP TABLE IF EXISTS Extras;

CREATE TABLE Extras (
    Extras_Id   INTEGER PRIMARY KEY
                        NOT NULL,
    Extras_Alt  VARCHAR,
    Extra_Price INT
);

INSERT INTO Extras (Extras_Id, Extras_Alt, Extra_Price) VALUES (1, 'Full board: breakfast, lunch, dinner', '1000 kr');
INSERT INTO Extras (Extras_Id, Extras_Alt, Extra_Price) VALUES (2, 'Half board: breakfast and lunch', '750 kr');
INSERT INTO Extras (Extras_Id, Extras_Alt, Extra_Price) VALUES (3, 'Extra bed', '150 kr');
INSERT INTO Extras (Extras_Id, Extras_Alt, Extra_Price) VALUES (4, 'none', '0 kr');

-- Table: Hotel
DROP TABLE IF EXISTS Hotel;

CREATE TABLE Hotel (
    Hotel_Id              INTEGER PRIMARY KEY,
    Hotel_Name            VARCHAR NOT NULL,
    City                  VARCHAR NOT NULL,
    Restaurant            BOOLEAN,
    Kids_Club             BOOLEAN,
    Pool                  BOOLEAN,
    Evening_Entertainment BOOLEAN,
    Distance_City         VARCHAR,
    Distance_Beach        VARCHAR,
    Review                VARCHAR
);

INSERT INTO Hotel (Hotel_Id, Hotel_Name, City, Restaurant, Kids_Club, Pool, Evening_Entertainment, Distance_City, Distance_Beach, Review) VALUES (1, 'Gothia Towers', 'Göteborg', 'true', 'true', 'true', 'false', '0.5 km', '4 km', '5/5');
INSERT INTO Hotel (Hotel_Id, Hotel_Name, City, Restaurant, Kids_Club, Pool, Evening_Entertainment, Distance_City, Distance_Beach, Review) VALUES (2, 'Radisson Blu', 'Stockholm', 'true', 'false', 'true', 'false', '0.2 km', '7 km', '4/5');
INSERT INTO Hotel (Hotel_Id, Hotel_Name, City, Restaurant, Kids_Club, Pool, Evening_Entertainment, Distance_City, Distance_Beach, Review) VALUES (3, 'Clarion Hotel', 'Luleå', 'false', 'false', 'true', 'true', '1 km', '5 km', '3/5');
INSERT INTO Hotel (Hotel_Id, Hotel_Name, City, Restaurant, Kids_Club, Pool, Evening_Entertainment, Distance_City, Distance_Beach, Review) VALUES (4, 'Comfort Hotel', 'Malmö', 'true', 'false', 'false', 'false', '4k m', '2 km', '2/5');
INSERT INTO Hotel (Hotel_Id, Hotel_Name, City, Restaurant, Kids_Club, Pool, Evening_Entertainment, Distance_City, Distance_Beach, Review) VALUES (5, 'Quality Hotel', 'Skövde', 'false', 'true', 'true', 'true', '3 km', '3 km', '1/5');

-- Table: Hotel_Rooms
DROP TABLE IF EXISTS Hotel_Rooms;

CREATE TABLE Hotel_Rooms (
    Hotel_Rooms_Id INT PRIMARY KEY,
    Bed_Size_Id    INT REFERENCES Bed_Size (Bed_Size_Id),
    Hotel_Id       INT REFERENCES Hotel (Hotel_Id),
    Extras_Id      INT REFERENCES Extras (Extras_Id) 
);

INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (1, 1, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (2, 2, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (3, 3, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (4, 2, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (5, 1, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (6, 3, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (7, 2, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (8, 1, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (9, 3, 1, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (10, 1, 2, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (11, 1, 2, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (12, 2, 2, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (13, 3, 2, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (14, 2, 2, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (15, 2, 2, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (16, 1, 2, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (17, 3, 2, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (18, 2, 3, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (19, 2, 3, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (20, 1, 3, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (21, 3, 3, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (22, 1, 3, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (23, 2, 3, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (24, 2, 3, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (25, 2, 3, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (26, 1, 4, 3);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (27, 3, 4, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (28, 3, 4, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (29, 2, 4, 2);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (30, 1, 4, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (31, 3, 4, 2);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (32, 1, 4, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (33, 2, 4, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (34, 1, 5, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (35, 3, 5, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (36, 2, 5, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (37, 1, 5, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (38, 1, 5, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (39, 3, 5, 4);
INSERT INTO Hotel_Rooms (Hotel_Rooms_Id, Bed_Size_Id, Hotel_Id, Extras_Id) VALUES (40, 2, 5, 4);

-- View: AllRoomsBookedAndAvailable
DROP VIEW IF EXISTS AllRoomsBookedAndAvailable;
CREATE VIEW AllRoomsBookedAndAvailable AS
    SELECT DISTINCT Hotel_Rooms.Hotel_Rooms_Id AS RoomNumber,
                    Booking.Start_Date AS StartDate,
                    Booking.End_Date AS EndDate,
                    Booking.Customer_Id AS Customer,
                    Hotel.City AS City,
                    Hotel.Hotel_Name AS HotelName,
                    Bed_Size.Bed_Price AS Price,
                    Bed_Size.Bed_Name AS BedType,
                    Hotel.Evening_Entertainment AS Evening,
                    Hotel.Kids_Club AS Kids,
                    Hotel.Pool AS Pool,
                    Hotel.Restaurant AS Restaurant,
                    Hotel.Review AS Review,
                    Hotel.Distance_Beach AS Beach,
                    Hotel.Distance_City AS CityDis
      FROM Hotel
           JOIN
           Hotel_Rooms ON Hotel_Rooms.Hotel_Id = Hotel.Hotel_Id
           LEFT JOIN
           Booking ON Booking.Hotel_Rooms_Id = Hotel_Rooms.Hotel_Rooms_Id
           JOIN
           Bed_Size ON Bed_Size.Bed_Size_Id = Hotel_Rooms.Bed_Size_Id
           JOIN
           Extras ON Extras.Extras_Id = Hotel_Rooms.Extras_Id;


-- View: AvailableRooms
DROP VIEW IF EXISTS AvailableRooms;
CREATE VIEW AvailableRooms AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL
     GROUP BY RoomNumber;


-- View: EmptyRoomsGothenburg
DROP VIEW IF EXISTS EmptyRoomsGothenburg;
CREATE VIEW EmptyRoomsGothenburg AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL AND 
           City = 'Göteborg'
     GROUP BY RoomNumber
     ORDER BY Review ASC;


-- View: EmptyRoomsLulea
DROP VIEW IF EXISTS EmptyRoomsLulea;
CREATE VIEW EmptyRoomsLulea AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL AND 
           City = 'Luleå'
     GROUP BY RoomNumber
     ORDER BY Review ASC;


-- View: EmptyRoomsMalmo
DROP VIEW IF EXISTS EmptyRoomsMalmo;
CREATE VIEW EmptyRoomsMalmo AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL AND 
           City = 'Malmö'
     GROUP BY RoomNumber
     ORDER BY Review ASC;


-- View: EmptyRoomsSkovde
DROP VIEW IF EXISTS EmptyRoomsSkovde;
CREATE VIEW EmptyRoomsSkovde AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL AND 
           City = 'Skövde'
     GROUP BY RoomNumber
     ORDER BY Review ASC;


-- View: EmptyRoomsStockholm
DROP VIEW IF EXISTS EmptyRoomsStockholm;
CREATE VIEW EmptyRoomsStockholm AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL AND 
           City = 'Stockholm'
     GROUP BY RoomNumber
     ORDER BY Review ASC;


-- View: HotelDistanceBeach
DROP VIEW IF EXISTS HotelDistanceBeach;
CREATE VIEW HotelDistanceBeach AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL
     GROUP BY RoomNumber
     ORDER BY Beach DESC;


-- View: HotelDistanceCity
DROP VIEW IF EXISTS HotelDistanceCity;
CREATE VIEW HotelDistanceCity AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL
     GROUP BY RoomNumber
     ORDER BY CityDis ASC;


-- View: OurHotelActivity
DROP VIEW IF EXISTS OurHotelActivity;
CREATE VIEW OurHotelActivity AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL
     GROUP BY RoomNumber
     ORDER BY Review DESC;


-- View: OurHotelPrice
DROP VIEW IF EXISTS OurHotelPrice;
CREATE VIEW OurHotelPrice AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL
     GROUP BY RoomNumber
     ORDER BY Price ASC;


-- View: OurHotels
DROP VIEW IF EXISTS OurHotels;
CREATE VIEW OurHotels AS
    SELECT Hotel.City,
           Hotel.Hotel_Name,
           Hotel.Evening_Entertainment,
           Hotel.Kids_Club,
           Hotel.Pool,
           Hotel.Restaurant
      FROM Hotel;


-- View: OurHotelsReview
DROP VIEW IF EXISTS OurHotelsReview;
CREATE VIEW OurHotelsReview AS
    SELECT *
      FROM AllRoomsBookedAndAvailable
     WHERE RoomNumber NOT IN (
               SELECT RoomNumber
                 FROM AllRoomsBookedAndAvailable
                WHERE StartDate BETWEEN '2022-02-01' AND '2022-02-04'
           )
AND 
           NOT (EndDate BETWEEN '2022-02-01' AND '2022-02-04') OR 
           StartDate IS NULL AND 
           EndDate IS NULL
     GROUP BY RoomNumber
     ORDER BY Review ASC;


-- View: ViewBookings
DROP VIEW IF EXISTS ViewBookings;
CREATE VIEW ViewBookings AS
    SELECT DISTINCT Booking.Booking_Id,
                    Booking.Customer_Id,
                    Booking.Start_Date,
                    Booking.End_Date,
                    Booking.Hotel_Rooms_Id,
                    Bed_Size.Bed_Price,
                    Bed_Size.Bed_Name,
                    Hotel.City,
                    Hotel.Hotel_Name,
                    Customer.First_Name,
                    Customer.Last_Name
      FROM Booking
           JOIN
           Hotel_Rooms ON Hotel_Rooms.Hotel_Rooms_Id = Booking.Hotel_Rooms_Id
           JOIN
           Hotel ON Hotel.Hotel_Id = Hotel_Rooms.Hotel_Id
           JOIN
           Customer ON Customer.Customer_Id = Booking.Customer_Id
           JOIN
           Bed_Size ON Bed_Size.Bed_Size_Id = Hotel_Rooms.Bed_Size_Id
     WHERE Booking.Customer_Id IS NOT NULL;


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
