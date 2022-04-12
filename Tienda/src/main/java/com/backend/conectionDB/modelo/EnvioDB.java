/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luis
 */
public class EnvioDB {

    public EnvioDB() {
    }

    /**
     * Método para agregar una tiempo de envío/traslado
     *
     * @param connection
     * @param codigoTiendaOrigen
     * @param codigoTiendaDestino
     * @param tiempo
     */
    public void crearTiempoDeEnvio(Connection connection, String codigoTiendaOrigen,
            String codigoTiendaDestino, String tiempo) {

        String query = "INSERT INTO envio (codigo_tienda_origen, codigo_tienda_destino, tiempo_traslado)VALUES (?,?,?)";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigoTiendaOrigen);
            preSt.setString(2, codigoTiendaDestino);
            preSt.setInt(3, Integer.parseInt(tiempo));

            preSt.executeUpdate();

            System.out.println("tiempo agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
