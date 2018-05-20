CREATE DATABASE IF NOT EXISTS `concretepage`;

USE `concretepage`;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` mediumint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL UNIQUE,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100),
  `address` varchar(100),
  `phone_number` varchar(20),
  `role` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `help` (
  `help_id` mediumint NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(20) NOT NULL,
  `message` varchar(2048) NOT NULL,
  PRIMARY KEY (`help_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `services` (
  `service_id` mediumint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type` varchar(30) NOT NULL,
  `price` decimal NOT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `requests` (
  `request_id` mediumint NOT NULL AUTO_INCREMENT,
  `user_id` mediumint NOT NULL,
  `service_id` mediumint NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` mediumint NOT NULL AUTO_INCREMENT,
  `customer_login` varchar(50) NOT NULL,
  `service_name` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `manager_name` varchar(50) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--для отрисовки таблицы заявок админа
SELECT u.username, s.name, s.type, s.price, r.status, r.request_id
FROM requests r, users u, services s
WHERE u.user_id = r.user_id
AND s.service_id = r.service_id
--для отрисовки таблицы заявок юзера
SELECT s.name, s.type, s.price, r.status
FROM requests r, services s
WHERE r.user_id = ?
AND s.service_id = r.service_id