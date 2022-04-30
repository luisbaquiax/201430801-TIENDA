/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.entidad.Cliente;
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
public class ClienteDB {

    public static final String FILTRO_NIT = "SELECT * FROM cliente WHERE nit LIKE ? ORDER BY nit ASC";
    public static final String FILTRO_NAME = "SELECT * FROM cliente WHERE nombre LIKE ? ORDER BY nit ASC";
    public static final String SELECT_ALL_CLIENTES = "SELECT * FROM cliente";

    public ClienteDB() {
    }

    /**
     * Método para crear un cliente y luego se agregará a la base de datos
     *
     * @param connection
     * @param nit
     * @param nombre
     * @param telefono
     * @param dpi
     * @param credito
     * @param email
     * @param direccion
     */
    public void crearCliente(Connection connection,
            String nit,
            String nombre,
            String telefono,
            String dpi,
            String credito,
            String email,
            String direccion) {

        String query = "INSERT INTO cliente VALUES (?,?,?,?,?,?,?)";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nit);
            preSt.setString(2, nombre);
            preSt.setString(3, telefono);
            preSt.setString(4, dpi);
            preSt.setDouble(5, Double.parseDouble(credito));
            preSt.setString(6, email);
            preSt.setString(7, direccion);

            preSt.executeUpdate();

            System.out.println("cliente agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * MODIFICA UN CLIENTE EN LA BASE DE DATOS
     *
     * @param connection
     * @param nombre
     * @param telefono
     * @param dpi
     * @param credito
     * @param correo
     * @param direccion
     * @param nit
     */
    public void modificarCliente(Connection connection,
            String nombre,
            String telefono,
            String dpi,
            String credito,
            String correo,
            String direccion,
            String nit) {

        String query = "UPDATE cliente SET nombre = ?, telefono = ?, dpi = ?, credito = ?, email = ?, direccion = ? WHERE nit = ?";
        String NIT = nit;

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, telefono);
            preSt.setString(3, dpi);
            preSt.setDouble(4, Double.parseDouble(credito));
            preSt.setString(5, correo);
            preSt.setString(6, direccion);
            preSt.setString(7, NIT);

            preSt.executeUpdate();

            System.out.println("Cliente actualizado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     *
     * @param connection
     * @param filtro
     * @param query
     * @return
     */
    public List<Cliente> getClientesWhitFilter(Connection connection, String filtro, String query) {
        List<Cliente> clientes = new ArrayList<>();
        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            while (result.next()) {
                clientes.add(getCliente(result));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }

    /**
     *
     * @param connection
     * @param query
     * @return
     */
    public List<Cliente> getClientesAllClientes(Connection connection, String query) {
        List<Cliente> clientes = new ArrayList<>();
        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            ResultSet result = preSt.executeQuery();

            while (result.next()) {
                clientes.add(getCliente(result));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }

    /**
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Cliente getCliente(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getString("nombre"),
                resultSet.getString("nit"),
                resultSet.getString("telefono"),
                resultSet.getString("credito"),
                resultSet.getString("dpi"),
                resultSet.getString("email"),
                resultSet.getString("direccion"));
    }
}
