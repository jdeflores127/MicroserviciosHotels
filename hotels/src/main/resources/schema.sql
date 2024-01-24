DROP TABLE IF EXISTS hotel;

CREATE TABLE hotel (
  hotel_id int NOT NULL AUTO_INCREMENT,
  hotel_name varchar(100) NOT NULL,
  hotel_address varchar(100) NOT NULL,
  PRIMARY KEY (hotel_id)
);
