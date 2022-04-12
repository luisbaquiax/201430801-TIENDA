/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.entidad.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luis
 */
public class PedidoDB {

    private static final String PEDIDO_POR_CLIENTE_FECHA = "SELECT * FROM pedido WHERE nit_cliente = ? AND fecha BETWEEN ? AND ?";

    public PedidoDB() {
    }

    /**
     * Método parra crear un pedido y agregar a la base de datos
     *
     * @param connection
     * @param pedido
     */
    public void crearPedidoConID(Connection connection, Pedido pedido) {
        String query = "INSERT INTO pedido "
                + "(id, fecha, total, anticipo, registrado, tienda_origen, tienda_destino, nit_cliente) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, pedido.getCodigoPedido());
            preSt.setString(2, pedido.getFechaPedido().mostrarFECHAS());
            preSt.setDouble(3, pedido.getTotalPagar());
            preSt.setDouble(4, pedido.getAnticipo());
            preSt.setBoolean(5, false);
            preSt.setString(6, pedido.getCodigoTiendaORIGEN());
            preSt.setString(7, pedido.getCodigoTiendaDESTINO());
            preSt.setString(8, pedido.getNitCliente());

            preSt.executeUpdate();

            System.out.println("pedido agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Método parra crear un pedido y agregar a la base de datos
     *
     * @param connection
     * @param pedido
     */
    public void crearPedido(Connection connection, Pedido pedido) {
        String query = "INSERT INTO pedido "
                + "(fecha, total, anticipo, registrado, tienda_origen, tienda_destino, nit_cliente) "
                + "VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, pedido.getFechaPedido().mostrarFECHAS());
            preSt.setDouble(2, pedido.getTotalPagar());
            preSt.setDouble(3, pedido.getAnticipo());
            preSt.setBoolean(4, false);
            preSt.setString(5, pedido.getCodigoTiendaORIGEN());
            preSt.setString(6, pedido.getCodigoTiendaDESTINO());
            preSt.setString(7, pedido.getNitCliente());

            preSt.executeUpdate();

            System.out.println("pedido agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
