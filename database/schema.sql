CREATE DATABASE eshop;

CREATE TABLE customers (
   name char(32),
   address varchar(128),
   email varchar(128),
   primary key (name)
);

-- Fail to execute following commands due to secure-file-priv error

-- LOAD DATA INFILE 'C:/Users/snow_/Desktop/PAF assessement/second/eshop/database/data.csv' 
-- INTO TABLE customers
-- FIELDS TERMINATED BY ':' 
-- LINES TERMINATED BY '\n'
-- IGNORE 1 ROWS;

-- hardcoded the entries
insert into customers
( name, address, email)

values
("fred", "201 Cobblestone Lane", "fredflintstone@bedrock.com"),
("sherlock", "221B Baker Street, London", "sherlock@consultingdetective.org"),
("spongebob", "124 Conch Street, Bikini Bottom", "spongebob@yahoo.com"),
("jessica", "698 Candlewood Land, Cabot Cove", "fletcher@gmail.com"),
("dursley", "4 Privet Drive, Little Whinging, Surrey", "dursley@gmail.com");


CREATE TABLE order_status (
  order_id INT PRIMARY KEY,
  delivery_id VARCHAR(255) NOT NULL,
  status ENUM('pending', 'dispatched') NOT NULL,
  status_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO order_status (order_id, delivery_id, status)
VALUES (?, ?, ?)


//Step 1 task C

CREATE DATABASE estore;

CREATE TABLE orders (

    orderId     int not null,
	deliveryId  int not null,
	name        char(32) not null,
	status      char(64) not null,
	orderDate   date,
	lineItems   text not null,
    PRIMARY KEY (name)
);