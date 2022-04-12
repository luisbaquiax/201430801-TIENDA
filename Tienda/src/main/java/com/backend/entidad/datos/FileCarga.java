/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.entidad.datos;

import com.backend.conectionDB.ConeccionDB;
import com.backend.entidad.Cliente;
import com.backend.entidad.DetallePedido;
import com.backend.entidad.Empleado;
import com.backend.entidad.FechaPedido;
import com.backend.entidad.Pedido;
import com.backend.entidad.Producto;
import com.backend.entidad.Sistema;
import com.backend.entidad.TiempoDeEnvio;
import com.backend.entidad.Tienda;
import com.frontend.Login;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author luis
 */
public class FileCarga {

    private Sistema sistema;
    private Tienda tienda;
    private TiempoDeEnvio tiempoDeEnvio;
    private Producto producto;
    private Cliente cliente;
    private Empleado empleado;
    private Pedido pedido;
    private Login login;

    private FechaPedido fechaPedido;

    public FileCarga(Sistema sistema, Login login) {
        this.sistema = sistema;
        this.login = login;
    }

    public void cargarDatos() {

        JFileChooser seleccionar = new JFileChooser();

        int selecionado = seleccionar.showOpenDialog(login);

        if (selecionado == JFileChooser.APPROVE_OPTION) {
            File archivo = seleccionar.getSelectedFile();

            try {
                FileReader leerArchivo = new FileReader(archivo.getAbsoluteFile());

                BufferedReader leyendo = new BufferedReader(leerArchivo);//para leer linea por linea

                String linea = "";

                String datos = "";

                while (linea != null) {
                    linea = leyendo.readLine();
                    datos += linea + "\n";

                }
                String[] lineas = datos.split("\n");

                for (int i = 0; i < lineas.length; i++) {

                    String[] infLinea = lineas[i].split(",");
                    if (infLinea[0].equalsIgnoreCase("tienda")) {

                        this.tienda = new Tienda(infLinea[1], infLinea[2], infLinea[3], infLinea[4]);
                        this.sistema.getTiendas().add(tienda);
                        //se agrega la tienda a la base de datos
                        this.sistema.getTiendaDB().crearTienda(
                                ConeccionDB.getConnection(),
                                tienda.getCodigo(),
                                tienda.getNombreTienda(),
                                tienda.getDireccion(),
                                tienda.getTelefono(),
                                tienda.getTelefono2(),
                                tienda.getCorreoElectronico(),
                                tienda.getHorario());
                    } else if (infLinea[0].equalsIgnoreCase("tiempo")) {

                        if (sistema.esNumeroEntero(infLinea[3])) {
                            this.tiempoDeEnvio = new TiempoDeEnvio(infLinea[1], infLinea[2], infLinea[3]);
                            this.sistema.getTiemposDeEnvio().add(tiempoDeEnvio);
                            //se agrega a la base de datos
                            this.sistema.getEnvioDB().crearTiempoDeEnvio(this.sistema.getConection().getConnection(), tiempoDeEnvio.getCodigoTIENDA1(),
                                    tiempoDeEnvio.getCodigoTIENDA2(), String.valueOf(tiempoDeEnvio.getTiempoEnvio()));
                        } else {
                            this.sistema.getDatosErroneos().add(lineas[i]);
                        }

                    } else if (infLinea[0].equalsIgnoreCase("producto")) {

                        if (sistema.esNumeroEntero(infLinea[4]) && sistema.esDecimal(infLinea[5])) {

                            if (sistema.yaExisteCodigoCadena(infLinea[3])) {

                                this.producto = new Producto(
                                        infLinea[1],
                                        infLinea[2],
                                        infLinea[3],
                                        infLinea[4],
                                        infLinea[5],
                                        infLinea[6]);
                                this.sistema.getProductos().add(producto);
                                //se agrega la existencia a la base de datos
                                this.sistema.getProductoDB().crearExistentes(
                                        ConeccionDB.getConnection(),
                                        producto.getCantidad() + "",
                                        producto.getPrecio() + "",
                                        producto.getTiendaDondeExiste(),
                                        producto.getCodigo());
                            } else {
                                this.sistema.getCodigosExistentes().add(infLinea[3]);
                                this.producto = new Producto(
                                        infLinea[1],
                                        infLinea[2],
                                        infLinea[3],
                                        infLinea[4],
                                        infLinea[5],
                                        infLinea[6]);
                                this.sistema.getProductos().add(producto);
                                //se agrega el produtcto a la base de datos
                                this.sistema.getProductoDB().crearProducto(this.sistema.getConection().getConnection(),
                                        producto.getCodigo(),
                                        producto.getNombre(),
                                        producto.getFabricante(),
                                        producto.getDescripcion(),
                                        producto.getGarantia());
                                //se agrega la existencia a la base de datos
                                this.sistema.getProductoDB().crearExistentes(this.sistema.getConection().getConnection(),
                                        producto.getCantidad() + "",
                                        producto.getPrecio() + "",
                                        producto.getTiendaDondeExiste(),
                                        producto.getCodigo());
                            }

                        } else {
                            this.sistema.getDatosErroneos().add(lineas[i]);
                        }

                    } else if (infLinea[0].equalsIgnoreCase("empleado")) {

                        if (sistema.esNumeroEntero(infLinea[3])) {
                            this.empleado = new Empleado(infLinea[1], infLinea[2], infLinea[3], infLinea[4]);
                            this.sistema.getEmpleados().add(empleado);

                            this.sistema.getEmpleadoDB().crearEmpleado(this.sistema.getConection().getConnection(), empleado.getCodigo(), empleado.getNomgre(),
                                    empleado.getTelefono(), empleado.getDpi(), empleado.getNit(), empleado.getCorreoElectronico(), empleado.getDireccion());
                        } else {
                            this.sistema.getDatosErroneos().add(lineas[i]);
                        }

                    } else if (infLinea[0].equalsIgnoreCase("cliente")) {
                        if (sistema.esDecimal(infLinea[4])) {
                            if (sistema.yaExisteCodigoCadena(infLinea[2])) {

                            } else {
                                this.cliente = new Cliente(infLinea[1], infLinea[2], infLinea[3], infLinea[4]);
                                this.sistema.getClientes().add(cliente);
                                //se agrega el cliente a la base de datos
                                this.sistema.getClienteDB().crearCliente(this.sistema.getConection().getConnection(),
                                        cliente.getNit(),
                                        cliente.getNombreCliente(),
                                        cliente.getTelefono(),
                                        cliente.getDPI(),
                                        String.valueOf(cliente.getCredito()),
                                        cliente.getCorreoElctronico(),
                                        cliente.getDireccion());
                                //
                                this.sistema.getCodigosExistentes().add(infLinea[2]);
                            }

                        } else {
                            this.sistema.getDatosErroneos().add(lineas[i]);
                        }

                    } else if (infLinea[0].equalsIgnoreCase("pedido")) {

                        if ((sistema.esNumeroEntero(infLinea[7]))
                                && (sistema.esDecimal(infLinea[8])
                                && (sistema.esDecimal(infLinea[9])))) {

                            String[] fecha = infLinea[4].split("-");
                            this.fechaPedido = new FechaPedido(fecha[0], fecha[1], fecha[2]);

                            this.pedido = new Pedido(
                                    Integer.parseInt(infLinea[1]),
                                    infLinea[2],
                                    infLinea[3],
                                    fechaPedido,
                                    infLinea[5],
                                    infLinea[6],
                                    infLinea[7],
                                    infLinea[8],
                                    infLinea[9]);
                            this.sistema.getPedidos().add(this.pedido);
                            //se agrega el pedido a la base de datos
                            this.sistema.getPedidoDB().crearPedidoConID(ConeccionDB.getConnection(), this.pedido);
                            this.sistema.getDetallePedidoDB().crearPedido(
                                    ConeccionDB.getConnection(),
                                    new DetallePedido(
                                            Integer.parseInt(infLinea[7]),
                                            pedido.getTotalPagar(),
                                            pedido.getCodigoProductoPedido(),
                                            Integer.parseInt(infLinea[1])));
                        } else {
                            this.sistema.getDatosErroneos().add(lineas[i]);
                        }

                    }
                }
            } catch (IOException ex) {

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.sistema.mostraTiendas();
        System.out.println("");
        this.sistema.mostrarPedidos();
        System.out.println("");
        this.sistema.mostrarClinetes();
        System.out.println("");
        this.sistema.mostrarEmpleados();
        System.out.println("");
        this.sistema.mostrarProductos();
        System.out.println("");
        this.sistema.mostrarTiemposDeEnvio();
        this.sistema.mostrarDatosErroneos();

    }

}
