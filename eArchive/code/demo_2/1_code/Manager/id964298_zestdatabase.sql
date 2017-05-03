-- Written, tested, and debugged by Ama Freeman and Raphaelle Marcial

-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 24, 2017 at 08:53 AM
-- Server version: 10.1.20-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id964298_zestdatabase`
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
('Barb', 'Chic', '2017/03/26', 'Sick', 'W'),
('Gil', 'Martinez', '2017-03-29', 'Testing', 'C'),
('Barb', 'Chic', '2017-03-29', 'Surfing', 'W'),
('Barb', 'Chic', '2017-03-25', 'somethin', 'W'),
('Gil', 'Martinez', '2017-03-30', 'Yay', 'C'),
('Jenny', 'Hall', '2017-04-11', 'hello', 'W'),
('Kim', 'Kar', '2017-04-28', 'Eye surgery.', 'B');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `first` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `pin` smallint(4) NOT NULL,
  `hourlyWage` double NOT NULL,
  `type` text NOT NULL,
  `totalWage` double NOT NULL DEFAULT '2'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`first`, `lastName`, `pin`, `hourlyWage`, `type`, `totalWage`) VALUES
('Mark', 'Deets', 8087, 6.3, 'B', 50.4),
('Janice', 'Witherspoon', 5429, 3.99, 'B', 313.605),
('Kim', 'Kar', 4712, 3.99, 'B', 27.93),
('Erica', 'Summers', 6511, 13.99, 'C', 111.92),
('Jane', 'Doe', 2219, 12.99, 'M', 51.96),
('Kell', 'Willis', 1784, 12.99, 'M', 90.93),
('Rodger', 'Sperry', 2424, 7.35, 'W', 25.725),
('Jenny', 'Hall', 1646, 7.99, 'W', 35.955),
('James', 'Baxter', 8470, 3, 'M', 18),
('Gil', 'Martinez', 9998, 10, 'W', 70);

-- --------------------------------------------------------

--
-- Table structure for table `finances`
--

CREATE TABLE `finances` (
  `Account` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `AccountNumber` int(32) NOT NULL,
  `AccountType` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Total` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `finances`
--

INSERT INTO `finances` (`Account`, `AccountNumber`, `AccountType`, `Total`) VALUES
('inventory', 10256, 'checking', 10567.86),
('wageDistribution', 63541, 'checking', 35780.32),
('emergencyFunds', 77821, 'savings', 22544.32),
('Tips', 41637, 'savings', 963.33);

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
(1, 'Ground Beef', 3, 'pounds', 1.33, NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `shifts`
--

CREATE TABLE `shifts` (
  `firstName` varchar(32) NOT NULL,
  `date` varchar(10) NOT NULL,
  `clockIn` varchar(9) NOT NULL,
  `workTime` float NOT NULL,
  `calculatedWage` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shifts`
--

INSERT INTO `shifts` (`firstName`, `date`, `clockIn`, `workTime`, `calculatedWage`) VALUES
('Mark', '2017-03-05', '12:30', 6, 37.8),
('Jane', '2017-03-16', '11:30', 4, 51.96),
('Kim', '2017-03-02', '15:30', 6.5, 25.935),
('Erica', '2017-03-16', '14:00', 8, 111.92),
('Kell', '2017-03-05', '08:00', 7, 90.93),
('Rodger', '2017-03-18', '15:00', 3.5, 25.725),
('Jenny', '2017-03-16', '13:00', 4.5, 35.955),
('James', '2017-03-16', '12:00', 7, 21),
('Gil', '2017-03-02', '14:00', 6.5, 65),
('Janice', '2017-03-08', '11:30', 6, 23.94),
('Gil', '2017-03-05', '11:00', 7, 70),
('Gil', '2017-03-28', '7:00', 8, 80),
('Mark', '2017-03-08', '15:00', 8, 50.4),
('Erica', '2017-04-07', '7:00', 7, 97.93),
('James', '2017-06-06', '3:00', 6, 18),
('Erica', '2017-04-23', '11:30', 5.5, 76.945);

-- --------------------------------------------------------

--
-- Table structure for table `survey`
--

CREATE TABLE `survey` (
  `surveyID` int(4) NOT NULL,
  `rating` float NOT NULL,
  `time` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `comment` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `managerReponse` varchar(500) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'N/A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `survey`
--

INSERT INTO `survey` (`surveyID`, `rating`, `time`, `comment`, `managerReponse`) VALUES
(1, 4.5, 'Friday-21-Apr-2017 16:45:09 PM', 'Very impressed with the fast service!', 'hello!'),
(3, 2, 'Saturday-22-Apr-2017 21:53:04 PM', 'Mediocre food, good management though.', 'whaddup'),
(4, 2.5, 'Saturday-22-Apr-2017 22:22:44 PM', 'I am still hungry.', 'N/A'),
(5, 3.5, 'Monday-24-Apr-2017 01:11:46 AM', 'The lights were very dim. I could barely see my food.', 'N/A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `survey`
--
ALTER TABLE `survey`
  ADD PRIMARY KEY (`surveyID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `survey`
--
ALTER TABLE `survey`
  MODIFY `surveyID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
