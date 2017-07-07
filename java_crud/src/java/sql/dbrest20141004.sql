CREATE DATABASE dbrest;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table 'personas'
--

INSERT INTO personas (per_nombre, per_email) VALUES
('julieta', 'juli@gmail'),
('marcelo', 'marce@gmail'),
('dieguito', 'dieguito@gmail'),
('pedro', 'peter@gmail'),
('carlos', 'carlitos@gmail'),
('sabrina', 'sabri@gmail'),
('max', 'max@gmail');

