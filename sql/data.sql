create database if not exists inventoryDB;
use inventoryDB;

Describe customer;
Insert into customer(name, address, phone_number, email) values('Simon', '64 Zoo Lane', 0789236789, 'kin@inbox.com' );
Insert into customer(name, address, phone_number, email) values('Bruce', '87 Ivy Road', 0761436781, 'gotham@batbox.com' );
Insert into customer(name, address, phone_number, email) values('Amanda', '12 Gunners Street', 0752961123, 'kin@inbox.com' );
Insert into customer(name, address, phone_number, email) values('Susan', '19 Barnay Street', 0752346123, 'Susie@inbox.com' );

Select * FROM customer;
Update customer SET email ='Ray2018@pinmail.com' WHERE name= 'Amanda';

Alter Table customer add age int;
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

Alter Table items add year_published int;
Update items SET year_published=1990 WHERE item_id='1';
Update items SET year_published=1987 WHERE item_id='2';
Update items SET year_published=1920 WHERE item_id='3';
Update items SET year_published=2004 WHERE item_id='4';

Delete from items Where item_id=2;
Insert into items values(0, 'Spderman', 90, 5.99, 1997);
Update items SET item ='Spiderman' WHERE item_id= 5;
Select*from items;


Describe orders;
Insert into orders(fk_customer_id) values(3);
Insert into orders(fk_customer_id) values(5);
Insert into orders(fk_customer_id) values(1);
Insert into orders(fk_customer_id) values(2);
Insert into orders(fk_customer_id) values(5);
Insert into orders(fk_customer_id) values(3);
Insert into orders(fk_customer_id) values(2);
select * from orders;
Delete from orders Where order_id=1;


Describe orderline;
Select*from orderline;
Insert into orderline(fk_order_id,fk_item_id, qty_ordered) values(2, 4,8);
Insert into orderline(fk_order_id,fk_item_id, qty_ordered) values(3, 5,2);
Insert into orderline(fk_order_id,fk_item_id, qty_ordered) values(4, 4,1);
Insert into orderline(fk_order_id,fk_item_id, qty_ordered) values(5, 1,5);
Insert into orderline(fk_order_id,fk_item_id, qty_ordered) values(6, 3,10);
Insert into orderline(fk_order_id,fk_item_id, qty_ordered) values(7, 3,1);

Alter Table orderline add status varchar (10);
Update orderline SET status='shipped' WHERE orderline_id='1';
Update orderline SET status='pending' WHERE orderline_id='2';
Update orderline SET status='pending' WHERE orderline_id='3';
Update orderline SET status='shipped' WHERE orderline_id='4';
Update orderline SET status='shipped' WHERE orderline_id='5';
Update orderline SET status='pending' WHERE orderline_id='6';

select * from orderline;
Delete from orderline Where orderline_id=6;
select * from orderline;

select * from orders join orderline on orders.order_id = orderline.fk_order_id;
select * from orders join orderline on orders.order_id = orderline.fk_order_id join items on items.item_id = orderline.fk_item_id;
select *, qty_ordered*price as order_total from orders join orderline on orders.order_id = orderline.fk_order_id join items on items.item_id = orderline.fk_item_id;
select fk_customer_id , sum(qty_ordered*price) as order_total from orders join orderline on orders.order_id = orderline.fk_order_id join items on items.item_id = orderline.fk_item_id group by fk_customer_id;
select order_id , sum(qty_ordered*price) as order_total from orders join orderline on orders.order_id = orderline.fk_order_id join items on items.item_id = orderline.fk_item_id group by fk_customer_id;
