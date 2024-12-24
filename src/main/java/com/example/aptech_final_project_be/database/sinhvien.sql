-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2024 at 10:51 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

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
  `lop` varchar(100) DEFAULT NULL,
  `ma_chuyen_nganh` int(11) DEFAULT NULL,
  `nam_vao_hoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `sinhvien`
--

INSERT INTO `sinhvien` (`id_sinhvien`, `id_nguoidung`, `ten_sinhvien`, `lop`, `ma_chuyen_nganh`, `nam_vao_hoc`) VALUES
(62, 62, 'Đoàn Nguyên Đức', 'KTPM01', 1, 2023),
(63, 63, 'Đoàn Dự', 'KTPM01', 1, 2023),
(64, 64, 'Sinh viên user64', 'KTPM01', 1, 2023),
(65, 65, 'Sinh viên user65', 'KTPM01', 1, 2023),
(66, 66, 'Sinh viên user66', 'KTPM01', 1, 2023),
(67, 67, 'Sinh viên user67', 'KTPM01', 1, 2023),
(68, 68, 'Sinh viên user68', 'KTPM01', 1, 2023),
(69, 69, 'Sinh viên user69', 'KTPM01', 1, 2023),
(70, 70, 'Sinh viên user70', 'KTPM01', 1, 2023),
(71, 71, 'Sinh viên user71', 'KTPM01', 1, 2023),
(72, 72, 'Sinh viên user72', 'KTPM02', 1, 2023),
(73, 73, 'Sinh viên user73', 'KTPM02', 1, 2023),
(74, 74, 'Sinh viên user74', 'KTPM02', 1, 2023),
(75, 75, 'Sinh viên user75', 'KTPM02', 1, 2023),
(76, 76, 'Sinh viên user76', 'KTPM02', 1, 2023),
(77, 77, 'Sinh viên user77', 'KTPM02', 1, 2023),
(78, 78, 'Sinh viên user78', 'KTPM02', 1, 2023),
(79, 79, 'Sinh viên user79', 'KTPM02', 1, 2023),
(80, 80, 'Sinh viên user80', 'KTPM02', 1, 2023),
(81, 81, 'Sinh viên user81', 'KTPM02', 1, 2023),
(82, 82, 'Sinh viên user82', 'KTPM03', 1, 2023),
(83, 83, 'Sinh viên user83', 'KTPM03', 1, 2023),
(84, 84, 'Sinh viên user84', 'KTPM03', 1, 2023),
(85, 85, 'Sinh viên user85', 'KTPM03', 1, 2023),
(86, 86, 'Sinh viên user86', 'KTPM03', 1, 2023),
(87, 87, 'Sinh viên user87', 'KTPM03', 1, 2023),
(88, 88, 'Sinh viên user88', 'KTPM03', 1, 2023),
(89, 89, 'Sinh viên user89', 'KTPM03', 1, 2023),
(90, 90, 'Sinh viên user90', 'KTPM03', 1, 2023),
(91, 91, 'Sinh viên user91', 'KTPM03', 1, 2023),
(92, 92, 'Sinh viên user92', 'MMT01', 2, 2023),
(93, 93, 'Sinh viên user93', 'MMT01', 2, 2023),
(94, 94, 'Sinh viên user94', 'MMT01', 2, 2023),
(95, 95, 'Sinh viên user95', 'MMT01', 2, 2023),
(96, 96, 'Sinh viên user96', 'MMT01', 2, 2023),
(97, 97, 'Sinh viên user97', 'MMT02', 2, 2023),
(98, 98, 'Sinh viên user98', 'MMT02', 2, 2023),
(99, 99, 'Sinh viên user99', 'MMT02', 2, 2023),
(100, 100, 'Sinh viên user100', 'MMT02', 2, 2023),
(101, 101, 'Đoàn Văn Vương', 'ATTT01', 4, 2023),
(102, 102, 'Lâm Chấn Đông', 'ATTT02', 4, 2023),
(103, 103, 'Tấm', 'ATTT03', 4, 2023),
(104, 104, 'Hoàng Mạnh Hà', 'HTTT01', 5, 2023),
(105, 105, 'Nguyễn Đức', 'ATTT01', 4, 2023),
(106, 106, 'Chẩu Mạnh Hà', 'ATTT01', 4, 2023),
(107, 107, 'Trần Đức Bình', 'ATTT01', 4, 2023),
(108, 108, 'Hoàng Việt Cồ', 'ATTT01', 4, 2023),
(109, 109, 'Văn Bằng', 'ATTT01', 4, 2023),
(110, 110, 'Khổng Tử', 'ATTT01', 4, 2023),
(111, 111, 'Nguyễn Chí Cường', 'ATTT02', 4, 2023);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`id_sinhvien`),
  ADD KEY `id_nguoidung` (`id_nguoidung`),
  ADD KEY `ma_chuyen_nganh` (`ma_chuyen_nganh`);

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
  ADD CONSTRAINT `sinhvien_ibfk_1` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE,
  ADD CONSTRAINT `sinhvien_ibfk_2` FOREIGN KEY (`ma_chuyen_nganh`) REFERENCES `chuyennganh` (`id_chuyennganh`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
