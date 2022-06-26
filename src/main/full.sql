DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE IF NOT EXISTS customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Arnold S.'),
('Silvester S.'),
('Willis B.');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES
                                            ('box', 10),
                                            ('sphere', 20),
                                            ('maul', 100),
                                            ('door', 50),
                                            ('camera', 500);


DROP TABLE IF EXISTS product_buyers CASCADE;
CREATE TABLE product_buyers (customer_id bigint, product_id bigint, FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES products (id));

INSERT INTO product_buyers VALUES
(2, 1),
(2, 2),
(2, 3),
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 5),
(3, 1);




