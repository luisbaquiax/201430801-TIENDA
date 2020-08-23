/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luis
 */
public class Conection {

    private String url = "jdbc:mysql://localhost:3306/TIENDA?useSSL=false";
    private String user = "user_tienda";
    private String password = "Usuario123.";

    private Connection connection = DriverManager.getConnection(url, user, password);

    public Conection() throws SQLException {
//         try (Connection connection = DriverManager.getConnection(url, user, password)) {
//             probarConection(connection);
//             System.out.println("conexion exitosa");
//            connection.close();
//        } catch (SQLException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        }
    }

    public void probarConection(Connection connection) {

        String query = "SELECT VERSION()";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Conection fallida");
            System.out.println("Error: " + e.getMessage());

        }
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
    public static void crearTienda(Connection connection, String codigo, String nombre, String direccion, String telefono, String telefono2, String email, String horario) {
        String query = "INSERT INTO TIENDAS VALUES (?,?,?,?,?,?,?)";
        /*
         * CODIGO VARCHAR(45) NOT NULL, nombre VARCHAR(45) NOT NULL, direccion
         * VARCHAR(45) NOT NULL, telefono VARCHAR(8) NOT NULL, telefono2
         * VARCHAR(8), email VARCHAR(45), horario VARCHAR(45), PRIMARY KEY(CODIGO)
         */

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

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
     * Retorna el objeto de tipo Connection
     *
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
