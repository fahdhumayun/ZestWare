-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2017 at 02:51 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zestware`
--

-- --------------------------------------------------------

--
-- Table structure for table `absence`
--

CREATE TABLE `absence` (
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `date` varchar(10) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `type` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `absence`
--

INSERT INTO `absence` (`firstName`, `lastName`, `date`, `comment`, `type`) VALUES
('Barb', 'Chic', '2017/03/26', 'Sick', 'w'),
('Gil', 'Martinez', '2017-03-29', 'Testing', 'c'),
('Barb', 'Chic', '2017-03-29', 'Surfing', 'w'),
('Barb', 'Chic', '2017-03-25', 'somethin', 'w'),
('Gil', 'Martinez', '2017-03-30', 'Yay', 'C'),
('Kim', 'Kar', '2017-03-31', 'Cuz im bad', 'B'),
('Mark', 'Deets', '2017-03-28', 'Sickness', 'B'),
('Kelsey', 'Kar', '2017-03-28', 'sick', 'B'),
('Kelsey', 'Kar', '2017-03-28', 'sick :(', 'B');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `pin` smallint(4) NOT NULL,
  `wage` double NOT NULL,
  `type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`firstName`, `lastName`, `pin`, `wage`, `type`) VALUES
('Jane', 'Doe', 2219, 12.99, 'M'),
('Rodger', 'Sperry', 2424, 7.35, 'W'),
('Jenny', 'Hall', 1645, 7.99, 'W'),
('Erica', 'Summers', 6511, 13.99, 'C'),
('Max', 'Deets', 1199, 6.3, 'B'),
('Kell', 'Willis', 1784, 12.99, 'M'),
('Jane', 'Witherspoon', 5429, 3.99, 'B'),
('Kelsey', 'Kar', 1027, 3.99, 'B'),
('Fred', 'Pace', 9989, 1, 'M'),
('Frankie', 'Munez', 3543, 4, 'B'),
('Josh', 'Larry', 6251, 3, 'W');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `itemID` int(11) NOT NULL,
  `itemName` varchar(32) NOT NULL,
  `itemTotal` double NOT NULL,
  `unitMeasurement` varchar(32) NOT NULL,
  `itemCostPerUnit` double NOT NULL,
  `imageName` varchar(50) DEFAULT NULL,
  `image` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`itemID`, `itemName`, `itemTotal`, `unitMeasurement`, `itemCostPerUnit`, `imageName`, `image`) VALUES
(1, 'Ground Beef', 50, 'lbs', 3.5, NULL, ''),
(2, 'Milk', 6, 'gallons', 2.3, NULL, ''),
(3, 'Tomatoes', 20, 'lbs', 1.59, NULL, ''),
(4, 'White Sugar', 25, 'lbs', 0.56, NULL, ''),
(5, 'Butter', 100, 'lbs', 0.53, NULL, ''),
(9, 'Sausage', 2, 'lbs', 2.99, NULL, ''),
(10, 'Potatoes', 50, 'lbs', 0.25, NULL, ''),
(11, 'Carrots', 4, 'lbs', 0.4, NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `shifts`
--

CREATE TABLE `shifts` (
  `firstName` varchar(32) NOT NULL,
  `date` varchar(10) NOT NULL,
  `hours` float NOT NULL,
  `clockIn` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shifts`
--

INSERT INTO `shifts` (`firstName`, `date`, `hours`, `clockIn`) VALUES
('Gil', '2017/03/26', 7.5, ' 00:21:06'),
('Mark', '2017/03/26', 7, ' 02:08:01'),
('Kelsey', '2017/03/27', 8, ' 12:09:46');

-- --------------------------------------------------------

--
-- Table structure for table `survey`
--

CREATE TABLE `survey` (
  `surveyID` int(4) NOT NULL,
  `rating` float NOT NULL,
  `time` varchar(40) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `managerResponse` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey`
--

INSERT INTO `survey` (`surveyID`, `rating`, `time`, `comment`, `managerResponse`) VALUES
(1, 4.5, 'Sunday-26-Mar-2017 16:45:12 PM', 'Test!', 'Good');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`itemID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
