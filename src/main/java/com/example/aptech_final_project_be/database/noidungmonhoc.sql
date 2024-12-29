-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2024 at 02:52 PM
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
-- Database: `do_an_nhom_4`
--

-- --------------------------------------------------------

--
-- Table structure for table `noidungmonhoc`
--

CREATE TABLE `noidungmonhoc` (
  `id_noidung` int(11) NOT NULL,
  `id_monhoc` int(11) NOT NULL,
  `id_file` int(11) NOT NULL,
  `ten_bai_giang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `noidungmonhoc`
--
ALTER TABLE `noidungmonhoc`
  ADD PRIMARY KEY (`id_noidung`),
  ADD KEY `id_monhoc` (`id_monhoc`),
  ADD KEY `fk_idfile` (`id_file`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `noidungmonhoc`
--
ALTER TABLE `noidungmonhoc`
  MODIFY `id_noidung` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `noidungmonhoc`
--
ALTER TABLE `noidungmonhoc`
  ADD CONSTRAINT `fk_idfile` FOREIGN KEY (`id_file`) REFERENCES `file_upload` (`id_file`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `noidungmonhoc_ibfk_1` FOREIGN KEY (`id_monhoc`) REFERENCES `monhoc` (`id_monhoc`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
