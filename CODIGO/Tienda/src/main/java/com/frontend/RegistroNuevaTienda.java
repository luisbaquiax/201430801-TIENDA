/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.entidad.Sistema;
import com.backend.entidad.TiempoDeEnvio;
import com.backend.entidad.Tienda;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class RegistroNuevaTienda extends javax.swing.JFrame {

    private VentanaTienda ventanaTienda;
    private VentanaEmpleado ventanaEmpleado;
    private VerificadorTiempoEnvio vrEnvio;
    private Sistema sistema;
    private Tienda tiendaNueva;
    private TiempoDeEnvio tiempoDeEnvioNueva;

    /**
     *
     * @param ventanaTienda
     * @param ventanaEmpleado
     * @param vrEnvio
     * @param sistema
     */
    public RegistroNuevaTienda(VentanaTienda ventanaTienda, VentanaEmpleado ventanaEmpleado, VerificadorTiempoEnvio vrEnvio, Sistema sistema) {
        initComponents();
        this.ventanaTienda = ventanaTienda;
        this.ventanaEmpleado = ventanaEmpleado;
        this.sistema = sistema;

        this.sistema.agregarItemsTienda(comboTiendas);

        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String cadena = "";
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
        txtNombreTienda = new javax.swing.JTextField();
        txtDireccionTienda = new javax.swing.JTextField();
        txtCodigoTienda = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtTelefono2 = new javax.swing.JTextField();
        txtCorreoElectronico = new javax.swing.JTextField();
        txtHORARIO = new javax.swing.JTextField();
        btnGuardarDatosCliente = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        comboTiendas = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnAgregarTiempo = new javax.swing.JButton();
        spinerTiempoEnvío = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Registro de nueva tienda");

        jLabel2.setText("Nombre: *");

        jLabel3.setText("Dirección: *");

        jLabel4.setText("Código: *");

        jLabel5.setText("Teléfono 1: *");

        jLabel6.setText("Correo Electónico:");

        jLabel7.setText("Teléfono 2: ");

        jLabel8.setText("Horario:");

        btnGuardarDatosCliente.setText("Guardar cambios");
        btnGuardarDatosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosClienteActionPerformed(evt);
            }
        });

        jLabel9.setText("*campos obligatorios");

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        comboTiendas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lista tiendas (código)" }));

        jLabel10.setText("Tieda destino");

        btnAgregarTiempo.setText("Agregar tiempo de envío");
        btnAgregarTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTiempoActionPerformed(evt);
            }
        });

        spinerTiempoEnvío.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1)
                        .addGap(152, 152, 152))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtCodigoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtNombreTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDireccionTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(360, 360, 360)
                                            .addComponent(btnRegresar)))
                                    .addComponent(txtHORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(comboTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnAgregarTiempo)
                                .addGap(46, 46, 46)
                                .addComponent(btnGuardarDatosCliente)
                                .addGap(51, 51, 51))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(spinerTiempoEnvío, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarTiempo)
                    .addComponent(btnGuardarDatosCliente))
                .addGap(20, 20, 20)
                .addComponent(spinerTiempoEnvío, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btnRegresar))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccionTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHORARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarDatosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosClienteActionPerformed
        // TODO add your handling code here:
        if (txtNombreTienda.getText().isEmpty() || (txtDireccionTienda.getText().isEmpty())
                || (txtCodigoTienda.getText().isEmpty()) || (txtTelefono.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Llene los campos obligatorios");
        } else {
            if (txtTelefono2.getText().isEmpty()) {
                this.txtTelefono2.setText("");
                if (txtCorreoElectronico.getText().isEmpty()) {
                    this.txtCorreoElectronico.setText("No hay correo");
                    if (txtHORARIO.getText().isEmpty()) {
                        this.txtHORARIO.setText("");
                    }
                }
            }
            //se crea una instancia de la clase tienda y se agrega al sistema como nueva tienda
            this.tiendaNueva = new Tienda(txtNombreTienda.getText(), txtDireccionTienda.getText(), txtCodigoTienda.getText(), txtTelefono.getText(), txtTelefono2.getText(),
                    txtCorreoElectronico.getText(), txtHORARIO.getText());
            this.sistema.agregarTiendaNueva(tiendaNueva);
            this.ventanaEmpleado.getComboTiendas().addItem(tiendaNueva.getCodigo());
            tiendaNueva.mostrarDatos();
        }
        this.txtCodigoTienda.setText("");
        this.txtCorreoElectronico.setText("");
        this.txtDireccionTienda.setText("");
        this.txtHORARIO.setText("");
        this.txtNombreTienda.setText("");
        this.txtTelefono.setText("");
        this.txtTelefono2.setText("");


    }//GEN-LAST:event_btnGuardarDatosClienteActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        super.setVisible(false);
        //this.vrEnvio.getDfm().setRowCount(0);
        this.ventanaTienda.setVisible(true);
        //this.vrEnvio.llenarTablaTiempos();

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTiempoActionPerformed
        // TODO add your handling code here:
        String tiendaDestino = comboTiendas.getSelectedItem().toString();
        int tiempoDeEnvio = (int) spinerTiempoEnvío.getValue();
        String tiempo = String.valueOf(tiempoDeEnvio);
        if (tiendaDestino.equalsIgnoreCase("Lista tiendas (código)")) {
            JOptionPane.showMessageDialog(null, "Selecione la tienda destino", "SELECCIONAR DESTINO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (this.tiendaNueva != null) {
                String codigoNuevaTienda = tiendaNueva.getCodigo();
                this.tiempoDeEnvioNueva = new TiempoDeEnvio(codigoNuevaTienda, tiendaDestino, tiempo);
                this.sistema.agregarTiempoDeEnvio(tiempoDeEnvioNueva);
                this.tiempoDeEnvioNueva.mostrarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "Guarde los cambios", "GUARDE DATOS", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAgregarTiempoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTiempo;
    private javax.swing.JButton btnGuardarDatosCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboTiendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner spinerTiempoEnvío;
    private javax.swing.JTextField txtCodigoTienda;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDireccionTienda;
    private javax.swing.JTextField txtHORARIO;
    private javax.swing.JTextField txtNombreTienda;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono2;
    // End of variables declaration//GEN-END:variables
}
