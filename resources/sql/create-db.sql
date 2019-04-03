CREATE DATABASE BeltLine;
use BeltLine;

CREATE TABLE if NOT EXISTS User (
    Username varchar(50) NOT NULL,
    Password varchar(50) NOT NULL,
    Status varchar(15)  NOT NULL,
    FirstName varchar(50) NOT NULL,
    LastName varchar(50) NOT NULL,
    PRIMARY KEY (Username)
    );

CREATE TABLE if NOT EXISTS Email (
    Username varchar(50) NOT NULL,
    Email varchar(50) NOT NULL,
    FOREIGN KEY (Username) REFERENCES User (Username)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY (Email)
    );

CREATE TABLE if NOT EXISTS Visitor (
	Username varchar(50) NOT NULL,
    FOREIGN KEY (Username) REFERENCES User (Username)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
   PRIMARY KEY (Username)
   );

Create TABLE if NOT EXISTS Employee (
    Username varchar(50) NOT NULL,
    EmployeeID varchar(9) NOT NULL,
    Phone char(10) NOT NULL,
    Address varchar(50) NOT NULL,
    City varchar(50) NOT NULL,
    State char(2) NOT NULL,
    ZipCode char(5) NOT  NULL,
    FOREIGN KEY (Username) REFERENCES User (Username)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    PRIMARY KEY (Username)
    );

CREATE TABLE if NOT EXISTS Administrator (
	Username varchar(50) NOT NULL,
    FOREIGN KEY (Username) REFERENCES User (Username)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
   PRIMARY KEY (Username)
   );

CREATE TABLE if NOT EXISTS Staff (
	Username varchar(50) NOT NULL,
    FOREIGN KEY (Username) REFERENCES User (Username)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
   PRIMARY KEY (Username)
   );

CREATE TABLE if NOT EXISTS Manager (
	Username varchar(50) NOT NULL,
    FOREIGN KEY (Username) REFERENCES User (Username)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
   PRIMARY KEY (Username)
   );

CREATE TABLE if NOT EXISTS Site(
	SName varchar(50) NOT NULL,
	Address varchar(50) NOT NULL,
	ZipCode char(5) NOT NULL,
	OpenEveryday varchar(1) NOT NULL ,
	ManagerUsername varchar(50) NOT NULL,
	PRIMARY KEY (SName),
	FOREIGN KEY (ManagerUsername) REFERENCES Manager (ManagerUsername)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
    );

CREATE TABLE Event(
    EName varchar(50) NOT NULL,
    StartDate datetime NOT NULL,
    SName varchar(50) NOT NULL,
    EndDate datetime NOT NULL,
    Price Decimal(6,2) NOT NULL,
    Capacity int,
    Description text NOT NULL,
    MinStaffReq int NOT NULL,
    PRIMARY KEY (EName, StartDate, SName),
    FOREIGN KEY (SName) REFERENCES Site (SName)
        ON DELETE CASCADE
        ON UPDATE CASCADE
    );

CREATE TABLE AssignTo(
    StaffUsername varchar(50)  NOT NULL,
    EName varchar(50) NOT NULL,
    StartDate datetime NOT NULL,
    SiteName varchar(50) NOT NULL,
    PRIMARY KEY (EName, StaffUsername, StartDate, SiteName),
    FOREIGN KEY (EName, StartDate, SiteName) REFERENCES Event (EName, StartDate, SiteName)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (StaffUsername) REFERENCES Staff (username)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    );

CREATE TABLE Transit(
	Type varchar(100) NOT NULL,
	Route varchar(100) NOT NULL,
	Price decimal(9,2),
	PRIMARY KEY (Type, Route)
	);

CREATE TABLE if NOT EXISTS Connect(
    SName varchar(50) NOT NULL,
    Route varchar(50) NOT NULL,
    Type varchar(50) NOT NULL,
    PRIMARY KEY (SName, Type, Route),
    FOREIGN KEY (SName) REFERENCES Site (SName),
        ON DELETE CASCADE,
        ON UPDATE CASCADE,
    FOREIGN KEY (Route, Type) REFERENCES Transit (Route, Type),
        ON DELETE CASCADE,
        ON UPDATE CASCADE,
    );

Create TABLE Take(
    Username varchar(50) NOT NULL,
    Route varchar(50) NOT NULL,
    Type varchar(50) NOT NULL,
    Date datetime NOT NULL,
    PRIMARY KEY (Username, Date, Type, Route)
    FOREIGN KEY (Route, Type) REFERENCES Transit (Route, Type)
        ON DELETE CASCADE
        ON UPDATE CASCADE
    FOREIGN KEY (Username) REFERENCES User (Username)
        ON DELETE CASCADE
        ON UPDATE CASCADE
    );

CREATE TABLE VisitSite (
    Username varchar(50)  NOT NULL,
    SName varchar(50) NOT NULL,
    VisitSiteDate datetime NOT NULL,
    PRIMARY KEY (Username, SName, VisitSiteDate),
    FOREIGN KEY (Username) REFERENCES User(Username)
        ON UPDATE CASCADE
        ON DELETE CASCADE
    FOREIGN KEY (SName) REFERENCES Site(SName)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );







