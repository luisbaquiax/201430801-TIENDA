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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class PedidoDB {

    private static final String PEDIDO_POR_CLIENTE_FECHA = "SELECT * FROM pedido WHERE nit_cliente = ? AND fecha BETWEEN ? AND ?";
    private static final String PEDIDO_POR_CLIENTE_SIN_FECHA = "SELECT * FROM pedido WHERE nit_cliente = ?";
    private static final String PEDIDO_QUE_LLEGARAN_A_LA_TIENDA = "SELECT * FROM pedido WHERE tienda_destino = ? AND registrado = 0 AND fecha BETWEEN ? AND ?";
    public static final String PEDIDO_QUE_LLEGARAN_A_LA_TIENDA_SIN_FECHA
            = "SELECT * FROM pedido WHERE tienda_destino = ? AND registrado = 0";
    public static final String PEDIDOS_ATRASADOS = "SELECT * FROM pedido WHERE tienda_destino = ? AND atrasado = 1";
    private static final String PEDIDO_QUE_SALIERON_DE_LA_TIENDA = "SELECT * FROM pedido WHERE tienda_origen = ? AND registrado = 0 AND fecha BETWEEN ? AND ?";
    private static final String PEDIDO_QUE_SALIERON_DE_LA_TIENDA_SIN_FECHA
            = "SELECT * FROM pedido WHERE tienda_origen = ? AND registrado = 0";

    private static final String TIEMPO_DE_PEDIDO = "SELECT TIMESTAMPDIFF(DAY, (select fecha from pedido where id = ? and registrado = 0), now()) AS dias";
    private static final String ULTIMO_PEDIDO = "SELECT MAX(id) AS ultimo FROM pedido";
    private static final String UPDATE = "UPDATE pedido SET fecha = ?, total = ?, anticipo = ?, registrado = ?, atrasado = ?, entregado = ?, tienda_origen = ?, tienda_destino = ?, nit_cliente = ? WHERE id = ?";

    private Connection conn;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public PedidoDB() {
    }

    /**
     * get the latest ID of latest pedido
     *
     * @return
     */
    public int getUltimo() {
        int ultimo = 0;
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(ULTIMO_PEDIDO);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ultimo = resultSet.getInt("ultimo");
            }
        } catch (SQLException e) {
        }
        return ultimo;
    }

    /**
     * Método parra crear un pedido y agregar a la base de datos
     *
     * @param connection
     * @param pedido
     */
    public void crearPedidoConID(Connection connection, Pedido pedido) {
        String query = "INSERT INTO pedido "
                + "(id, fecha, total, anticipo, registrado, atrasado, entregado, tienda_origen, tienda_destino, nit_cliente) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, pedido.getCodigoPedido());
            preSt.setString(2, pedido.getFechaPedido().mostrarFECHAS());
            preSt.setDouble(3, pedido.getTotalPagar());
            preSt.setDouble(4, pedido.getAnticipo());
            preSt.setBoolean(5, pedido.isRegistrado());
            preSt.setBoolean(6, pedido.isAtrasado());
            preSt.setBoolean(7, pedido.isEntregado());
            preSt.setString(8, pedido.getCodigoTiendaORIGEN());
            preSt.setString(9, pedido.getCodigoTiendaDESTINO());
            preSt.setString(10, pedido.getNitCliente());

            preSt.executeUpdate();

            System.out.println("pedido agregado");

            preSt.close();
        } catch (SQLException e) {
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * Ingresa un pedido al sistema a la base de datos
     *
     * @param connection
     * @param pedido
     */
    public void insert(Connection connection, Pedido pedido) {
        String query = "INSERT INTO pedido "
                + "(fecha, total, anticipo, registrado, atrasado, entregado, tienda_origen, tienda_destino, nit_cliente) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, pedido.getFecha());
            preSt.setDouble(2, pedido.getTotalPagar());
            preSt.setDouble(3, pedido.getAnticipo());
            preSt.setBoolean(4, pedido.isRegistrado());
            preSt.setBoolean(5, pedido.isAtrasado());
            preSt.setBoolean(6, pedido.isEntregado());
            preSt.setString(7, pedido.getCodigoTiendaORIGEN());
            preSt.setString(8, pedido.getCodigoTiendaDESTINO());
            preSt.setString(9, pedido.getNitCliente());

            preSt.executeUpdate();

            System.out.println("pedido agregado");

            preSt.close();
        } catch (SQLException e) {
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     *
     * @param pedido
     * @return
     */
    public boolean actualizar(Pedido pedido) {

        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(UPDATE);
            statement.setString(1, pedido.getFecha());
            statement.setDouble(2, pedido.getTotalPagar());
            statement.setDouble(3, pedido.getAnticipo());
            statement.setBoolean(4, pedido.isRegistrado());
            statement.setBoolean(5, pedido.isAtrasado());
            statement.setBoolean(6, pedido.isEntregado());
            statement.setString(7, pedido.getCodigoTiendaORIGEN());
            statement.setString(8, pedido.getCodigoTiendaDESTINO());
            statement.setString(9, pedido.getNitCliente());
            statement.setInt(10, pedido.getCodigoPedido());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
            return false;
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
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return pedidos;
    }

    /**
     * Pedidos que llegarán a la tienda sin fecha
     * <br>query: PEDIDO_QUE_LLEGARAN_A_LA_TIENDA_SIN_FECHA = "SELECT * FROM
     * pedido WHERE tienda_destino = ? AND registrado = 0"
     *
     * @param codigoTienda
     * @param query
     * @return
     */
    public List<Pedido> getPedidosPorTienda(String codigoTienda, String query) {
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {

            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, codigoTienda);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pedido = getPedido(resultSet);
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return pedidos;
    }

    /**
     *
     * @param codigoTienda
     * @return
     */
    public List<Pedido> getPedidosSalenDeTienda(String codigoTienda) {

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
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return pedidos;
    }

    /**
     *
     * @param nitCliente
     * @return
     */
    public List<Pedido> getPedidosEnCursoPorCliente(String nitCliente) {

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
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return pedidos;
    }

    public List<Pedido> getPedidosEnCursoPorCliente(String nitCliente, String fecha1, String fecha2) {

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
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
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
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(TIEMPO_DE_PEDIDO);
            statement.setInt(1, p.getCodigoPedido());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                t = resultSet.getInt("dias");
            }
        } catch (SQLException e) {
            Logger.getLogger(PedidoDB.class.getName()).log(Level.SEVERE, null, e);
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
                resultSet.getBoolean("registrado"),
                resultSet.getBoolean("atrasado"),
                resultSet.getBoolean("entregado"));
    }
}
