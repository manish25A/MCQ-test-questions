-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2020 at 05:10 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mcqtestquestions`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `q_id` int(11) NOT NULL,
  `question` varchar(250) NOT NULL,
  `rightans` varchar(250) NOT NULL,
  `wrong1` varchar(250) NOT NULL,
  `wrong2` varchar(250) NOT NULL,
  `wrong3` varchar(250) NOT NULL,
  `subject` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`q_id`, `question`, `rightans`, `wrong1`, `wrong2`, `wrong3`, `subject`) VALUES
(1, 'Who is designer of java?', 'James Gosling', 'James Charles', 'James Clinton', 'James Bond', 'java'),
(24, 'Who manages  java?', 'Sun Microsystems', 'Sun system', 'solar system', 'sun technos', 'java'),
(25, 'When was java first appeared?', 'May 23, 1995', 'May 13, 1995', 'April 13, 1995', 'May 23, 1998', 'java'),
(26, 'kudxfhvuisd', 'uygdsfuy', 'iudbfviu', 'udfgbui', 'uyvuyv', 'java'),
(27, 'w4wetretq', 'saefkk', 'kjdbvjgbu', 'wybfsbvfb78', 'gfauyfg78', 'java'),
(29, 'kuguyguih834979', 'guygbv ihv8998', 'uysg uyog78', 'hg uy sdfsf78', ' ugdvu ', 'java'),
(30, 'jhvukygfgh8', 'bdusyfbvu dug', 'gu fuidhfs ', 'iudsffbvud', 'jhb udv', 'java'),
(31, 'sidufhguidfs i', 'idfbviuds', 'ug iudsf', 'iuhs uiq', 'iu nidhv', 'java'),
(32, 'dkughdin909', 'idhrgi d', 'hisfidh h9', 'fidh fiuh7', 'duivh iud', 'java'),
(35, 'question ', 'rightans ', 'wrong1', 'wrong2', 'wrong3', 'subject'),
(36, 'question ', 'rightans ', 'wrong1', 'wrong2', 'wrong3', 'subject');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `s_id` int(11) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `collage` varchar(200) NOT NULL,
  `country` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`s_id`, `first_name`, `last_name`, `collage`, `country`, `email`, `phone`, `username`, `password`) VALUES
(1, 'Abhishek', 'Thapa', 'Softwarica', 'Nepal', 'abhishekthapa115@gmail.com', '9867739191', 'abhi', 'abc'),
(2, 'Manish', 'B.C.', 'softwarica', 'Nepal', 'manysh23@gmail.com', 'manysh23@gmail.com', 'manish', 'manish'),
(3, 'bishal', 'thapa', 'softwarica', 'nepal', 'bishaljung', 'bishaljung', 'bishal8886', 'thapa14938'),
(4, 'sdfgsdf', 'gsdfg', 'gsrg', 'sfgsd', 'wergwerg', 'wergwerg', 'sdfgsdf7853', 'gsdfg9374'),
(5, 'Manish', 'BC', 'mansih23', 'nepal', 'manysh23@gmail.com', 'manysh23@gmail.com', 'Manish3874', 'BC19793'),
(6, 'Manish', 'BC', 'softwarica', 'Nepal', 'manysh23@gmail.com', 'manysh23@gmail.com', 'Manish9474', 'BC9873'),
(7, 'bishal', 'jung', 'softwarica', 'nepal', 'bishaljung63', 'bishaljung63', 'bishal2564', 'jung19056'),
(8, 'potato', 'mama', 'softwarica', 'nepal', 'asdfghjkl', 'asdfghjkl', 'potato6764', 'mama10158'),
(9, 'manish', 'bc', 'softwarica', 'nepal', 'manysh23@Gmail.com', 'manysh23@Gmail.com', 'manish7405', 'bc9987'),
(10, 'as', 'ddd', 'ddd', 'ddddd', 'dddddd', 'dddddd', 'as2333', 'ddd5144'),
(11, 'manish', 'bc', 'softwarica', 'nepal', 'manysh23@gmail.com', '9868033278', 'manish', 'password'),
(12, 'manish', 'bc', 'softwarica', 'nepal', 'manysh23@gmail.com', '9868033278', 'manish', 'password'),
(13, 'manish', 'bc', 'softwarica', 'nepal', 'manysh23@gmail.com', '9868033278', 'manish', 'password'),
(14, 'manish', 'BC', 'softwarica', 'Nepal', 'manysh23@gmail.com', 'manysh23@gmail.com', 'manish4291', 'BC1047'),
(15, 'Manish', 'BC', 'Softwarica College of IT and E-commerce', 'Nepal', 'manysh23@gmail.com', 'manysh23@gmail.com', 'Manish7831', 'BC18627'),
(16, 'manish', 'mansid', 'sdfvb', 'ibj', 'bjkb', 'bjkb', 'manish8771', 'mansid19605');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `id` int(11) NOT NULL,
  `correctAnswer` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `subject` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`id`, `correctAnswer`, `student_id`, `subject`) VALUES
(1, 10, 1, ''),
(2, 0, 1, ''),
(3, 10, 1, ''),
(4, 10, 1, ''),
(5, 0, 2, 'java'),
(6, 2, 2, 'java'),
(7, 0, 0, 'java'),
(8, 0, 2, 'java'),
(9, 0, 2, 'java'),
(10, 1, 5, 'sub'),
(11, 1, 5, 'sub'),
(12, 0, 2, 'java'),
(13, 0, 2, 'java'),
(14, 0, 2, 'java'),
(15, 0, 2, 'java'),
(16, 0, 2, 'java'),
(17, 0, 2, 'python'),
(18, 0, 2, 'java'),
(19, 1, 5, 'sub'),
(20, 10, 2, 'java'),
(21, 10, 2, 'java'),
(22, 1, 5, 'sub'),
(23, 0, 2, 'java'),
(24, 0, 2, 'java'),
(25, 0, 2, 'java'),
(26, 9, 2, 'java'),
(27, 0, 2, 'java');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`q_id`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `q_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
