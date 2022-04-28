CREATE DATABASE gymescorpion;
USE gymescorpion;
DROP DATABASE gymescorpion;
DROP TABLE Usuario;
-- Activo, Inactivo, Baneado

CREATE TABLE Estado(
idEstado INT PRIMARY KEY NOT NULL auto_increment,
Estado VARCHAR(10) NOT NULL
);

INSERT INTO Estado(Estado) VALUES 
('activo'),
('inactivo'),
('baneado');

CREATE TABLE tipo_usuario(
id_tipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
rol VARCHAR(10)
);

INSERT INTO tipo_usuario(rol) VALUES 
('admin'),
('trabajador'),
('visita'),
('socio');

CREATE TABLE Usuario(
idUsuario INT PRIMARY KEY NOT NULL auto_increment,
idEstado INT NOT NULL DEFAULT '1',
Usur VARCHAR(45) NULL,
Nombre VARCHAR(45) NULL,
pass VARCHAR(100) NULL,
id_tipo INT DEFAULT '2',
FOREIGN KEY (idEstado) REFERENCES Estado (idEstado)
ON DELETE CASCADE ON UPDATE CASCADE
);

/*SHA1*/
INSERT INTO Usuario(Usur, Nombre, pass, id_tipo) VALUES
('admin', 'admin', sha1('pass'), '1');

INSERT INTO Usuario(Usur, Nombre, pass, id_tipo) VALUES
('emp', 'Socio', sha1('clave'), '2');

SELECT * FROM Usuario;

-- HASTA AQUI SE ESTÁN HACIENDO COMPROBACION BD JAVA

-- Los clientes del gimnasio
CREATE TABLE Socio(
idSocio INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idEstado INT NOT NULL,
fechaCreacion DATETIME NULL,
Nombre VARCHAR(45) NULL,
Paterno VARCHAR(45) NULL,
Materno VARCHAR(45) NULL,
Tel VARCHAR(45) NULL,
-- Observaciones VARCHAR(500) NULL,
idUsuarioCreo INT NULL,
FOREIGN KEY (idEstado) REFERENCES Estado(idEstado) 
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);

-- Sucursales FALTA TERMINAR
CREATE TABLE Sucursal(
idSucursal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- direccion VARCHAR(50),
Nombre VARCHAR(45),
Tel VARCHAR(10),
idUsuario INT NOT NULL,
miembros INT NULL,
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (miembros) REFERENCES Socio(idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);

-- Membresia de los clientes delee gimnasio
CREATE TABLE Membresia(
idMembresia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Nombre VARCHAR(45) NULL,
-- idEstados INT NULL,
fechaCreacion DATETIME NULL,
Precio DECIMAL (8, 2) NULL,
idUsuarioCreo INT NULL,
meses INT NULL COMMENT 'meses de la membresia',
horaInicio TIME NULL,
horaFinal TIME NULL,
-- FOREIGN KEY (idEstados) REFERENCES Estado(idEstados)
-- ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);


-- Membresia de socios

CREATE TABLE SocioMembresia(
idSocioMembresia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idEstado INT NULL,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
idSocio INT NULL,
idMembresia INT NULL,
Precio DECIMAL (8,2) NULL,
fechaInicioMembresia DATETIME NULL,
FOREIGN KEY (idEstado) REFERENCES Estado (idEstado)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSocio) REFERENCES Socio(idSocio)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idMembresia) REFERENCES Membresia (idMembresia)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Entrada(
idEntrada INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- idEstados INT NULL DEFAULT 1,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
idSocio INT NOT NULL,
-- Total DECIMAL (8, 2) NULL,
-- FOREIGN KEY (idEstados) REFERENCES Estado (idEstados)
-- ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Salida(
idSalida INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- idEstado INT NULL,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
idSocio INT NOT NULL,
-- FOREIGN KEY (idEstado) REFERENCES Estado (idEstado) 
-- ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario (idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);
/*
CREATE TABLE DetalleSalida(
idDetalleSalida INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
idSalida INT NULL,
FOREIGN KEY (idProducto) REFERENCES Producto (idProducto)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSalida) REFERENCES Salida (idSalida)
ON DELETE CASCADE ON UPDATE CASCADE
);
*/
/*
CREATE TABLE DetalleEntrada(
idDetalleEntrada INT NOT NULL AUTO_INCREMENT,
idProducto INT NULL,
CostoUnitario DECIMAL(8, 2) NULL,
idEntrado INT NULL,
idDetalleSalida INT NULL,
FOREIGN KEY (idEntrada) REFERENCES Entrada (idEntrada)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idDetalleSalida) REFERENCES DetalleSalida (idDetalleSalida)
ON DELETE CASCADE ON UPDATE CASCADE
);
*/
/*
CREATE TABLE Registro(
idRegistro INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idSocio INT NULL,
fechaCreacion DATETIME NULL,
FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);
*/
CREATE TABLE Visita(
idVisita INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- idSocio INT NULL,
Nombre VARCHAR(50),
Paterno VARCHAR(50),
fechaCreacion DATETIME NULL,
precioVisita DECIMAL(8, 2) NULL
-- FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
-- ON DELETE CASCADE ON UPDATE CASCADE
);

DROP DATABASE gymescorpion;
/*-----------------------------------------------------------------------------------------*/
								/*	NUEVA BASE DE DATOS */
/*-----------------------------------------------------------------------------------------*/                                                                                 

CREATE DATABASE gymescorpion;
USE gymescorpion;

CREATE TABLE Estado(
idEstado INT PRIMARY KEY NOT NULL auto_increment,
Estado VARCHAR(10) NOT NULL
);

INSERT INTO Estado(Estado) VALUES 
('activo'),
('inactivo'),
('baneado');

CREATE TABLE tipoUsuario(
idTipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Rol VARCHAR(10)
);

INSERT INTO tipoUsuario(Rol) VALUES 
('admin'),
('trabajador'),
('visita'),
('miembro');

CREATE TABLE Sucursal(
idSucursal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Nombre VARCHAR(45),
Tel VARCHAR(10),
Calle VARCHAR(30),
Colonia VARCHAR(30)
);

INSERT INTO Sucursal(Nombre, Tel, Calle, Colonia) VALUES 
('Sucursal1', '1234567890', 'Sur 741', 'Colonia1'),
('Sucursal2', '7418529637', 'Norte 52', 'Colonia2'),
('Sucursal3', '3698521475', 'Poniente 84', 'Colonia3');

CREATE TABLE Usuario(
idUsuario INT PRIMARY KEY NOT NULL auto_increment,
idEstado INT NOT NULL DEFAULT '1',
Usuario VARCHAR(45) NULL,
Nombre VARCHAR(45) NULL,
Apellido VARCHAR(45) NULL,
fechaCreacion TIMESTAMP,
pass VARCHAR(100) NULL,
idTipo INT DEFAULT '2',
idSucursal INT NOT NULL,
FOREIGN KEY (idEstado) REFERENCES Estado (idEstado)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idTipo) REFERENCES tipoUsuario (idTipo)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSucursal) REFERENCES Sucursal (idSucursal)
ON DELETE CASCADE ON UPDATE CASCADE
);
/*INSERTAR DATOS CON PASSWORD CIFRADO CON SHA1*/
INSERT INTO Usuario(Usuario, Nombre, Apellido, fechaCreacion, pass, idTipo, idSucursal) VALUES
('adminSuc1', 'administrador', 'de Sucursal1', '2022-04-27 00:20:50', sha1('pass'), '1', '1'),
('adminSuc2', 'administrador', 'de Sucursal2', '2022-04-27 00:03:57', sha1('contra'), '1', '2'),
('adminSuc3', 'administrador', 'de Sucursal3', '2022-04-27 01:12:50', sha1('clave'), '1', '3');
/*UPDATE Usuario 
SET Apellido = 'de Sucursal3', Nombre = 'administrador3'
WHERE idUsuario = '3';*/
INSERT INTO Usuario(Usuario, Nombre, Apellido, fechaCreacion, pass, idTipo, idSucursal) VALUES
('emp', 'Socio', 'Sucursal1', '2022-04-27 00:15:34', sha1('clave'), '2', '1'),
('emp2', 'trabajador', 'Sucursal2', '2022-04-27 08:30:15', sha1('contraseña'), '2', '2'),
('emp3', 'colaborador', 'Sucursal3', '2022-04-27 00:00:00', sha1('123'), '2', '3');
SELECT * FROM Usuario;

CREATE TABLE Miembro(
idMiembro INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idEstado INT NOT NULL,
fechaCreacion DATETIME NULL,
Nombre VARCHAR(45) NULL,
Paterno VARCHAR(45) NULL,
Materno VARCHAR(45) NULL,
Tel VARCHAR(45) NULL,
Observaciones VARCHAR(500) NULL,
idUsuarioCreo INT NULL,
FOREIGN KEY (idEstado) REFERENCES Estado(idEstado) 
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Membresia(
idMembresia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Nombre VARCHAR(45) NULL,
idEstado INT NULL,
fechaCreacion DATETIME NULL,
Precio DECIMAL (8, 2) NULL,
idUsuarioCreo INT NULL,
meses INT NULL COMMENT 'meses de la membresia',
horaInicio TIME NULL,
horaFinal TIME NULL,
FOREIGN KEY (idEstado) REFERENCES Estado(idEstado)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE MiembroMembresia(
idSocioMembresia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idEstado INT NULL,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
idMiembro INT NULL,
idMembresia INT NULL,
Precio DECIMAL (8,2) NULL,
fechaInicioMembresia DATETIME NULL,
FOREIGN KEY (idEstado) REFERENCES Estado (idEstado)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idMiembro) REFERENCES Miembro(idMiembro)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idMembresia) REFERENCES Membresia (idMembresia)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Entrada(
idEntrada INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
fechaCreacion DATETIME NOT NULL,
idUsuarioCreo INT NULL,
idMiembro INT NOT NULL,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idMiembro) REFERENCES Miembro(idMiembro)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Salida(
idSalida INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
idMiembro INT NOT NULL,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario (idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idMiembro) REFERENCES Miembro(idMiembro)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Visita(
idVisita INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idMiembro INT NULL,
fechaCreacion DATETIME NULL,
precioVisita DECIMAL(8, 2) NULL,
FOREIGN KEY (idMiembro) REFERENCES Miembro (idMiembro)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE UsuarioSucursal(
idUsuarioSucursal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idSucursal INT NOT NULL,
idUsuario INT NOT NULL,
FOREIGN KEY (idSucursal) REFERENCES Sucursal(idSucursal)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);

DROP DATABASE gymescorpion;