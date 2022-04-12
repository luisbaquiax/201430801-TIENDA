CREATE SCHEMA IF NOT EXISTS TIENDA;

USE TIENDA;

CREATE TABLE IF NOT EXISTS tienda(
    codigo VARCHAR(45) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    direccion VARCHAR(45) NOT NULL,
    telefono VARCHAR(8) NOT NULL,
    telefono2 VARCHAR(8),
    email VARCHAR(45),
	horario VARCHAR(45),
  PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS producto(
	codigo VARCHAR(45) NOT NULL,
	nombre VARCHAR(45) NOT NULL,
	fabricante VARCHAR(45) NOT NULL,
    descripcion VARCHAR(200),
    garantia VARCHAR(45),
    vendido BOOLEAN,
	PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS existencia(
  id INT NOT NULL AUTO_INCREMENT,
  cantidad INT NOT NULL,
  precio_unitario DOUBLE NOT NULL,
  codigo_tienda VARCHAR(45) NOT NULL,
  codigo_producto VARCHAR(45) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(codigo_tienda) REFERENCES tienda(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY(codigo_producto) REFERENCES producto(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS cliente(
	nit VARCHAR(13) NOT NULL,
	nombre VARCHAR(45) NOT NULL,
	telefono VARCHAR(8) NOT NULL,
    dpi VARCHAR(13),
    credito DOUBLE,
    email VARCHAR(45),
    direccion VARCHAR(45),
	PRIMARY KEY(nit)
);

CREATE TABLE IF NOT EXISTS pedido(
    id INT NOT NULL AUTO_INCREMENT,
	fecha DATE NOT NULL,
    total DOUBLE NOT NULL,
    anticipo DOUBLE NOT NULL,
    registrado BOOLEAN NOT NULL,
    tienda_origen VARCHAR(45) NOT NULL,
    tienda_destino VARCHAR(45) NOT NULL,
    nit_cliente VARCHAR(13) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(tienda_origen) REFERENCES tienda(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(tienda_destino) REFERENCES tienda(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(nit_cliente) REFERENCES cliente(nit) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS detallePedido(
    id INT NOT NULL AUTO_INCREMENT,
    cantidad_articulos INT NOT NULL,
    sub_total DOUBLE NOT NULL,
    codigo_producto VARCHAR(45) NOT NULL,
    id_pedido INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(codigo_producto) REFERENCES producto(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_pedido) REFERENCES pedido(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS empleado(
    codigo VARCHAR(45) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    telefono VARCHAR(8) NOT NULL,
    dpi VARCHAR(13) NOT NULL,
    nit VARCHAR(13),
    email VARCHAR(45) NOT NULL,
    direccion VARCHAR(45) NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS envio(
  id INT NOT NULL AUTO_INCREMENT,
  codigo_tienda_origen VARCHAR(45) NOT NULL,
  codigo_tienda_destino VARCHAR(45) NOT NULL,
  tiempo_traslado INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(codigo_tienda_origen) REFERENCES tienda(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY(codigo_tienda_destino) REFERENCES tienda(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS compra(
    id INT NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    nit_cliente VARCHAR(13) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(nit_cliente) REFERENCES cliente(nit) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS detalleCompra(
    id INT NOT NULL AUTO_INCREMENT,
    cantidad_articulos INT NOT NULL,
    id_compra INT NOT NULL,
    codigo_producto VARCHAR(45) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_compra) REFERENCES compra(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(codigo_producto) REFERENCES producto(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

USE TIENDA;
INSERT INTO empleado(codigo, nombre, telefono, dpi, nit, email, direccion) 
VALUES('empleado1234', 'Luis Baquiax', '48324640', '87987879','nit-emplead1', 'luis.baquiax@gmail.com','Chuatroj, totonicapan');
