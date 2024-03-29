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
public class Compra {

    private int id;
    private String fecha;
    private String nitCliente;
    private String codigoTienda;
    private double total;

    /**
     *
     * @param id
     * @param fecha
     * @param nitCliente
     * @param codigoTienda
     * @param total
     */
    public Compra(int id, String fecha, String nitCliente, String codigoTienda, double total) {
        this.id = id;
        this.fecha = fecha;
        this.nitCliente = nitCliente;
        this.codigoTienda = codigoTienda;
        this.total = total;
    }

    /**
     *
     * @param fecha
     * @param nitCliente
     * @param codigoTienda
     * @param total
     */
    public Compra(String fecha, String nitCliente, String codigoTienda, double total) {
        this.fecha = fecha;
        this.nitCliente = nitCliente;
        this.codigoTienda = codigoTienda;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", fecha=" + fecha + ", nitCliente=" + nitCliente + ", codigoTienda=" + getCodigoTienda() + '}';
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nitCliente
     */
    public String getNitCliente() {
        return nitCliente;
    }

    /**
     * @param nitCliente the nitCliente to set
     */
    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    /**
     * @return the codigoTienda
     */
    public String getCodigoTienda() {
        return codigoTienda;
    }

    /**
     * @param codigoTienda the codigoTienda to set
     */
    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
