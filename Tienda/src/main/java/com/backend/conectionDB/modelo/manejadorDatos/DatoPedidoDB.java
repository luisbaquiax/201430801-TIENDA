/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo.manejadorDatos;

import com.backend.conectionDB.modelo.PedidoDB;
import com.backend.entidad.Pedido;
import com.backend.entidad.Sistema;
import com.backend.entidad.TiempoDeEnvio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class DatoPedidoDB {

    private Sistema sistema;

    public DatoPedidoDB(Sistema sistema) {
        this.sistema = sistema;
    }

    /**
     * Lista los pedidos que llegaron a la tienda pero que no están registrados.
     *
     * @param codigoTienda
     * @return
     */
    public List<Pedido> getPedidosLlegaranSinRegistradosSinFecha(String codigoTienda) {
        List<Pedido> pedidos = new ArrayList<>();
        for (int i = 0; i < sistema.getPedidoDB().getPedidosPorTienda(codigoTienda).size(); i++) {
            if (sistema.getPedidoDB().getTiempoPedido(sistema.getPedidoDB().getPedidosPorTienda(codigoTienda).get(i))
                    > sistema.getEnvioDB().getEnvio(sistema.getPedidoDB().getPedidosPorTienda(codigoTienda).get(i)).getTiempoEnvio()) {
                pedidos.add(sistema.getPedidoDB().getPedidosPorTienda(codigoTienda).get(i));
            }
        }
        return pedidos;
    }

    /**
     *
     * @param codigoTienda
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<Pedido> getPedidosLlegaronSinRegistradosConFecha(String codigoTienda, String fecha1, String fecha2) {
        List<Pedido> pedidos = new ArrayList<>();
        for (int i = 0; i < sistema.getPedidoDB().getPedidosPorTienda(codigoTienda, fecha1, fecha2).size(); i++) {
            if (sistema.getPedidoDB().getTiempoPedido(
                    sistema.getPedidoDB().getPedidosPorTienda(codigoTienda, fecha1, fecha2).get(i))
                    > sistema.getEnvioDB().getEnvio(
                            sistema.getPedidoDB().
                                    getPedidosPorTienda(codigoTienda, fecha1, fecha2).
                                    get(i)).getTiempoEnvio()) {
                pedidos.add(sistema.getPedidoDB().getPedidosPorTienda(codigoTienda, fecha1, fecha2).get(i));
            }
        }
        return pedidos;
    }

    /**
     * Retorna los pedidos que salieron de la tienda en cuestión.
     *
     * @param codigoTienda
     * @return
     */
    public List<Pedido> getPedidosSalieron(String codigoTienda) {
        List<Pedido> pedidos = new ArrayList<>();
        for (int i = 0; i < sistema.getPedidoDB().getPedidosSalenDeTienda(codigoTienda).size(); i++) {
            if (sistema.getPedidoDB().getTiempoPedido(sistema.getPedidoDB().getPedidosPorTienda(codigoTienda).get(i))
                    <= sistema.getEnvioDB().getEnvio(
                            sistema.getPedidoDB().
                                    getPedidosPorTienda(codigoTienda).
                                    get(i)).getTiempoEnvio()) {

                pedidos.add(sistema.getPedidoDB().getPedidosPorTienda(codigoTienda).get(i));
            }
        }
        return pedidos;
    }

    public List<Pedido> getPedidosSalieronPorFecha(String codigoTienda, String fech1, String fecha2) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        for (int i = 0; i < sistema.getPedidoDB().getPedidosSalenDeTienda(codigoTienda, fech1, fecha2).size(); i++) {
            if (sistema.getPedidoDB().getTiempoPedido(
                    sistema.getPedidoDB().getPedidosSalenDeTienda(codigoTienda, fech1, fecha2).get(i))
                    <= sistema.getEnvioDB().getEnvio(
                            sistema.getPedidoDB().
                                    getPedidosPorTienda(codigoTienda).
                                    get(i)).getTiempoEnvio()) {

                pedidos.add(sistema.getPedidoDB().getPedidosSalenDeTienda(codigoTienda, fech1, fecha2).get(i));
            }
        }
        return pedidos;
    }

    /**
     * Retorna una lista de pedidos que están en curso de un cliente.
     *
     * @param nitCliente
     * @return
     */
    public List<Pedido> getPedidosByCustomerEnCurso(String nitCliente) {
        List<Pedido> pedidos = new ArrayList<>();
        for (int i = 0; i < sistema.getPedidoDB().getPedidosEnCursoPorCliente(nitCliente).size(); i++) {
            if (sistema.getPedidoDB().getTiempoPedido(sistema.getPedidoDB().getPedidosEnCursoPorCliente(nitCliente).get(i))
                    <= sistema.getEnvioDB().getEnvio(sistema.getPedidoDB().getPedidosEnCursoPorCliente(nitCliente).get(i)).getTiempoEnvio()) {
                pedidos.add(sistema.getPedidoDB().getPedidosEnCursoPorCliente(nitCliente).get(i));
            }
        }
        return pedidos;
    }

    public List<Pedido> getPedidosByCustomerEnCurso(String nitCliente, String fecha1, String fecha2) {
        List<Pedido> pedidos = new ArrayList<>();
        for (int i = 0; i < sistema.getPedidoDB().getPedidosEnCursoPorCliente(nitCliente, fecha1, fecha2).size(); i++) {
            if (sistema.getPedidoDB().getTiempoPedido(sistema.getPedidoDB().getPedidosEnCursoPorCliente(nitCliente, fecha1, fecha2).get(i))
                    <= sistema.getEnvioDB().getEnvio(sistema.getPedidoDB().getPedidosEnCursoPorCliente(nitCliente, fecha1, fecha2).get(i)).getTiempoEnvio()) {
                pedidos.add(sistema.getPedidoDB().getPedidosEnCursoPorCliente(nitCliente, fecha1, fecha2).get(i));
            }
        }
        return pedidos;
    }
}
