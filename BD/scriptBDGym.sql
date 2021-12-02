drop database gymescorpion;

CREATE DATABASE gymEscorpion;
USE gymEscorpion;

CREATE TABLE Estado(
idEstado INT PRIMARY KEY NOT NULL auto_increment,
Estado VARCHAR(45) NULL
);

CREATE TABLE tipo_usuario(
id_tipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
rol VARCHAR(10)
);
INSERT INTO Estado (Estado) VALUES 
('activo'), 
('inactivo'), 
('baneado');

INSERT INTO tipo_usuario (rol) VALUES
('admin'),
('socio');

CREATE TABLE Usuario(
idUsuario INT PRIMARY KEY NOT NULL auto_increment,
idEstado INT NULL default'1',
Username VARCHAR(45) NULL,
Nombre VARCHAR(45) NULL,
pass VARCHAR(45) NULL,
id_tipo INT default '2',
FOREIGN KEY (idEstado) REFERENCES Estado(idEstado)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (id_tipo) REFERENCES tipo_usuario(id_tipo)
ON DELETE CASCADE ON UPDATE CASCADE
);

/*SHA1*/
INSERT INTO Usuario(Username, Nombre, pass, id_tipo) VALUES
('admin', 'admin', sha1('pass'), '1'),
('emp', 'Socio', sha1('clave'), '2');

Drop table usuario;

CREATE TABLE Socio(
idSocio INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
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

CREATE TABLE Sucursal(
idSucursal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
direccion VARCHAR(45),
Nombre VARCHAR(45),
Tel VARCHAR(10),
idUsuario INT NOT NULL,
miembros INT NULL
);

CREATE TABLE Membresia(
idMembresia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Nombre VARCHAR(45) NULL,
idEstado INT NULL,
fechaCreacion DATETIME NULL,
Precio DECIMAL (8, 2) NULL,
idUsuarioCreo INT NULL,
meses INT NULL COMMENT 'meses de la membresia',
horaInicio TIME NULL COMMENT 'hora que comienza la membresia para horarios especiales',
horaFinal TIME NULL COMMENT 'hora en que termina la membresia para horarios especiales',
FOREIGN KEY (idEstado) REFERENCES Estado(idEstado)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);

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
idEstado INT NULL DEFAULT 1,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
Total DECIMAL (8, 2) NULL,
FOREIGN KEY (idEstado) REFERENCES Estado (idEstado)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Salida(
idSalida INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idEstado INT NULL,
fechaCreacion DATETIME NULL,
total DECIMAL(8, 2) NULL,
idUsuarioCreo INT NULL,
FOREIGN KEY (idEstado) REFERENCES Estado (idEstado) 
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario (idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE DetalleSalida(
idDetalleSalida INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
descripcion varchar(500) NULL,
idSalida INT NULL,
FOREIGN KEY (idSalida) REFERENCES Salida (idSalida)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE DetalleEntrada(
idDetalleEntrada INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
descripcion varchar(500) NULL,
idEntrada INT NULL,
FOREIGN KEY (idEntrada) REFERENCES Entrada (idEntrada)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Registro(
idRegistro INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idSocio INT NULL,
fechaCreacion DATETIME NULL,
FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Visita(
idVisita INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idSocio INT NULL,
fechaCreacion DATETIME NULL,
precioVisita DECIMAL(8, 2) NULL,
FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);
