CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_login` varchar(20) NOT NULL,
  `user_password` varchar(20),
  PRIMARY KEY (`id`,`user_login`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `user_login` (`user_login`)
);
INSERT INTO `users` VALUES (1,'alexinfostudent','123'), (2,'alex','456');