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
    private String USER = "root";
    private String PASSWORD = "luisbaquiax1234";

    private static ConeccionDB conexionSingleton = null;

    private static Connection CONECCION = null;

<<<<<<< HEAD

=======
>>>>>>> versionOld
    public ConeccionDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CONECCION = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException ex) {
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
