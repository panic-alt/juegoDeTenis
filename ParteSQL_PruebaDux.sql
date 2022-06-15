--Todos los productos del rubro "librería", creados hoy.
DECLARE @FechaDeHoy DATETIME = CAST( GETDATE() AS Date)
SELECT
	prd.codigo
	prd.nombre
	prd.fecha_creacion
	rbr.id_rubro
	rbr.rubro
FROM
	producto prd
JOIN rubro rbr
ON prd.id_rubro = rbr.id_rubro
WHERE fecha_creacion = @FechaDeHoy
AND rbr.rubro LIKE 'libreria';

--Monto total vendido por cliente (mostrar nombre del cliente y monto).
SELECT 
	cliente.razon_social,
	SUM(precio) as monto_vendido
FROM venta
JOIN cliente
ON venta.id_cliente = cliente.id_cliente
GROUP BY cliente.razon_social;

--Cantidad de ventas por producto.

SELECT 
	producto.nombre,
	COUNT(*) codigo_producto 
FROM venta
JOIN producto
ON venta.codigo_producto = producto.codigo
GROUP BY producto.nombre;

--Cantidad de productos comprados por cliente en el mes actual.

SELECT 
	cliente.razon_social,
	SUM(venta.cantidad) as ProductosComprados
FROM venta
JOIN cliente
ON venta.id_cliente = cliente.id_cliente
GROUP BY cliente.razon_social;

--Ventas que tienen al menos un producto del rubro "bazar".

SELECT 
	venta.id_venta,
	venta.nombre, 
	producto.codigo,
	rubro.rubro
FROM venta
JOIN producto
ON venta.codigo_producto = producto.codigo
JOIN rubro
ON producto.id_rubro = rubro.id_rubro
WHERE rubro.rubro = "bazar" 


-- Rubros que no tienen ventas en los últimos 2 meses.

DECLARE @FechaDeHoy DATETIME = CAST( GETDATE() AS Date);
DECLARE @FechaHace2Meses DATETIME = DATEADD(MONTH, -2, @FechaDeHoy);
SELECT 
	venta.id_venta,
	rubro.rubro,
	venta.fecha
FROM venta
JOIN producto
ON venta.codigo_producto = producto.codigo
JOIN rubro
ON producto.id_rubro = rubro.id_rubro
WHERE venta.fecha =< @FechaHace2Meses










