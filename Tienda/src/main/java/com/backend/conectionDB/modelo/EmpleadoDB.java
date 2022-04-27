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

    public static final String FILTRO_CODE = "SELECT * FROM empleado WHERE codigo LIKE ? ORDER BY codigo ASC";
    public static final String FILTRO_NAME = "SELECT * FROM empleado WHERE nombre LIKE ? ORDER BY codigo ASC";

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
     * @throws java.sql.SQLException
     */
    public void modificarEmpleado(Connection connection,
            String codigo,
            String nombre,
            String telefono,
            String dpi,
            String nit,
            String email,
            String direccion) throws SQLException {

        String query = "UPDATE empleado SET nombre = ?, telefono = ?, dpi = ?, nit = ?, email = ?, direccion = ? WHERE codigo = ?";

        PreparedStatement preSt = connection.prepareStatement(query);

        preSt.setString(1, nombre);
        preSt.setString(2, telefono);
        preSt.setString(3, dpi);
        preSt.setString(4, nit);
        preSt.setString(5, email);
        preSt.setString(6, direccion);
        preSt.setString(7, codigo);

        preSt.executeUpdate();

    }

    /**
     *
     * @param connection
     * @param filtro
     * @param query
     * @return
     */
    public List<Empleado> mostrarEmpleadosConFiltro(Connection connection, String filtro, String query) {
        List<Empleado> empleados = new ArrayList<>();
        try ( PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            while (result.next()) {
                empleados.add(getEmpleado(result));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return empleados;
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
                empleado = getEmpleado(resultSet);
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
                empleado = getEmpleado(resultSet);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
        }
        return empleados;
    }

    private Empleado getEmpleado(ResultSet resultSet) throws SQLException {
        return new Empleado(
                resultSet.getString("nombre"),
                resultSet.getString("codigo"),
                resultSet.getString("telefono"),
                resultSet.getString("dpi"),
                resultSet.getString("nit"),
                resultSet.getString("email"),
                resultSet.getString("direccion"));
    }
}
