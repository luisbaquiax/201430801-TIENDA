/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.entidad.Empleado;
import com.backend.entidad.Sistema;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class ModificarEmpleado extends javax.swing.JFrame {

    private TablaEmpleados tablaEmpleados;
    private Empleado empleado;

    /**
     * Creates new form RegistroNuevoCliente
     */
    public ModificarEmpleado(TablaEmpleados tablaEmpleados, Empleado empleado) {
        initComponents();
        this.tablaEmpleados = tablaEmpleados;
        this.empleado = empleado;

        this.txtCodigoEmplead.setText(empleado.getCodigo());
        this.txtNombreEmpleado.setText(empleado.getNomgre());
        this.txtTelefonoEmpleado.setText(empleado.getTelefono());
        this.txtNITempleado.setText(empleado.getNit());
        this.txtDPIempleado.setText(empleado.getDpi());
        this.txtCorreoElectronicoEmpleado.setText(empleado.getCorreoElectronico());
        this.txtDireccionEmpleado.setText(empleado.getDireccion());

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoEmplead = new javax.swing.JTextField();
        txtNombreEmpleado = new javax.swing.JTextField();
        txtTelefonoEmpleado = new javax.swing.JTextField();
        txtNITempleado = new javax.swing.JTextField();
        txtDPIempleado = new javax.swing.JTextField();
        txtCorreoElectronicoEmpleado = new javax.swing.JTextField();
        txtDireccionEmpleado = new javax.swing.JTextField();
        btnGuardarCambios = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Modificar  un empleado");

        jLabel2.setText("Código del empleado:  *");

        jLabel3.setText("Nombre: *");

        jLabel4.setText("Teléfono: *");

        jLabel5.setText("NIT: ");

        jLabel6.setText("Correo Electónico: *");

        jLabel7.setText("DPI: *");

        jLabel8.setText("Dirección: *");

        txtCodigoEmplead.setEditable(false);

        btnGuardarCambios.setText("Guardar cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        jLabel9.setText("*campos obligatorios");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(182, 182, 182))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCorreoElectronicoEmpleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(txtDPIempleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNITempleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoEmplead, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccionEmpleado)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardarCambios)
                                .addGap(28, 28, 28)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoEmplead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNITempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDPIempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreoElectronicoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCambios)
                    .addComponent(btnSalir))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:
        if (txtNombreEmpleado.getText().isEmpty() || (txtTelefonoEmpleado.getText().isEmpty()) || (txtDPIempleado.getText().isEmpty())
                || (txtCorreoElectronicoEmpleado.getText().isEmpty()) || (txtDireccionEmpleado.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Debe llenar los campos obligatorios", "CAMPOS OBLIGATORIOS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (txtNITempleado.getText().isEmpty()) {
                this.txtNITempleado.setText("");
            }
            this.empleado.setCodigo(txtCodigoEmplead.getText());
            this.empleado.setCorreoElectronico(txtCorreoElectronicoEmpleado.getText());
            this.empleado.setDireccion(txtDireccionEmpleado.getText());
            this.empleado.setDpi(txtDPIempleado.getText());
            this.empleado.setNit(txtNITempleado.getText());
            this.empleado.setNomgre(txtNombreEmpleado.getText());
            this.empleado.setTelefono(txtTelefonoEmpleado.getText());

        }
        this.txtCorreoElectronicoEmpleado.setText("");
        this.txtDPIempleado.setText("");
        this.txtDireccionEmpleado.setText("");
        this.txtNITempleado.setText("");
        this.txtNombreEmpleado.setText("");
        this.txtTelefonoEmpleado.setText("");
        
        this.tablaEmpleados.repaint();
        this.tablaEmpleados.revalidate();
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.tablaEmpleados.setVisible(true);
        super.setVisible(false);
        this.tablaEmpleados.llenarTablaEmpleados();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCodigoEmplead;
    private javax.swing.JTextField txtCorreoElectronicoEmpleado;
    private javax.swing.JTextField txtDPIempleado;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtNITempleado;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtTelefonoEmpleado;
    // End of variables declaration//GEN-END:variables
}
