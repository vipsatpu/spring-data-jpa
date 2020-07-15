CREATE TABLE IF NOT EXISTS `department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `description` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO `department` (`id`, `name`, `description`) VALUES
	(1, 'IT', 'Information Technology'),
	(2, 'TelComm', 'Telecommunication'),
	(3, 'Ins', 'Insurance'),
	(4, 'HR', 'Human Resources');


CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `email` varchar(150) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `dept_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`)
) ;

INSERT INTO `employee` (`id`, `name`, `email`, `address`, `dept_id`) VALUES
	(1, 'Soumitra', 'soumitra@gmail.com', NULL, 1),
	(2, 'Suman', 'suman@gmail.com', NULL, 2),
	(3, 'Avisek', 'avisek@gmail.com', NULL, 3);
    
    
CREATE TABLE IF NOT EXISTS `event` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `clasz` varchar(255) NOT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `event` (`id`, `title`, `url`, `clasz`, `start_date`, `end_date`) VALUES
	(1, 'Example', 'http://www.example.com', 'event-success', '2020-03-03 15:27:51', '2018-04-10 20:01:02'),
	(2, 'Java Tutorials', 'https://www.java.com', 'event-important', '2020-03-11 19:00:00', '2018-03-12 19:42:45'),
	(3, 'Docker Tutorial', 'https://www.docker.com', 'event-info', '2020-03-12 20:03:05', '2018-05-13 08:45:53');
    

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ;


INSERT INTO `product` (`id`, `name`, `code`, `price`) VALUES
	(1, 'Portable Hard Drive', 'USB02', 5000),
	(2, 'Shoes', 'SH03', 1000),
	(3, 'Simple Mobile', 'MB06', 3000),
	(4, 'Headphone', 'HD08', 400),
	(5, 'Test 1', 'test1', 5),
	(6, 'Test 2', 'test2', 6),
	(7, 'Test 3', 'test3', 7);
