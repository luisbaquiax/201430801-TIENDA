/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.frontend.Login;
import java.sql.SQLException;

/**
 *
 * @author luis
 *
 */
public class Inicio {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Login login = new Login();
        login.setVisible(true);

    }
}
