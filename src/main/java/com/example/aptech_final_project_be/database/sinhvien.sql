-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2024 at 02:43 PM
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
-- Table structure for table `sinhvien`
--

CREATE TABLE `sinhvien` (
  `id_sinhvien` int(11) NOT NULL,
  `id_nguoidung` int(11) NOT NULL,
  `ten_sinhvien` varchar(255) NOT NULL,
  `id_lop` int(11) DEFAULT NULL,
  `id_chuyennganh` int(11) DEFAULT NULL,
  `nam_vao_hoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `sinhvien`
--

INSERT INTO `sinhvien` (`id_sinhvien`, `id_nguoidung`, `ten_sinhvien`, `id_lop`, `id_chuyennganh`, `nam_vao_hoc`) VALUES
(62, 62, 'Đoàn Nguyên Đức', NULL, 1, 2023),
(63, 63, 'Đoàn Dự', NULL, 1, 2023),
(64, 64, 'Sinh viên user64', NULL, 1, 2023),
(65, 65, 'Sinh viên user65', NULL, 1, 2023),
(66, 66, 'Sinh viên user66', NULL, 1, 2023),
(67, 67, 'Sinh viên user67', NULL, 1, 2023),
(68, 68, 'Sinh viên user68', NULL, 1, 2023),
(69, 69, 'Sinh viên user69', NULL, 1, 2023),
(70, 70, 'Sinh viên user70', NULL, 1, 2023),
(71, 71, 'Sinh viên user71', NULL, 1, 2023),
(72, 72, 'Sinh viên user72', NULL, 1, 2023),
(73, 73, 'Sinh viên user73', NULL, 1, 2023),
(74, 74, 'Sinh viên user74', NULL, 1, 2023),
(75, 75, 'Sinh viên user75', NULL, 1, 2023),
(76, 76, 'Sinh viên user76', NULL, 1, 2023),
(77, 77, 'Sinh viên user77', NULL, 1, 2023),
(78, 78, 'Sinh viên user78', NULL, 1, 2023),
(79, 79, 'Sinh viên user79', NULL, 1, 2023),
(80, 80, 'Sinh viên user80', NULL, 1, 2023),
(81, 81, 'Sinh viên user81', NULL, 1, 2023),
(82, 82, 'Sinh viên user82', NULL, 1, 2023),
(83, 83, 'Sinh viên user83', NULL, 1, 2023),
(84, 84, 'Sinh viên user84', NULL, 1, 2023),
(85, 85, 'Sinh viên user85', NULL, 1, 2023),
(86, 86, 'Sinh viên user86', NULL, 1, 2023),
(87, 87, 'Sinh viên user87', NULL, 1, 2023),
(88, 88, 'Sinh viên user88', NULL, 1, 2023),
(89, 89, 'Sinh viên user89', NULL, 1, 2023),
(90, 90, 'Sinh viên user90', NULL, 1, 2023),
(91, 91, 'Sinh viên user91', NULL, 1, 2023),
(92, 92, 'Sinh viên user92', NULL, 2, 2023),
(93, 93, 'Sinh viên user93', NULL, 2, 2023),
(94, 94, 'Sinh viên user94', NULL, 2, 2023),
(95, 95, 'Sinh viên user95', NULL, 2, 2023),
(96, 96, 'Sinh viên user96', NULL, 2, 2023),
(97, 97, 'Sinh viên user97', NULL, 2, 2023),
(98, 98, 'Sinh viên user98', NULL, 2, 2023),
(99, 99, 'Sinh viên user99', NULL, 2, 2023),
(100, 100, 'Sinh viên user100', NULL, 2, 2023),
(101, 101, 'Đoàn Văn Vương', NULL, 4, 2023),
(102, 102, 'Lâm Chấn Đông', NULL, 4, 2023),
(103, 103, 'Tấm', NULL, 4, 2023),
(104, 104, 'Hoàng Mạnh Hà', NULL, 5, 2023),
(105, 105, 'Nguyễn Đức', NULL, 4, 2023),
(106, 106, 'Chẩu Mạnh Hà', NULL, 4, 2023),
(107, 107, 'Trần Đức Bình', NULL, 4, 2023),
(108, 108, 'Hoàng Việt Cồ', NULL, 4, 2023),
(109, 109, 'Văn Bằng', NULL, 4, 2023),
(110, 110, 'Khổng Tử', NULL, 4, 2023),
(111, 111, 'Nguyễn Chí Cường', NULL, 4, 2023);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`id_sinhvien`),
  ADD KEY `id_nguoidung` (`id_nguoidung`),
  ADD KEY `ma_chuyen_nganh` (`id_chuyennganh`),
  ADD KEY `fk_id_lop` (`id_lop`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sinhvien`
--
ALTER TABLE `sinhvien`
  MODIFY `id_sinhvien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD CONSTRAINT `fk_id_lop` FOREIGN KEY (`id_lop`) REFERENCES `lop` (`id_lop`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_nguoidung` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sinhvien_ibfk_1` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE,
  ADD CONSTRAINT `sinhvien_ibfk_2` FOREIGN KEY (`id_chuyennganh`) REFERENCES `chuyennganh` (`id_chuyennganh`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
