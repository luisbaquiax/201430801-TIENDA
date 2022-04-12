/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.conectionDB.modelo;

import com.backend.entidad.DetallePedido;
import java.sql.*;

/**
 *
 * @author luis
 */
public class DetallePedidoDB {

    /**
     * Método parra crear un pedido y agregar a la base de datos
     *
     * @param connection
     * @param detalle
     */
    public void crearPedido(Connection connection, DetallePedido detalle) {
        String query = "INSERT INTO detallePedido "
                + "(cantidad_articulos, sub_total, codigo_producto, id_pedido) "
                + "VALUES (?,?,?,?)";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, detalle.getCantidadArticulos());
            preSt.setDouble(2, detalle.getSuboTotal());
            preSt.setString(3, detalle.getCodigoProduco());
            preSt.setInt(4, detalle.getIdPedido());

            preSt.executeUpdate();

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
