# Respuestas Test

## 1.1) Describe el funcionamiento general de la sentencia JOIN.
> Permite enlazar los datos de dos o más tablas mediante sus llaves primarias para realizar una
consulta.

## 1.2) ¿Cuáles son los tipos de JOIN y cuál es el funcionamiento de los mismos?

> **inner join:** muestra un resultado si hay coincidencias.

> **left join**: muestra principalmente los datos de la tabla izquierda y sus coincidencias con las
tablas relacionadas.

> **right join:** principalmente la tabla derecha y coincidencias con las otras.

> **full join:** muestra los datos de todas las tablas relacionadas y sus coincidencias con o sin
resultados.

## 1.3) ¿Cuál es el funcionamiento general de los TRIGGER y qué propósito tienen?
> Ejecuta una sentencia si se cumple la condición definida.

## 1.4) ¿Qué es y para qué sirve un STORED PROCEDURE?
> Es un procedimiento creado para realizar un proceso específico, puede ser ejecutado en
cualquier momento y es reutilizable.

# Hacer las consultas necesarias para:

## 1.5) Traer todos los productos que tengan una venta.
```
SELECT productos.nombre AS productos
FROM productos
INNER JOIN ventas ON ventas.idProducto = productos.idProductos
GROUP BY productos;
```

## 1.6) Traer todos los productos que tengan ventas y la cantidad total de productos vendidos.
````
SELECT productos.nombre AS productos,
       sum(ventas.cantidad) AS total
FROM productos
RIGHT JOIN ventas ON ventas.idProducto = productos.idProductos
GROUP BY productos;
````

## 1.7) Traer todos los productos (independientemente de si tienen ventas o no) y la suma total ($) vendida por producto.
````
SELECT p.nombre AS productos,
       coalesce(sum(p.precio * v.cantidad), 0) AS venta_total
FROM productos p
LEFT JOIN ventas v ON v.idProducto = p.idProductos
GROUP BY productos;
````
