/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.entidad;

/**
 *
 * @author luis
 */
public class DetallePedido {

    private int id;
    private int cantidadArticulos;
    private double suboTotal;
    private String codigoProduco;
    private int idPedido;

    public DetallePedido() {
    }

    /**
     * Recuperar detalle-pedido
     *
     * @param id
     * @param cantidadArticulos
     * @param suboTotal
     * @param codigoProduco
     * @param idPedido
     */
    public DetallePedido(int id, int cantidadArticulos, double suboTotal, String codigoProduco, int idPedido) {
        this.id = id;
        this.cantidadArticulos = cantidadArticulos;
        this.suboTotal = suboTotal;
        this.codigoProduco = codigoProduco;
        this.idPedido = idPedido;
    }

    /**
     * Create new DetallePedido
     *
     * @param cantidadArticulos
     * @param suboTotal
     * @param codigoProduco
     * @param idPedido
     */
    public DetallePedido(int cantidadArticulos, double suboTotal, String codigoProduco, int idPedido) {
        this.cantidadArticulos = cantidadArticulos;
        this.suboTotal = suboTotal;
        this.codigoProduco = codigoProduco;
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "id=" + id + ", cantidadArticulos=" + cantidadArticulos + ", suboTotal=" + suboTotal + ", codigoProduco=" + codigoProduco + ", idPedido=" + idPedido + '}';
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
     * @return the suboTotal
     */
    public double getSuboTotal() {
        return suboTotal;
    }

    /**
     * @param suboTotal the suboTotal to set
     */
    public void setSuboTotal(double suboTotal) {
        this.suboTotal = suboTotal;
    }

    /**
     * @return the codigoProduco
     */
    public String getCodigoProduco() {
        return codigoProduco;
    }

    /**
     * @param codigoProduco the codigoProduco to set
     */
    public void setCodigoProduco(String codigoProduco) {
        this.codigoProduco = codigoProduco;
    }

    /**
     * @return the idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

}
