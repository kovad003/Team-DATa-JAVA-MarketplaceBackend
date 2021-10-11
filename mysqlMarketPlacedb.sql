ddddDROP DATABASE IF EXISTS webshopdb;
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

CREATE TABLE category (
id varchar(10) NOT NULL,
title varchar(25) not null,
color varchar(25) default '#ffffff',
description varchar(100),
imageurl varchar(500),
PRIMARY KEY (id)
);
CREATE TABLE customer (
id varchar(25) NOT NULL,
name varchar(50) NOT NULL,
family varchar(50) NOT NULL,
username varchar(50) NOT NULL,
dateofbirth varchar(25) ,
email varchar(100) NOT NULL,
phone varchar(25),
imageurl varchar(200)
);

INSERT INTO customer (id, name , family, username, dateofbirth, email, phone, imageurl) VALUES
('p001', 'Frank', 'Larson', 'flarson', '20.03.1989', 'f.larson@gmail.com', '0403771254', "https://images.unsplash.com/flagged/photo-1570612861542-284f4c12e75f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('p004', 'Jacki', 'Fitcher', 'jackyfi' , '12.05.1992', 'jacki.fitcher@gmail.com', '0402875145', "https://images.unsplash.com/photo-1573140247632-f8fd74997d5c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('p005', 'Sara', 'Peterson', 'speterson', '10.08.1996', 's.peterson@gmail.com', '0467568412', "https://images.unsplash.com/photo-1509967419530-da38b4704bc6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=895&q=80");

select * from customer;

# Creating item table
CREATE TABLE item (
itemId INTEGER NOT NULL auto_increment,
categoryId INTEGER NOT NULL,
customerId INTEGER NOT NULL,
title varchar(25) NOT NULL,
price decimal(10,2) NOT NULL,
description varchar(500) NOT NULL,
image varchar(255) NOT NULL,
`condition` varchar(25) NOT NULL,
location varchar (55) NOT NULL,
datePosted timestamp,
PRIMARY KEY (itemId)
);

INSERT INTO item (categoryId, customerId, title, price, description, `condition`, location, image) VALUES
(1, 1001, "Dell notebook", 150,
"I have just bought a desktop PC so I do not need this any longer.", 
"used", "Hameenlinna",
"https://i0.wp.com/cdn.mos.cms.futurecdn.net/zM9p9D2RUQebhKR3CieqZA.jpg"),

(2, 1002, "Grey Sofa", 69.99, 
"Granny's old sofa. She got bored after 34 years...", 
"used", "Hameenlinna",
"https://moderntovintage.com/wp-content/uploads/2017/08/Photo-Aug-01-2-08-05-PM-300x225.jpg"),

(3, 1003, "Running shoes", 250, 
"Brand new running shoe. Ideal for longer distances.", 
"new", "Hameenlinna",
"http://4.bp.blogspot.com/-PKLvGmPzWn8/Tz3iUwonF2I/AAAAAAAAAIo/6T3zlIBhJ3o/s400/adidas+running+shoes.jpg"
),

('3', '1003' , 'Lamborgini', '86000' ,
 'Black interior with white accent stitching. Full babied with 5 layers of Ceramic Pro 9H and 3 layers of Ceramic Pro Lite. Full frontal protection (PPF). Carbon Fiber mirror caps. Selling to make room for additional investments',
 'old', 'Hameenlinna' ,
 "https://images.unsplash.com/photo-1511919884226-fd3cad34687c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

('7', '1001' , 'Cofee maker', '150' ,
 'Etiam in commodo mauris. Integer cursus laoreet ante, sed consectetur urna molestie id. Nunc hendrerit quis dolor ac sollicitudin. Fusce ut pretium velit. ',
 'very new', 'Hameenlinna' ,
 "https://images.unsplash.com/photo-1576470331852-65ef7a0243a8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

('4', '1004' , 'Nike shoes', '48' ,
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam dignissim, lectus quis lacinia vulputate, orci mauris consectetur lectus, ut pharetra leo velit ut nisl.',
 'new', 'Hameenlinna' ,
 "https://images.unsplash.com/photo-1623684225794-a8f1f5037f5c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

('1', '1005' , 'Sofa', '100' ,
 'This sofa was bought from Sofology and is 4 years old - it is extremely comfortable and all the electrics are in full working order.There are 3 small areas on the arms and seat where the surface has worn slightly and there is an area where excessive head wear has dis-colored the leather, I tried to clean it and it went a darker colour,See pics - so we use a "Throw" to cover the top part of the sofa and it looks fine. Clean.',
 'very new', 'Hameenlinna' ,
 "https://images.unsplash.com/photo-1582582494705-f8ce0b0c24f0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=869&q=80"),

('5', '1004' , 'Play station 3', '120' ,
 'Aenean ut ex lacinia, consectetur quam vitae, iaculis nibh. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.',
 'Old',  'Lahti' ,
 "https://images.unsplash.com/photo-1526509867162-5b0c0d1b4b33?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"),

('7', '1005' , 'Coocking Pan', '5' ,
 'Quisque convallis mi at sapien molestie faucibus. In velit ex, elementum vitae cursus id, interdum nec mi. Sed pellentesque risus malesuada, egestas mi pretium, porttitor risus.',
 'new',  'Hameenlinna' ,
 "https://images.unsplash.com/photo-1592156328757-ae2941276b2c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

('4', '1003' , 'Nike shoes', '18' ,
 'Nunc ultricies imperdiet ligula ac ullamcorper. Cras eget dictum nulla, lobortis malesuada metus. Vestibulum iaculis, eros vel tempus laoreet, augue diam lacinia lacus, a pretium risus nunc sit amet tortor. Aenean volutpat nisl vitae tellus sagittis aliquet. Mauris a felis a nisi auctor accumsan.',
 'new', 'Helsinki' ,
 "https://images.unsplash.com/photo-1524532787116-e70228437bbe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869&q=80"),

('1', '1002' , 'Sofa', '180' ,
 'Praesent ut nisi non arcu sodales cursus eget ut nunc. Donec vulputate, lorem faucibus porttitor lacinia, massa diam hendrerit metus, sed pharetra leo velit consequat massa. Donec malesuada elementum condimentum. Etiam leo diam, viverra vitae leo id, auctor suscipit enim.',
 'new', 'Helsinki' ,
 "https://images.unsplash.com/photo-1605774337664-7a846e9cdf17?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=774&q=80"),

('6', '1002' , 'Boardgame', '120' ,
 'Donec congue neque lacus, id finibus libero commodo id. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean laoreet interdum arcu, vitae sodales augue bibendum quis. Sed rhoncus arcu ex, ut luctus velit posuere a. Morbi in nibh metus.',
 'new', 'Helsinki' ,
 "https://images.unsplash.com/photo-1606503153255-59d8b8b82176?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

('1', '1001' , 'Classic Chair', '35' ,
 'Sed at erat molestie, efficitur mi id, vehicula augue. Vestibulum non libero ac mi condimentum venenatis et a arcu. Maecenas nec nulla semper, vehicula odio at, interdum leo.',
 'new', 'Tampere' , 
 "https://images.unsplash.com/photo-1462212210333-335063b676bc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1032&q=80"),

('3', '1003' , 'Volkswagen', '980' ,
 'Donec congue neque lacus, id finibus libero commodo id. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean laoreet interdum arcu, vitae sodales augue bibendum quis. Sed rhoncus arcu ex, ut luctus velit posuere a. Morbi in nibh metus.',
 'old', 'Helsinki' ,
 "https://images.unsplash.com/photo-1503650923300-dd2f6a007eaf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80");

select * from item;





