/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB.modelo;

import com.backend.conectionDB.modelo.manejadorDatos.*;
import com.backend.conectionDB.modelo.productoExistencia.ProductoExistenciaDB;
import com.backend.entidad.Pedido;
import com.backend.entidad.Sistema;
import java.sql.SQLException;

/**
 *
 * @author luis
 */
public class probando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EmpleadoDB e = new EmpleadoDB();
            PedidoDB p = new PedidoDB();
            EnvioDB envioDB = new EnvioDB();
            Pedido pedido = new Pedido();
            DatoPedidoDB datoPedidoDB = new DatoPedidoDB(new Sistema());
            DetalleCompraDB detalleCompraDB = new DetalleCompraDB();
            CompraDB compraDB = new CompraDB();
            DetallePedidoDB detallePedidoDB = new DetallePedidoDB();
            ProductReportDB productReportDB = new ProductReportDB();
            ProductoExistenciaDB productoExistenciaDB = new ProductoExistenciaDB();
            String nit = "Q-8877";
            String fecha1 = "2022-02-14";
            String fecha2 = "2022-02-15";
            String tienda = "ABC-1";

            for (int i = 0; i < productoExistenciaDB.getAllProductosByTienda(tienda).size(); i++) {
                System.out.println(productoExistenciaDB.getAllProductosByTienda(tienda).get(i).getInfo());
            }

//            System.out.println("mas vendido por fecha");
//            for (int i = 0; i < productReportDB.getProductosMasVendido(fecha1, fecha2).size(); i++) {
//                System.out.println(productReportDB.getProductosMasVendido(fecha1, fecha2).get(i).toString());
//            }
//            System.out.println("mas vendido por fecha y tienda");
//            for (int i = 0; i < productReportDB.getProductosMasVendidoPorTienda(tienda, fecha1, fecha2).size(); i++) {
//                System.out.println(productReportDB.getProductosMasVendidoPorTienda(tienda, fecha1, fecha2).get(i).toString());
//            }
//            for (int i = 0; i < p.getPedidosEnCursoPorCliente(nit).size(); i++) {
//                System.out.println(p.getPedidosEnCursoPorCliente(nit).get(i).toString());
//                for (int j = 0; j < detallePedidoDB.getDetallePedido(p.getPedidosEnCursoPorCliente(nit).get(i).getCodigoPedido()).size(); j++) {
//                    System.out.println(detallePedidoDB.getDetallePedido(p.getPedidosEnCursoPorCliente(nit).get(i).getCodigoPedido()).get(j).toString());
//                }
//            }
//            System.out.println("con fecha");
//            for (int i = 0; i < p.getPedidosEnCursoPorCliente(nit, fecha1, fecha2).size(); i++) {
//                System.out.println(p.getPedidosEnCursoPorCliente(nit, fecha1, fecha2).get(i).toString());
//                for (int j = 0; j < detallePedidoDB.getDetallePedido(p.getPedidosEnCursoPorCliente(nit, fecha1, fecha2).get(i).getCodigoPedido()).size(); j++) {
//                    System.out.println(detallePedidoDB.getDetallePedido(p.getPedidosEnCursoPorCliente(nit, fecha1, fecha2).get(i).getCodigoPedido()).get(j).toString());
//                }
//            }
//            String nit = "E-5924";
//            String fecha1 = "2022-02-14";
//            String fecha2 = "2022-02-14";
//            for (int j = 0; j < compraDB.getCompraByCliente(nit, fecha1, fecha2).size(); j++) {
//                System.out.println(compraDB.getCompraByCliente(nit, fecha1, fecha2).toString());
//                for (int i = 0; i < detalleCompraDB.getCompraByIDCompra(compraDB.getCompraByCliente(nit, fecha1, fecha2).get(j).getId()).getProductos().size(); i++) {
//                    System.out.println(detalleCompraDB.getCompraByIDCompra(compraDB.getCompraByCliente(nit, fecha1, fecha2).get(j).getId()).getProductos().get(i).toString());
//                }
//            }
            System.out.println("hola");
        } catch (SQLException e) {
            System.out.println("valio");
            System.out.println(e.getMessage());
        }
    }

}
