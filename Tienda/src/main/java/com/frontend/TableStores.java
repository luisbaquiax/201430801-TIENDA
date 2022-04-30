/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.conectionDB.ConeccionDB;
import com.backend.conectionDB.modelo.TiendaDB;
import com.backend.entidad.Sistema;
import com.backend.entidad.Tienda;
import com.tienda.utiles.Utiles;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public final class TableStores extends javax.swing.JFrame {

    private VentanaTienda ventanaTienda;
    private Sistema sistema;

    private DefaultTableModel dfm;

    /**
     *
     * @param ventanaTienda
     * @param sistema
     */
    public TableStores(VentanaTienda ventanaTienda, Sistema sistema) {
        initComponents();
        Utiles.ponerIconoButton(btnRegresar, "iconos/back.png");
        this.ventanaTienda = ventanaTienda;
        this.sistema = sistema;

        llenarTablaTiendas(sistema.getTiendaDB().getTiendas(TiendaDB.SELECT_TIENDAS));

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        scrollTablaEmpleados = new javax.swing.JScrollPane();
        tableListaEmpleados = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMostarTiendas = new javax.swing.JButton();
        btnOrdenarTiendas = new javax.swing.JButton();
        txtFiltroCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFiltroNombre = new javax.swing.JTextField();
        btnOrdenarTiendasDES = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tableListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dirección", "Código", "Teléfono1", "Teléfono 2", "E-mail", "Horario"
            }
        ));
        scrollTablaEmpleados.setViewportView(tableListaEmpleados);

        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de tiendas");

        btnMostarTiendas.setText("Mostrar todas las tiendas");
        btnMostarTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarTiendasActionPerformed(evt);
            }
        });

        btnOrdenarTiendas.setText("Ordenar ASC");
        btnOrdenarTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarTiendasActionPerformed(evt);
            }
        });

        txtFiltroCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroCodigoKeyReleased(evt);
            }
        });

        jLabel2.setText("Buscar tienda por codigo (filtrado):");

        jLabel3.setText("Buscar tienda filtrando el nombre:");

        txtFiltroNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroNombreKeyReleased(evt);
            }
        });

        btnOrdenarTiendasDES.setText("Ordenar DES");
        btnOrdenarTiendasDES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarTiendasDESActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnMostarTiendas)
                .addGap(18, 18, 18)
                .addComponent(btnOrdenarTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenarTiendasDES, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiltroCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(324, 324, 324))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTablaEmpleados)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostarTiendas)
                    .addComponent(jLabel2)
                    .addComponent(txtFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenarTiendas)
                    .addComponent(btnOrdenarTiendasDES))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTablaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnMostarTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarTiendasActionPerformed
        // TODO add your handling code here:
        this.dfm.setRowCount(0);
        llenarTablaTiendas(sistema.getTiendaDB().getTiendas(TiendaDB.SELECT_TIENDAS));

    }//GEN-LAST:event_btnMostarTiendasActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        super.setVisible(false);
        this.ventanaTienda.setVisible(true);

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnOrdenarTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarTiendasActionPerformed

        dfm.setRowCount(0);
        try {
            this.sistema.getTiendaDB().buscarTiendaCodigo(ConeccionDB.getConnection(), txtFiltroNombre.getText(), dfm, TiendaDB.SEARCH_TIENDA_BY_NOMBRE_ASC);
        } catch (SQLException ex) {
            Logger.getLogger(TableStores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOrdenarTiendasActionPerformed

    private void txtFiltroCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroCodigoKeyReleased
        // TODO add your handling code here:
        this.dfm.setRowCount(0);
        try {
            this.sistema.getTiendaDB().buscarTiendaCodigo(ConeccionDB.getConnection(), txtFiltroCodigo.getText(), dfm, TiendaDB.SEARCH_TIENDA_BY_CODIGO_ASC);
        } catch (SQLException ex) {
            Logger.getLogger(TableStores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroCodigoKeyReleased

    private void txtFiltroNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNombreKeyReleased
        // TODO add your handling code here:
        this.dfm.setRowCount(0);
        try {
            this.sistema.getTiendaDB().buscarTiendaNombre(ConeccionDB.getConnection(), txtFiltroNombre.getText(), dfm, TiendaDB.SEARCH_TIENDA_BY_NOMBRE_ASC);
        } catch (SQLException ex) {
            Logger.getLogger(TableStores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroNombreKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        setVisible(false);
        this.ventanaTienda.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnOrdenarTiendasDESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarTiendasDESActionPerformed
        // TODO add your handling code here:
        dfm.setRowCount(0);
        try {
            this.sistema.getTiendaDB().buscarTiendaCodigo(ConeccionDB.getConnection(), txtFiltroNombre.getText(), dfm, TiendaDB.SEARCH_TIENDA_BY_NOMBRE_DESC);
        } catch (SQLException ex) {
            Logger.getLogger(TableStores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOrdenarTiendasDESActionPerformed

    public void llenarTablaTiendas(List<Tienda> tiendas) {
        dfm = (DefaultTableModel) tableListaEmpleados.getModel();
        for (Tienda t : tiendas) {

            String[] datos = {t.getNombreTienda(),
                t.getDireccion(),
                t.getCodigo(),
                t.getTelefono(),
                t.getTelefono2(),
                t.getCorreoElectronico(),
                t.getHorario()
            };
            dfm.addRow(datos);
        }
    }

    public JTable getTablesListaEmpleados() {
        return tableListaEmpleados;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostarTiendas;
    private javax.swing.JButton btnOrdenarTiendas;
    private javax.swing.JButton btnOrdenarTiendasDES;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollTablaEmpleados;
    private javax.swing.JTable tableListaEmpleados;
    private javax.swing.JTextField txtFiltroCodigo;
    private javax.swing.JTextField txtFiltroNombre;
    // End of variables declaration//GEN-END:variables
}
