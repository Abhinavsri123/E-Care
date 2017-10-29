-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2017 at 06:13 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecare`
--
CREATE DATABASE IF NOT EXISTS `ecare` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ecare`;

-- --------------------------------------------------------

--
-- Table structure for table `challan`
--

CREATE TABLE `challan` (
  `challanid` text NOT NULL,
  `user` text NOT NULL,
  `date_of_challan` text NOT NULL,
  `vehical` text NOT NULL,
  `resone` text NOT NULL,
  `fine` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complain`
--

CREATE TABLE `complain` (
  `user` text NOT NULL,
  `location` text NOT NULL,
  `message` text NOT NULL,
  `police_allow` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `points`
--

CREATE TABLE `points` (
  `user` text NOT NULL,
  `point` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rule_breaking`
--

CREATE TABLE `rule_breaking` (
  `sn` int(11) NOT NULL,
  `user` text NOT NULL,
  `date` text NOT NULL,
  `status` text NOT NULL,
  `point` text NOT NULL,
  `time` text NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `travellingdetails`
--

CREATE TABLE `travellingdetails` (
  `user` text NOT NULL,
  `date` text NOT NULL,
  `vehicaltravelling` text NOT NULL,
  `time` text NOT NULL,
  `location` text NOT NULL,
  `vehicaltype` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rule_breaking`
--
ALTER TABLE `rule_breaking`
  ADD PRIMARY KEY (`sn`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rule_breaking`
--
ALTER TABLE `rule_breaking`
  MODIFY `sn` int(11) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
