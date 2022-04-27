/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.conectionDB.ConeccionDB;
import com.backend.conectionDB.modelo.EmpleadoDB;
import com.backend.entidad.Empleado;
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
public class RegistroNuevoEmpleado extends javax.swing.JFrame {

    private TablaEmpleados tablaEmpleados;
    private Sistema sistema;
    private Empleado empleadoNuevo;
    private EmpleadoDB empleadoDB;

    /**
     * Creates new form RegistroNuevoCliente
     */
    public RegistroNuevoEmpleado(TablaEmpleados tablaEmpleados, Sistema sistema) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Nuevo empleado.");
        int tam = 25;
        Utiles.ponerIconoButton(btnOutoff, "iconos/outRed.jpeg");
        Utiles.ponerIconoButton(btnAdd, "iconos/addGreen.png", tam);
        Utiles.ponerIconoButton(btnGuardarDatosEmpleado, "iconos/saveBlue.jpeg", tam);
        Utiles.ponerIconoButton(btnCancelar, "iconos/cancel.png", tam);

        this.tablaEmpleados = tablaEmpleados;
        this.sistema = sistema;
        this.empleadoDB = new EmpleadoDB();
        establecerEnfoque();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoEmpleado = new javax.swing.JTextField();
        txtNombreEmpleado = new javax.swing.JTextField();
        txtTelefonoEmpleado = new javax.swing.JTextField();
        txtNITempleado = new javax.swing.JTextField();
        txtDPIempleado = new javax.swing.JTextField();
        txtCorreoElectronicoEmpleado = new javax.swing.JTextField();
        txtDireccionEmpleado = new javax.swing.JTextField();
        btnGuardarDatosEmpleado = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnOutoff = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de nuevo empleado");

        jLabel2.setText("Código del empleado:  *");

        jLabel3.setText("Nombre: *");

        jLabel4.setText("Teléfono: *");

        jLabel5.setText("NIT: ");

        jLabel6.setText("Correo Electónico: *");

        jLabel7.setText("DPI: *");

        jLabel8.setText("Dirección: *");

        btnGuardarDatosEmpleado.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardarDatosEmpleado.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnGuardarDatosEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarDatosEmpleado.setText("Guardar cambios");
        btnGuardarDatosEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosEmpleadoActionPerformed(evt);
            }
        });

        jLabel9.setText("*campos obligatorios");

        btnOutoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutoffActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 0, 255));
        btnAdd.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Nuevo");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOutoff, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCorreoElectronicoEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDPIempleado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNITempleado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnGuardarDatosEmpleado)
                    .addComponent(btnCancelar)
                    .addComponent(btnOutoff, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNITempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDPIempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreoElectronicoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarDatosEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosEmpleadoActionPerformed
        // TODO add your handling code here:
        if ((txtCodigoEmpleado.getText().isBlank()) || (txtNombreEmpleado.getText().isBlank()) || (txtTelefonoEmpleado.getText().isBlank())
                || (txtDPIempleado.getText().isBlank()) || (txtCorreoElectronicoEmpleado.getText().isBlank())
                || (txtDireccionEmpleado.getText().isBlank())) {
            JOptionPane.showMessageDialog(null, "Debe llenar los campos obligatorios", "CAMPOS OBLIGATORIOS", JOptionPane.INFORMATION_MESSAGE);
        } else {

            try {
                //se agrega a la base de datos
                this.empleadoDB.crearEmpleado(
                        ConeccionDB.getConnection(),
                        txtCodigoEmpleado.getText(),
                        txtNombreEmpleado.getText(),
                        txtTelefonoEmpleado.getText(),
                        txtDPIempleado.getText(),
                        txtNITempleado.getText(),
                        txtCorreoElectronicoEmpleado.getText(),
                        txtDireccionEmpleado.getText());
                JOptionPane.showMessageDialog(this, "Información gurdad exitosamente.", "Datos guardados.", JOptionPane.INFORMATION_MESSAGE);
                reiniciarCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar los datos", "Error en el servidor", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnGuardarDatosEmpleadoActionPerformed

    private void btnOutoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutoffActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnOutoffActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        tablaEmpleados.setVisible(true);
        tablaEmpleados.llenarTablaEmpleados(this.sistema.getEmpleadoDB().getEmpleados());
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        reiniciarCampos();
        System.out.println(btnAdd.getHeight());
    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        setVisible(false);
        tablaEmpleados.setVisible(true);
        tablaEmpleados.llenarTablaEmpleados(this.sistema.getEmpleadoDB().getEmpleados());
    }//GEN-LAST:event_formWindowClosed

    private void reiniciarCampos() {
        Utiles.reinicarCampos(
                txtCodigoEmpleado,
                txtCorreoElectronicoEmpleado,
                txtDPIempleado,
                txtDireccionEmpleado,
                txtNITempleado,
                txtNombreEmpleado,
                txtTelefonoEmpleado);
    }

    private void establecerEnfoque() {

        KeyListener hola = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    if (e.getComponent().equals(txtCodigoEmpleado)) {
                        txtNombreEmpleado.requestFocus();
                    } else if (e.getComponent().equals(txtNombreEmpleado)) {
                        txtTelefonoEmpleado.requestFocus();
                    } else if (e.getComponent().equals(txtTelefonoEmpleado)) {
                        txtNITempleado.requestFocus();
                    } else if (e.getComponent().equals(txtNITempleado)) {
                        txtDPIempleado.requestFocus();
                    } else if (e.getComponent().equals(txtDPIempleado)) {
                        txtCorreoElectronicoEmpleado.requestFocus();
                    } else if (e.getComponent().equals(txtCorreoElectronicoEmpleado)) {
                        txtDireccionEmpleado.requestFocus();
                    } else if (e.getComponent().equals(txtDireccionEmpleado)) {
                        btnGuardarDatosEmpleado.requestFocus();
                    }
                }
            }
        };
        this.txtCodigoEmpleado.addKeyListener(hola);
        this.txtNombreEmpleado.addKeyListener(hola);
        this.txtTelefonoEmpleado.addKeyListener(hola);
        this.txtNITempleado.addKeyListener(hola);
        this.txtDPIempleado.addKeyListener(hola);
        this.txtCorreoElectronicoEmpleado.addKeyListener(hola);
        this.txtDireccionEmpleado.addKeyListener(hola);
        this.btnGuardarDatosEmpleado.addKeyListener(hola);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarDatosEmpleado;
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
    private javax.swing.JTextField txtCodigoEmpleado;
    private javax.swing.JTextField txtCorreoElectronicoEmpleado;
    private javax.swing.JTextField txtDPIempleado;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtNITempleado;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtTelefonoEmpleado;
    // End of variables declaration//GEN-END:variables
}
