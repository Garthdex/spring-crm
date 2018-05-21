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
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('1', '~100mb', 'internet', '300', 'lorem ipsum');
INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('2', '~50mb', 'internet', '150', 'lorem ipsum');
INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('3', '~10mb', 'internet', '50', 'lorem ipsum');
INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('4', 'call #1', 'phone', '100', 'lorem ipsum');
INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('5', 'call #2', 'phone', '75', 'lorem ipsum');
INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('6', 'call #3', 'phone', '50', 'lorem ipsum');
INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('7', 'plan #1', 'tv', '100', 'lorem ipsum');
INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('8', 'plan #2', 'tv', '75', 'lorem ipsum');
INSERT INTO `heroku_04213aef2650618`.`services` (`service_id`, `name`, `type`, `price`, `description`) VALUES ('9', 'plan #3', 'tv', '50', 'lorem ipsum');

CREATE TABLE IF NOT EXISTS `requests` (
  `request_id` mediumint NOT NULL AUTO_INCREMENT,
  `user_id` mediumint NOT NULL,
  `service_id` mediumint NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` mediumint NOT NULL AUTO_INCREMENT,
  `customer_id` mediumint NOT NULL,
  `service_id` mediumint NOT NULL,
  `manager_id` mediumint NOT NULL,
  `date` varchar(100) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--for render request table for admin
SELECT u.username, s.name, s.type, s.price, r.status, r.request_id
FROM requests r, users u, services s
WHERE u.user_id = r.user_id
AND s.service_id = r.service_id
--for render request table for user
SELECT s.name, s.type, s.price, r.status
FROM requests r, services s
WHERE r.user_id = ?
AND s.service_id = r.service_id
--for render order table
SELECT u.username, s.name, s.type, s.price, o.date, m.full_name
FROM orders as o, users as u, services as s, users as m
WHERE u.user_id = o.customer_id
AND s.service_id = o.service_id
AND o.manager_id = m.user_id