-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2015 at 10:01 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `logicnowexdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
`id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `first_name`, `last_name`) VALUES
(1, 'Kami', 'test'),
(2, 'Teo', 'test'),
(3, 'Meo', 'test'),
(4, 'Kami', 'test'),
(5, 'Teo', 'test'),
(6, 'Meo', 'test'),
(7, 'Kami', 'test'),
(8, 'Teo', 'test'),
(9, 'Meo', 'test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
