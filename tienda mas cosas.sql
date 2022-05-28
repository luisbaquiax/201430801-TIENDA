use TIENDA;
select * from tienda;
select * from envio;
select * from pedido;
select * from compra;
select * from detalleCompra;
select * from detallePedido;
select * from cliente;
select * from producto;
UPDATE pedido set fecha = '2022-02-15' where id >0;

INSERT INTO compra (id, fecha, nit_cliente, codigo_tienda) VALUES(1, '2022-02-15', 'E-5924','ABC-1');
INSERT INTO compra (id, fecha, nit_cliente, codigo_tienda) VALUES(2, '2022-02-15', 'G-9924','ABC-1');
INSERT INTO compra (id, fecha, nit_cliente, codigo_tienda) VALUES(3, '2022-02-15', 'E-5924','ABC-2');
INSERT INTO compra (id, fecha, nit_cliente, codigo_tienda) VALUES(4, '2022-02-15', 'E-5924','ABC-3');
INSERT INTO detalleCompra(id, cantidad_articulos, id_compra, codigo_producto) VALUES(1, 25, 1, 'CKL-4392');
INSERT INTO detalleCompra(id, cantidad_articulos, id_compra, codigo_producto) VALUES(2, 25, 1, 'CKL-4392');
INSERT INTO detalleCompra(id, cantidad_articulos, id_compra, codigo_producto) VALUES(3, 25, 2, 'HSN-3802');
INSERT INTO detalleCompra(id, cantidad_articulos, id_compra, codigo_producto) VALUES(4, 25, 2, 'HSN-3802');
INSERT INTO detalleCompra(id, cantidad_articulos, id_compra, codigo_producto) VALUES(5, 25, 3, 'UVU-8844');
INSERT INTO detalleCompra(id, cantidad_articulos, id_compra, codigo_producto) VALUES(6, 25, 4, 'UVU-8844');

INSERT INTO pedido(id, fecha, total, anticipo, registrado, tienda_origen, tienda_destino, nit_cliente) 
VALUE(100, CURDATE(),500,300,0,'ABC-1','ABC-2','Q-8877');

INSERT INTO detallePedido(cantidad_articulos, sub_total, codigo_producto, id_pedido) 
VALUE(25,300,'JPJ-196',28);
INSERT INTO detallePedido(cantidad_articulos, sub_total, codigo_producto, id_pedido) 
VALUE(25,300,'JPJ-196',28);

INSERT INTO detallePedido(cantidad_articulos, sub_total, codigo_producto, id_pedido) 
VALUE(25,300,'JPJ-196',29);
INSERT INTO detallePedido(cantidad_articulos, sub_total, codigo_producto, id_pedido) 
VALUE(25,300,'JPJ-196',29);
INSERT INTO detallePedido(cantidad_articulos, sub_total, codigo_producto, id_pedido) 
VALUE(25,300,'JPJ-196',29);

INSERT INTO detallePedido(cantidad_articulos, sub_total, codigo_producto, id_pedido) 
VALUE(25,300,'JPJ-196',30);INSERT INTO detallePedido(cantidad_articulos, sub_total, codigo_producto, id_pedido) 
VALUE(25,300,'JPJ-196',30);INSERT INTO detallePedido(cantidad_articulos, sub_total, codigo_producto, id_pedido) 
VALUE(25,300,'JPJ-196',30);
