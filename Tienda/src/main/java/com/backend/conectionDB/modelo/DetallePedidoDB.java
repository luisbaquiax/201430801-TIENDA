/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.DetallePedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class DetallePedidoDB {

    private static final String DETALLE_PEDIDO = "SELECT * FROM detallePedido WHERE id_pedido = ?";

    private Connection conn;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public DetallePedidoDB() {
        this.conn = null;
        this.statement = null;
        this.resultSet = null;
    }

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

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

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

    /**
     * Retorna una lista del detalle del pedido
     *
     * @param idPedido
     * @return
     */
    public List<DetallePedido> getDetallePedido(int idPedido) {
        List<DetallePedido> detalle = new ArrayList<>();
        DetallePedido de = null;
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(DETALLE_PEDIDO);
            statement.setInt(1, idPedido);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                de = new DetallePedido(
                        resultSet.getInt("id"),
                        resultSet.getInt("cantidad_articulos"),
                        resultSet.getDouble("sub_total"),
                        resultSet.getString("codigo_producto"),
                        resultSet.getInt("id_pedido"));
                detalle.add(de);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return detalle;
    }
}
