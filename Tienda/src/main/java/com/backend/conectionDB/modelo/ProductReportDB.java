/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class ProductReportDB {

    private static final String PRODUCTO_MAS_VENDIDO_FECHA = "SELECT d.codigo_producto, p.nombre, p.fabricante, SUM(d.cantidad_articulos) AS total\n"
            + "FROM compra c\n"
            + "INNER JOIN detalleCompra d\n"
            + "ON c.id = d.id_compra \n"
            + "INNER JOIN producto p\n"
            + "ON d.codigo_producto = p.codigo \n"
            + "WHERE c.fecha BETWEEN ? AND ? GROUP BY d.codigo_producto limit 10";

    private static final String PRODUCTO_MAS_VENDIDO_POR_TIENDA_FECHA = "SELECT d.codigo_producto, p.nombre, p.fabricante, SUM(d.cantidad_articulos) AS total\n"
            + "FROM compra c\n"
            + "INNER JOIN detalleCompra d\n"
            + "ON c.id = d.id_compra \n"
            + "INNER JOIN producto p\n"
            + "ON d.codigo_producto = p.codigo \n"
            + "WHERE c.codigo_tienda = ? AND c.fecha BETWEEN ? AND ? GROUP BY d.codigo_producto";

    private static final String CODIGOS_PRODUCTO_NO_VENDIDO = "SELECT codigo_producto FROM existencia WHERE codigo_tienda = ? AND producto_vendido = 0";

    private Connection conn;
    private ResultSet resultSet;
    private PreparedStatement statement;

    public ProductReportDB() {
        this.conn = null;
        this.statement = null;
        this.resultSet = null;
    }

    /**
     * query: PRODUCTO_MAS_VENDIDO_FECHA = SELECT d.codigo_producto, p.nombre,
     * p.fabricante, SUM(d.cantidad_articulos) AS total FROM compra c INNER JOIN
     * detalleCompra d ON c.id = d.id_compra INNER JOIN producto p ON
     * d.codigo_producto = p.codigo WHERE c.fecha BETWEEN ? AND ? GROUP BY
     * d.codigo_producto limit 10
     *
     * @param fecha1
     * @param fecha2
     * @return prductos [producto: codigo, name, fabricante, total]
     */
    public List<Producto> getProductosMasVendido(String fecha1, String fecha2) {
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PRODUCTO_MAS_VENDIDO_FECHA);
            statement.setString(1, fecha1);
            statement.setString(2, fecha2);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producto = getProduct(resultSet);
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productos;
    }

    /**
     * query: PRODUCTO_MAS_VENDIDO_POR_TIENDA_FECHA = SELECT d.codigo_producto,
     * p.nombre, p.fabricante, SUM(d.cantidad_articulos) AS total FROM compra c
     * INNER JOIN detalleCompra d ON c.id = d.id_compra INNER JOIN producto p ON
     * d.codigo_producto = p.codigo WHERE c.codigo_tienda = ? AND c.fecha
     * BETWEEN ? AND ? GROUP BY d.codigo_producto
     *
     * @param codigoTienda
     * @param fecha1
     * @param fecha2
     * @return prductos [producto: codigo, name, fabricante, total]
     */
    public List<Producto> getProductosMasVendidoPorTienda(String codigoTienda, String fecha1, String fecha2) {
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PRODUCTO_MAS_VENDIDO_POR_TIENDA_FECHA);
            statement.setString(1, codigoTienda);
            statement.setString(2, fecha1);
            statement.setString(3, fecha2);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producto = getProduct(resultSet);
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productos;
    }

    private Producto getProduct(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setCodigo(resultSet.getString("codigo_producto"));
        producto.setFabricante(resultSet.getString("fabricante"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setCantidad(resultSet.getInt("total"));
        return producto;
    }
    

    private List<String> getCodigoProduct(String codigoTienda) {
        List<String> codigos = new ArrayList<>();

        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(CODIGOS_PRODUCTO_NO_VENDIDO);
            statement.setString(1, codigoTienda);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                codigos.add(resultSet.getString("codigo_producto"));
            }

        } catch (Exception e) {
        }
        return codigos;
    }

}
