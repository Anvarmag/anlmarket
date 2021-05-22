INSERT INTO stores (id, store_name, email, phone, city)
VALUES (1, 'Apple', 'Apple@gmail.com', '8800200300', 'Москва'),
       (2, 'Adidas', 'Adidas@gmail.com', '8800100800', 'Пенза'),
       (3, 'Pandora', 'Pandora@gmail.com', '8800666555', 'Казань');


INSERT INTO products (id, name, category, price, imageURL, store_id, store_name)
VALUES (1, 'Iphone 11', 'Телефоны', 80000, '/media/74693e5a-cfff-4fee-a769-abd89997b89c.jpeg', 1, 'Apple'),
       (2, 'Iphone 12', 'Телефоны', 70000, '/media/74693e5a-cfff-4fee-a769-abd89997b89c.jpeg', 1, 'Apple'),
       (3, 'Костюм', 'Одежда', 5000, '/media/bf973cf1-367d-4f10-bfa0-88129d6798f8.jpeg', 2, 'Adidas'),
       (4, 'Кепка', 'Одежда', 500, '/media/de4c754e-9a5a-40cd-b9e7-77cc62c09f8e.jpeg', 2, 'Adidas'),
       (5, 'Браслет', 'Бижутерия', 1500, '/media/dd260c3c-ae55-4f9e-8b0b-6e0d283e7f38.jpeg', 3, 'Pandora'),
       (6, 'Подвеска', 'Бижутерия', 1700, '/media/333f40be-ce16-405c-a128-1026b2ba257a.jpeg', 3, 'Pandora');

//INSERT INTO statistics (store_id,store_name, reviews, rating)
//VALUES (1,'Apple',1050,8),
//     (2,'Adidas',500,9),
//   (3,'Pandora',800,10);