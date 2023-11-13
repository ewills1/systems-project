CREATE TABLE Product ( 
    productID INT NOT NULL PRIMARY KEY,
    name STRING,
    price INT,
    quantity INT,
    FOREIGN KEY (locomotiveID) REFERENCES Locomotive(locomotiveID),
    FOREIGN KEY (rollingStockID) REFERENCES RollingStock(rollingStockID),
    FOREIGN (controllerID) REFERENCES Controller(controllerID)
);

CREATE TABLE OrderLine (
    orderID INT,
    productID INT,
    orderLineNumber INT,
    productQuantity INT, 
    orderLineCost MONEY,
    PRIMARY FOREIGN KEY (orderID, productID)
);

CREATE TABLE Order (
    orderID INT NOT NULL PRIMARY KEY,
    date Date,
    totalCost Money,
    status Status
);

CREATE TABLE User (
    userID NOT NULL PRIMARY KEY,
    forename String,
    surname String,
    bankCardName String,
    cardHolderName String,
    expiryDate String,
    securityCode Int,
    userType Type,
    PRIMARY FOREIGN KEY (houseID)
);

CREATE TABLE Address (
    houseID NOT NULL PRIMARY KEY,
    streetName String,
    cityName String,
    postcode String
);

CREATE TABLE Locomotive (
    PRIMARY FOREIGN KEY (productID)
    FOREIGN KEY (trainSetID)
);

CREATE TABLE RollingStock (
    PRIMARY FOREIGN KEY (productID)
    FOREIGN KEY (trainSetID)
);

CREATE TABLE Controller (
    PRIMARY FOREIGN KEY (productID)
);

CREATE TABLE TrainSet (
    trainSetID NOT NULL PRIMARY KEY
    PRIMARY FOREIGN KEY (productID)
    FOREIGN KEY (trainPackProductID)
    FOREIGN KEY (controllerProductID)
);

CREATE TABLE TrackPack (
    PRIMARY FOREIGN KEY (productID)
);