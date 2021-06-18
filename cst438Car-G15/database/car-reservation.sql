-- Don't check for foreign keys otherwise it will not be able to drop the tables
SET FOREIGN_KEY_CHECKS = 0;
-- If a table with name "car" exists, drop it
DROP TABLE IF EXISTS car;
-- Creating table for car
CREATE TABLE IF NOT EXISTS car(
   id           INTEGER  NOT NULL PRIMARY KEY 
  ,make         VARCHAR(13) NOT NULL
  ,model        VARCHAR(18) NOT NULL
  ,fuel         VARCHAR(7) NOT NULL
  ,transmission VARCHAR(32) NOT NULL
  ,year         INTEGER  NOT NULL
  ,price        INTEGER  NOT NULL
  ,city         VARCHAR(15) NOT NULL
);
-- If a table with name "reservations" exists, drop it
DROP TABLE IF EXISTS reservations;
-- Creating table for reservations
CREATE TABLE IF NOT EXISTS reservations (
    rid INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, -- Using autoincrement so that the rid increases by one each time a reservation is made
    car_id int NOT NULL,
    email VARCHAR(45) NOT NULL,
    FOREIGN KEY (car_id) REFERENCES car(id) -- Using a foreign key with cars.id in order to create a nested view for API calls
);
-- Inserting data into the "car" table. "reservations" table will be populated once reservations are made
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (1,'Renault','Fuego','Regular','Manual 5-spd',1984,199,'seattle');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (2,'Chevrolet','Celebrity Wagon','Regular','Automatic 4-spd',1987,99,'new york');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (3,'Toyota','MR2','Premium','Manual 5-spd',1989,150,'boston');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (4,'Jeep','Grand Wagoneer 4WD','Regular','Automatic 3-spd',1989,100,'seattle');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (5,'Ford','Ranger Pickup 2WD','Regular','Manual 5-spd',1990,99,'boston');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (6,'Eagle','Summit Wagon','Regular','Automatic 4-spd',1992,50,'san diego');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (7,'Ford','Mustang','Regular','Manual 5-spd',1999,125,'boston');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (8,'BMW','328ci','Premium','Automatic 5-spd',2000,199,'new york');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (9,'Dodge','Durango 4WD','Regular','Automatic 4-spd',2000,125,'washington d.c.');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (10,'Aston Martin','DB AR1','Premium','Manual 6-spd',2003,325,'washington d.c.');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (11,'Volkswagen','Jetta Wagon','Premium','Automatic (S5)',2003,99,'san francisco');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (12,'Mercury','Mountaineer 2WD','Regular','Automatic 5-spd',2003,99,'san francisco');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (13,'Mercedes-Benz','E500','Premium','Automatic 7-spd',2005,145,'washington d.c.');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (14,'Acura','MDX 4WD','Premium','Automatic (S5)',2009,129,'san francisco');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (15,'Nissan','Rogue AWD','Regular','Automatic (variable gear ratios)',2010,99,'san diego');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (16,'Porsche','Cayenne','Premium','Automatic 8-spd',2011,299,'new york');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (17,'Kia','Forte Koup','Regular','Automatic 6-spd',2013,119,'seattle');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (18,'Acura','TSX','Premium','Automatic (S5)',2014,99,'san diego');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (19,'Volvo','XC60 AWD','Regular','Automatic (S6)',2016,125,'san diego');
INSERT INTO car(id,make,model,fuel,transmission,year,price,city) VALUES (20,'Honda','Civic 5Dr','Premium','Manual 6-spd',2021,99,'new york');
