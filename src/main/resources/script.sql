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
