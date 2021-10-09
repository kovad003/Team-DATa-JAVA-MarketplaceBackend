# Creating Databse
DROP DATABASE IF EXISTS webshopdb;
create database webshopdb;
use webshopdb;

# Granting user access
GRANT ALL on webshopdb.* to nobody@localhost identified by 'kukucs';

# Creating item table
CREATE TABLE item (
itemId INTEGER NOT NULL auto_increment,
categoryId INTEGER NOT NULL,
customerId INTEGER NOT NULL,
title varchar(25) NOT NULL,
price decimal(10,2) NOT NULL,
description varchar(75) NOT NULL,
image varchar(255) NOT NULL,
`condition` varchar(25) NOT NULL,
location varchar (55) NOT NULL,
datePosted timestamp,
PRIMARY KEY (itemId)
);

INSERT INTO item (categoryId, customerId, title, price, description, image, `condition`, location) VALUES
(1, 1001, "Dell notebook", 150,
"I have just bought a desktop PC so I do not need this any longer.", 
"https://i0.wp.com/cdn.mos.cms.futurecdn.net/zM9p9D2RUQebhKR3CieqZA.jpg",
"used", "Hameenlinna"),

(2, 1002, "Grey Sofa", 69.99, 
"Granny's old sofa. She got bored after 34 years...", 
"https://moderntovintage.com/wp-content/uploads/2017/08/Photo-Aug-01-2-08-05-PM-300x225.jpg",
"used", "Hameenlinna"),

(3, 1003, "Running shoes", 250, 
"Brand new running shoe. Ideal for longer distances.", 
"http://4.bp.blogspot.com/-PKLvGmPzWn8/Tz3iUwonF2I/AAAAAAAAAIo/6T3zlIBhJ3o/s400/adidas+running+shoes.jpg",
"new", "Hameenlinna");


DESCRIBE item;
SELECT * from item;
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