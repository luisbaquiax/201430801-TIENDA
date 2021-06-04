/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.entidad.Sistema;
import com.backend.entidad.TiempoDeEnvio;
import com.backend.entidad.Tienda;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class VerificadorTiempoEnvio extends javax.swing.JFrame {

    private Sistema sistema;
    private VentanaTienda ventanaTienda;
    private Tienda tiendaActual;
    private Tienda tiendaViendo;
    private TiendaDatos tiendaDatos;

    private DefaultTableModel dfm;

    /**
     * Creates new form VerifidorTiempoEnvio
     *
     * @param sistema
     * @param ventanaTienda
     * @param tiendaActual
     */
    public VerificadorTiempoEnvio(VentanaTienda ventanaTienda, Sistema sistema, Tienda tiendaActual) {

        initComponents();
        this.ventanaTienda = ventanaTienda;
        this.sistema = sistema;
        this.tiendaActual = tiendaActual;

        llenarTablaTiempos();
        agregarItems();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTiemposEnvio = new javax.swing.JTable();
        btnVerDatosTienda = new javax.swing.JButton();
        btnOrdenarEnvio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comoTiendas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAgrearTiempo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        spinerTiempoDeEnvio = new javax.swing.JSpinner();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableTiemposEnvio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tienda Origen (actual)", "Tiempo de envío (días)", "Tienda Destino"
            }
        ));
        jScrollPane1.setViewportView(tableTiemposEnvio);

        btnVerDatosTienda.setText("Ver datos de la tienda");
        btnVerDatosTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDatosTiendaActionPerformed(evt);
            }
        });

        btnOrdenarEnvio.setText("Ordenar por tiempo de envío");
        btnOrdenarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarEnvioActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione la tienda");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("Tiempo de envío");

        comoTiendas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tienda destino" }));

        jLabel3.setText("Seleccione la tienda destino");

        btnAgrearTiempo.setText("Agregar tiempo");
        btnAgrearTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrearTiempoActionPerformed(evt);
            }
        });

        jLabel4.setText("De la tienda nuevas");

        spinerTiempoDeEnvio.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnSalir.setText("Salir / regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnOrdenarEnvio)
                .addGap(60, 60, 60)
                .addComponent(btnVerDatosTienda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgrearTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(spinerTiempoDeEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comoTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(283, 283, 283))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(305, 305, 305))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(219, 219, 219))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerDatosTienda)
                    .addComponent(btnOrdenarEnvio)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comoTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgrearTiempo)
                    .addComponent(spinerTiempoDeEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnOrdenarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarEnvioActionPerformed
        // TODO add your handling code here:
        dfm.setRowCount(0);
        this.sistema.ordenarTiempoDeEnvio();
        llenarTablaTiempos();

    }//GEN-LAST:event_btnOrdenarEnvioActionPerformed

    private void btnVerDatosTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDatosTiendaActionPerformed
        // TODO add your handling code here:
        int fila = this.tableTiemposEnvio.getSelectedRow();
        if (fila > -1) {
            String codigoTiendaDestino = String.valueOf(dfm.getValueAt(fila, 2));
            this.tiendaViendo = this.sistema.buscarTienda(codigoTiendaDestino);
            this.tiendaDatos = new TiendaDatos(this, tiendaViendo, sistema);
            this.tiendaDatos.setVisible(true);
            super.setVisible(false);
        }
    }//GEN-LAST:event_btnVerDatosTiendaActionPerformed

    private void btnAgrearTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrearTiempoActionPerformed
        // TODO add your handling code here:
        String tiendaSelecciona = comoTiendas.getSelectedItem().toString();
        int timpoDeEnvio = (int) spinerTiempoDeEnvio.getValue();
        String tiempoEnvio = String.valueOf(timpoDeEnvio);

        if (tiendaSelecciona.equals("Tienda destino")) {
            JOptionPane.showMessageDialog(null, "Seleccione la tienda destino");
        } else {
            this.sistema.agregarTiempoDeEnvio(new TiempoDeEnvio(this.tiendaActual.getCodigo(), tiendaSelecciona, tiempoEnvio));
            dfm.setRowCount(0);
            llenarTablaTiempos();
        }
    }//GEN-LAST:event_btnAgrearTiempoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.ventanaTienda.setVisible(true);
        //llenarTablaTiempos();
        super.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    public void llenarTablaTiempos() {
        dfm = (DefaultTableModel) tableTiemposEnvio.getModel();
        for (TiempoDeEnvio tiempos : this.sistema.getTiemposDeEnvio()) {
            if (tiempos.getCodigoTIENDA1().equals(this.tiendaActual.getCodigo())) {
                String[] datos = {tiempos.getCodigoTIENDA1(),
                    tiempos.getTiempoEnvio() + "",
                    tiempos.getCodigoTIENDA2()

                };
                dfm.addRow(datos);
            }
        }
    }

    public void agregarItems() {
        for (Tienda tienda : this.sistema.getTiendas()) {
            if (tienda.getCodigo() != this.tiendaActual.getCodigo()) {
                this.comoTiendas.addItem(tienda.getCodigo());
            }

        }
    }

    public DefaultTableModel getDfm() {
        return dfm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgrearTiempo;
    private javax.swing.JButton btnOrdenarEnvio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerDatosTienda;
    private javax.swing.JComboBox<String> comoTiendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinerTiempoDeEnvio;
    private javax.swing.JTable tableTiemposEnvio;
    // End of variables declaration//GEN-END:variables
}
