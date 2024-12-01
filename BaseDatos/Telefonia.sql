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

CREATE TABLE Cliente (
	idUsuario VARCHAR(20) NOT NULL,
	fechaRegistro DATE,
	numLineas INT,
	Estado VARCHAR(15) CHECK (Estado IN('ACTIVO','SUSPENDIDO')),
	PRIMARY KEY (idUsuario),
	FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

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
('PRE1', 'Recarga Basico', 'PREPAGO', 5.00, 5, 1, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp, Youtube y Spotify'),
('PRE2', 'Recargar Super', 'PREPAGO', 7.00, 7, 2, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram y WhatsApp, Youtube y Spotify'),
('PRE3', 'Recargar Premiun', 'PREPAGO', 10.00, 10, 3, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp, Youtube y Spotify'),
('PRE4', 'Recargar Total', 'PREPAGO', 15.00, 15, 5, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp, Youtube y Spotify'),
('POS1', 'Plan Basico', 'POSTPAGO', 39.90, 30, 25, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp y Waze'),
('POS2', 'Plan Super', 'POSTPAGO', 49.90, 30, 40, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp y Waze'),
('POS3', 'Plan Premiun', 'POSTPAGO', 59.90, 30, 75, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp y Waze'),
('POS4', 'Plan Total', 'POSTPAGO', 69.90, 30, 100, 'Llamadas y SMS ilimitados', 'Facebook, Mesenger, Instagram, WhatsApp y Waze'),
('EMP1', 'Plan Basico', 'EMPRESARIAL', 39.90, 30, 30, '2GB de Roaming, Llamadas y SMS ilimitados a Perú, Canada y EE.UU.', 'Facebook, Mesenger, Instagram, WhatsApp y Bussines Pack'),
('EMP2', 'Plan Premiun', 'EMPRESARIAL', 59.90, 30, 80, '3GB de Roaming, Llamadas y SMS ilimitados a Perú, Canada y EE.UU.', 'Facebook, Mesenger, Instagram, WhatsApp y Bussines Pack'),
('EMP3', 'Plan Internacional Total', 'EMPRESARIAL', 69.90, 30, 105, '5GB de Roaming, Llamadas y SMS ilimitados a Perú, Canada y EE.UU.', 'Facebook, Mesenger, Instagram, WhatsApp y Bussines Pack')

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

CREATE TRIGGER trg_UpdateNumLineas
ON Linea
AFTER UPDATE
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM Inserted i
        JOIN Deleted d ON i.idLinea = d.idLinea
        WHERE i.Estado = 'CANCELADA' AND d.Estado <> 'CANCELADA'
    )
    BEGIN
        -- Actualizar el número de líneas del cliente
        UPDATE Cliente
        SET numLineas = numLineas - 1
        FROM Cliente c
        JOIN Inserted i ON c.idUsuario = i.idCliente
        WHERE i.Estado = 'CANCELADA';
    END
END;

CREATE OR ALTER TRIGGER trg_incrementarNumLineas
ON Linea
AFTER INSERT
AS
BEGIN
    UPDATE Cliente
    SET numLineas = numLineas + 1
    FROM Cliente c
    INNER JOIN Inserted i ON c.idUsuario = i.idCliente;
END;	

CREATE FUNCTION ObtenerFacturasPorCliente(@idCliente VARCHAR(20))
RETURNS TABLE
AS
RETURN
(
    SELECT 
		F.idFactura,
        L.Telefono,
        L.idPlan,
        F.Total,
        F.fechaEmision,
        F.fechaVencimiento,
        F.estadoPago
		
    FROM 
        Cliente AS C
    INNER JOIN 
        Linea AS L ON C.idUsuario = L.idCliente
    INNER JOIN 
        detalleFactura AS DF ON L.idLinea = DF.idLinea
    INNER JOIN 
        Factura AS F ON F.idFactura = DF.idFactura
    WHERE 
        C.idUsuario = @idCliente
);

CREATE TRIGGER trg_UpdateFacturaVencida
ON Factura
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    UPDATE Factura
    SET estadoPago = 'VENCIDO',
        Total = Total + 10
    WHERE estadoPago = 'PENDIENTE' 
      AND fechaVencimiento < GETDATE();
END;

CREATE FUNCTION ObtenerEstadoPagoPorLinea (
    @idLinea INT,
    @idCliente VARCHAR(20)
)
RETURNS VARCHAR(15)
AS
BEGIN
    DECLARE @estadoPago VARCHAR(15);

    SELECT @estadoPago = F.estadoPago
    FROM Cliente AS C
    INNER JOIN Linea AS L ON C.idUsuario = L.idCliente
    INNER JOIN detalleFactura AS DF ON L.idLinea = DF.idLinea
    INNER JOIN Factura AS F ON F.idFactura = DF.idFactura
    WHERE L.idLinea = @idLinea
    AND C.idUsuario = @idCliente;

    RETURN @estadoPago;
END;