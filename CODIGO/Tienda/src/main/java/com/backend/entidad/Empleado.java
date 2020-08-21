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
public class Empleado implements Comparable<Empleado> {

    //para la carga de datos
    private String nomgre;
    private String codigo;
    private String telefono;
    private String dpi;
    //
    private String nit;
    private String correoElectronico;
    private String direccion;

    /**
     * Constructor de la clase empleado para la carga de los datos
     *
     * @param nomgre
     * @param codigo
     * @param telefono
     * @param dpi
     */
    public Empleado(String nomgre, String codigo, String telefono, String dpi) {
        this.nomgre = nomgre;
        this.codigo = codigo;
        this.telefono = telefono;
        this.dpi = dpi;

        this.nit = "";
        this.correoElectronico = "";
        this.direccion = "";

    }

    /**
     * Constructor de la calse empleado para registrar nuevo empleado
     *
     * @param nomgre
     * @param codigo
     * @param telefono
     * @param dpi
     * @param nit
     * @param correoElectronico
     * @param direccion
     */
    public Empleado(String nomgre, String codigo, String telefono, String dpi, String nit, String correoElectronico, String direccion) {
        this.nomgre = nomgre;
        this.codigo = codigo;
        this.telefono = telefono;
        this.dpi = dpi;
        this.nit = nit;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    public void mostarDatos() {
        System.out.println("Nombre: " + this.nomgre + " codigo " + this.codigo + " telefono: " + this.telefono + " dpi: " + this.dpi
                + " nit: " + this.nit + " correo: " + this.correoElectronico + " direccion: " + this.direccion);
    }

    @Override
    public int compareTo(Empleado empleado) {
        return this.getCodigo().compareTo(empleado.getCodigo());
    }

    /**
     * @return the nomgre
     */
    public String getNomgre() {
        return nomgre;
    }

    /**
     * @param nomgre the nomgre to set
     */
    public void setNomgre(String nomgre) {
        this.nomgre = nomgre;
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
     * @return the dpi
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(String dpi) {
        this.dpi = dpi;
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
