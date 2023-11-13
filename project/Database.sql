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