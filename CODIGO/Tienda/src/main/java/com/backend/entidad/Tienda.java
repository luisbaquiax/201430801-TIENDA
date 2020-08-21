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
public class Tienda implements Comparable<Tienda> {

    private String nombreTienda;
    private String direccion;
    private String codigo;
    private String telefono;

    //datos no obligatorios
    private String telefono2;
    private String correoElectronico;
    private String horario;

    /**
     * Constructor que recibe los datos obligatorios al cargar los datos
     *
     * @param nombreTienda
     * @param direccion
     * @param codigo
     * @param telefono
     */
    public Tienda(String nombreTienda, String direccion, String codigo, String telefono) {
        this.nombreTienda = nombreTienda;
        this.direccion = direccion;
        this.codigo = codigo;
        this.telefono = telefono;

        this.telefono2 = "";
        this.correoElectronico = "";
        this.horario = "";
    }

    /**
     * Constructor que me ayudará para registrar una nueva tienda
     *
     * @param nombreTienda
     * @param direccion
     * @param codigo
     * @param telefono
     * @param telefono2
     * @param correoElectronico
     * @param horario
     */
    public Tienda(String nombreTienda, String direccion, String codigo, String telefono, String telefono2, String correoElectronico, String horario) {
        this.nombreTienda = nombreTienda;
        this.direccion = direccion;
        this.codigo = codigo;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.correoElectronico = correoElectronico;
        this.horario = horario;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombreTienda + " direccion; " + this.direccion + " codigo de la tienda: " + this.codigo + " telefono: " + this.telefono);
    }

    @Override
    public int compareTo(Tienda t) {
        return this.nombreTienda.compareTo(t.getNombreTienda());
    }

    /**
     * @return the nombreTienda
     */
    public String getNombreTienda() {
        return nombreTienda;
    }

    /**
     * @param nombreTienda the nombreTienda to set
     */
    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
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
     * @return the telefono2
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * @param telefono2 the telefono2 to set
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

}
