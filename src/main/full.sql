DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Arnold S.'),
('Silvester S.'),
('Willis B.');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE simple_items (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO simple_items (title, price) VALUES
('box', 10),
('sphere', 20),
('door', 50),
('camera', 500);



