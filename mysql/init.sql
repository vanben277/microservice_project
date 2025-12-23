-- Drop the database if it already exists
DROP
DATABASE IF EXISTS microservice;

-- Create database
CREATE
DATABASE IF NOT EXISTS microservice;
USE
microservice;

-- Create table department
DROP TABLE IF EXISTS department;
CREATE TABLE IF NOT EXISTS department
(
    id
    INT
    UNSIGNED
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    100
) CHARACTER SET utf8mb4 NOT NULL UNIQUE,
    total_member INT UNSIGNED,
    type ENUM
(
    'DEV',
    'TEST',
    'SCRUM_MASTER',
    'PM'
) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
    );

-- Create table account
DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    id            INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username      VARCHAR(50) NOT NULL UNIQUE,
    firstname     VARCHAR(50),
    lastname      VARCHAR(50),
    department_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (id)
);

-- Create table users
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    email         VARCHAR(50)  NOT NULL UNIQUE,
    password      VARCHAR(120) NOT NULL,
    username      VARCHAR(20)  NOT NULL UNIQUE,
    firstname     VARCHAR(20),
    lastname      VARCHAR(20),
    access_token  VARCHAR(255),
    refresh_token VARCHAR(255),
    role          ENUM('USER','ADMIN','MANAGER') NOT NULL,
    PRIMARY KEY (id)
);

-- Create table refreshtoken
DROP TABLE IF EXISTS refreshtoken;
CREATE TABLE refreshtoken
(
    id          BIGINT       NOT NULL PRIMARY KEY,
    expiry_date DATETIME(6) NOT NULL,
    token       VARCHAR(255) NOT NULL UNIQUE,
    user_id     BIGINT DEFAULT NULL UNIQUE,
    CONSTRAINT fk_user_refresh FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Create table refreshtoken_seq
DROP TABLE IF EXISTS refreshtoken_seq;
CREATE TABLE refreshtoken_seq
(
    next_val BIGINT DEFAULT NULL
);

-- Create table roles
DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name ENUM('ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER') DEFAULT NULL
);

-- Create table user_roles
DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,
    role_id INT    NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles (id)
);

-- =============================================
-- INSERT DATA
-- =============================================
INSERT INTO department(name, total_member, type, created_at)
VALUES ('Marketing', 1, 'DEV', '2020-03-05'),
       ('Sale', 2, 'TEST', '2020-03-05'),
       ('Bảo vệ', 3, 'SCRUM_MASTER', '2020-03-07'),
       ('Nhân sự', 4, 'PM', '2020-03-08'),
       ('Kỹ thuật', 5, 'DEV', '2020-03-10'),
       ('Tài chính', 6, 'SCRUM_MASTER', NOW()),
       ('Phó giám đốc', 7, 'PM', NOW()),
       ('Giám đốc', 8, 'TEST', '2020-04-07'),
       ('Thư kí', 9, 'PM', '2020-04-07'),
       ('Bán hàng', 1, 'DEV', '2020-04-09');

INSERT INTO account(username, department_id)
VALUES ('dangblack', 5),
       ('quanganh', 1),
       ('vanchien', 1),
       ('cocoduongqua', 1),
       ('doccocaubai', 2),
       ('khabanh', 2),
       ('huanhoahong', 2),
       ('tungnui', 8),
       ('duongghuu', 9);

INSERT INTO refreshtoken_seq (next_val)
VALUES (1);

INSERT INTO roles (id, name)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_MODERATOR'),
       (3, 'ROLE_ADMIN');