-- inserty dla zniżek
INSERT INTO discount (type_of_discount, discount_value) VALUES
    ('PERCENT', 10.0);

INSERT INTO discount (type_of_discount, discount_value) VALUES
    ('VALUE', 50.0);

-- Inserty dla produktów
INSERT INTO product (name, category, price, discount_id, image_path) VALUES
    ('Call of duty Modern Warfare 3', 'Gry Komputerowe', 59.99, 1 , '/images/callofduty.jpg');

INSERT INTO product (name, category, price, discount_id, image_path) VALUES
    ('Cyberpunk 2077', 'Gry Komputerowe', 49.99, 2, '/images/Cyberpunk_2077.jpeg');

INSERT INTO product (name, category, price, discount_id,image_path) VALUES
    ('Assassin''s Creed Valhalla', 'Gry Komputerowe', 69.99, 1, '/images/ac_valhalla.jpeg');

INSERT INTO product (name, category, price, discount_id,image_path) VALUES
    ('Dying Light 2', 'Gry Komputerowe', 39.99, 2, '/images/dying.jpeg');

INSERT INTO product (name, category, price, discount_id,image_path) VALUES
    ('Hogwart Legacy', 'Gry Komputerowe', 59.99, 1, '/images/hogwart_legacy.webp');

INSERT INTO product (name, category, price, discount_id,image_path) VALUES
    ('Uncharted legacy of thieves collection', 'Gry Komputerowe', 29.99, 2, '/images/uncharted.jpg');

INSERT INTO product (name, category, price, discount_id,image_path) VALUES
    ('Forza horizon 5', 'Gry Komputerowe', 49.99, 1, '/images/forza_horizon.jpeg');

INSERT INTO product (name, category, price, discount_id,image_path) VALUES
    ('Spider-Man 2', 'Gry Komputerowe', 39.99, 2, '/images/spiderman.jpeg');

INSERT INTO product (name, category, price, discount_id,image_path) VALUES
    ('The Sims 4: Tiny Living Stuff', 'Gry Komputerowe', 39.99, 1, '/images/sims.jpg');

INSERT INTO product (name, category, price, discount_id,image_path) VALUES
    ('Oddworld Soulstorm Day One Oddition', 'Gry Komputerowe', 14.99, 2, '/images/soulstorm.jpg');


-- inserty dla warehouse
INSERT INTO warehouse (product_id, quantity) VALUES (1, 50);
INSERT INTO warehouse (product_id, quantity) VALUES (2, 20);
INSERT INTO warehouse (product_id, quantity) VALUES (3, 75);
INSERT INTO warehouse (product_id, quantity) VALUES (4, 10);
INSERT INTO warehouse (product_id, quantity) VALUES (5, 95);
INSERT INTO warehouse (product_id, quantity) VALUES (6, 30);
INSERT INTO warehouse (product_id, quantity) VALUES (7, 80);
INSERT INTO warehouse (product_id, quantity) VALUES (8, 15);
INSERT INTO warehouse (product_id, quantity) VALUES (9, 40);
INSERT INTO warehouse (product_id, quantity) VALUES (10, 60);

-- INSERT INTO cart (user_id) VALUES (NULL);
INSERT INTO users(username,password) VALUES ('Anna','password1');
