-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 04, 2014 at 11:16 PM
-- Server version: 1.0.100
-- PHP Version: 5.4.4-14+deb7u14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "-03:00";


--
-- Database: 'dbrest'
--
DROP DATABASE dbrest;
CREATE DATABASE dbrest DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE dbrest;

-- --------------------------------------------------------

--
-- Table structure for table 'personas'
--

DROP TABLE IF EXISTS personas;
CREATE TABLE IF NOT EXISTS personas (
  per_id int(11) NOT NULL AUTO_INCREMENT,
  per_nombre varchar(250) NOT NULL,
  per_email varchar(250) NOT NULL,
  PRIMARY KEY (per_id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table 'personas'
--

INSERT INTO personas (per_id, per_nombre, per_email) VALUES
(2, 'ot', 'tro@gmail'),
(3, 'uno', 'uno@gmail'),
(4, 'dieguito', 'dieguito@gmail'),
(5, 'max', 'max@gmail');

