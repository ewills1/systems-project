CREATE TABLE Product ( 
    productID INT NOT NULL PRIMARY KEY,
    name VARCHAR (100),
    price INT,
    quantity INT,
    locomotiveID INT,
    rollingStockID INT,
    controllerID INT,
    FOREIGN KEY (locomotiveID) REFERENCES Locomotive(productID),
    FOREIGN KEY (rollingStockID) REFERENCES RollingStock(productID),
    FOREIGN KEY (controllerID) REFERENCES Controller(productID)
);

CREATE TABLE OrderLine (
    orderID INT,
    productID INT,
    orderLineNumber INT,
    productQuantity INT, 
    orderLineCost DECIMAL (8,2),
    PRIMARY KEY (orderID, productID),
    FOREIGN KEY (orderID) REFERENCES `Order` (orderID),
    FOREIGN KEY (productID) REFERENCES Product (productID)
);

CREATE TABLE `Order` (
    orderID INT NOT NULL PRIMARY KEY,
    date DATE,
    totalCost DECIMAL (8,2),
    status BOOL
);

CREATE TABLE User (
    userID INT NOT NULL PRIMARY KEY,
    forename VARCHAR (100),
    surname VARCHAR (100),
    bankCardName VARCHAR (100),
    houseID INT,
    cardHolderName VARCHAR (100),
    expiryDate VARCHAR (100),
    securityCode INT,
    userType VARCHAR (100),
    PRIMARY KEY (houseID),
	FOREIGN KEY (houseID) REFERENCES Address (houseID)
);

CREATE TABLE Address (
    houseID INT NOT NULL PRIMARY KEY,
    streetName VARCHAR (100),
    cityName VARCHAR (100),
    postcode VARCHAR (100)
);

CREATE TABLE Locomotive (
    productID INT,
    trainSetID INT,
	PRIMARY KEY (productID),
    FOREIGN KEY (productID) REFERENCES Product (productID),
    FOREIGN KEY (trainSetID) REFERENCES TrainSet(trainSetID)
);

CREATE TABLE RollingStock (
    productID INT,
    trainSetID INT,
	PRIMARY KEY (productID),
	FOREIGN KEY (productID) REFERENCES Product(productID),
    FOREIGN KEY (trainSetID) REFERENCES TrainSet (trainSetID)
);

CREATE TABLE Controller (
    productID INT,
	PRIMARY KEY (productID),
    FOREIGN KEY (productID) REFERENCES Product(productID)
);

CREATE TABLE TrainSet (
    productID INT,
    trainSetID INT,
    trainPackProductID INT,
    controllerProductID INT,
    PRIMARY KEY (productID, trainSetID),
    FOREIGN KEY (productID) REFERENCES Product (productID),
    FOREIGN KEY (trainPackProductID) REFERENCES TrackPack (productID),
    FOREIGN KEY (controllerProductID) REFERENCES Controller (productID)
);

CREATE TABLE TrackPack (
    productID INT,
	PRIMARY KEY (productID),
    FOREIGN KEY (productID) REFERENCES Product (productID)
);