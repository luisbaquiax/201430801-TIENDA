/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.conectionDB.modelo.EnvioDB;
import com.backend.entidad.Sistema;
import com.backend.entidad.TiempoDeEnvio;
import com.backend.entidad.Tienda;
import com.tienda.utiles.Utiles;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public final class VerificadorTiempoEnvio extends javax.swing.JFrame {

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
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/tiendaIcono.png")));
        Utiles utiles = new Utiles();
        utiles.ponerIconoButton(btnSalir, "/iconos/exit.png");
        this.ventanaTienda = ventanaTienda;
        this.sistema = sistema;
        this.tiendaActual = tiendaActual;

        llenarTablaTiempos(this.sistema.getEnvioDB().getEnviosEntreTiendas(tiendaActual.getCodigo(), EnvioDB.ENVIOS_TIENDA_ACTUAL));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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
        btnOrdenarEnvio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        tableTiemposEnvio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tienda Origen", "Tiempo de envío (días)", "Tienda Destino", "Ver tienda", "Modificar Tiempo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTiemposEnvio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTiemposEnvioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTiemposEnvio);

        btnOrdenarEnvio.setBackground(new java.awt.Color(0, 0, 255));
        btnOrdenarEnvio.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenarEnvio.setText("Ordenar por tiempo de envío");
        btnOrdenarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarEnvioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tiempo de envío");

        btnSalir.setBackground(new java.awt.Color(0, 0, 255));
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnOrdenarEnvio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrdenarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarEnvioActionPerformed
        // TODO add your handling code here:
        dfm.setRowCount(0);
        llenarTablaTiempos(this.sistema.getEnvioDB().getEnviosEntreTiendas(this.tiendaActual.getCodigo(), EnvioDB.ENVIOS_TIENDA_ACTUAL_ORDER_BY_TIEMPO_ENVIO_ASC));

    }//GEN-LAST:event_btnOrdenarEnvioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.ventanaTienda.setVisible(true);
        super.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tableTiemposEnvioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTiemposEnvioMouseClicked
        // TODO add your handling code here:
        int fila = this.tableTiemposEnvio.getSelectedRow();
        int columna = this.tableTiemposEnvio.getSelectedColumn();
        if (columna == 3) {
            JOptionPane.showMessageDialog(
                    this,
                    this.sistema.getTiendaDB()
                            .getTiendaByCodigo(
                                    this.sistema.getEnvioDB()
                                            .getEnviosEntreTiendas(
                                                    this.tiendaActual.getCodigo(), EnvioDB.ENVIOS_TIENDA_ACTUAL).get(fila).getCodigoTIENDA1()).toString()
                    + "\n"
                    + this.sistema.getTiendaDB()
                            .getTiendaByCodigo(
                                    this.sistema.getEnvioDB()
                                            .getEnviosEntreTiendas(
                                                    this.tiendaActual.getCodigo(), EnvioDB.ENVIOS_TIENDA_ACTUAL).get(fila).getCodigoTIENDA2()).toString(),
                    "Tiendas",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (columna == 4) {
            ModificadorTiempoEnvio modificadorTiempoEnvio = new ModificadorTiempoEnvio(
                    sistema, this.sistema.getEnvioDB()
                            .getEnviosEntreTiendas(
                                    this.tiendaActual.getCodigo(), EnvioDB.ENVIOS_TIENDA_ACTUAL).get(fila),
                    this, tiendaActual);
            modificadorTiempoEnvio.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_tableTiemposEnvioMouseClicked

    public void llenarTablaTiempos(List<TiempoDeEnvio> envios) {
        dfm = (DefaultTableModel) tableTiemposEnvio.getModel();
        for (TiempoDeEnvio tiempos : envios) {
            if (tiendaActual.getCodigo().equalsIgnoreCase(tiempos.getCodigoTIENDA1())) {
                String[] datos = {
                    tiempos.getCodigoTIENDA1() + " (actual)",
                    tiempos.getTiempoEnvio() + "",
                    tiempos.getCodigoTIENDA2(),
                    "Ver tienda",
                    "Modificar"

                };
                dfm.addRow(datos);

            } else if (tiendaActual.getCodigo().equalsIgnoreCase(tiempos.getCodigoTIENDA2())) {
                String[] datos = {
                    tiempos.getCodigoTIENDA1(),
                    tiempos.getTiempoEnvio() + "",
                    tiempos.getCodigoTIENDA2() + " (actual)",
                    "Ver tienda",
                    "Modificar"
                };
                dfm.addRow(datos);

            } else {
                String[] datos = {
                    tiempos.getCodigoTIENDA1(),
                    tiempos.getTiempoEnvio() + "",
                    tiempos.getCodigoTIENDA2(),
                    "Ver tienda",
                    "Modificar"
                };
                dfm.addRow(datos);

            }
        }
    }

    public DefaultTableModel getDfm() {
        return dfm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrdenarEnvio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTiemposEnvio;
    // End of variables declaration//GEN-END:variables
}
