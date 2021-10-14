# DATABSE =================================================================================================================================
# Creating Databse
DROP DATABASE IF EXISTS webshopdb;
create database webshopdb;
use webshopdb;

# Granting user access
GRANT ALL on webshopdb.* to nobody@localhost identified by 'kukucs';
# =========================================================================================================================================
# CATEGORY TABLE ==========================================================================================================================
/* create table category and insert all categories */
CREATE TABLE category (
id int(10) NOT NULL,
title varchar(25) not null,
color varchar(25) default '#ffffff',
description varchar(100),
imageurl varchar(500),
PRIMARY KEY (id)
);

INSERT INTO category (id, title , color, description, imageurl) VALUES
(1 , 'Furnitures', '#586ba4', 'Furnitures, Sofa, Chair, Table and etc.' , "https://images.unsplash.com/photo-1550581190-9c1c48d21d6c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=809&q=80"),
(2, 'Books', '#f5dd90' , 'Books and other written documents' , "https://images.unsplash.com/photo-1495446815901-a7297e633e8d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
(3, 'Cars', '#f68e5f', 'Vehicles and all related items', "https://images.unsplash.com/photo-1539799139339-50c5fe1e2b1b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80"),
(4, 'Clothes', '#324376', 'All the items worn to cover the body like pants, dress, glasses and etc.' , "https://images.unsplash.com/photo-1551488831-00ddcb6c6bd3?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
(5, 'Electronics', '#f76c5e', 'All the electronic items like TV, Iron, computer, labtop, Phone and etc.', "https://images.unsplash.com/photo-1496171367470-9ed9a91ea931?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
(6, 'Games', '#586ba4', 'All the differnt type of games like Boeardgames, console, toys and etc.', "https://images.unsplash.com/photo-1500995617113-cf789362a3e1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
(7, 'Kitchen', '#f5dd90', 'All the items related to Kitchen', "https://images.unsplash.com/photo-1609766856923-7e0a0c06584d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
(8, 'Sports', '#f68e5f', 'All sport materials',"https://images.unsplash.com/photo-1584735935682-2f2b69dff9d2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=871&q=80"),
(9, 'Property', '#324376', 'Houses, Villas, and any type of tradable properties', "https://images.unsplash.com/photo-1515263487990-61b07816b324?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"),
(10, 'Bikes', '#f5dd90', 'Bikes and bicycles and all items related to them' , "https://images.unsplash.com/photo-1485965120184-e220f721d03e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
(11, 'Others', '#f68e5f', 'Items that do not fall into the specified categories.', "https://images.unsplash.com/photo-1528396518501-b53b655eb9b3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80");

select * from category;
# =========================================================================================================================================
# CUSTOMER TABLE ==========================================================================================================================
/* Tukhtaboy version
# Creating users table
USE loginsystemdb;
CREATE TABLE users (
id INTEGER(11) NOT NULL auto_increment,
username varchar(90) not null,
firstname varchar(90) not null,
lastname varchar(90) not null,
email varchar(90) not null,
password varchar(90) not null,
create_datetime datetime not null,
PRIMARY KEY (id));
*/

CREATE TABLE customer ( 
customerId INTEGER NOT NULL auto_increment,
firstName varchar(55) NOT NULL,
lastName varchar(55) NOT NULL,
userName varchar(55) NOT NULL,
`password` varchar(55) NOT NULL,
dateOfBirth varchar(25) ,
email varchar(100) NOT NULL,
phone varchar(15) NOT NULL,
image varchar(255) NOT NULL,
PRIMARY KEY (customerId)
);
ALTER TABLE customer AUTO_INCREMENT=1000;


INSERT INTO customer ( firstName, lastName, userName, `password`, dateOfBirth, email, phone, image) VALUES
('Frank', 'Larson', 'flarson', 'flarson1234', '20.03.1989', 'f.larson@gmail.com', '0403771254', "https://images.unsplash.com/flagged/photo-1570612861542-284f4c12e75f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('Jacki', 'Fitcher', 'jackyfi' , 'jackyfi1234', '12.05.1992', 'jacki.fitcher@gmail.com', '0402875145', "https://images.unsplash.com/photo-1573140247632-f8fd74997d5c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),
('Sara', 'Peterson', 'speterson', 'speterson1234', '10.08.1996', 's.peterson@gmail.com', '0467568412', "https://images.unsplash.com/photo-1509967419530-da38b4704bc6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=895&q=80");

/*
DROP TABLE customer;
CREATE TABLE customer (
id INTEGER NOT NULL auto_increment,
`password` varchar(55) NOT NULL,
PRIMARY KEY (id)
);INSERT INTO customer (`password`) VALUES
('password'),
('password'),
('password');
*/
SELECT customerId, userName FROM customer WHERE userName = "flarson" AND `password`= "flarson1234";
select * from customer;
# =========================================================================================================================================
# ITEM TABLE ==============================================================================================================================
# Creating item table
CREATE TABLE item (
itemId INTEGER NOT NULL auto_increment,
categoryId INTEGER NOT NULL,
customerId INTEGER NOT NULL,
title varchar(55) NOT NULL,
price decimal(10,2) NOT NULL,
description varchar(500) NOT NULL,
image varchar(255) NOT NULL,
`condition` varchar(25) NOT NULL,
location varchar (255) NOT NULL,
datePosted timestamp,
PRIMARY KEY (itemId)
);

INSERT INTO item (categoryId, customerId, title, price, description, `condition`, location, image) VALUES
(5, 1000, "Dell notebook", 150,
"I have just bought a desktop PC so I do not need this any longer.", 
"used", "Hameenlinna",
"https://i0.wp.com/cdn.mos.cms.futurecdn.net/zM9p9D2RUQebhKR3CieqZA.jpg"),

(1, 1001, "Grey Sofa", 69.99, 
"Granny's old sofa. She got bored after 34 years...", 
"used", "Hameenlinna",
"https://moderntovintage.com/wp-content/uploads/2017/08/Photo-Aug-01-2-08-05-PM-300x225.jpg"),

(4, 1002, "Running shoes", 250, 
"Brand new running shoe. Ideal for longer distances.", 
"new", "Hameenlinna",
"http://4.bp.blogspot.com/-PKLvGmPzWn8/Tz3iUwonF2I/AAAAAAAAAIo/6T3zlIBhJ3o/s400/adidas+running+shoes.jpg"
),

(3, '1002' , 'Lamborgini', '86000' ,
 'Black interior with white accent stitching. Full babied with 5 layers of Ceramic Pro 9H and 3 layers of Ceramic Pro Lite. Full frontal protection (PPF). Carbon Fiber mirror caps. Selling to make room for additional investments',
 'old', 'Hameenlinna' ,
 "https://images.unsplash.com/photo-1511919884226-fd3cad34687c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

(7, '1000' , 'Cofee maker', '150' ,
 'Etiam in commodo mauris. Integer cursus laoreet ante, sed consectetur urna molestie id. Nunc hendrerit quis dolor ac sollicitudin. Fusce ut pretium velit. ',
 'very new', 'Hameenlinna' ,
 "https://images.unsplash.com/photo-1576470331852-65ef7a0243a8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

(4, '1001' , 'Nike shoes', '48' ,
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam dignissim, lectus quis lacinia vulputate, orci mauris consectetur lectus, ut pharetra leo velit ut nisl.',
 'new', 'Hameenlinna' ,
 "https://images.unsplash.com/photo-1623684225794-a8f1f5037f5c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

(1, '1002' , 'Sofa', '100' ,
 'This sofa was bought from Sofology and is 4 years old - it is extremely comfortable and all the electrics are in full working order.There are 3 small areas on the arms and seat where the surface has worn slightly and there is an area where excessive head wear has dis-colored the leather, I tried to clean it and it went a darker colour,See pics - so we use a "Throw" to cover the top part of the sofa and it looks fine. Clean.',
 'very new', 'Hameenlinna' ,
 "https://images.unsplash.com/photo-1582582494705-f8ce0b0c24f0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=869&q=80"),

(5, '1001' , 'Play station 3', '120' ,
 'Aenean ut ex lacinia, consectetur quam vitae, iaculis nibh. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.',
 'Old',  'Lahti' ,
 "https://images.unsplash.com/photo-1526509867162-5b0c0d1b4b33?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"),

(7, '1002' , 'Coocking Pan', '5' ,
 'Quisque convallis mi at sapien molestie faucibus. In velit ex, elementum vitae cursus id, interdum nec mi. Sed pellentesque risus malesuada, egestas mi pretium, porttitor risus.',
 'new',  'Hameenlinna' ,
 "https://images.unsplash.com/photo-1592156328757-ae2941276b2c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

(4, '1002' , 'Nike shoes', '18' ,
 'Nunc ultricies imperdiet ligula ac ullamcorper. Cras eget dictum nulla, lobortis malesuada metus. Vestibulum iaculis, eros vel tempus laoreet, augue diam lacinia lacus, a pretium risus nunc sit amet tortor. Aenean volutpat nisl vitae tellus sagittis aliquet. Mauris a felis a nisi auctor accumsan.',
 'new', 'Helsinki' ,
 "https://images.unsplash.com/photo-1524532787116-e70228437bbe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869&q=80"),

(1, '1001' , 'Sofa', '180' ,
 'Praesent ut nisi non arcu sodales cursus eget ut nunc. Donec vulputate, lorem faucibus porttitor lacinia, massa diam hendrerit metus, sed pharetra leo velit consequat massa. Donec malesuada elementum condimentum. Etiam leo diam, viverra vitae leo id, auctor suscipit enim.',
 'new', 'Helsinki' ,
 "https://images.unsplash.com/photo-1605774337664-7a846e9cdf17?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=774&q=80"),

(6, '1001' , 'Boardgame', '120' ,
 'Donec congue neque lacus, id finibus libero commodo id. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean laoreet interdum arcu, vitae sodales augue bibendum quis. Sed rhoncus arcu ex, ut luctus velit posuere a. Morbi in nibh metus.',
 'new', 'Helsinki' ,
 "https://images.unsplash.com/photo-1606503153255-59d8b8b82176?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"),

(1, '1000' , 'Classic Chair', '35' ,
 'Sed at erat molestie, efficitur mi id, vehicula augue. Vestibulum non libero ac mi condimentum venenatis et a arcu. Maecenas nec nulla semper, vehicula odio at, interdum leo.',
 'new', 'Tampere' , 
 "https://images.unsplash.com/photo-1462212210333-335063b676bc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1032&q=80"),

(3, '1002' , 'Volkswagen', '980' ,
 'Donec congue neque lacus, id finibus libero commodo id. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean laoreet interdum arcu, vitae sodales augue bibendum quis. Sed rhoncus arcu ex, ut luctus velit posuere a. Morbi in nibh metus.',
 'old', 'Helsinki' ,
 "https://images.unsplash.com/photo-1503650923300-dd2f6a007eaf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80");

SELECT * from item;
# DESCRIBE item;
/*
SELECT * from item WHERE price < 100;
SELECT * from item WHERE price > 100;
SELECT * from item WHERE price >= 100 AND price <= 200;
SELECT * from item WHERE price >= ? AND price <= ?;

*/

/* FOR JAVA
SELECT * FROM item WHERE id = 3;
UPDATE item SET description = 'new description' WHERE id = 3;
UPDATE item SET name = ?, price = ?, description = ?, category = ? WHERE id = ?;
DELETE FROM item WHERE id=1;
DELETE FROM item WHERE id=3;
DELETE FROM item WHERE id=1 LIMIT ROW_COUNT;
SELECT ROW_COUNT(); #Checks deleted rows
DELETE FROM item WHERE id=1 LIMIT ROW_COUNT;
DELETE FROM item WHERE id=15 LIMIT ROW_COUNT;
SELECT ROW_COUNT(); #Checks deleted rows
INSERT INTO item (categoryId, customerId, title, price, description, image, `condition`) VALUES
(3,3,"dd", 4,"d","d","d");
UPDATE item SET categoryId = 111, customerId = 111, title = "newtitle", price = 111, description = "new descr", image = "https://images.wallpapersden.com/image/wxl-steven-seagal-brunette-face_53269.jpg", `condition` = "updated condition" WHERE itemId = 1;
*/
# ============================================================================================================================================
# REGION TABLE ===============================================================================================================================
CREATE TABLE region( # let's keep it as manual value(no auto_incr.)
regionId INT NOT NULL, 
regionName VARCHAR(55) NOT NULL);

INSERT INTO region (regionId, regionName) VALUES
(1,"Åland"),
(2,"Varsinais-Suomi"),
(3,"Uusimaa"),
(4,"Satakunta"),
(5,"Päijät-Häme"),
(6,"Pohjois-Savo"),
(7,"Pohjois-Pohjanmaa"),
(8,"Pohjois-Karjala"),
(9,"Pohjanmaa"),
(10,"Pirkanmaa"),
(11,"Lappi"),
(12,"Kymenlaakso"),
(13,"Keski-Suomi"),
(14,"Keski-Pohjanmaa"),
(15,"Kanta-Häme"),
(16,"Kainuu"),
(17,"Etelä-Savo"),
(18,"Etelä-Pohjanmaa"),
(19,"Etelä-Karjala");

SELECT * FROM region;

# ============================================================================================================================================
# CITY TABLE =================================================================================================================================
/* Source of data:
https://simplemaps.com/data/fi-cities
*/
CREATE TABLE city(
cityId INT NOT NULL AUTO_INCREMENT,
regionId INT NOT NULL,
cityName VARCHAR(55) NOT NULL,
latitude FLOAT(10,4) NOT NULL, /*10 digit in total, 4 digit as decimal*/
longitude FLOAT(10,4) NOT NULL,
PRIMARY KEY (cityId));

INSERT INTO city(regionId, cityName, latitude, longitude)VALUES
(1,"Mariehamn",60.0986,19.9444),
(1,"Jomala",60.15,19.95),
(1,"Lemland",60.0806,20.1),
(1,"Hammarland",60.2167,19.7403),
(1,"Eckerö",60.2167,19.55),
(1,"Brändö",60.4117,21.0453),
(1,"Geta",60.375,19.85),
(1,"Vårdö",60.2417,20.375),
(1,"Lumparland",60.1167,20.2583),
(1,"Kumlinge",60.2583,20.7783),
(1,"Sottunga",60.1333,20.6667),
(1,"Godby",60.23,19.9881),
(1,"Ödkarby",60.3073,19.9862),
(1,"Björby",60.2572,20.1342),
(1,"Föglö",60,20.4333),
(1,"Karlby",59.9167,20.9),
(1,"Åva",60.4667,21.0833),
(2,"Turku",60.4517,22.27),
(2,"Salo",60.3831,23.1331),
(2,"Kaarina",60.4069,22.3722),
(2,"Raisio",60.4861,22.1694),
(2,"Lieto",60.5,22.4497),
(2,"Naantali",60.4681,22.0264),
(2,"Loimaa",60.8514,23.0583),
(2,"Uusikaupunki",60.7833,21.4167),
(2,"Pargas",60.3,22.3),
(2,"Paimio",60.4569,22.6861),
(2,"Masku",60.5708,22.1),
(2,"Somero",60.6292,23.5139),
(2,"Laitila",60.8792,21.6931),
(2,"Mynämäki",60.6833,21.9833),
(2,"Rusko",60.5417,22.2222),
(2,"Nousiainen",60.6,22.0833),
(2,"Aura",60.6472,22.5903),
(2,"Kimito",60.1639,22.7278),
(2,"Sauvo",60.3417,22.6917),
(2,"Koski Tl",60.6542,23.1403),
(2,"Pyhäranta",60.95,21.4417),
(2,"Marttila",60.5833,22.9),
(2,"Tarvasjoki",60.5833,22.7333),
(2,"Taivassalo",60.5617,21.6083),
(2,"Oripää",60.8556,22.6972),
(2,"Kustavi",60.5467,21.3583),
(2,"Kyrö",60.7,22.75),
(2,"Vinkkilä",60.6833,21.7167),
(2,"Dalsbruk",60.0333,22.5167),
(3,"Helsinki",60.1756,24.9342),
(3,"Espoo",60.21,24.66),
(3,"Vantaa",60.3,25.0333),
(3,"Porvoo",60.3931,25.6639),
(3,"Lohja",60.25,24.0667),
(3,"Hyvinkää",60.6306,24.8597),
(3,"Nurmijärvi",60.4667,24.8083),
(3,"Järvenpää",60.4722,25.0889),
(3,"Kirkkonummi",60.1167,24.4167),
(3,"Tuusula",60.4028,25.0292),
(3,"Kerava",60.4028,25.1),
(3,"Vihti",60.4167,24.3331),
(3,"Raseborg",59.975,23.4361),
(3,"Mäntsälä",60.6331,25.3167),
(3,"Sipoo",60.3764,25.2722),
(3,"Loviisa",60.4569,26.225),
(3,"Kauniainen",60.2097,24.7264),
(3,"Karkkila",60.5347,24.2097),
(3,"Hanko",59.8236,22.9681),
(3,"Siuntio",60.1333,24.2167),
(3,"Ingå",60.0458,24.0056),
(3,"Pornainen",60.475,25.375),
(3,"Askola",60.5278,25.6),
(3,"Lappträsk",60.6167,26.2),
(3,"Pukkila",60.645,25.5833),
(3,"Myrskylä",60.6667,25.85),
(3,"Nummela",60.3333,24.3333),
(4,"Pori",61.4847,21.7972),
(4,"Rauma",61.1167,21.5),
(4,"Ulvila",61.4292,21.875),
(4,"Eura",61.1333,22.0833),
(4,"Kankaanpää",61.8042,22.3944),
(4,"Huittinen",61.1764,22.6986),
(4,"Kokemäki",61.2556,22.3486),
(4,"Harjavalta",61.3139,22.1417),
(4,"Säkylä",61.05,22.35),
(4,"Eurajoki",61.2,21.7333),
(4,"Nakkila",61.3653,22.0042),
(4,"Luvia",61.3611,21.625),
(4,"Merikarvia",61.8583,21.5),
(4,"Köyliö",61.1167,22.3083),
(4,"Karvia",62.1333,22.5583),
(4,"Pomarkku",61.6917,22.0083),
(4,"Jämijärvi",61.8167,22.6917),
(4,"Lavia",61.5958,22.5861),
(4,"Honkajoki",61.9931,22.2639),
(4,"Siikainen",61.8833,21.8167),
(5,"Lahti",60.9804,25.655),
(5,"Hollola",60.9886,25.5128),
(5,"Heinola",61.2028,26.0319),
(5,"Orimattila",60.8042,25.7333),
(5,"Nastola",60.9477,25.9301),
(5,"Sysmä",61.5028,25.6847),
(5,"Padasjoki",61.35,25.275),
(5,"Hartola",61.5784,26.0142),
(5,"Hämeenkoski",61.025,25.15),
(5,"Järvelä",60.868,25.273),
(5,"Vääksy",61.1722,25.5472),
(6,"Kuopio",62.8925,27.6783),
(6,"Iisalmi",63.5611,27.1889),
(6,"Siilinjärvi",63.075,27.66),
(6,"Varkaus",62.3167,27.8833),
(6,"Lapinlahti",63.3667,27.3833),
(6,"Leppävirta",62.4917,27.7875),
(6,"Kiuruvesi",63.6528,26.6194),
(6,"Suonenjoki",62.625,27.1222),
(6,"Juankoski",63.0639,28.3278),
(6,"Pielavesi",63.2333,26.7583),
(6,"Sonkajärvi",63.6667,27.5167),
(6,"Maaninka",63.1583,27.3),
(6,"Vieremä",63.7431,27.0014),
(6,"Rautalampi",62.6217,26.8333),
(6,"Kaavi",62.975,28.4833),
(6,"Tuusniemi",62.8083,28.4917),
(6,"Keitele",63.1783,26.35),
(6,"Vesanto",62.9333,26.4167),
(6,"Rautavaara",63.4944,28.2986),
(6,"Tervo",62.9556,26.7556),
(7,"Oulu",65.0142,25.4719),
(7,"Raahe",64.6847,24.4792),
(7,"Kempele",64.9125,25.5083),
(7,"Kuusamo",65.9667,29.1667),
(7,"Ylivieska",64.0722,24.5375),
(7,"Kalajoki",64.2597,23.9486),
(7,"Nivala",63.9292,24.9778),
(7,"Ii",65.3167,25.3722),
(7,"Liminka",64.8083,25.4167),
(7,"Muhos",64.8,26),
(7,"Pudasjärvi",65.3583,27),
(7,"Oulainen",64.2667,24.8167),
(7,"Haapajärvi",63.7486,25.3181),
(7,"Haapavesi",64.1375,25.3667),
(7,"Tyrnävä",64.75,25.65),
(7,"Sievi",63.9069,24.5167),
(7,"Ruukki",64.6639,25.1014),
(7,"Taivalkoski",65.575,28.2417),
(7,"Pyhäjoki",64.4667,24.2583),
(7,"Reisjärvi",63.6056,24.9319),
(7,"Utajärvi",64.75,26.4167),
(7,"Alavieska",64.1667,24.3083),
(7,"Kärsämäki",63.975,25.7583),
(7,"Lumijoki",64.8367,25.1867),
(7,"Pulkkila",64.2667,25.8667),
(7,"Pyhäntä",64.0972,26.3306),
(7,"Merijärvi",64.2967,24.4467),
(7,"Hailuoto",65.0167,24.7167),
(7,"Pyhäsalmi",63.6833,25.9833),
(8,"Joensuu",62.6,29.7639),
(8,"Kontiolahti",62.7667,29.85),
(8,"Liperi",62.5333,29.3833),
(8,"Lieksa",63.3167,30.0167),
(8,"Kitee",62.0986,30.1375),
(8,"Nurmes",63.5444,29.1333),
(8,"Outokumpu",62.725,29.0167),
(8,"Ilomantsi",62.6667,30.9333),
(8,"Juuka",63.2417,29.25),
(8,"Tohmajärvi",62.2264,30.3319),
(8,"Polvijärvi",62.855,29.3667),
(8,"Rääkkylä",62.3133,29.625),
(8,"Valtimo",63.68,28.8167),
(9,"Vaasa",63.1,21.6167),
(9,"Jakobstad",63.6667,22.7),
(9,"Korsholm",63.1125,21.6778),
(9,"Närpes",62.4736,21.3375),
(9,"Laihia",62.9764,22.0111),
(9,"Nykarleby",63.5167,22.5333),
(9,"Kristinestad",62.2736,21.3778),
(9,"Vörå",63.1333,22.25),
(9,"Kronoby",63.725,23.0333),
(9,"Malax",62.9417,21.55),
(9,"Larsmo",63.75,22.8),
(9,"Isokyrö",63,22.3167),
(9,"Korsnäs",62.7833,21.1833),
(9,"Kaskinen",62.3847,21.2222),
(9,"Bennäs",63.6,22.7917),
(10,"Tampere",61.4981,23.7608),
(10,"Nokia",61.4767,23.5053),
(10,"Ylöjärvi",61.55,23.5833),
(10,"Kangasala",61.4639,24.065),
(10,"Sastamala",61.3417,22.9083),
(10,"Lempäälä",61.3139,23.7528),
(10,"Valkeakoski",61.2667,24.0306),
(10,"Pirkkala",61.4667,23.65),
(10,"Toijala",61.1667,23.8681),
(10,"Hämeenkyrö",61.6333,23.2),
(10,"Orivesi",61.6778,24.3569),
(10,"Ikaalinen",61.7694,23.0681),
(10,"Mänttä",62.0292,24.6236),
(10,"Virrat",62.2403,23.7708),
(10,"Parkano",62.0097,23.025),
(10,"Pälkäne",61.3389,24.2681),
(10,"Urjala",61.0833,23.55),
(10,"Ruovesi",61.9833,24.0833),
(10,"Vesilahti",61.3167,23.6167),
(10,"Punkalaidun",61.1117,23.105),
(10,"Kihniö",62.2083,23.1792),
(10,"Korkeakoski",61.8,24.3667),
(11,"Rovaniemi",66.5028,25.7285),
(11,"Tornio",65.8497,24.1441),
(11,"Kemi",65.7336,24.5634),
(11,"Sodankylä",67.4149,26.5907),
(11,"Keminmaa",65.799,24.5426),
(11,"Kemijärvi",66.715,27.4306),
(11,"Inari",68.9055,27.0176),
(11,"Kittilä",67.6531,24.9114),
(11,"Ylitornio",66.3167,23.6667),
(11,"Ranua",65.9275,26.5184),
(11,"Salla",66.8333,28.6667),
(11,"Pello",66.7756,23.9635),
(11,"Posio",66.1097,28.1739),
(11,"Simo",65.6613,25.0623),
(11,"Tervola",66.0821,24.808),
(11,"Muonio",67.9593,23.6772),
(11,"Enontekiö",68.3847,23.6389),
(11,"Utsjoki",69.9078,27.0265),
(11,"Savukoski",67.2917,28.1667),
(11,"Pelkosenniemi",67.1083,27.5167),
(11,"Kolari",67.3317,23.7913),
(11,"Ivalo",68.6565,27.5404),
(12,"Kouvola",60.8681,26.7042),
(12,"Kotka",60.4667,26.9458),
(12,"Hamina",60.5697,27.1981),
(12,"Virolahti",60.5833,27.7),
(12,"Miehikkälä",60.6708,27.7),
(12,"Siltakylä",60.4958,26.7097),
(12,"Kausala",60.8928,26.3394),
(13,"Jyväskylä",62.2333,25.7333),
(13,"Jyväskylän Maalaiskunta",62.2889,25.7417),
(13,"Jämsä",61.8639,25.1903),
(13,"Äänekoski",62.6042,25.7264),
(13,"Laukaa",62.4167,25.95),
(13,"Keuruu",62.2597,24.7069),
(13,"Saarijärvi",62.7056,25.2569),
(13,"Muurame",62.1292,25.6722),
(13,"Viitasaari",63.075,25.8597),
(13,"Hankasalmi",62.3889,26.4361),
(13,"Joutsa",61.7417,26.1153),
(13,"Karstula",62.875,24.8),
(13,"Pihtipudas",63.3667,25.575),
(13,"Petäjävesi",62.25,25.1833),
(13,"Uurainen",62.5,25.4367),
(13,"Konnevesi",62.6283,26.2833),
(13,"Toivakka",62.1,26.0833),
(13,"Kuhmoinen",61.5667,25.1833),
(13,"Kinnula",63.3667,24.9667),
(13,"Multia",62.4083,24.795),
(13,"Kannonkoski",62.975,25.2667),
(13,"Kyyjärvi",63.0431,24.5639),
(13,"Kivijärvi",63.12,25.075),
(13,"Luhanka",61.8,25.7),
(14,"Kokkola",63.8376,23.132),
(14,"Kannus",63.9017,23.9151),
(14,"Toholampi",63.775,24.25),
(14,"Veteli",63.4753,23.7886),
(14,"Perho",63.2167,24.4167),
(14,"Halsua",63.4633,24.1667),
(14,"Lestijärvi",63.525,24.6653),
(14,"Kaustinen",63.5481,23.6999),
(15,"Hämeenlinna",61,24.4414),
(15,"Riihimäki",60.7333,24.7667),
(15,"Forssa",60.8167,23.6167),
(15,"Loppi",60.7181,24.4417),
(15,"Tammela",60.8,23.7667),
(15,"Jokioinen",60.8042,23.4861),
(15,"Ypäjä",60.8083,23.2833),
(15,"Humppila",60.925,23.3667),
(15,"Turenki",60.9167,24.6333),
(15,"Parola",61.05,24.3667),
(15,"Oitti",60.7833,25.0333),
(16,"Kajaani",64.225,27.7333),
(16,"Sotkamo",64.1333,28.3833),
(16,"Kuhmo",64.125,29.5167),
(16,"Suomussalmi",64.8833,28.9167),
(16,"Paltamo",64.4083,27.8417),
(16,"Vaala",64.55,26.8333),
(16,"Puolanka",64.8681,27.6708),
(16,"Hyrynsalmi",64.675,28.4917),
(16,"Ristijärvi",64.5056,28.2139),
(17,"Mikkeli",61.6875,27.2736),
(17,"Savonlinna",61.8667,28.8831),
(17,"Pieksämäki",62.3,27.1583),
(17,"Juva",61.8972,27.8569),
(17,"Mäntyharju",61.4181,26.8792),
(17,"Kangasniemi",61.99,26.6417),
(17,"Joroinen",62.1792,27.8278),
(17,"Rantasalmi",62.0667,28.3),
(17,"Heinävesi",62.425,28.6333),
(17,"Sulkava",61.7875,28.3708),
(17,"Hirvensalmi",61.6389,26.7806),
(17,"Puumala",61.525,28.1833),
(17,"Pertunmaa",61.5028,26.4792),
(17,"Enonkoski",62.0889,28.9333),
(17,"Polvijärvi",62.4167,28.3333),
(18,"Seinäjoki",62.7903,22.8403),
(18,"Kurikka",62.6167,22.4),
(18,"Kauhava",63.1014,23.0639),
(18,"Lapua",62.9708,23.0069),
(18,"Kauhajoki",62.4319,22.1794),
(18,"Ilmajoki",62.7333,22.5833),
(18,"Alavus",62.5861,23.6194),
(18,"Alajärvi",63,23.8167),
(18,"Jalasjärvi",62.4917,22.7667),
(18,"Ähtäri",62.55,24.0694),
(18,"Teuva",62.4861,21.7472),
(18,"Kuortane",62.8083,23.5083),
(18,"Lappajärvi",63.2167,23.6333),
(18,"Vimpeli",63.1617,23.8167),
(18,"Evijärvi",63.3667,23.475),
(18,"Soini",62.875,24.2083),
(18,"Isojoki",62.1139,21.9583),
(18,"Karijoki",62.3083,21.7083),
(19,"Lappeenranta",61.0583,28.1861),
(19,"Imatra",61.1931,28.7764),
(19,"Ruokolahti",61.2917,28.8167),
(19,"Parikkala",61.55,29.5),
(19,"Taipalsaari",61.1597,28.0597),
(19,"Savitaipale",61.2,27.6833),
(19,"Lemi",61.0611,27.8042),
(19,"Simpele",61.4333,29.367),
(19,"Taavetti",60.9167,27.5667);


# Select all from city
SELECT * FROM city;

# Selecting all data from city and region joined by regionId (region names will be visible)
SELECT cityId, city.regionId, cityName, regionName, latitude, longitude
FROM city
LEFT JOIN region
ON city.regionId = region.regionId;

# Selecting a specific city amended with all region columns
SELECT cityId, city.regionId, cityName, regionName, latitude, longitude
FROM city
LEFT JOIN region
ON city.regionId = region.regionId
WHERE city.cityId = 265;  /*Hämeenlinna*/

# Selecting all cities from a specific region
SELECT cityId, city.regionId, cityName, regionName, latitude, longitude
FROM city
LEFT JOIN region
ON city.regionId = region.regionId
WHERE city.regionId = 15 ; /*Kanta-Häme region*/

# ============================================================================================================================================
