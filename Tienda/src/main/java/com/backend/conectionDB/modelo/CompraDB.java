/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class CompraDB {

    private static final String COMPRAS_POR_CLIENTE_FECHA = "SELECT * FROM compra WHERE nit_cliente = ? AND fecha BETWEEN ? AND ?";
    private static final String COMPRAS_POR_CLIENTE_SIN_FECHA = "SELECT * FROM compra WHERE nit_cliente = ?";
    private static final String COMPRAS_POR_CLIENTE_FECHA_POR_TIENDA = "SELECT * FROM compra WHERE nit_cliente = ? AND codigo_tienda = ? AND fecha BETWEEN ? AND ?";
    private static final String COMPRAS_POR_CLIENTE_SIN_FECHA_POR_TIENDA = "SELECT * FROM compra WHERE nit_cliente = ? AND codigo_tienda = ?";

    private static final String CREATE_COMPRA = "INSERT INTO compra (fecha, nit_cliente, codigo_tienda, total) VALUES(?,?,?,?)";
    private static final String GET_ULTIMO_ID_COMPRA = "SELECT MAX(id) AS ultimo FROM compra";
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public CompraDB() {
        this.conn = null;
        this.statement = null;
        this.resultSet = null;
    }

    public void ceate(Compra compra) {
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(CREATE_COMPRA);
            statement.setString(1, compra.getFecha());
            statement.setString(2, compra.getNitCliente());
            statement.setString(3, compra.getCodigoTienda());
            statement.setDouble(4, compra.getTotal());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompraDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param nitCliente
     * @return
     */
    public List<Compra> getCompraByCliente(String nitCliente) {
        Compra compra = null;
        List<Compra> compras = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(COMPRAS_POR_CLIENTE_SIN_FECHA);
            statement.setString(1, nitCliente);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                compra = getCompra(resultSet);
                compras.add(compra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return compras;
    }

    /**
     *
     * @param nitCliente
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<Compra> getCompraByCliente(String nitCliente, String fecha1, String fecha2) {
        Compra compra = null;
        List<Compra> compras = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(COMPRAS_POR_CLIENTE_FECHA);
            statement.setString(1, nitCliente);
            statement.setString(2, fecha1);
            statement.setString(3, fecha2);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                compra = getCompra(resultSet);
                compras.add(compra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return compras;
    }

    /**
     * Obtiene el ultimo ID compra insertado
     *
     * @return
     */
    public int getUltimo() {
        int ultimoId = 0;
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(GET_ULTIMO_ID_COMPRA);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ultimoId = resultSet.getInt("ultimo");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ultimoId;
    }

    private Compra getCompra(ResultSet resultSet) throws SQLException {
        return new Compra(
                resultSet.getInt("id"),
                resultSet.getString("fecha"),
                resultSet.getString("nit_cliente"),
                resultSet.getString("codigo_tienda"),
                resultSet.getDouble("total"));
    }
}
