use TIENDA;
select * from envio;
select * from producto;
select * from existencia;

SELECT *
FROM producto p
LEFT JOIN existencia e
ON p.codigo = e.codigo_producto WHERE e.codigo_tienda LIKE '%c%' ORDER BY p.codigo ASC;