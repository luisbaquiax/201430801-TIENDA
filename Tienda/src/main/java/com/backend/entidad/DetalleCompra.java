/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.entidad;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class DetalleCompra {

    private int id;
    private ArrayList<Producto> productos;
    private int idCompra;
    private double total;

    public DetalleCompra() {
    }

    /**
     *
     * @param id
     * @param productos
     * @param idCompra
     */
    public DetalleCompra(int id, ArrayList<Producto> productos, int idCompra) {
        this.id = id;
        this.productos = productos;
        this.idCompra = idCompra;
        this.total = getTotal();
    }

    private double calcularTotal() {
        double tot = 0;
        for (int i = 0; i < productos.size(); i++) {
            tot += productos.get(i).getPrecio() * productos.get(i).getCantidad();
        }
        return tot;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" + "id=" + id + ", productos=" + productos + ", idCompra=" + idCompra + ", total=" + total + '}';
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
     * @return the productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the idCompra
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     *
     * @return THIS total
     */
    public double getTotal() {
        return total;
    }

}
