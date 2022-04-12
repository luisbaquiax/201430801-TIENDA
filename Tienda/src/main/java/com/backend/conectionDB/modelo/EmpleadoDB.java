/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class EmpleadoDB {

    public EmpleadoDB() {
    }

    /**
     * Método para crear un empleado y agregar a la base de datos
     *
     * @param connection
     * @param codigo
     * @param nombre
     * @param telefono
     * @param dpi
     * @param nit
     * @param email
     * @param direccion
     */
    public void crearEmpleado(Connection connection,
            String codigo,
            String nombre,
            String telefono,
            String dpi,
            String nit,
            String email,
            String direccion) {

        String query = "INSERT INTO empleado VALUES (?,?,?,?,?,?,?)";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, telefono);
            preSt.setString(4, dpi);
            preSt.setString(5, nit);
            preSt.setString(6, email);
            preSt.setString(7, direccion);

            preSt.executeUpdate();

            System.out.println("empleado agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * *
     * MOdifica el empleado en la base de datos
     *
     * @param connection
     * @param codigo
     * @param nombre
     * @param telefono
     * @param dpi
     * @param nit
     * @param email
     * @param direccion
     */
    public void modificarEmpleado(Connection connection,
            String codigo,
            String nombre,
            String telefono,
            String dpi,
            String nit,
            String email,
            String direccion) {

        String query = "UPDATE EMPLEADO SET nombre = ?, telefono = ?, dpi = ?, nit = ?, email = ?, direccion = ? WHERE codigo = ?";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, telefono);
            preSt.setString(3, dpi);
            preSt.setString(4, nit);
            preSt.setString(5, email);
            preSt.setString(6, direccion);
            preSt.setString(7, codigo);

            preSt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Busca el emplead por codigo
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarEmpleadoCodigo(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM empleado WHERE codigo LIKE ? ORDER BY codigo ASC";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(5),
                    result.getString(4),
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
     * Busca al empleado usanto el nombre como filtro
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarEmpleadoNombre(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM empleado WHERE nombre LIKE ? ORDER BY codigo ASC";

        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(5),
                    result.getString(4),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Empleado buscarEmpleado(String codigo) {

        String query = "SELECT * FROM empleado WHERE codigo = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Empleado empleado = null;

        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, codigo);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                empleado = new Empleado(
                        resultSet.getString("nombre"),
                        resultSet.getString("codigo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("dpi"),
                        resultSet.getString("nit"),
                        resultSet.getString("email"),
                        resultSet.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return empleado;
    }

    public List<Empleado> getEmpleados() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";
        Empleado empleado = null;
        try {
            conn = ConeccionDB.getConnection();
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                empleado = new Empleado(
                        resultSet.getString("nombre"),
                        resultSet.getString("codigo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("dpi"),
                        resultSet.getString("nit"),
                        resultSet.getString("email"),
                        resultSet.getString("direccion"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
        }
        return empleados;
    }
}
