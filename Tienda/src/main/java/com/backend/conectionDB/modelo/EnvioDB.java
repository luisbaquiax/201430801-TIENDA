/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Pedido;
import com.backend.entidad.TiempoDeEnvio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class EnvioDB {

    private static final String TIEMPO_DE_ENVIO = "SELECT * FROM envio WHERE \n"
            + "((codigo_tienda_origen = ? AND codigo_tienda_destino = ?) "
            + "OR (codigo_tienda_origen = ? AND codigo_tienda_destino = ?))";

    public static final String ENVIOS_TIENDA_ACTUAL = "SELECT * FROM envio WHERE codigo_tienda_origen = ? OR codigo_tienda_destino = ?";
    public static final String ENVIOS_TIENDA_ACTUAL_ORDER_BY_TIEMPO_ENVIO_ASC
            = "SELECT * FROM envio WHERE codigo_tienda_origen = ? OR codigo_tienda_destino = ? ORDER BY tiempo_traslado ASC";

    private static final String UPDATE_ENVIO = "UPDATE envio SET tiempo_traslado = ? WHERE id = ?";

    private Connection conn = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    public EnvioDB() {
        this.conn = null;
        this.statement = null;
        this.resultSet = null;
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

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     *
     * @param connection
     * @param envio
     * @param valor
     */
    public void update(Connection connection, TiempoDeEnvio envio, int valor) {

        try ( PreparedStatement preSt = connection.prepareStatement(UPDATE_ENVIO)) {
            System.out.println(envio.toString());
            preSt.setInt(1, valor);
            preSt.setInt(2, envio.getId());

            preSt.executeUpdate();
            System.out.println("actualizado");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * query: IEMPO_DE_ENVIO = SELECT * FROM envio WHERE ((codigo_tienda_origen
     * = ? AND codigo_tienda_destino = ?) OR (codigo_tienda_origen = ? AND
     * codigo_tienda_destino = ?))
     *
     * @param pedido
     * @return
     */
    public TiempoDeEnvio getEnvio(Pedido pedido) {

        TiempoDeEnvio envio = null;
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(TIEMPO_DE_ENVIO);
            statement.setString(1, pedido.getCodigoTiendaORIGEN());
            statement.setString(2, pedido.getCodigoTiendaDESTINO());
            statement.setString(4, pedido.getCodigoTiendaORIGEN());
            statement.setString(3, pedido.getCodigoTiendaDESTINO());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                envio = getEnvio(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return envio;
    }

    /**
     *
     * @param codigoTienda
     * @param query
     * @return
     */
    public List<TiempoDeEnvio> getEnviosEntreTiendas(String codigoTienda, String query) {
        List<TiempoDeEnvio> tiempoDeEnvios = new ArrayList<>();
        TiempoDeEnvio envio = null;
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, codigoTienda);
            statement.setString(2, codigoTienda);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                envio = getEnvio(resultSet);
                tiempoDeEnvios.add(envio);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tiempoDeEnvios;
    }

    private TiempoDeEnvio getEnvio(ResultSet resultSet) throws SQLException {
        return new TiempoDeEnvio(
                resultSet.getInt("id"),
                resultSet.getString("codigo_tienda_origen"),
                resultSet.getString("codigo_tienda_destino"),
                resultSet.getInt("tiempo_traslado"));
    }
}
