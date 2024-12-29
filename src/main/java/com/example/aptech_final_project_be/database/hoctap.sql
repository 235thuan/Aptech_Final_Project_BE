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
-- Table structure for table `hoctap`
--

CREATE TABLE `hoctap` (
  `id_hoctap` int(11) NOT NULL,
  `id_nguoidung` int(11) NOT NULL,
  `id_monhoc` int(11) NOT NULL,
  `id_noidung` int(11) NOT NULL,
  `trang_thai` enum('Đang học','Đã hoàn thành') DEFAULT 'Đang học',
  `thoi_gian_bat_dau` datetime DEFAULT current_timestamp(),
  `thoi_gian_hoan_thanh` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hoctap`
--
ALTER TABLE `hoctap`
  ADD PRIMARY KEY (`id_hoctap`),
  ADD KEY `id_nguoidung` (`id_nguoidung`),
  ADD KEY `id_monhoc` (`id_monhoc`),
  ADD KEY `id_noidung` (`id_noidung`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoctap`
--
ALTER TABLE `hoctap`
  MODIFY `id_hoctap` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hoctap`
--
ALTER TABLE `hoctap`
  ADD CONSTRAINT `hoctap_ibfk_1` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`),
  ADD CONSTRAINT `hoctap_ibfk_2` FOREIGN KEY (`id_monhoc`) REFERENCES `monhoc` (`id_monhoc`),
  ADD CONSTRAINT `hoctap_ibfk_3` FOREIGN KEY (`id_noidung`) REFERENCES `noidungmonhoc` (`id_noidung`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
