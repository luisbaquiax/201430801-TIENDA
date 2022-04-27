/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class PedidoDB {

    private static final String PEDIDO_POR_CLIENTE_FECHA = "SELECT * FROM pedido WHERE nit_cliente = ? AND fecha BETWEEN ? AND ?";
    private static final String PEDIDO_POR_CLIENTE_SIN_FECHA = "SELECT * FROM pedido WHERE nit_cliente = ?";
    private static final String PEDIDO_QUE_LLEGARAN_A_LA_TIENDA = "SELECT * FROM pedido WHERE tienda_destino = ? AND registrado = 0 AND fecha BETWEEN ? AND ?";
    private static final String PEDIDO_QUE_LLEGARAN_A_LA_TIENDA_SIN_FECHA
            = "SELECT * FROM pedido WHERE tienda_destino = ? AND registrado = 0";
    private static final String PEDIDO_QUE_SALIERON_DE_LA_TIENDA = "SELECT * FROM pedido WHERE tienda_origen = ? AND registrado = 0 AND fecha BETWEEN ? AND ?";
    private static final String PEDIDO_QUE_SALIERON_DE_LA_TIENDA_SIN_FECHA
            = "SELECT * FROM pedido WHERE tienda_origen = ? AND registrado = 0";

    private static final String TIEMPO_DE_PEDIDO = "SELECT TIMESTAMPDIFF(DAY, now(), (select fecha from pedido where id = ? and registrado = 0)) AS dias";

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
            preSt.setBoolean(5, pedido.isRegistrado());
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
            preSt.setBoolean(4, pedido.isRegistrado());
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

    /**
     * Pedidos que llegarán a la tienda con fecha
     *
     * @param codigoTienda
     * @param fecha1
     * @param fecah2
     * @return
     */
    public List<Pedido> getPedidosPorTienda(String codigoTienda, String fecha1, String fecah2) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PEDIDO_QUE_LLEGARAN_A_LA_TIENDA);
            statement.setString(1, codigoTienda);
            statement.setString(2, fecha1);
            statement.setString(3, fecah2);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pedido = getPedido(resultSet);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pedidos;
    }

    /**
     * Pedidos que llegarán a la tienda sin fecha
     * <br>query: PEDIDO_QUE_LLEGARAN_A_LA_TIENDA_SIN_FECHA = "SELECT * FROM
     * pedido WHERE tienda_destino = ? AND registrado = 0"
     *
     * @param codigoTienda
     * @return
     */
    public List<Pedido> getPedidosPorTienda(String codigoTienda) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PEDIDO_QUE_LLEGARAN_A_LA_TIENDA_SIN_FECHA);
            statement.setString(1, codigoTienda);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pedido = getPedido(resultSet);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pedidos;
    }

   
    /**
     *
     * @param codigoTienda
     * @return
     */
    public List<Pedido> getPedidosPorTiendaSinRegistrar(String codigoTienda) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PEDIDO_QUE_SALIERON_DE_LA_TIENDA_SIN_FECHA);
            statement.setString(1, codigoTienda);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pedido = getPedido(resultSet);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pedidos;
    }

    /**
     *
     * @param codigoTienda
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<Pedido> getPedidosSalenDeTienda(String codigoTienda, String fecha1, String fecha2) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PEDIDO_QUE_SALIERON_DE_LA_TIENDA);
            statement.setString(1, codigoTienda);
            statement.setString(2, fecha1);
            statement.setString(3, fecha2);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pedido = getPedido(resultSet);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pedidos;
    }

    /**
     *
     * @param codigoTienda
     * @return
     */
    public List<Pedido> getPedidosSalenDeTienda(String codigoTienda) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PEDIDO_QUE_SALIERON_DE_LA_TIENDA_SIN_FECHA);
            statement.setString(1, codigoTienda);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pedido = getPedido(resultSet);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pedidos;
    }
     public List<Pedido> getPedidosEnCursoPorCliente(String nitCliente) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PEDIDO_POR_CLIENTE_SIN_FECHA);
            statement.setString(1, nitCliente);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pedido = getPedido(resultSet);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pedidos;
    }
    
    public List<Pedido> getPedidosEnCursoPorCliente(String nitCliente, String fecha1, String fecha2) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(PEDIDO_POR_CLIENTE_FECHA);
            statement.setString(1, nitCliente);
            statement.setString(2, fecha1);
            statement.setString(3, fecha2);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pedido = getPedido(resultSet);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pedidos;
    }

    /** <br>
     * query: SELECT TIMESTAMPDIFF(DAY, now(), (select fecha from pedido where
     * id = ? and registrado = 0)) AS dias;
     *
     * @param p
     * @return
     */
    public int getTiempoPedido(Pedido p) {
        int t = -1;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(TIEMPO_DE_PEDIDO);
            statement.setInt(1, p.getCodigoPedido());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                t = resultSet.getInt("dias");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

    /**
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Pedido getPedido(ResultSet resultSet) throws SQLException {
        return new Pedido(
                resultSet.getInt("id"),
                resultSet.getString("tienda_origen"),
                resultSet.getString("tienda_destino"),
                resultSet.getString("fecha"),
                resultSet.getString("nit_cliente"),
                resultSet.getDouble("total"),
                resultSet.getDouble("anticipo"),
                resultSet.getBoolean("registrado"));
    }
}
