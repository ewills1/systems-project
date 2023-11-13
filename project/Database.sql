CREATE TABLE Product ( 
    productID INT NOT NULL PRIMARY KEY,
    name STRING,
    price INT,
    quantity INT,
    FOREIGN KEY (locomotiveID) REFERENCES Locomotive(locomotiveID),
    FOREIGN KEY (rollingStockID) REFERENCES RollingStock(rollingStockID),
    FOREIGN KEY (controllerID) REFERENCES Controller(controllerID)
);

CREATE TABLE OrderLine (
    orderID INT,
    productID INT,
    orderLineNumber INT,
    productQuantity INT, 
    orderLineCost MONEY,
    PRIMARY FOREIGN KEY (orderID, productID),
    FOREIGN KEY (orderID) REFERENCES Order (orderID),
    FOREIGN KEY (productID) REFERENCES Product (productID)
);

CREATE TABLE Order (
    orderID INT NOT NULL PRIMARY KEY,
    date DATE,
    totalCost MONEY,
    status STATUS
);

CREATE TABLE User (
    userID NOT NULL PRIMARY KEY,
    forename STRING,
    surname STRING,
    bankCardName STRING,
    cardHolderName STRING,
    expiryDate STRING,
    securityCode INT,
    userType TYPE,
    PRIMARY FOREIGN KEY (houseID) REFERENCES Address (houseID)
);

CREATE TABLE Address (
    houseID NOT NULL PRIMARY KEY,
    streetName STRING,
    cityName STRING,
    postcode STRING
);

CREATE TABLE Locomotive (
    PRIMARY FOREIGN KEY (productID) REFERENCES Product (productID),
    FOREIGN KEY (trainSetID) REFERENCES TrainSet(trainSetID)
);

CREATE TABLE RollingStock (
    PRIMARY FOREIGN KEY (productID) REFERENCES Product(productID),
    FOREIGN KEY (trainSetID) REFERENCES TrainSet (trainSetID)
);

CREATE TABLE Controller (
    PRIMARY FOREIGN KEY (productID) REFERENCES Product(productID)
);

CREATE TABLE TrainSet (
    trainSetID NOT NULL PRIMARY KEY,
    PRIMARY FOREIGN KEY (productID) REFERENCES Product (productID),
    FOREIGN KEY (trainPackProductID) REFERENCES TrackPack (productID),
    FOREIGN KEY (controllerProductID)
);

CREATE TABLE TrackPack (
    PRIMARY FOREIGN KEY (productID) REFERENCES Product (productID)
);