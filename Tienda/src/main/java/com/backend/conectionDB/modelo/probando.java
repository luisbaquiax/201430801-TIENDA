/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

/**
 *
 * @author luis
 */
public class probando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EmpleadoDB e = new EmpleadoDB();
            System.out.println(e.buscarEmpleado("empleado1234").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
