/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luis
 */
public class ConeccionDB {

    private String URL = "jdbc:mysql://localhost:3306/TIENDA?allowPublicKeyRetrieval=true&useSSL=false";
    private String USER = "tienda";
    private String PASSWORD = "tienda1234";

    private static ConeccionDB conexionSingleton = null;

    private static Connection CONECCION = null;

    public ConeccionDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            CONECCION = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexion exitosa");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (conexionSingleton == null) {
            conexionSingleton = new ConeccionDB();
        }
        return CONECCION;
    }

}
