/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend.cliente;

import com.backend.entidad.Cliente;
import com.backend.entidad.Pedido;
import com.backend.entidad.Producto;
import com.backend.entidad.Sistema;
import com.frontend.Login;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class CatalogoProductos extends javax.swing.JFrame {

    private Login login;
    private Sistema sistema;
    private Cliente clienteActual;
    private DefaultTableModel dfm;

    /**
     * Crea una nueva ventana para el cliente
     *
     * @param login
     * @param sistema
     */
    public CatalogoProductos(Login login, Sistema sistema, Cliente clienteActual) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/tiendaIcono.png")));
        this.sistema = sistema;
        this.login = login;
        this.clienteActual = clienteActual;
        llenarTablaProductos();
                
        //llenarTablaProdcutosPedidos();

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        txtBuscarPorCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarPorNOmbre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBuscarPorFabricante = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnAscendente = new javax.swing.JButton();
        btnDescendente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("aakar", 0, 18)); // NOI18N

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "FABRICANTE", "CÓDIGO", "CANTIDAD", "PRECIO", "TIENDA DE EXISTENCIA"
            }
        ));
        jScrollPane1.setViewportView(tableProducts);

        jLabel1.setText("Buscar producto por código:");

        jLabel2.setText("Buscar producto por nombre:");

        jLabel3.setText("Buscar producto por fabricante:");

        btnSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("CÁTALOGO DE PRODUCTOS");

        btnAscendente.setText("Ordenar Ascendentemente");

        btnDescendente.setText("Ordenar descendentemente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(377, 377, 377))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnDescendente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAscendente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarPorNOmbre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarPorFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtBuscarPorNOmbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtBuscarPorFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAscendente)))
                .addGap(18, 18, 18)
                .addComponent(btnDescendente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.login.setVisible(true);
        super.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    public void llenarTablaProductos() {
        dfm = (DefaultTableModel) tableProducts.getModel();

        for (Producto producto : this.sistema.getProductos()) {
            String[] datos = {
                producto.getNombre(),
                producto.getFabricante(),
                producto.getCodigo(),
                producto.getCantidad() + "",
                producto.getPrecio() + "",
                producto.getTiendaDondeExiste()
            };
            dfm.addRow(datos);
        }
    }

    public void llenarTablaProdcutosPedidos() {
        dfm = (DefaultTableModel) tableProducts.getModel();
        for (Pedido pedido : this.sistema.getPedidos()) {
            if (pedido.getNitCliente().equals(this.clienteActual.getNit())) {
                for (Producto producto : this.sistema.getProductos()) {
                    if (pedido.getCodigoTiendaDESTINO().equalsIgnoreCase(producto.getTiendaDondeExiste())) {
                        String[] datos = {
                            producto.getNombre(),
                            producto.getFabricante(),
                            producto.getCodigo(),
                            producto.getCantidad() + "",
                            producto.getPrecio() + "",
                            producto.getTiendaDondeExiste()
                        };
                        dfm.addRow(datos);
                    }
                }

            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAscendente;
    private javax.swing.JButton btnDescendente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTextField txtBuscarPorCodigo;
    private javax.swing.JTextField txtBuscarPorFabricante;
    private javax.swing.JTextField txtBuscarPorNOmbre;
    // End of variables declaration//GEN-END:variables
}
