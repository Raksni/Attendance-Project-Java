-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2022 at 07:46 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugasmandiripbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance_batch`
--

CREATE TABLE `attendance_batch` (
  `date` date NOT NULL,
  `classname` varchar(45) NOT NULL,
  `subjectid` varchar(45) NOT NULL,
  `session` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance_batch`
--

INSERT INTO `attendance_batch` (`date`, `classname`, `subjectid`, `session`) VALUES
('2022-06-17', '2KS1', 'pbo', 'Session 1');

-- --------------------------------------------------------

--
-- Table structure for table `attendence`
--

CREATE TABLE `attendence` (
  `date` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `studentid` varchar(45) NOT NULL,
  `classname` varchar(45) NOT NULL,
  `subjectid` varchar(45) NOT NULL,
  `session` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendence`
--

INSERT INTO `attendence` (`date`, `status`, `studentid`, `classname`, `subjectid`, `session`) VALUES
('2022-06-17', 'Late 20 Menit', '222011404', '2KS1', 'pbo', 'Session 1');

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `classname` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`classname`) VALUES
('1KS1'),
('1KS3'),
('2KS1'),
('2KS2');

-- --------------------------------------------------------

--
-- Table structure for table `class_subject`
--

CREATE TABLE `class_subject` (
  `classname` varchar(45) NOT NULL,
  `subjectid` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class_subject`
--

INSERT INTO `class_subject` (`classname`, `subjectid`) VALUES
('1KS1', 'alin'),
('1KS1', 'basdat'),
('1KS3', 'basdat'),
('2KS1', 'anareg'),
('2KS1', 'komstat'),
('2KS1', 'metnum'),
('2KS1', 'metstat2'),
('2KS1', 'metsur'),
('2KS1', 'pbo'),
('2KS1', 'pbw'),
('2KS1', 'pos'),
('2KS2', 'anareg'),
('2KS2', 'komstat'),
('2KS2', 'metnum'),
('2KS2', 'metstat2'),
('2KS2', 'metsur'),
('2KS2', 'pbo'),
('2KS2', 'pbw'),
('2KS2', 'pos');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `usertype` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `usertype`) VALUES
('admin', 'admin', 'Administrator'),
('delok', '12345', 'Teacher'),
('rajuh', '12345', 'Teacher'),
('rizda', '12345', 'Teacher'),
('sela', '12345', 'Teacher'),
('ugu', '12345', 'Teacher');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentid` varchar(45) NOT NULL,
  `studentname` varchar(45) DEFAULT NULL,
  `dept` varchar(45) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `classname` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentid`, `studentname`, `dept`, `semester`, `classname`) VALUES
('222011404', 'Wa Ode Raksni Dumpatua', 'D4 Komputasi', 4, '2KS1'),
('222011405', 'La Ode Delok Jumsya', 'D4 Komputasi', 4, '2KS2'),
('22211892', 'Wa Ode Rizda Dempalas', 'D4 Komputasi', 2, '1KS1');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subjectid` varchar(45) NOT NULL,
  `subjectname` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subjectid`, `subjectname`) VALUES
('alin', 'Aljabar Linear'),
('anareg', 'Analisis Regresi'),
('basdat', 'Basis Data'),
('komstat', 'Komputasi Statistik'),
('metnum', 'Metode Numerik'),
('metstat2', 'Metode Statistika II'),
('metsur', 'Metode Survei'),
('pbo', 'Pemrograman Berorientasi Objek'),
('pbw', 'Pemrograman Berbasis Web'),
('pos', 'Pengantar Official Statistik');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacherid` varchar(45) NOT NULL,
  `teachername` varchar(45) DEFAULT NULL,
  `Login_username` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacherid`, `teachername`, `Login_username`) VALUES
('2', 'Rizda', 'rizda'),
('3', 'Sela', 'sela'),
('4', 'Rajuh', 'rajuh'),
('5', 'Amji', 'ugu'),
('6', 'Delok', 'delok');

-- --------------------------------------------------------

--
-- Table structure for table `teaches`
--

CREATE TABLE `teaches` (
  `teacher_teacherid` varchar(45) NOT NULL,
  `classname` varchar(45) NOT NULL,
  `subjectid` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teaches`
--

INSERT INTO `teaches` (`teacher_teacherid`, `classname`, `subjectid`) VALUES
('2', '2KS1', 'pbo'),
('2', '2KS2', 'pbo'),
('3', '2KS1', 'anareg'),
('3', '2KS2', 'anareg'),
('4', '1KS1', 'alin'),
('4', '2KS1', 'komstat'),
('4', '2KS2', 'komstat'),
('5', '2KS1', 'metnum'),
('5', '2KS2', 'metnum'),
('5', '2KS1', 'metsur'),
('6', '2KS1', 'pos');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance_batch`
--
ALTER TABLE `attendance_batch`
  ADD PRIMARY KEY (`date`,`classname`,`subjectid`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`classname`);

--
-- Indexes for table `class_subject`
--
ALTER TABLE `class_subject`
  ADD PRIMARY KEY (`classname`,`subjectid`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subjectid`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacherid`);

--
-- Indexes for table `teaches`
--
ALTER TABLE `teaches`
  ADD PRIMARY KEY (`teacher_teacherid`,`subjectid`,`classname`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
