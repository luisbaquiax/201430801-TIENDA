/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.conectionDB.ConeccionDB;
import com.backend.conectionDB.modelo.ClienteDB;
import com.backend.entidad.Cliente;
import com.backend.entidad.Sistema;
import com.tienda.utiles.Utiles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class ModificadorCliente extends javax.swing.JFrame {

    private TableClients tableClients;
    private Cliente cliente;
    private Sistema sistema;
    private ClienteDB clienteDB;

    /**
     * Para modificar los datos de un cliente
     *
     * @param tableClients
     * @param cliente
     */
    public ModificadorCliente(TableClients tableClients, Cliente cliente, Sistema sistema) {
        initComponents();
        setLocationRelativeTo(null);
        int tam = 25;
        Utiles.ponerIconoButton(btnGuardarDatosCliente, "iconos/saveBlue.jpeg", tam);
        Utiles.ponerIconoButton(btnCancel, "iconos/cancel.png", tam);
        Utiles.ponerIconoButton(btnOutoff, "iconos/outRed.jpeg");
        setLocationRelativeTo(null);
        this.clienteDB = new ClienteDB();
        this.tableClients = tableClients;
        this.cliente = cliente;
        this.sistema = sistema;

        this.txtCorreoElectronico.setText(cliente.getCorreoElctronico());
        this.spinerCredito.setValue(cliente.getCredito());
        this.txtDPI_Cliente.setText(cliente.getDPI());
        this.txtDireccionCliente.setText(cliente.getDireccion());
        this.txtNITcliente.setText(cliente.getNit());
        this.txtNombreCliente.setText(cliente.getNombreCliente());
        this.txtTelefono_cliente.setText(cliente.getTelefono());

        establecerFocus();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNITcliente = new javax.swing.JTextField();
        txtTelefono_cliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDPI_Cliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JTextField();
        btnGuardarDatosCliente = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnOutoff = new javax.swing.JButton();
        spinerCredito = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar cliente");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre: *");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIT: *");

        txtNITcliente.setEditable(false);
        txtNITcliente.setColumns(13);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teléfono: *");

        txtDPI_Cliente.setColumns(13);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DPI:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Credito:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo Electónico:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirección:");

        btnGuardarDatosCliente.setBackground(new java.awt.Color(0, 51, 255));
        btnGuardarDatosCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarDatosCliente.setText("Guardar cambios");
        btnGuardarDatosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosClienteActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("*campos obligatorios");

        btnCancel.setBackground(new java.awt.Color(255, 153, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar/regresar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOutoff.setForeground(new java.awt.Color(255, 0, 102));

        spinerCredito.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOutoff, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtNITcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtTelefono_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtDPI_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(spinerCredito))))
                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOutoff, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardarDatosCliente)
                        .addComponent(btnCancel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNITcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(spinerCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(txtDPI_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarDatosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosClienteActionPerformed
        // TODO add your handling code here:
        if (txtNombreCliente.getText().isBlank() || (txtTelefono_cliente.getText().isBlank())) {
            JOptionPane.showMessageDialog(this, "Llene los campos obligatoriso", "CAMPOS OBLIGATORIOS *", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (txtDPI_Cliente.getText().length() > 13 || txtNITcliente.getText().length() > 13) {
                JOptionPane.showMessageDialog(this, "Verifique el NIT o el DPI tenga no mas de 13 caracteres.", "TAMAÑO DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //se modifica los datos del cliente
                this.cliente.setCorreoElctronico(txtCorreoElectronico.getText());
                this.cliente.setCredito(Double.parseDouble(spinerCredito.getValue() + ""));
                this.cliente.setDPI(txtDPI_Cliente.getText());
                this.cliente.setDireccion(txtDireccionCliente.getText());
                this.cliente.setNombreCliente(txtNombreCliente.getText());
                this.cliente.setTelefono(txtTelefono_cliente.getText());
                try {
                    //se actualiza el cliente en la base de datos
                    this.clienteDB.modificarCliente(
                            ConeccionDB.getConnection(),
                            cliente.getNombreCliente(),
                            cliente.getTelefono(),
                            cliente.getDPI(),
                            cliente.getCredito() + "",
                            cliente.getCorreoElctronico(),
                            cliente.getDireccion(),
                            cliente.getNit());
                    JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente.", "Cliente modificado.", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "No se pudo guardar los cambios.", "Error al guardar los datos.", JOptionPane.INFORMATION_MESSAGE);
                }
                setVisible(false);
                this.tableClients.setVisible(true);
            }
        }


    }//GEN-LAST:event_btnGuardarDatosClienteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
        this.tableClients.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        setVisible(false);
        this.tableClients.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void establecerFocus() {

        KeyListener focus = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    if (e.getComponent().equals(txtNombreCliente)) {
                        txtNITcliente.requestFocus();
                    } else if (e.getComponent().equals(txtTelefono_cliente)) {
                        txtDPI_Cliente.requestFocus();
                    } else if (e.getComponent().equals(txtDPI_Cliente)) {
                        spinerCredito.requestFocus();
                    } else if (e.getComponent().equals(spinerCredito)) {
                        txtCorreoElectronico.requestFocus();
                    } else if (e.getComponent().equals(txtCorreoElectronico)) {
                        txtDireccionCliente.requestFocus();
                    } else if (e.getComponent().equals(txtDireccionCliente)) {
                        btnGuardarDatosCliente.requestFocus();
                    }
                }
            }
        };
        this.txtCorreoElectronico.addKeyListener(focus);
        this.spinerCredito.addKeyListener(focus);
        this.txtDPI_Cliente.addKeyListener(focus);
        this.txtDireccionCliente.addKeyListener(focus);
        this.txtNombreCliente.addKeyListener(focus);
        this.txtTelefono_cliente.addKeyListener(focus);
        this.btnGuardarDatosCliente.addKeyListener(focus);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGuardarDatosCliente;
    private javax.swing.JButton btnOutoff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spinerCredito;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDPI_Cliente;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtNITcliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtTelefono_cliente;
    // End of variables declaration//GEN-END:variables
}
