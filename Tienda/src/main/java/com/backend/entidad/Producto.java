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
public class Producto implements Comparable<Producto>, Cloneable {

    private String nombre;
    private String fabricante;
    private String codigo;
    private int cantidad;
    private double precio;
    private String tiendaDondeExiste;

    private String descripcion;
    private String garantia;

    private boolean vendido;
    private int id;

    public Producto() {
    }

    /**
     * COnstructor de la clase producto, servirá en la carga de datos, además
     * para registrar un nuevo producto
     *
     * @param nombre
     * @param fabricante
     * @param codigo
     * @param cantidad
     * @param precio
     * @param tiendaDondeExiste
     */
    public Producto(String nombre, String fabricante, String codigo, String cantidad, String precio, String tiendaDondeExiste) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.cantidad = Integer.parseInt(cantidad);
        this.precio = Double.parseDouble(precio);
        this.tiendaDondeExiste = tiendaDondeExiste;
        this.descripcion = "";
        this.garantia = "";
    }

    /**
     * Este constructor me servirá cuando se registre un producto
     *
     * @param nombre
     * @param fabricante
     * @param codigo
     * @param cantidad
     * @param precio
     * @param tiendaDondeExiste
     * @param descripcion
     * @param garantia
     */
    public Producto(String nombre, String fabricante, String codigo, String cantidad, String precio, String tiendaDondeExiste, String descripcion, String garantia) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.cantidad = Integer.parseInt(cantidad);
        this.precio = Double.parseDouble(precio);
        this.tiendaDondeExiste = tiendaDondeExiste;
        this.descripcion = descripcion;
        this.garantia = garantia;
    }

    /**
     *
     * @param nombre
     * @param fabricante
     * @param codigo
     * @param descripcion
     * @param garantia
     * @param vendido
     */
    public Producto(String nombre, String fabricante, String codigo, String descripcion, String garantia, boolean vendido) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.garantia = garantia;
        this.vendido = vendido;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombre + " fabricante: " + this.fabricante + "codigo producto:" + this.codigo + " cantidad: " + this.cantidad
                + " precio c/u: " + this.precio + " tienda de existencia: " + this.tiendaDondeExiste);

    }

    /**
     * Producto - existencia
     *
     * @param nombre
     * @param fabricante
     * @param codigo
     * @param cantidad
     * @param precio
     * @param tiendaDondeExiste
     * @param descripcion
     * @param garantia
     * @param vendido
     * @param id
     */
    public Producto(String nombre, String fabricante, String codigo, int cantidad, double precio, String tiendaDondeExiste, String descripcion, String garantia, boolean vendido, int id) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tiendaDondeExiste = tiendaDondeExiste;
        this.descripcion = descripcion;
        this.garantia = garantia;
        this.vendido = vendido;
        this.id = id;
    }

    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }

    public String getInfo() {
        return "Producto{" + "nombre=" + nombre + ", fabricante=" + fabricante + ", codigo=" + codigo + ", cantidad=" + cantidad + ", precio=" + precio + ", tiendaDondeExiste=" + tiendaDondeExiste + ", descripcion=" + descripcion + ", garantia=" + garantia + ", vendido=" + vendido + ", id=" + id + '}';
    }

    public String getInfoVenta() {
        return "Nombre: " + nombre + ", cantidad: " + cantidad + ", precio:" + precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", fabricante=" + fabricante + ", codigo=" + codigo + ", cantidad=" + cantidad + ", precio=" + precio + ", tiendaDondeExiste=" + tiendaDondeExiste + ", descripcion=" + descripcion + ", garantia=" + garantia + ", vendido=" + vendido + '}';
    }

    @Override
    public int compareTo(Producto producto) {
        return this.codigo.compareTo(producto.getCodigo());
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the tiendaEXISTENCIA
     */
    public String getTiendaDondeExiste() {
        return tiendaDondeExiste;
    }

    /**
     * @param tiendaEXISTENCIA the tiendaEXISTENCIA to set
     */
    public void setTiendaEXISTENCIA(String tiendaEXISTENCIA) {
        this.tiendaDondeExiste = tiendaEXISTENCIA;
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

}
