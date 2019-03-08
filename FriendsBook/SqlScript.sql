CREATE TABLE `useraccount` (
 `user_id` varchar(10) NOT NULL,
 `password` varchar(255) NOT NULL,
 `name` varchar(50) NOT NULL,
 `gender` varchar(10) NOT NULL,
 `school_name` varchar(100) NOT NULL,
 `birthday` date NOT NULL,
 `email` varchar(100) NOT NULL,
 `account_created_on` varchar(100) NOT NULL,
 PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

