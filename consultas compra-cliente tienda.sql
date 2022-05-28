select * from compra;
select * from detalleCompra;

SELECT c.id, c.fecha, c.nit_cliente, d.id, d.cantidad_articulos, d.id_compra, d.codigo_producto
FROM compra c
INNER JOIN detalleCompra d
ON c.id = d.id_compra;
/*producto mas vendido*/
SELECT codigo_producto, SUM(cantidad_articulos) AS total
FROM detalleCompra GROUP BY codigo_producto LIMIT 10;

/*producto mas vendido peor fecha*/
SELECT d.codigo_producto, SUM(d.cantidad_articulos) AS total
FROM detalleCompra d
INNER JOIN compra c
ON d.id_compra = c.id
WHERE c.fecha BETWEEN '2022-02-14' AND '2022-02-15'
GROUP BY d.codigo_producto LIMIT 10;


SELECT d.codigo_producto, p.nombre, p.fabricante, SUM(d.cantidad_articulos) AS total
FROM compra c
INNER JOIN detalleCompra d
ON c.id = d.id_compra 
INNER JOIN producto p
ON d.codigo_producto = p.codigo 
WHERE c.fecha BETWEEN '2022-02-15' AND '2022-02-15' GROUP BY d.codigo_producto limit 10;

/*producot más vendido por tienda en un intervalo de fecha*/
SELECT d.codigo_producto, p.nombre, p.fabricante, SUM(d.cantidad_articulos) AS total
FROM compra c
INNER JOIN detalleCompra d
ON c.id = d.id_compra 
INNER JOIN producto p
ON d.codigo_producto = p.codigo 
WHERE c.codigo_tienda = 'ABC-1' AND c.fecha BETWEEN '2022-02-15' AND '2022-02-15' GROUP BY d.codigo_producto limit 10;

/*producot más vendido por tienda*/
SELECT d.codigo_producto, p.nombre, p.fabricante, SUM(d.cantidad_articulos) AS total
FROM compra c
INNER JOIN detalleCompra d
ON c.id = d.id_compra 
INNER JOIN producto p
ON d.codigo_producto = p.codigo 
WHERE c.codigo_tienda = 'ABC-1' GROUP BY d.codigo_producto limit 10;
