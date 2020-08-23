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
    public void crearTienda(Connection connection, String codigo, String nombre, String direccion, String telefono, String telefono2, String email, String horario) {
        String query = "INSERT INTO TIENDAS VALUES (?,?,?,?,?,?,?)";
//        ID INT NOT NULL AUTO_INCREMENT,
//  codigo_tienda_origen VARCHAR(45) NOT NULL,
//  codigo_tienda_destino VARCHAR(45) NOT NULL,
//  tiempo_traslado INT NOT NULL,

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
     * Método para agregar una tiempo de envío/traslado
     *
     * @param connection
     * @param codigoTiendaOrigen
     * @param codigoTiendaDestino
     * @param tiempo
     */
    public void crearTiempoDeEnvio(Connection connection, String codigoTiendaOrigen,
            String codigoTiendaDestino, String tiempo) {

        String query = "INSERT INTO TIENDAS ENVIOS (?,?,?)";
        //  codigo_tienda_origen VARCHAR(45) NOT NULL,
        //  codigo_tienda_destino VARCHAR(45) NOT NULL,
        //  tiempo_traslado INT NOT NULL,

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

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

    public void crearProducto(Connection connection, String codigo, String nombre, String fabricante, String cantidad, String precio,
            String descripcion, String garantia, String codigoTiendaExistencia) {
//	CODIGO VARCHAR(45) NOT NULL,
//	nombre VARCHAR(45) NOT NULL,
//	fabricante VARCHAR(45) NOT NULL,
//	cantidad INT NOT NULL,
//  precio DOUBLE NOT NULL,
//  descripcion VARCHAR(200),
//  garantia
//  CODIGO_TIENDA_EXISTENCIA VARCHAR(45),
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

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
