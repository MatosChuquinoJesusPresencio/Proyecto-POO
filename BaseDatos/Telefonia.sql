CREATE DATABASE Telefonia;

USE Telefonia;

CREATE TABLE Usuario (
	idUsuario VARCHAR(20) NOT NULL,
	Nombre VARCHAR(40),
	apellidoP VARCHAR(25),
	apellidoM VARCHAR(25),
	Email VARCHAR(50) UNIQUE,
	Contrasena VARCHAR(40),
	fechaNacimiento DATE,
	tipoDocumento VARCHAR (10) CHECK (tipoDocumento IN('DNI','Pasaporte')),
	Documento VARCHAR(20) UNIQUE,
	PRIMARY KEY (idUsuario)
);

INSERT INTO Usuario (idUsuario, Nombre, apellidoP, apellidoM, Email, Contrasena, fechaNacimiento, tipoDocumento, Documento) VALUES
('USR0001', 'Jesus', 'Matos', 'Chuquino', 'Jesus123@gmail.com', '123', '27-03-2006', 'DNI', '37190211'),
('USR0002', 'Edu', 'Morales', 'Carlos', 'EduMC@gmail.com', '123', '03/11/2004', 'DNI', '12334312');

CREATE TABLE Cliente (
	idUsuario VARCHAR(20) NOT NULL,
	fechaRegistro DATE,
	numLineas INT,
	Estado VARCHAR(15) CHECK (Estado IN('ACTIVO','SUSPENDIDO')),
	PRIMARY KEY (idUsuario),
	FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

INSERT INTO Cliente (idUsuario, fechaRegistro, numLineas, Estado) VALUES 
('USR0002', '13/11/2024', 0, 'ACTIVO');

CREATE TABLE Empleado(
	idUsuario VARCHAR(20) NOT NULL,
	Salario DECIMAL(10,2),
	fechaContratado DATE,
	PRIMARY KEY (idUsuario),
	FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

INSERT INTO Empleado (idUsuario, Salario, fechaContratado) VALUES
('USR0001', 400.25, '04-11-2024')

CREATE TABLE [Plan] (
	idPlan VARCHAR(10) PRIMARY KEY NOT NULL,
	Detalles VARCHAR(40),
	tipoPlan VARCHAR(20) CHECK(tipoPlan IN('POSTPAGO','PREPAGO','EMPRESARIAL')),
	Precio DECIMAL(5,2),
	duracionDias INT,
	Gigas INT,
	Beneficios VARCHAR(200),
	Apps VARCHAR(250)
);

INSERT INTO [Plan] (idPlan, Detalles, tipoPlan, Precio, duracionDias, Gigas, Beneficios, Apps) VALUES
('PRE1', 'Recarga de S/.5', 'PREPAGO', 5.00, 5, 1, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp, Youtube y Spotify'),
('PRE2', 'Recarga de S/.7', 'PREPAGO', 7.00, 7, 2, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram y WhatsApp, Youtube y Spotify'),
('PRE3', 'Recarga de S/.10', 'PREPAGO', 10.00, 10, 3, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram y WhatsApp, Youtube y Spotify'),
('PRE4', 'Recarga de S/.15', 'PREPAGO', 15.00, 15, 5, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram y WhatsApp, Youtube y Spotify'),
('POS1', 'Plan S/.39.90 al mes', 'POSTPAGO', 39.90, 30, 25, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp y Waze'),
('POS2', 'Plan S/.49.90 al mes', 'POSTPAGO', 49.90, 30, 40, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp y Waze'),
('POS3', 'Plan S/.59.90 al mes', 'POSTPAGO', 59.90, 30, 75, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp y Waze'),
('POS4', 'Plan S/.69.90 al mes', 'POSTPAGO', 69.90, 30, 100, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp y Waze'),
('EMP1', 'Plan S/.39.90 al mes', 'EMPRESARIAL', 39.90, 30, 30, '2GB de Roaming, Llamadas y SMS ilimitados a Perú, Canada y EE.UU.', 'Facebook, Mesenger, Instagram, WhatsApp y Bussines Pack'),
('EMP2', 'Plan S/.59.90 al mes', 'EMPRESARIAL', 59.90, 30, 80, '3GB de Roaming, Llamadas y SMS ilimitados a Perú, Canada y EE.UU.', 'Facebook, Mesenger, Instagram, WhatsApp y Bussines Pack'),
('EMP3', 'Plan S/.69.90 al mes', 'EMPRESARIAL', 69.90, 30, 105, '5GB de Roaming, Llamadas y SMS ilimitados a Perú, Canada y EE.UU.', 'Facebook, Mesenger, Instagram, WhatsApp y Bussines Pack')

CREATE TABLE Linea (
	idLinea INT PRIMARY KEY NOT NULL,
	idCliente VARCHAR(20) NOT NULL,
	idPlan VARCHAR(10) NOT NULL,
	Telefono INT UNIQUE,
	Estado VARCHAR(10) CHECK (Estado IN('ACTIVA','CANCELADA','SUSPENDIDA')),
	fechaInicioPlan DATE,
	fechaFinPlan DATE,
	FOREIGN KEY(idCliente) REFERENCES Cliente(idUsuario),
	FOREIGN KEY(idPlan) REFERENCES [Plan](idPlan)
);

CREATE TABLE Factura (
	idFactura INT PRIMARY KEY NOT NULL,
	idUsuario VARCHAR(20) NOT NULL,
	fechaEmision DATE,
	fechaVencimiento DATE,
	Total DECIMAL(10,2),
	estadoPago VARCHAR(15) CHECK(estadoPago IN('PENDIENTE','PAGADA','VENCIDO')),
	metodoPago VARCHAR(15) CHECK(metodoPago IN('TARJETA','EFECTIVO','DIGITAL')),
	FOREIGN KEY(idUsuario) REFERENCES Cliente(idUsuario)
);

CREATE TABLE paqueteAdicional (
	idPaquete INT PRIMARY KEY NOT NULL,
	Nombre VARCHAR(20),
	Descripcion VARCHAR(50),
	precioUnitario DECIMAL(10,2),
	duracionDias INT
);

INSERT INTO paqueteAdicional (idPaquete, Nombre, Descripcion, precioUnitario, duracionDias) VALUES
(1, '5GB Adicionales', 'Comprar 5GB', 5.00, 30),
(2, '10GB Adicionales', 'Comprar 10GB', 10.00, 30),
(3, '15GB Adicionales', 'Comprar 15GB', 15.00, 30),
(4, '20GB Adicionales', 'Comprar 20GB', 20.00, 30),
(5, '25GB Adicionales', 'Comprar 25GB', 25.00, 30)

CREATE TABLE detalleFactura (
	idDetalle INT PRIMARY KEY NOT NULL,
	idFactura INT,
	idLinea INT,
	idPaquete INT,
	Descripcion VARCHAR(100),
	precioLinea DECIMAL(10,2),
	cantidadPaquete INT,
	precioUnitario DECIMAL(10,2),
	subTotal DECIMAL(10,2),
	FOREIGN KEY (idFactura) REFERENCES Factura(idFactura),
	FOREIGN KEY (idLinea) REFERENCES Linea(idLinea),
	FOREIGN KEY (idPaquete) REFERENCES paqueteAdicional(idPaquete)
);
