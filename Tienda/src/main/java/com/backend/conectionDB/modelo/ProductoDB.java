/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class ProductoDB {

    private static final String PRODUCTO = "SELECT * FROM producto WHERE codigo = ?";

    public ProductoDB() {
    }

    /**
     * Métod para crear un producto en la base de datos
     *
     * @param connection
     * @param codigo
     * @param nombre
     * @param fabricante
     * @param descripcion
     * @param garantia
     */
    public void crearProducto(Connection connection,
            String codigo,
            String nombre,
            String fabricante,
            String descripcion,
            String garantia) {

        String query = "INSERT INTO producto (codigo, nombre, fabricante, descripcion, garantia)VALUES (?,?,?,?,?)";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, fabricante);
            preSt.setString(4, descripcion);
            preSt.setString(5, garantia);

            preSt.executeUpdate();

            System.out.println("producto agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

 

    /**
     * Crea la existencia de un nuevo producto
     *
     * @param connection
     * @param cantidad
     * @param precio
     * @param tiendaDondeExiste
     * @param codgioProducto
     */
    public void crearExistentes(Connection connection,
            String cantidad,
            String precio,
            String tiendaDondeExiste,
            String codgioProducto) {

        String query = "INSERT INTO existencia (cantidad, precio_unitario, codigo_tienda, codigo_producto)VALUES (?,?,?,?)";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, Integer.parseInt(cantidad));
            preSt.setDouble(2, Double.parseDouble(precio));
            preSt.setString(3, tiendaDondeExiste);
            preSt.setString(4, codgioProducto);

            preSt.executeUpdate();

            System.out.println("existencia agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Modifica el precio de un producto
     *
     * @param connection
     * @param precio
     * @param codigoProducto
     * @param codigoTienda
     */
    public void modificarPrecioProducto(Connection connection,
            String precio,
            String codigoProducto,
            String codigoTienda) {

        String query = "UPDATE existencia SET precio_unitario = ? WHERE codigo_producto = ? AND codigo_tienda = ?";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setDouble(1, Double.parseDouble(precio));
            preSt.setString(2, codigoProducto);
            preSt.setString(3, codigoTienda);

            preSt.executeUpdate();

            System.out.println("precio actualizado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Modificamos la cantidad de artículos de la actual tienda
     *
     * @param connection
     * @param cantidad
     * @param codgioProducto
     * @param codigoTienda
     */
    public void modificarCantidadExistenciaProducto(Connection connection,
            String cantidad,
            String codgioProducto,
            String codigoTienda) {

        String query = "UPDATE existencia SET cantidad = ? WHERE codigo_producto = ? AND codigo_tienda = ?";
        String codigo_producto = codgioProducto;

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setDouble(1, Double.parseDouble(cantidad));
            preSt.setString(2, codigo_producto);
            preSt.setString(3, codigoTienda);

            preSt.executeUpdate();

            System.out.println("cantidad actualizado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     *
     * @param codigo
     * @return
     */
    public Producto getProducto(String codigo) throws NullPointerException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Producto producto = null;
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PRODUCTO);
            statement.setString(1, codigo);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                producto = new Producto(
                        resultSet.getString("nombre"),
                        resultSet.getString("fabricante"),
                        resultSet.getString("codigo"),
                        resultSet.getString("descripcion"),
                        resultSet.getString("garantia"),
                        resultSet.getBoolean("vendido"));
            }
        } catch (SQLException e) {
        }
        return producto;
    }
}
