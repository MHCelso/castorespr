CREATE DATABASE IF NOT EXISTS develop
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS user
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    last_name VARCHAR(100),
    email VARCHAR(255) UNIQUE NOT NULL,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status ENUM('ACTIVO', 'INACTIVO') NOT NULL,
    role ENUM('ADMIN', 'USER') NOT NULL
);

INSERT INTO user
    (name, user_name, password, last_name, email, status, role, created_at, updated_at)
VALUES
    ('Carlos', 'gcarlos', '$2y$10$ncSZhwTdPD2bo3ZE.6wSV.RV5oPC6Wqi.vbmLFJnk2.A6uNztj0SC', 'Gomez', 'carlos.gomez@example.com', 'ACTIVO', 'USER', NOW(), NOW()),
    ('Maria', 'lmaria', '$2y$10$ncSZhwTdPD2bo3ZE.6wSV.RV5oPC6Wqi.vbmLFJnk2.A6uNztj0SC', 'Lopez', 'maria.lopez@example.com', 'ACTIVO', 'ADMIN', NOW(), NOW());

CREATE TABLE IF NOT EXISTS product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,
    status ENUM('ACTIVO', 'INACTIVO') NOT NULL,
    added_by_name VARCHAR(255) NOT NULL
);

INSERT INTO product
    (name, price, quantity, created_at, updated_at, status, added_by_name)
VALUES
    ('Mouse', 399.00, 0, NOW(), NOW(), 'ACTIVO', 'Maria'),
    ('Laptop', 15999.99, 0, NOW(), NOW(), 'ACTIVO', 'Maria');

CREATE TABLE IF NOT EXISTS history (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    action_type ENUM('ENTRADA', 'SALIDA') NOT NULL,
    quantity INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    added_by_name VARCHAR(255) NOT NULL
);

INSERT INTO history
    (action_type, product_id, quantity, created_at, added_by_name)
VALUES
    ('ENTRADA', 1, 0, NOW(), 'Maria'),
    ('ENTRADA', 2, 0, NOW(), 'Maria');
