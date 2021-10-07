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