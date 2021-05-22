CREATE TABLE stores
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    store_name TEXT NOT NULL,
    email      TEXT NOT NULL,
    phone      TEXT NOT NULL,
    city       TEXT NOT NULL
);


CREATE TABLE products
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    name       TEXT    NOT NULL,
    category   TEXT    NOT NULL,
    price      INTEGER NOT NULL CHECK (price > 0),
    imageURL   TEXT,
    store_id   INTEGER NOT NULL REFERENCES stores,
    store_name TEXT    NOT NULL
);

