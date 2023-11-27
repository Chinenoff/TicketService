CREATE TABLE if not exists 'USERS'
(
    `id`   BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    'login'        VARCHAR(128) NOT NULL,
    'password'       VARCHAR(128) NOT NULL,
    'first_name'     VARCHAR(128) NOT NULL,
    'middle_name'    VARCHAR(128) NOT NULL,
    'last_name'      VARCHAR(128) NOT NULL,
);