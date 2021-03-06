create database if not exists inventoryDB;
use inventoryDB;

Describe customer;
Insert into customer(name, address, phone_number, email) values('Simon', '64 Zoo Lane', 0789236789, 'kin@inbox.com' );
Insert into customer(name, address, phone_number, email) values('Bruce', '87 Ivy Road', 0761436781, 'gotham@batbox.com' );
Insert into customer(name, address, phone_number, email) values('Amanda', '12 Gunners Street', 0752961123, 'kin@inbox.com' );
Insert into customer(name, address, phone_number, email) values('Susan', '19 Barnay Street', 0752346123, 'Susie@inbox.com' );

Select * FROM customer;
Update customer SET email ='Ray2018@pinmail.com' WHERE name= 'Amanda';


Update customer SET age=20 WHERE name='simon';
Update customer SET age=35 WHERE name='Bruce';
Update customer SET age=28 WHERE name='Susan';

Delete from customer WHERE customer_id=4;
Insert into customer values(0, 'Jane', '55 Potters Avenue', 07981756248, 'Jane98@pobox.com', 27);
Select * from customer;


Describe items;
Insert into items(item, quantity,price)values('The Great Gatsby',200,29.99);
Insert into items(item, quantity,price)values('The Wind in the Willows',90,9.99);
Insert into items(item, quantity,price)values('Peter Pan',130,19.50);
Insert into items(item, quantity,price)values('Da vinci Code',10,20.00);


Delete from items Where item_id=2;
Insert into items values(0, 'Spderman', 90, 5.99);
Update items SET item ='Spiderman' WHERE item_id= 5;
Select*from items;

select * from customer;
Describe orders;
Insert into orders(fk_customer_id) values(3);
Insert into orders(fk_customer_id) values(2);
Insert into orders(fk_customer_id) values(5);
Insert into orders(fk_customer_id) values(6);
Insert into orders(fk_customer_id) values(4);
Insert into orders(fk_customer_id) values(7);
Insert into orders(fk_customer_id) values(1);
select * from orders;
Delete from orders Where order_id=2;


Describe orderline;
Select*from orderline;
Insert into orderline(fk_order_id,fk_item_id, qty_ordered) values(2, 4,8);
Insert into orderline(fk_order_id,fk_item_id, qty_ordered) values(7, 1,1);

select * from orderline;
Delete from orderline Where orderline_id=6;
select * from orderline;

select * from orders join orderline on orders.order_id = orderline.fk_order_id;
select * from orders join orderline on orders.order_id = orderline.fk_order_id join items on items.item_id = orderline.fk_item_id;
select *, qty_ordered*price as order_total from orders join orderline on orders.order_id = orderline.fk_order_id join items on items.item_id = orderline.fk_item_id;
select fk_customer_id , sum(qty_ordered*price) as order_total from orders join orderline on orders.order_id = orderline.fk_order_id join items on items.item_id = orderline.fk_item_id group by fk_customer_id;

