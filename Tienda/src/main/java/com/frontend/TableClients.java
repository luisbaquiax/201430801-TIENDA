/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.entidad.Cliente;
import com.backend.entidad.Empleado;
import com.backend.entidad.Sistema;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class TableClients extends javax.swing.JFrame {

    private VentanaEmpleado ventanaEmpleado;
    private Sistema sistema;
    private Cliente clienteElegido;

    private ModificadorCliente modificadorCliente;
    private RegistroNuevoCliente registroNuevoCliente;

    private DefaultTableModel dfm;

    /**
     * Creates new form TablaEmpleados
     */
    public TableClients(VentanaEmpleado ventanaEmpleado, Sistema sistema) {
        initComponents();
        this.ventanaEmpleado = ventanaEmpleado;
        this.sistema = sistema;

        llenarTableClients();

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollTablaEmpleados = new javax.swing.JScrollPane();
        tableListClients = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnModificaCliente = new javax.swing.JButton();
        btnOrdenarClientePorNit = new javax.swing.JButton();
        btnRegistroNuevoCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFiltroNOmbre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFiltroNit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableListClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Teléfono", "NIT", "DPI", "Crédito de compra", "E-mail", "Direción"
            }
        ));
        scrollTablaEmpleados.setViewportView(tableListClients);

        btnRegresar.setText("Regresar a la ventana anterior");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Listado de clientes");

        btnModificaCliente.setText("MODIFICAR CLIENTE");
        btnModificaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaClienteActionPerformed(evt);
            }
        });

        btnOrdenarClientePorNit.setText("Ordenar  por NIT");
        btnOrdenarClientePorNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarClientePorNitActionPerformed(evt);
            }
        });

        btnRegistroNuevoCliente.setText("REGISTRAR NUEVO CLIENTE");
        btnRegistroNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroNuevoClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Todos los clientes:");

        jLabel3.setText("Buscar por nombre:");

        txtFiltroNOmbre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroNOmbreKeyReleased(evt);
            }
        });

        jLabel4.setText("Buscar por NIT:");

        txtFiltroNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroNitKeyReleased(evt);
            }
        });

        jLabel5.setText("Selecione el cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTablaEmpleados)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFiltroNOmbre)
                    .addComponent(txtFiltroNit, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnOrdenarClientePorNit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(btnRegistroNuevoCliente)
                        .addGap(49, 49, 49)
                        .addComponent(btnModificaCliente)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(108, 108, 108)))
                .addComponent(btnRegresar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(434, 434, 434))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFiltroNOmbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFiltroNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRegresar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOrdenarClientePorNit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistroNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(scrollTablaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaClienteActionPerformed
        // TODO add your handling code here:
        //obtener la fila
        int fila = this.tableListClients.getSelectedRow();
        if (fila >= 0) {
            //System.out.println(fila);
            //obtenemso el valor de la columna 2, es decir el NIT del clientey en base a eso se procede a buscar al clienteElegido
            String nit = String.valueOf(this.dfm.getValueAt(fila, 2));
            this.clienteElegido = this.sistema.buscarCliente(nit);
            this.modificadorCliente = new ModificadorCliente(this, clienteElegido, this.sistema);
            this.modificadorCliente.setVisible(true);
            super.setVisible(false);
            dfm.setRowCount(0);
        }

    }//GEN-LAST:event_btnModificaClienteActionPerformed

    private void btnOrdenarClientePorNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarClientePorNitActionPerformed
        // TODO add your handling code here:
        dfm.setRowCount(0);
        this.sistema.ordenarClientes();
        llenarTableClients();
    }//GEN-LAST:event_btnOrdenarClientePorNitActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        super.setVisible(false);
        this.ventanaEmpleado.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistroNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroNuevoClienteActionPerformed
        // TODO add your handling code here:
        this.registroNuevoCliente = new RegistroNuevoCliente(this, sistema);
        this.registroNuevoCliente.setVisible(true);
        dfm.setRowCount(0);
        super.setVisible(false);

    }//GEN-LAST:event_btnRegistroNuevoClienteActionPerformed

    private void txtFiltroNOmbreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNOmbreKeyReleased
        // TODO add your handling code here:
        dfm.setRowCount(0);
        try {
            this.sistema.getClienteDB().buscarClienteNombre(this.sistema.getConection().getConnection(), txtFiltroNOmbre.getText(), dfm);
        } catch (SQLException ex) {
            Logger.getLogger(TableClients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroNOmbreKeyReleased

    private void txtFiltroNitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNitKeyReleased
        // TODO add your handling code here:
        dfm.setRowCount(0);
        try {
            this.sistema.getClienteDB().buscarClienteNit(this.sistema.getConection().getConnection(), txtFiltroNit.getText(), dfm);
        } catch (SQLException ex) {
            Logger.getLogger(TableClients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroNitKeyReleased

    public void llenarTableClients() {
        dfm = (DefaultTableModel) tableListClients.getModel();
        for (Cliente cliente : this.sistema.getClientes()) {

            String[] datos = {cliente.getNombreCliente(),
                cliente.getTelefono(),
                cliente.getNit(),
                cliente.getDPI(),
                cliente.getCredito() + "",
                cliente.getCorreoElctronico(),
                cliente.getDireccion()
            };
            dfm.addRow(datos);
        }
    }

    public JTable getTablesListaClientes() {
        return tableListClients;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificaCliente;
    private javax.swing.JButton btnOrdenarClientePorNit;
    private javax.swing.JButton btnRegistroNuevoCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollTablaEmpleados;
    private javax.swing.JTable tableListClients;
    private javax.swing.JTextField txtFiltroNOmbre;
    private javax.swing.JTextField txtFiltroNit;
    // End of variables declaration//GEN-END:variables
}
