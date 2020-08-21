/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.entidad;

/**
 *
 * @author luis
 */
public class FechaPedido {

    private String año;
    private String mes;
    private String dia;

    /**
     * COnstructor para guardar la fecha de un pedido en la carga de datos
     *
     * @param año
     * @param mes
     * @param dia
     */
    public FechaPedido(String año, String mes, String dia) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public void mostrarFecha() {
        System.out.println(this.año+"-"+this.mes+"-"+this.dia);
    }
    
    public String mostrarFECHAS(){
        return this.año+"-"+this.mes+"-"+this.dia;
    }

    /**
     * @return the año
     */
    public String getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(String año) {
        this.año = año;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

}
