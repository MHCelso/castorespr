CREATE DATABASE IF NOT EXISTS develop
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS user
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    userName VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    lastName VARCHAR(100),
    email VARCHAR(255) UNIQUE NOT NULL,
    updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deletedAt TIMESTAMP NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
    role ENUM('ADMIN', 'USER', 'GUEST') NOT NULL
);

INSERT INTO user
    (name, userName, password, lastName, email, status, role, createdAt)
VALUES
    ('Carlos', 'gcarlos', '$2y$10$ncSZhwTdPD2bo3ZE.6wSV.RV5oPC6Wqi.vbmLFJnk2.A6uNztj0SC', 'Gomez', 'carlos.gomez@example.com', 'ACTIVE', 'GUEST', CURRENT_TIMESTAMP),
    ('Maria', 'lmaria', '$2y$10$ncSZhwTdPD2bo3ZE.6wSV.RV5oPC6Wqi.vbmLFJnk2.A6uNztj0SC', 'Lopez', 'maria.lopez@example.com', 'ACTIVE', 'ADMIN', CURRENT_TIMESTAMP),
    ('Juan', 'hjuan', '$2y$10$ncSZhwTdPD2bo3ZE.6wSV.RV5oPC6Wqi.vbmLFJnk2.A6uNztj0SC', 'Hernandez', 'juan.hernandez@example.com', 'ACTIVE', 'USER', CURRENT_TIMESTAMP);
