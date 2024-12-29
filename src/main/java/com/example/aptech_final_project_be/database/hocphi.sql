-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2024 at 02:51 PM
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
-- Table structure for table `hocphi`
--

CREATE TABLE `hocphi` (
  `id_hocphi` int(11) NOT NULL,
  `id_sinhvien` int(11) NOT NULL,
  `so_tien` decimal(10,2) NOT NULL,
  `trang_thai` enum('Chưa thanh toán','Đang xử lý','Đã thanh toán') DEFAULT 'Chưa thanh toán'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hocphi`
--

INSERT INTO `hocphi` (`id_hocphi`, `id_sinhvien`, `so_tien`, `trang_thai`) VALUES
(190, 62, 80400000.00, 'Chưa thanh toán'),
(191, 63, 80400000.00, 'Đã thanh toán'),
(192, 64, 80400000.00, 'Đang xử lý'),
(193, 65, 80400000.00, 'Chưa thanh toán'),
(194, 66, 80400000.00, 'Đã thanh toán'),
(195, 67, 80400000.00, 'Đang xử lý'),
(196, 68, 80400000.00, 'Chưa thanh toán'),
(197, 69, 80400000.00, 'Đã thanh toán'),
(198, 70, 80400000.00, 'Đang xử lý'),
(199, 71, 80400000.00, 'Chưa thanh toán'),
(200, 72, 80400000.00, 'Đã thanh toán'),
(201, 73, 80400000.00, 'Đang xử lý'),
(202, 74, 80400000.00, 'Chưa thanh toán'),
(203, 75, 80400000.00, 'Đã thanh toán'),
(204, 76, 80400000.00, 'Đang xử lý'),
(205, 77, 80400000.00, 'Chưa thanh toán'),
(206, 78, 80400000.00, 'Đã thanh toán'),
(207, 79, 80400000.00, 'Đang xử lý'),
(208, 80, 80400000.00, 'Chưa thanh toán'),
(209, 81, 80400000.00, 'Đã thanh toán'),
(210, 82, 80400000.00, 'Đang xử lý'),
(211, 83, 80400000.00, 'Chưa thanh toán'),
(212, 84, 80400000.00, 'Đã thanh toán'),
(213, 85, 80400000.00, 'Đang xử lý'),
(214, 86, 80400000.00, 'Chưa thanh toán'),
(215, 87, 80400000.00, 'Đã thanh toán'),
(216, 88, 80400000.00, 'Đang xử lý'),
(217, 89, 80400000.00, 'Chưa thanh toán'),
(218, 90, 80400000.00, 'Đã thanh toán'),
(219, 91, 80400000.00, 'Đang xử lý'),
(220, 92, 33300000.00, 'Chưa thanh toán'),
(221, 93, 33300000.00, 'Đã thanh toán'),
(222, 94, 33300000.00, 'Đang xử lý'),
(223, 95, 33300000.00, 'Chưa thanh toán'),
(224, 96, 33300000.00, 'Đã thanh toán'),
(225, 97, 33300000.00, 'Đang xử lý'),
(226, 98, 33300000.00, 'Chưa thanh toán'),
(227, 99, 33300000.00, 'Đã thanh toán'),
(228, 100, 33300000.00, 'Đang xử lý'),
(229, 101, 13500000.00, 'Chưa thanh toán'),
(230, 102, 13500000.00, 'Đã thanh toán'),
(231, 103, 13500000.00, 'Đang xử lý'),
(232, 104, 3000000.00, 'Chưa thanh toán'),
(233, 105, 13500000.00, 'Đã thanh toán'),
(234, 106, 13500000.00, 'Đang xử lý'),
(235, 107, 13500000.00, 'Chưa thanh toán'),
(236, 108, 13500000.00, 'Đã thanh toán'),
(237, 109, 13500000.00, 'Đang xử lý'),
(238, 110, 13500000.00, 'Chưa thanh toán'),
(239, 111, 13500000.00, 'Đã thanh toán');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hocphi`
--
ALTER TABLE `hocphi`
  ADD PRIMARY KEY (`id_hocphi`),
  ADD KEY `id_sinhvien` (`id_sinhvien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hocphi`
--
ALTER TABLE `hocphi`
  MODIFY `id_hocphi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=240;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hocphi`
--
ALTER TABLE `hocphi`
  ADD CONSTRAINT `hocphi_ibfk_1` FOREIGN KEY (`id_sinhvien`) REFERENCES `sinhvien` (`id_sinhvien`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
