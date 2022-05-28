/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Compra;
import com.backend.entidad.DetalleCompra;
import com.backend.entidad.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class DetalleCompraDB {

    private static final String DETALLE_COMPRA = "SELECT * FROM detalleCompra WHERE id_compra = ?";
    private static final String CREATE_DETALLE_COMPRA = "INSERT INTO detalleCompra(cantidad_articulos, id_compra, codigo_producto) VALUES(?,?,?)";

    private Connection conn;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private ProductoDB productoDB;

    public DetalleCompraDB() {
        this.productoDB = new ProductoDB();
    }

    /**
     * query: CREATE_DETALLE_COMPRA = INSERT INTO
     * detalleCompra(cantidad_articulos, id_compra, codigo_producto)
     * VALUES(?,?,?)
     *
     * @param detalleCompra
     */
    public void insert(DetalleCompra detalleCompra) {
        for (Producto producto : detalleCompra.getProductos()) {
            try {
                conn = ConeccionDB.getConnection();
                statement = conn.prepareStatement(CREATE_DETALLE_COMPRA);
                statement.setInt(1, producto.getCantidad());
                statement.setInt(2, detalleCompra.getIdCompra());
                statement.setString(3, producto.getCodigo());

                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DetalleCompraDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DetalleCompra getCompraByIDCompra(int idCompra) {
        Compra compra = null;
        DetalleCompra detalleCompra = null;
        ArrayList<Producto> productos = new ArrayList<>();
        Producto producto = null;
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(DETALLE_COMPRA);
            statement.setInt(1, idCompra);
            resultSet = statement.executeQuery();
            detalleCompra = new DetalleCompra();
            while (resultSet.next()) {
                detalleCompra.setIdCompra(resultSet.getInt("id_compra"));
                producto = productoDB.getProducto(resultSet.getString("codigo_producto"));
                producto.setCantidad(resultSet.getInt("cantidad_articulos"));
                productos.add(producto);
            }
            detalleCompra.setProductos(productos);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return detalleCompra;
    }

}
