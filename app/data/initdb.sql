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
    status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
    role ENUM('ADMIN', 'USER', 'GUEST') NOT NULL
);

INSERT INTO user
    (name, user_name, password, last_name, email, status, role, created_at, updated_at)
VALUES
    ('Carlos', 'gcarlos', '$2y$10$ncSZhwTdPD2bo3ZE.6wSV.RV5oPC6Wqi.vbmLFJnk2.A6uNztj0SC', 'Gomez', 'carlos.gomez@example.com', 'ACTIVE', 'GUEST', NOW(), NOW()),
    ('Maria', 'lmaria', '$2y$10$ncSZhwTdPD2bo3ZE.6wSV.RV5oPC6Wqi.vbmLFJnk2.A6uNztj0SC', 'Lopez', 'maria.lopez@example.com', 'ACTIVE', 'ADMIN', NOW(), NOW()),
    ('Juan', 'hjuan', '$2y$10$ncSZhwTdPD2bo3ZE.6wSV.RV5oPC6Wqi.vbmLFJnk2.A6uNztj0SC', 'Hernandez', 'juan.hernandez@example.com', 'ACTIVE', 'USER', NOW(), NOW());

CREATE TABLE IF NOT EXISTS product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,
    status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
    added_by_user_id INT NOT NULL
);

INSERT INTO product
    (name, price, quantity, created_at, updated_at, status, added_by_user_id)
VALUES
    ('Mouse', 399.00, 0, NOW(), NOW(), 'ACTIVE', 1),
    ('Laptop', 15999.99, 0, NOW(), NOW(), 'ACTIVE', 1);
