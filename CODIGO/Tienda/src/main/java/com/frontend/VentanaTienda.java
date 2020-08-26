/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.entidad.Producto;
import com.backend.entidad.Sistema;
import com.backend.entidad.Tienda;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class VentanaTienda extends javax.swing.JFrame {

    private VentanaEmpleado ventanaEmpleado;
    private Sistema sistema;
    private String tiendaSeleccionada;
    private Producto productoBuscado;

    private RegistroNuevoProducto registroNuevoProducto;
    private RegistroNuevaTienda registroNuevaTienda;
    private TableStores tableStores;
    private VerificadorTiempoEnvio verifidorTiempoEnvio;
    private Tienda tiendaActual;
    private ReportWindow reportWindow;

    private DefaultTableModel dfm;

    /**
     * Creates new form VentanaTienda
     *
     * @param ventanaEmpleado
     * @param sistema
     * @param tiendaSeleccionada
     */
    public VentanaTienda(VentanaEmpleado ventanaEmpleado, Sistema sistema, String tiendaSeleccionada) {
        initComponents();
        this.ventanaEmpleado = ventanaEmpleado;
        this.sistema = sistema;
        this.tiendaSeleccionada = tiendaSeleccionada;
        this.tiendaActual = this.sistema.buscarTienda(tiendaSeleccionada);

        llenarTablaProductos();

        super.setTitle("                 TIENDA: " + tiendaActual.getNombreTienda());
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTienda = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnModificarPrecio = new javax.swing.JButton();
        btnOrdenarProductoPorCodigo = new javax.swing.JButton();
        btnRegistrarProducto = new javax.swing.JButton();
        btnRegitroTienda = new javax.swing.JButton();
        btnTablaTiendas = new javax.swing.JButton();
        btnVERtiempoEnvio = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaSistema = new javax.swing.JLabel();
        btnAgregarExistencia = new javax.swing.JButton();
        txtModificarPrecio = new javax.swing.JTextField();
        spinerExistencias = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnReportes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnModificarPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnModificarPrecio.setText("Modificar precio");
        btnModificarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPrecioActionPerformed(evt);
            }
        });

        btnOrdenarProductoPorCodigo.setText("ORDENAR POR CÓDIGO");
        btnOrdenarProductoPorCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarProductoPorCodigoActionPerformed(evt);
            }
        });

        btnRegistrarProducto.setText("REGISTRAR PRODUCTO");
        btnRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductoActionPerformed(evt);
            }
        });

        btnRegitroTienda.setText("Registra nueva tienda");
        btnRegitroTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegitroTiendaActionPerformed(evt);
            }
        });

        btnTablaTiendas.setText("Ver tiendas");
        btnTablaTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaTiendasActionPerformed(evt);
            }
        });

        btnVERtiempoEnvio.setText("Ver tiempo de envío a otras tiendas");
        btnVERtiempoEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVERtiempoEnvioActionPerformed(evt);
            }
        });

        btnVentas.setText("Ventas");

        jLabel1.setText("Seleccione el producto");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("PRODUCTOS");

        btnAgregarExistencia.setText("Agregar existencias");
        btnAgregarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExistenciaActionPerformed(evt);
            }
        });

        spinerExistencias.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel3.setText("Seleccione el producto");

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "FABRICANTE", "CODIGO", "CANTIDAD", "PRECIO", "DESCRIPCIÓN", "GARANTÍA"
            }
        ));
        jScrollPane1.setViewportView(tableProducts);

        javax.swing.GroupLayout panelTiendaLayout = new javax.swing.GroupLayout(panelTienda);
        panelTienda.setLayout(panelTiendaLayout);
        panelTiendaLayout.setHorizontalGroup(
            panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelTiendaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOrdenarProductoPorCodigo))
                        .addGap(133, 133, 133)
                        .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVERtiempoEnvio)
                            .addComponent(btnRegitroTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTiendaLayout.createSequentialGroup()
                                .addComponent(btnTablaTiendas)
                                .addGap(36, 36, 36)
                                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(panelTiendaLayout.createSequentialGroup()
                                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelTiendaLayout.createSequentialGroup()
                        .addComponent(btnModificarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtModificarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarExistencia)
                        .addGap(18, 18, 18)
                        .addComponent(spinerExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelTiendaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(161, 161, 161)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTiendaLayout.setVerticalGroup(
            panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiendaLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTiendaLayout.createSequentialGroup()
                        .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRegitroTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTablaTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTiendaLayout.createSequentialGroup()
                                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTiendaLayout.createSequentialGroup()
                                .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnVERtiempoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOrdenarProductoPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinerExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModificarPrecio)
                                .addComponent(txtModificarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        super.setVisible(false);
        this.ventanaEmpleado.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPrecioActionPerformed
        // TODO add your handling code here:
        int fila = this.tableProducts.getSelectedRow();
        System.out.println(fila);
        if (txtModificarPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el precio para realizar la modificación");
        } else {
            if (fila > -1) {
                //try {
                String codigo = String.valueOf(this.dfm.getValueAt(fila, 2));
                this.productoBuscado = this.sistema.buscarProducto(codigo);
                System.out.println(productoBuscado.getPrecio());
                double precioNuevo = Double.parseDouble(this.txtModificarPrecio.getText());
                System.out.println(precioNuevo);

                this.productoBuscado.setPrecio(precioNuevo);
                System.out.println(productoBuscado.getCantidad());
                dfm.setRowCount(0);
                llenarTablaProductos();
                //} catch (Exception e) {
                //}
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione el producto a moidifcar");
            }
        }
    }//GEN-LAST:event_btnModificarPrecioActionPerformed

    private void btnRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductoActionPerformed
        // TODO add your handling code here:
        this.registroNuevoProducto = new RegistroNuevoProducto(this, sistema, this.tiendaSeleccionada);
        this.registroNuevoProducto.setVisible(true);
        dfm.setRowCount(0);
        super.setVisible(false);
    }//GEN-LAST:event_btnRegistrarProductoActionPerformed

    private void btnOrdenarProductoPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarProductoPorCodigoActionPerformed
        // TODO add your handling code here:
        dfm.setRowCount(0);
        this.sistema.ordenarProductosPorCodigo();
        llenarTablaProductos();
    }//GEN-LAST:event_btnOrdenarProductoPorCodigoActionPerformed

    private void btnRegitroTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegitroTiendaActionPerformed
        // TODO add your handling code here:
        this.registroNuevaTienda = new RegistroNuevaTienda(this, ventanaEmpleado, verifidorTiempoEnvio, sistema);
        this.registroNuevaTienda.setVisible(true);
        //this.verifidorTiempoEnvio.getDfm().setRowCount(0);
        super.setVisible(false);
    }//GEN-LAST:event_btnRegitroTiendaActionPerformed

    private void btnTablaTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaTiendasActionPerformed
        // TODO add your handling code here:
        this.tableStores = new TableStores(this, sistema);
        this.tableStores.setVisible(true);
    }//GEN-LAST:event_btnTablaTiendasActionPerformed

    private void btnVERtiempoEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVERtiempoEnvioActionPerformed
        // TODO add your handling code here:
        this.verifidorTiempoEnvio = new VerificadorTiempoEnvio(this, this.sistema, this.tiendaActual);
        this.verifidorTiempoEnvio.setVisible(true);
        //this.verifidorTiempoEnvio.getDfm().setRowCount(0);
    }//GEN-LAST:event_btnVERtiempoEnvioActionPerformed

    private void btnAgregarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExistenciaActionPerformed
        // TODO add your handling code here:

        int fila = this.tableProducts.getSelectedRow();
        System.out.println(fila);

        if (fila > -1) {
            //try {
            String codigo = String.valueOf(this.dfm.getValueAt(fila, 2));
            this.productoBuscado = this.sistema.buscarProducto(codigo);
            System.out.println(productoBuscado.getCantidad());
            int cantidad = (int) spinerExistencias.getValue();

            System.out.println(cantidad);

            int cantidadNueva = productoBuscado.getCantidad() + cantidad;
            this.productoBuscado.setCantidad(cantidadNueva);
            System.out.println(productoBuscado.getCantidad());
            dfm.setRowCount(0);
            llenarTablaProductos();
            //} catch (Exception e) {
            //}
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione el producto a moidifcar");
        }
    }//GEN-LAST:event_btnAgregarExistenciaActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
        this.reportWindow = new ReportWindow(this, sistema, tiendaActual);
        this.reportWindow.setVisible(true);
        
    }//GEN-LAST:event_btnReportesActionPerformed

    public void llenarTablaProductos() {
        dfm = (DefaultTableModel) tableProducts.getModel();

        for (Producto producto : this.sistema.getProductos()) {
            if (producto.getTiendaDondeExiste().equals(this.tiendaSeleccionada)) {
                String[] datos = {producto.getNombre(),
                    producto.getFabricante(),
                    producto.getCodigo(),
                    producto.getCantidad() + "",
                    producto.getPrecio() + "",
                    producto.getDescripcion(),
                    producto.getGarantia()
                };
                dfm.addRow(datos);
            }

        }
    }

    public VerificadorTiempoEnvio getVerifidorTiempoEnvio() {
        return verifidorTiempoEnvio;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarExistencia;
    private javax.swing.JButton btnModificarPrecio;
    private javax.swing.JButton btnOrdenarProductoPorCodigo;
    private javax.swing.JButton btnRegistrarProducto;
    private javax.swing.JButton btnRegitroTienda;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTablaTiendas;
    private javax.swing.JButton btnVERtiempoEnvio;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelTienda;
    private javax.swing.JSpinner spinerExistencias;
    private javax.swing.JTable tableProducts;
    private javax.swing.JLabel txtFechaSistema;
    private javax.swing.JTextField txtModificarPrecio;
    // End of variables declaration//GEN-END:variables
}
