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
public class Cliente implements Comparable<Cliente> {

    private String nombreCliente;
    private String nit;
    private String telefono;

    private double credito;

    private String DPI;
    private String correoElctronico;
    private String direccion;

    public Cliente() {
    }

    /**
     * constructor que me sirve en la carga de datos
     *
     * @param nombreCliente
     * @param nit
     * @param telefono
     * @param credito
     */
    public Cliente(String nombreCliente, String nit, String telefono, String credito) {
        this.nombreCliente = nombreCliente;
        this.nit = nit;
        this.telefono = telefono;
        this.credito = Double.parseDouble(credito);

        this.DPI = "";
        this.correoElctronico = "";
        this.direccion = "";

    }

    /**
     * Constructor para el registro nuevo de un cliente
     *
     * @param nombreCliente
     * @param nit
     * @param telefono
     * @param credito
     * @param DPI
     * @param correoElctronico
     * @param direccion
     */
    public Cliente(String nombreCliente, String nit, String telefono, String credito, String DPI, String correoElctronico, String direccion) {
        this.nombreCliente = nombreCliente;
        this.nit = nit;
        this.telefono = telefono;
        this.credito = Double.parseDouble(credito);
        this.DPI = DPI;
        this.correoElctronico = correoElctronico;
        this.direccion = direccion;
    }

    public void mostarDatos() {
        System.out.println("nombreCliente: " + this.getNombreCliente() + " nit " + this.getNit() + " telefono: " + this.getTelefono()
                + " credito: " + this.getCredito() + " DPI: " + this.getDPI() + " correoElctronico: " + this.getCorreoElctronico()
                + " direccion: " + this.getDireccion());
    }

    @Override
    public int compareTo(Cliente cliente) {
        return this.getNit().compareTo(cliente.getNit());
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the credito
     */
    public double getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(double credito) {
        this.credito = credito;
    }

    /**
     * @return the DPI
     */
    public String getDPI() {
        return DPI;
    }

    /**
     * @param DPI the DPI to set
     */
    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    /**
     * @return the correoElctronico
     */
    public String getCorreoElctronico() {
        return correoElctronico;
    }

    /**
     * @param correoElctronico the correoElctronico to set
     */
    public void setCorreoElctronico(String correoElctronico) {
        this.correoElctronico = correoElctronico;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
