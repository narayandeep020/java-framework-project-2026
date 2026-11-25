CREATE TABLE category (
  category_id BIGINT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(45),
  PRIMARY KEY (category_id)
);

CREATE TABLE product (
  product_id BIGINT NOT NULL AUTO_INCREMENT,
  product_name VARCHAR(45),
  PRIMARY KEY (product_id),
  category_id BIGINT,
  FOREIGN KEY (category_id) REFERENCES category(category_id)
);

select * from category;
select * from product;