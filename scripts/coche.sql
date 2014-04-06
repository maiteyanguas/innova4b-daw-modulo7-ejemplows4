CREATE TABLE `coche` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `matricula` varchar(45) DEFAULT NULL,
  `anyoCompra` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

insert into coche(marca,modelo,matricula,anyoCompra) values ('Seat','Ibiza','7455CKP',2001);