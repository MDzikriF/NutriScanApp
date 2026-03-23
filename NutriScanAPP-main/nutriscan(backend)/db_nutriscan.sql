-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2025 at 02:31 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_nutriscan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hasil_scan`
--

CREATE TABLE `tbl_hasil_scan` (
  `no` int(40) NOT NULL,
  `kalori` varchar(50) NOT NULL,
  `karbohidrat` varchar(255) NOT NULL,
  `lemak total` varchar(50) NOT NULL,
  `protein` varchar(50) NOT NULL,
  `natrium` varchar(50) NOT NULL,
  `serat` varchar(50) NOT NULL,
  `mineral` text NOT NULL,
  `catatan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `no` int(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `password` text NOT NULL,
  `usia` int(20) NOT NULL,
  `tinggi_badan` int(10) NOT NULL,
  `berat_badan` int(20) NOT NULL,
  `alergi` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`no`, `nama`, `password`, `usia`, `tinggi_badan`, `berat_badan`, `alergi`) VALUES
(1, '', '', 0, 0, 0, ''),
(5, 'janedoe', '321', 23, 166, 65, 'Telur'),
(7, 'fulan', 're321', 21, 180, 80, 'Telur'),
(8, 'fulanah', '321', 24, 167, 65, 'Kacang'),
(9, 'prasetyo', '321', 21, 167, 90, 'Gandum'),
(10, 'Hanz', '321', 19, 171, 70, 'Lainnya'),
(13, 'pras', 'tyo890', 23, 176, 73, 'Telur'),
(14, 'human', '54321', 20, 190, 60, 'Susu'),
(15, 'manusia', '4331', 19, 180, 80, 'Telur'),
(20, 'fulanih', '321', 18, 167, 60, 'Gandum'),
(22, 'man', '321', 21, 189, 80, 'Susu'),
(24, 'Jhondoe', '321', 19, 180, 80, 'Susu'),
(25, 'jack', '321', 18, 180, 78, 'Kacang');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_hasil_scan`
--
ALTER TABLE `tbl_hasil_scan`
  ADD PRIMARY KEY (`no`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_hasil_scan`
--
ALTER TABLE `tbl_hasil_scan`
  MODIFY `no` int(40) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `no` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
