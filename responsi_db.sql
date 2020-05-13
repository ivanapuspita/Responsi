-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2020 at 09:52 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `responsi_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `id` int(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `posisi` varchar(40) NOT NULL,
  `alamat` varchar(40) NOT NULL,
  `telp` varchar(40) NOT NULL,
  `gajipokok` int(11) NOT NULL,
  `jamlembur` int(11) NOT NULL,
  `tunjangan` int(11) NOT NULL,
  `pajak` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`id`, `nama`, `posisi`, `alamat`, `telp`, `gajipokok`, `jamlembur`, `tunjangan`, `pajak`, `total`) VALUES
(101, 'Akika', 'Manager', 'aaa', '081223222111', 10000000, 10, 15000, 100000, 9915000),
(111, 'Anisa', 'Programmer', 'Jl mangga', '081222333111', 5000000, 10, 15000, 50000, 4965000),
(118, 'Vika', 'Programmer', 'jl gaga', '081223390912', 6000000, 12, 18000, 60000, 5958000),
(221, 'Avila', 'Marketing', 'Jl Sisi', '089900989891', 10000000, 12, 18000, 100000, 9918000);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `idkar` int(11) NOT NULL,
  `namakar` varchar(40) NOT NULL,
  `posisikar` varchar(40) NOT NULL,
  `alamatkar` varchar(40) NOT NULL,
  `telpkar` varchar(40) NOT NULL,
  `totalkar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`idkar`, `namakar`, `posisikar`, `alamatkar`, `telpkar`, `totalkar`) VALUES
(101, 'Alika', 'Manager', 'aaa', '081223222111', 10000000),
(113, 'Ali', 'Direktur', 'Jl manggis', '081111222', 15000000),
(114, 'anisa a', 'programmer', 'jl salak', '081222000999', 8000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`idkar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
