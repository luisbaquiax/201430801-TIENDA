/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.conectionDB.modelo;

/**
 *
 * @author luis
 */
public class CompraDB {

    private static final String COMPRAS_POR_CLIENTE_FECHA = "SELECT * FROM compra WHERE nit_cliente = ? AND fecha BETWEEN ? AND ?";
    
}
