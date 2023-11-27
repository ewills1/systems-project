CREATE TABLE Products ( 
    productCode VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR (100),
    price DECIMAL(8,2),
    quantity INT
);

CREATE TABLE OrderLines (
    orderID INT,
    productCode VARCHAR(100),
    orderLineNumber INT,
    productQuantity INT, 
    orderLineCost DECIMAL (8,2),
    PRIMARY KEY (orderID, productCode),
    FOREIGN KEY (orderID) REFERENCES `Orders` (orderID),
    FOREIGN KEY (productCode) REFERENCES Products (productCode)
);

CREATE TABLE `Orders` (
    orderID INT,
    date DATE,
    totalCost DECIMAL (8,2),
    placed ENUM('pending ', 'confirmed ', 'fulfilled ') NOT NULL,
    PRIMARY KEY (orderID)
);

CREATE TABLE Users (
    userID VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    forename VARCHAR (100),
    surname VARCHAR (100),
    bankCardName VARCHAR (100),
    addressID INT,
    cardHolderName VARCHAR (100),
    expiryDate VARCHAR (100),
    securityCode INT,
    PRIMARY KEY (userID),
	FOREIGN KEY (addressID) REFERENCES Addresses (addressID)
);

CREATE TABLE Roles (
userID VARCHAR (50) NOT NULL ,
role ENUM('Manager ', 'Staff ', 'User ') NOT NULL ,
PRIMARY KEY (userID , role),
FOREIGN KEY (userID) REFERENCES Users(userID)
); 

CREATE TABLE Addresses (
    addressID INT,
    streetName VARCHAR (100),
    cityName VARCHAR (100),
    postcode VARCHAR (100),
    houseNumber VARCHAR(50),
    PRIMARY KEY (addressID)
);

CREATE TABLE Locomotives (
    productCode VARCHAR(100),
    era VARCHAR(50),
    dcc VARCHAR(50),
	PRIMARY KEY (productCode),
    FOREIGN KEY (productCode) REFERENCES Products (productCode)
);

CREATE TABLE RollingStocks (
    productCode VARCHAR(100),
    era VARCHAR(50),
	PRIMARY KEY (productCode),
	FOREIGN KEY (productCode) REFERENCES Products(productCode)
);

CREATE TABLE Controllers (
    productCode VARCHAR(100),
    dcc VARCHAR(50),
	PRIMARY KEY (productCode),
    FOREIGN KEY (productCode) REFERENCES Products (productCode)
);

CREATE TABLE TrainSets (
    productCode VARCHAR(100),
    era VARCHAR(50),
    PRIMARY KEY (productCode),
    FOREIGN KEY (productCode) REFERENCES Products (productCode)
);

CREATE TABLE TrackPacks (
    productCode VARCHAR(100),
	PRIMARY KEY (productCode),
    FOREIGN KEY (productCode) REFERENCES Products (productCode)
);

CREATE TABLE Tracks (
	productCode VARCHAR(100),
    PRIMARY KEY (productCode),
    FOREIGN KEY (productCode) REFERENCES Products (productCode)
);