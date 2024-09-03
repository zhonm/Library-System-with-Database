-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2024 at 02:39 PM
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
-- Table structure for table `issuebooks`
--

CREATE TABLE `issuebooks` (
  `Book_Number` varchar(255) NOT NULL,
  `Student_ID` varchar(255) NOT NULL,
  `Student_Name` varchar(255) DEFAULT NULL,
  `Student_Contact` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `issuebooks`
--

INSERT INTO `issuebooks` (`Book_Number`, `Student_ID`, `Student_Name`, `Student_Contact`) VALUES
('K2089', '03220007865', 'David', '09677743970');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `issuebooks`
--
ALTER TABLE `issuebooks`
  ADD PRIMARY KEY (`Book_Number`,`Student_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
