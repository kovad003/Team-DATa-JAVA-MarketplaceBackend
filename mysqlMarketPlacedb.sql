DROP DATABASE IF EXISTS webshopdb;
create database webshopdb;
use webshopdb;
GRANT ALL on webshopdb.* to nobody@localhost identified by 'kukucs';

CREATE TABLE item (
id INTEGER NOT NULL auto_increment,
name varchar(25) not null,
price decimal(10,2) not null,
description varchar(75) not null,
category varchar(25) not null,
PRIMARY KEY (id)
);

INSERT INTO item (name, price, description, category) VALUES
("Rain coat", 29.99, "My son is growing like a champ. A red coat is on the sale!", "Clothes"),
("Grey Sofa", 69.99, "Granny's old sofa. She got bored after 34 years...", "Furniture"),
("Dell notebook", 150, "I have just bought a desktop PC so I do not need this any longer.", "Electronics"),
("Samsung notebook", 25, "Laptop is malfunctioning. Only buy it for spare its spare parts.", "Electronics"),
("Running shoes", 250, "Brand new running shoe. Ideal for longer distances.", "Clothes"),
("Bicycle", 104.5, "Bicycle in excellent condition. Manufactured in the Netherlands!", "Sports");

SELECT * from item;
/* FOR JAVA
SELECT * FROM item WHERE id = 3;
UPDATE item SET description = 'new description' WHERE id = 3;
UPDATE item SET name = ?, price = ?, description = ?, category = ? WHERE id = ?;
DELETE FROM item WHERE id=1;
*/

/* create table category and insert all categories */
CREATE TABLE category (
id varchar(10) NOT NULL,
title varchar(25) not null,
color varchar(25) default '#ffffff',
description varchar(100),
imageurl varchar(500),
PRIMARY KEY (id)
);

INSERT INTO category (id, title , color, description, imageurl) VALUES
('c01', 'Furnitures', '#586ba4', 'Furnitures, Sofa, Chair, Table and etc.' , "https://images.unsplash.com/photo-1550581190-9c1c48d21d6c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=809&q=80"),
('c02', 'Books', '#f5dd90' , 'Books and other written documents' , "https://images.unsplash.com/photo-1495446815901-a7297e633e8d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('c03', 'Cars', '#f68e5f', 'Vehicles and all related items', "https://images.unsplash.com/photo-1539799139339-50c5fe1e2b1b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80"),
('c04', 'Clothes', '#324376', 'All the items worn to cover the body like pants, dress, glasses and etc.' , "https://images.unsplash.com/photo-1551488831-00ddcb6c6bd3?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('c05', 'Electronics', '#f76c5e', 'All the electronic items like TV, Iron, computer, labtop, Phone and etc.', "https://images.unsplash.com/photo-1496171367470-9ed9a91ea931?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('c06', 'Games', '#586ba4', 'All the differnt type of games like Boeardgames, console, toys and etc.', "https://images.unsplash.com/photo-1500995617113-cf789362a3e1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('c07', 'Kitchen', '#f5dd90', 'All the items related to Kitchen', "https://images.unsplash.com/photo-1609766856923-7e0a0c06584d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('c08', 'Sports', '#f68e5f', 'All sport materials',"https://images.unsplash.com/photo-1584735935682-2f2b69dff9d2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=871&q=80"),
('c09', 'Property', '#324376', 'Houses, Villas, and any type of tradable properties', "https://images.unsplash.com/photo-1515263487990-61b07816b324?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"),
('c10', 'Bikes', '#f5dd90', 'Bikes and bicycles and all items related to them' , "https://images.unsplash.com/photo-1485965120184-e220f721d03e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('c11', 'Others', '#f68e5f', 'Items that do not fall into the specified categories.', "https://images.unsplash.com/photo-1528396518501-b53b655eb9b3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80");

select * from category;






