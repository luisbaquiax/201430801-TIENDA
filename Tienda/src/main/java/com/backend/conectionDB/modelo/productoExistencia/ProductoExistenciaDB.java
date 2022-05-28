/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo.productoExistencia;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class ProductoExistenciaDB {

    private static final String ALL_PRODUCTO_EXISTENCIA = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto ORDER BY p.codigo ASC";

    private static final String ALL_PRODUCTO_EXISTENCIA_BY_TIENDA = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE codigo_tienda = ?";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_CODIGO = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE p.codigo LIKE ? ORDER BY p.codigo ASC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_CODIGO_DESC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE p.codigo LIKE ? ORDER BY p.codigo DESC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_NOMBRE = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE p.nombre LIKE ? ORDER BY p.codigo ASC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_NOMBRE_ASC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE p.nombre LIKE ? ORDER BY p.nombre ASC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_NOMBRE_DESC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE p.nombre LIKE ? ORDER BY p.nombre DESC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_FABRICANTE_ASC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE p.fabricante LIKE ? ORDER BY p.fabricante ASC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_FABRICANTE_DESC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE p.fabricante LIKE ? ORDER BY p.fabricante DESC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_CANTIDAD_ASC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto ORDER BY e.cantidad ASC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_CANTIDAD_DESC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto ORDER BY e.cantidad DESC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_PRECIO_ASC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto ORDER BY e.precio_unitario ASC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_PRECIO_DESC = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto ORDER BY e.precio_unitario DESC";

    public static final String ALL_PRODUCTO_EXISTENCIA_FILTER_TIENDA = "SELECT *\n"
            + "FROM producto p\n"
            + "LEFT JOIN existencia e\n"
            + "ON p.codigo = e.codigo_producto WHERE e.codigo_tienda LIKE ? ORDER BY p.codigo ASC";

    private Connection conn;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public ProductoExistenciaDB() {
        this.conn = null;
        this.statement = null;
        this.resultSet = null;
    }

    /**
     * sql: ALL_PRODUCTO_EXISTENCIA = SELECT * FROM producto p LEFT JOIN
     * existencia e ON p.codigo = e.codigo_producto
     *
     * @return
     */
    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();
        Producto producto = null;

        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(ALL_PRODUCTO_EXISTENCIA);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producto = getProducto(resultSet);
                productos.add(producto);
            }
        } catch (SQLException e) {
        }
        return productos;
    }

    /**
     *
     * @param filter
     * @param query
     * @return
     */
    public List<Producto> getAllProductosWhitFilter(String filter, String query) {
        List<Producto> productos = new ArrayList<>();
        Producto producto = null;

        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, "%" + filter + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producto = getProducto(resultSet);
                productos.add(producto);
            }
        } catch (SQLException e) {
        }
        return productos;
    }

    /**
     * sql:
     *
     * @param codigoTienda
     * @return
     */
    public List<Producto> getAllProductosByTienda(String codigoTienda) {
        List<Producto> productos = new ArrayList<>();
        Producto producto = null;

        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(ALL_PRODUCTO_EXISTENCIA_BY_TIENDA);
            statement.setString(1, codigoTienda);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producto = getProducto(resultSet);
                productos.add(producto);
            }
        } catch (SQLException e) {
        }
        return productos;
    }

    /**
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Producto getProducto(ResultSet resultSet) throws SQLException {
        return new Producto(
                resultSet.getString("nombre"),
                resultSet.getString("fabricante"),
                resultSet.getString("codigo"),
                resultSet.getInt("cantidad"),
                resultSet.getDouble("precio_unitario"),
                resultSet.getString("codigo_tienda"),
                resultSet.getString("descripcion"),
                resultSet.getString("garantia"),
                resultSet.getBoolean("producto_vendido"),
                resultSet.getInt("id"));
    }

}
