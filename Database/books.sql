-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2024 at 02:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `Unique_ID` int(10) NOT NULL,
  `Book_Number` varchar(50) DEFAULT NULL,
  `Name` varchar(100) NOT NULL,
  `Author` varchar(100) NOT NULL,
  `Publisher` varchar(100) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `Added_Date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`Unique_ID`, `Book_Number`, `Name`, `Author`, `Publisher`, `Quantity`, `Added_Date`) VALUES
(3, 'K2089', 'Ikas', 'Mr.June', 'OLFU', 96, '2024-05-24 12:12:52'),
(4, 'G767', 'Avengers', 'Stan Lee', 'NBSB', 78, '2024-05-22 07:34:59'),
(5, 'G789', 'Twilight', 'John', 'National Book Store', 90, '2024-05-22 08:11:43'),
(6, 'G098', 'Twilight: New Moon', 'Stephenie Meyer', 'OLFU', 651, '2024-05-24 11:01:42');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`Unique_ID`),
  ADD UNIQUE KEY `callno` (`Book_Number`),
  ADD UNIQUE KEY `callno_2` (`Book_Number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `Unique_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
