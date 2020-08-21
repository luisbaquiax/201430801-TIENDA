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
public class Pedido {

    private String codigoPedido;
    private String codigoTiendaORIGEN;
    private String codigoTiendaDESTINO;
    private FechaPedido fechaPedido;
    private String nitDelCliente;
    private String codigoProductoPedido;
    private int cantidadArticulos;
    private double totalPagar;
    private double anticipo;

    /**
     * COnstructor del pedido en la carga de datos
     *
     * @param codigoPedido
     * @param codigoTiendaORIGEN
     * @param codigoTiendaDESTINO
     * @param fechaPedido
     * @param codigoCliente
     * @param codigoProductoPedido
     * @param cantidadArticulos
     * @param totalPagar
     * @param anticipo
     */
    public Pedido(String codigoPedido, String codigoTiendaORIGEN, String codigoTiendaDESTINO, FechaPedido fechaPedido,
            String codigoCliente, String codigoProductoPedido, String cantidadArticulos, String totalPagar, String anticipo) {
        this.codigoPedido = codigoPedido;
        this.codigoTiendaORIGEN = codigoTiendaORIGEN;
        this.codigoTiendaDESTINO = codigoTiendaDESTINO;
        this.fechaPedido = fechaPedido;
        this.nitDelCliente = codigoCliente;
        this.codigoProductoPedido = codigoProductoPedido;
        this.cantidadArticulos = Integer.parseInt(cantidadArticulos);
        this.totalPagar = Double.parseDouble(totalPagar);
        this.anticipo = Double.parseDouble(anticipo);
    }

    public void mostarDatos() {
        System.out.println("Codigo pedido: " + this.codigoPedido + " codigoTiendaORIGEN " + this.codigoTiendaORIGEN + " codigoTiendaDESTINO: " + this.codigoTiendaDESTINO
                + " fechaPedido: " + this.fechaPedido.mostrarFECHAS() + " codigoCliente: " + this.nitDelCliente + " codigoProductoPedido: " + this.codigoProductoPedido
                + " cantidadArticulos: " + this.cantidadArticulos + " totalPagar: " + this.totalPagar + " anticipo: " + this.anticipo);

    }

    /**
     * @return the codigoPedido
     */
    public String getCodigoPedido() {
        return codigoPedido;
    }

    /**
     * @param codigoPedido the codigoPedido to set
     */
    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    /**
     * @return the codigoTiendaORIGEN
     */
    public String getCodigoTiendaORIGEN() {
        return codigoTiendaORIGEN;
    }

    /**
     * @param codigoTiendaORIGEN the codigoTiendaORIGEN to set
     */
    public void setCodigoTiendaORIGEN(String codigoTiendaORIGEN) {
        this.codigoTiendaORIGEN = codigoTiendaORIGEN;
    }

    /**
     * @return the codigoTiendaDESTINO
     */
    public String getCodigoTiendaDESTINO() {
        return codigoTiendaDESTINO;
    }

    /**
     * @param codigoTiendaDESTINO the codigoTiendaDESTINO to set
     */
    public void setCodigoTiendaDESTINO(String codigoTiendaDESTINO) {
        this.codigoTiendaDESTINO = codigoTiendaDESTINO;
    }

    /**
     * @return the fechaPedido
     */
    public FechaPedido getFechaPedido() {
        return fechaPedido;
    }

    /**
     * @param fechaPedido the fechaPedido to set
     */
    public void setFechaPedido(FechaPedido fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    /**
     * @return the codigoCliente
     */
    public String getNitCliente() {
        return nitDelCliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setNitCliente(String codigoCliente) {
        this.nitDelCliente = codigoCliente;
    }

    /**
     * @return the codigoProductoPedido
     */
    public String getCodigoProductoPedido() {
        return codigoProductoPedido;
    }

    /**
     * @param codigoProductoPedido the codigoProductoPedido to set
     */
    public void setCodigoProductoPedido(String codigoProductoPedido) {
        this.codigoProductoPedido = codigoProductoPedido;
    }

    /**
     * @return the cantidadArticulos
     */
    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    /**
     * @param cantidadArticulos the cantidadArticulos to set
     */
    public void setCantidadArticulos(int cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    /**
     * @return the totalPagar
     */
    public double getTotalPagar() {
        return totalPagar;
    }

    /**
     * @param totalPagar the totalPagar to set
     */
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * @return the anticipo
     */
    public double getAnticipo() {
        return anticipo;
    }

    /**
     * @param anticipo the anticipo to set
     */
    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

}
