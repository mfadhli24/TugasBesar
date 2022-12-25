-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Des 2022 pada 15.38
-- Versi server: 10.1.34-MariaDB
-- Versi PHP: 5.6.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasir`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(50) NOT NULL,
  `id_kategori` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `id_kategori`, `nama_barang`, `harga`) VALUES
('03fc552a-eea7-4203-89c2-69585cfa90d9', '90c78279-52d2-4294-8c89-85fe9744a59c', 'hahhahaha', 4000),
('17a62f35-1afe-430e-bb73-2c7c349cb695', '2e82d30a-d20b-40ed-9c97-e7f4d87661d3', 'HoneyMoon', 12000),
('1cecc47a-3e5b-4f8d-a0dd-525feaeddc98', '90c78279-52d2-4294-8c89-85fe9744a59c', 'TO Geprek', 17000),
('2ed3e170-5197-48ad-b0d0-7d31c2e2bf5c', '1a483f92-f294-4c7e-be9f-16b5a5fb1fc7', '123', 123),
('455261d2-b422-46ff-b0b5-89e16f157790', '2e82d30a-d20b-40ed-9c97-e7f4d87661d3', 'Mock', 12000),
('48751e2d-f8a6-485b-8753-d99c8496dbe4', 'Makan Berat', '123456', 123456),
('7253b76e-12b0-40cf-a803-f34db40cf966', '1a483f92-f294-4c7e-be9f-16b5a5fb1fc7', 'Koopich', 15000),
('745617a7-011c-42a4-9234-fe16631b057a', '2e82d30a-d20b-40ed-9c97-e7f4d87661d3', 'Percobaan', 100000),
('820a381b-c8ea-4a10-b6b7-8b7bafb32910', '1a483f92-f294-4c7e-be9f-16b5a5fb1fc7', 'percobaan', 123123123),
('86348d9d-15fc-4f8b-97f7-b8a802eebfdf', 'ceaef6fe-8be0-42ef-8e64-e42f960db6f1', 'Ice Coffee Lemon', 15000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_transaksi` int(11) NOT NULL,
  `nama_pembeli` varchar(50) NOT NULL,
  `qyt` int(11) NOT NULL,
  `total_transaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` varchar(50) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
('1a483f92-f294-4c7e-be9f-16b5a5fb1fc7', 'Cemilan'),
('2e82d30a-d20b-40ed-9c97-e7f4d87661d3', 'Non-Kopi'),
('90c78279-52d2-4294-8c89-85fe9744a59c', 'Makan Berat'),
('9666f529-2002-4c2d-b21a-d5472336be4e', 'Desert'),
('b2e855a6-3db1-484a-bd1c-483a35aeb1c8', 'Milky'),
('c429f0d0-48b2-4089-b648-3571c749f23c', 'Kopi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transksi` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `nama_pembeli` text NOT NULL,
  `harga` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transksi`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transksi` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
