/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class TiendaDB {

    public TiendaDB() {
    }

    /**
     * Metodo para agregar una tienda a la base de datos
     *
     * @param connection
     * @param nombre
     * @param direccion
     * @param codigo
     * @param telefono
     * @param telefono2
     * @param email
     * @param horario
     */
    public void crearTienda(Connection connection, String codigo, String nombre, String direccion, String telefono, String telefono2, String email, String horario) {
        String query = "INSERT INTO tienda VALUES (?,?,?,?,?,?,?)";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, direccion);
            preSt.setString(4, telefono);
            preSt.setString(5, telefono2);
            preSt.setString(6, email);
            preSt.setString(7, horario);

            preSt.executeUpdate();

            System.out.println("tienda agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Busca a las tiendas filtrando el nombre
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarTiendaNombre(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM tienda WHERE nombre LIKE ? ORDER BY nombre ASC";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(2),
                    result.getString(3),
                    result.getString(1),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * BUsca a las tiendas filgrando el codigo de la misma
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarTiendaCodigo(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM tienda WHERE codigo LIKE ? ORDER BY codigo ASC";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(2),
                    result.getString(3),
                    result.getString(1),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /**
     * 
     * @return 
     */
    public List<Tienda> getTiendas() {
        String query = "SELECT * FROM tienda";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Tienda> tiendas = new ArrayList<>();
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tiendas.add(
                        new Tienda(
                                resultSet.getString("nombre"),
                                resultSet.getString("direccion"),
                                resultSet.getString("codigo"),
                                resultSet.getString("telefono"),
                                resultSet.getString("telefono2"),
                                resultSet.getString("email"),
                                resultSet.getString("horario")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tiendas;
    }
}
