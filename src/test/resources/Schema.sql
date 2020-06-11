drop database if exists testDB;
create database if not exists testDB;
use testDB;
CREATE TABLE customer(customer_id int NOT NULL auto_increment,name varchar (20) NOT NULL,Address varchar (30),phone_number varchar (11),email varchar (30),age int,PRIMARY KEY(customer_id));
CREATE TABLE items(item_id int NOT NULL auto_increment,item varchar(255) NOT NULL,quantity int NOT NULL,price dec(4,2) NOT NULL,PRIMARY KEY(item_id));
CREATE TABLE orders(order_id int NOT NULL auto_increment,fk_customer_id int NOT NULL,time_placed timestamp default current_timestamp,PRIMARY KEY(order_ID),FOREIGN KEY(fk_customer_id) REFERENCES customer(customer_id));
CREATE TABLE orderline(orderline_id int NOT NULL auto_increment,fk_order_id int NOT NULL, fk_item_id int NOT NULL, qty_ordered int Not Null, PRIMARY KEY(orderline_id),FOREIGN KEY(fk_order_id) REFERENCES orders(order_id),FOREIGN KEY(fk_item_id) REFERENCES items(item_id));