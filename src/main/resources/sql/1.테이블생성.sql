create database shoppingmall;

CREATE TABLE shoppingmall.item (
  id BIGINT AUTO_INCREMENT,
  item_name VARCHAR(50) NOT NULL,
  price INT NOT NULL,
  stock_number INT NOT NULL,
  item_detail LONGTEXT NOT NULL,
  item_status VARCHAR(20),
  registered_at DATETIME,
  updated_at DATETIME,
  PRIMARY KEY (`id`)
);