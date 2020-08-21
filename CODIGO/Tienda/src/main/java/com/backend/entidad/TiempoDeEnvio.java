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
public class TiempoDeEnvio implements Comparable<TiempoDeEnvio> {

    private String codigoTiendaOrigen;
    private String codigoTeindaDestino;
    private int tiempoEnvio;

    /**
     * Constructor que recibe los la tineda origen, tienda destino, y el tiempo
     * de envío entre ellas
     *
     * @param codigoTIENDA1
     * @param codigoTIENDA2
     * @param tiempoEnvio
     */
    public TiempoDeEnvio(String codigoTIENDA1, String codigoTIENDA2, String tiempoEnvio) {
        this.codigoTiendaOrigen = codigoTIENDA1;
        this.codigoTeindaDestino = codigoTIENDA2;
        this.tiempoEnvio = Integer.parseInt(tiempoEnvio);
    }

    public void mostrarDatos() {
        System.out.println("codigo tiendaOrigen: " + this.codigoTiendaOrigen + " codigo tienda destino: " + this.codigoTeindaDestino + " tiempo de envío:" + this.tiempoEnvio);
    }

    @Override
    public int compareTo(TiempoDeEnvio tiempEnvio) {
        String tiempo = String.valueOf(this.tiempoEnvio);
        String tiempo2 = String.valueOf(tiempEnvio.getTiempoEnvio());
        return tiempo.compareTo(tiempo2);
    }

    /**
     * Cogido de la tienda origen / actual
     *
     * @return the codigoTIENDA1
     */
    public String getCodigoTIENDA1() {
        return codigoTiendaOrigen;
    }

    /**
     * @param codigoTIENDA1 the codigoTIENDA1 to set
     */
    public void setCodigoTIENDA1(String codigoTIENDA1) {
        this.codigoTiendaOrigen = codigoTIENDA1;
    }

    /**
     * codigo de la tienda destino
     *
     * @return the codigoTIENDA2
     */
    public String getCodigoTIENDA2() {
        return codigoTeindaDestino;
    }

    /**
     * @param codigoTIENDA2 the codigoTIENDA2 to set
     */
    public void setCodigoTIENDA2(String codigoTIENDA2) {
        this.codigoTeindaDestino = codigoTIENDA2;
    }

    /**
     * @return the tiempoEnvio
     */
    public int getTiempoEnvio() {
        return tiempoEnvio;
    }

    /**
     * @param tiempoEnvio the tiempoEnvio to set
     */
    public void setTiempoEnvio(int tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }

}
