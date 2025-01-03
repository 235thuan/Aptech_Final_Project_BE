-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2024 at 02:47 PM
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
-- Table structure for table `monhoc`
--

CREATE TABLE `monhoc` (
  `id_monhoc` int(11) NOT NULL,
  `ten_monhoc` varchar(255) NOT NULL,
  `so_tin_chi` int(11) NOT NULL,
  `id_chuyennganh` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`id_monhoc`, `ten_monhoc`, `so_tin_chi`, `id_chuyennganh`) VALUES
(1, 'Lập Trình C', 3, 1),
(2, 'Cấu Trúc Dữ Liệu', 4, 1),
(3, 'Hệ Điều Hành', 3, 1),
(4, 'Mạng Máy Tính', 4, 1),
(5, 'Kỹ Thuật Phần Mềm', 3, 1),
(6, 'An Toàn Thông Tin', 2, 1),
(7, 'Giải Thuật', 4, 1),
(8, 'Khoa Học Dữ Liệu', 4, 1),
(9, 'Lập Trình Java', 3, 1),
(10, 'Mạng Viễn Thông', 3, 1),
(11, 'Kinh Tế Vi Mô', 3, 2),
(12, 'Quản Trị Kinh Doanh', 3, 2),
(13, 'Kế Toán Quản Trị', 3, 2),
(14, 'Marketing', 4, 2),
(15, 'Tài Chính Ngân Hàng', 4, 2),
(16, 'Kinh Tế Lượng', 3, 2),
(17, 'Kinh Tế Học', 4, 2),
(18, 'Lý Thuyết Tài Chính', 3, 2),
(19, 'Đầu Tư Tài Chính', 3, 2),
(20, 'Pháp Luật Kinh Tế', 3, 2),
(21, 'Y Học Cơ Sở', 4, 3),
(22, 'Sinh Lý Học', 3, 3),
(23, 'Dược Học Cơ Sở', 3, 3),
(24, 'Chẩn Đoán Bệnh', 4, 3),
(25, 'Điều Dưỡng', 3, 3),
(26, 'Vi sinh học Y Dược', 3, 3),
(27, 'Răng Hàm Mặt', 3, 3),
(28, 'Sức Khỏe Cộng Đồng', 4, 3),
(29, 'Giải Phẫu Học', 3, 3),
(30, 'Kỹ Thuật Cầu Đường', 3, 4),
(31, 'Xây Dựng Dân Dụng', 3, 4),
(32, 'Kết Cấu Công Trình', 4, 4),
(33, 'Kỹ Thuật Xây Dựng', 4, 4),
(34, 'Vật Liệu Xây Dựng', 3, 4),
(35, 'Đo Lường và Thiết Kế', 4, 4),
(36, 'Quản Lý Dự Án', 4, 4),
(37, 'Điện Tử Viễn Thông', 3, 5),
(38, 'Kỹ Thuật Điện Tử', 3, 5),
(39, 'Viễn Thông và Mạng', 4, 5),
(40, 'Mạng và An Toàn Thông Tin', 3, 5),
(41, 'Xử Lý Tín Hiệu', 4, 5),
(42, 'Điện Tử Công Nghiệp', 3, 5),
(43, 'Điện Tử Viễn Thông 2', 3, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`id_monhoc`),
  ADD KEY `ma_chuyen_nganh` (`id_chuyennganh`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `monhoc`
--
ALTER TABLE `monhoc`
  MODIFY `id_monhoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `monhoc`
--
ALTER TABLE `monhoc`
  ADD CONSTRAINT `monhoc_ibfk_1` FOREIGN KEY (`id_chuyennganh`) REFERENCES `chuyennganh` (`id_chuyennganh`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
