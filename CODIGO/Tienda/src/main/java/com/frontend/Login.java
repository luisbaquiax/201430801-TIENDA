/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.conection.Conection;
import com.frontend.cliente.CatalogoProductos;
import com.backend.entidad.Cliente;
import com.backend.entidad.Empleado;
import com.backend.entidad.FechaPedido;
import com.backend.entidad.Pedido;
import com.backend.entidad.Producto;
import com.backend.entidad.Sistema;
import com.backend.entidad.TiempoDeEnvio;
import com.backend.entidad.Tienda;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Luis
 */
public class Login extends javax.swing.JFrame {

    private Sistema sistema;
    private Tienda tienda;
    private TiempoDeEnvio tiempoDeEnvio;
    private Producto producto;
    private Cliente cliente;
    private Empleado empleado;
    private Pedido pedido;

    private FechaPedido fechaPedido;

    private CatalogoProductos ventanaCliente;
    private VentanaEmpleado ventanaEmpleado;

    private int informacionCargada = 0;

    //private Conection conection;
    /**
     *
     * @param principal
     */
    public Login() throws SQLException {
        initComponents();

        setTitle(" INICIAR SESIÓN ");
        //BORDE DE COMPONENTES
        Border borde = BorderFactory.createLineBorder(Color.BLACK);
        this.txtEMPLEADO.setBorder(borde);
        this.txtIngresarCliente.setBorder(borde);

        this.sistema = new Sistema();

        //this.conection = new Conection();
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
        txtEMPLEADO = new javax.swing.JTextField();
        btnaCancelar = new javax.swing.JButton();
        btnIniciarSesionEmpleado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIngresarCliente = new javax.swing.JTextField();
        btnIngresarCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCargarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Iniciar Sesión");

        jLabel2.setText("Empleado:");

        btnaCancelar.setText("Cancelar");
        btnaCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaCancelarActionPerformed(evt);
            }
        });

        btnIniciarSesionEmpleado.setText("Iniciar Sesión");
        btnIniciarSesionEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionEmpleadoActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        btnIngresarCliente.setText("Ingresar como cliente");
        btnIngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Ingrese su codigo de empleado");

        jLabel5.setText("Ingrese su NIT:");

        btnCargarDatos.setText("CARGAR DATOS");
        btnCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEMPLEADO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnIngresarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCargarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIniciarSesionEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(btnaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnIniciarSesionEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCargarDatos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEMPLEADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(69, 69, 69))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIngresarCliente))
                        .addGap(18, 18, 18)
                        .addComponent(btnaCancelar)
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnaCancelarActionPerformed

    private void btnIniciarSesionEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionEmpleadoActionPerformed
        // TODO add your handling code here:

        try {

            if (this.txtEMPLEADO.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "INGRESE SU CODIGO", "INGRESAR CODIGO", JOptionPane.INFORMATION_MESSAGE);
            } else if (txtEMPLEADO.getText().equalsIgnoreCase("admin") || txtEMPLEADO.getText()
                    .equalsIgnoreCase(this.sistema.buscarEmpleado(this.txtEMPLEADO.getText()).getCodigo())) {
                this.ventanaEmpleado = new VentanaEmpleado(this, this.sistema);
                this.ventanaEmpleado.setVisible(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CÓDIGO INCORRECTO", "INGRESAR CODIGO", JOptionPane.INFORMATION_MESSAGE);
        }
        this.txtEMPLEADO.setText("");
    }//GEN-LAST:event_btnIniciarSesionEmpleadoActionPerformed

    private void btnIngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarClienteActionPerformed
        // TODO add your handling code here:
        if (txtIngresarCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese su NIT ", "INGRESAR NIT-CLIENTE", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Cliente clienteBuscado = this.sistema.buscarCliente(txtIngresarCliente.getText());
            if (clienteBuscado == null) {
                JOptionPane.showMessageDialog(null, "Usted no está registrado como cliente");
            } else {
                if (txtIngresarCliente.getText().equals(clienteBuscado.getNit())) {
                    this.ventanaCliente = new CatalogoProductos(this, sistema, clienteBuscado);
                    this.ventanaCliente.setVisible(true);
                    super.setVisible(false);
                }
            }
        }
        this.txtIngresarCliente.setText("");

    }//GEN-LAST:event_btnIngresarClienteActionPerformed

    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosActionPerformed
        // TODO add your handling code here:

        try {
            if (informacionCargada == 0) {

                if (this.txtEMPLEADO.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "CÓDIGO INCORRECTO", "INGRESAR CODIGO", JOptionPane.INFORMATION_MESSAGE);
                } else if (txtEMPLEADO.getText().equalsIgnoreCase("admin")) {

                    cargarDatos();
                } else if (txtEMPLEADO.getText()
                        .equals(this.sistema.buscarEmpleado(this.txtEMPLEADO.getText()).getCodigo())) {

                    cargarDatos();
                }
            } else {
                JOptionPane.showMessageDialog(null, "DATOS CARGADOS", "CARGA DE DATOS", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CÓDIGO INCORRECTO", "INGRESAR CODIGO", JOptionPane.INFORMATION_MESSAGE);
        }
        this.txtEMPLEADO.setText("");


    }//GEN-LAST:event_btnCargarDatosActionPerformed

    private void cargarDatos() {

        JFileChooser seleccionar = new JFileChooser();

        int selecionado = seleccionar.showOpenDialog(this);

        if (selecionado == JFileChooser.APPROVE_OPTION) {
            File archivo = seleccionar.getSelectedFile();

            try {
                FileReader leerArchivo = new FileReader(archivo.getAbsoluteFile());

                BufferedReader leyendo = new BufferedReader(leerArchivo);//para leer linea por linea

                String linea = "";

                String datos = "";

                while (linea != null) {
                    linea = leyendo.readLine();
                    datos += linea + "\n";

                }
                String[] lineas = datos.split("\n");

                for (int i = 0; i < lineas.length; i++) {

                    String[] infLinea = lineas[i].split(",");
                    if (infLinea[0].equalsIgnoreCase("tienda")) {
                        this.tienda = new Tienda(infLinea[1], infLinea[2], infLinea[3], infLinea[4]);
                        this.sistema.getTiendas().add(tienda);
                        this.sistema.getConection().crearTienda(sistema.getConection().getConnection(), tienda.getCodigo(), tienda.getNombreTienda(), tienda.getDireccion(),
                                tienda.getTelefono(), tienda.getTelefono2(), tienda.getCorreoElectronico(), tienda.getHorario());
                    } else if (infLinea[0].equalsIgnoreCase("tiempo")) {
                        this.tiempoDeEnvio = new TiempoDeEnvio(infLinea[1], infLinea[2], infLinea[3]);
                        this.sistema.getTiemposDeEnvio().add(tiempoDeEnvio);
                    } else if (infLinea[0].equalsIgnoreCase("producto")) {
                        this.producto = new Producto(infLinea[1], infLinea[2], infLinea[3], infLinea[4], infLinea[5], infLinea[6]);
                        this.sistema.getProductos().add(producto);
                    } else if (infLinea[0].equalsIgnoreCase("empleado")) {
                        this.empleado = new Empleado(infLinea[1], infLinea[2], infLinea[3], infLinea[4]);
                        this.sistema.getEmpleados().add(empleado);
                    } else if (infLinea[0].equalsIgnoreCase("cliente")) {
                        this.cliente = new Cliente(infLinea[1], infLinea[2], infLinea[3], infLinea[4]);
                        this.sistema.getClientes().add(cliente);
                    } else if (infLinea[0].equalsIgnoreCase("pedido")) {
                        String[] fecha = infLinea[4].split("-");
                        this.fechaPedido = new FechaPedido(fecha[0], fecha[1], fecha[2]);
                        this.pedido = new Pedido(infLinea[1], infLinea[2], infLinea[3], fechaPedido, infLinea[5], infLinea[6], infLinea[7], infLinea[8], infLinea[9]);
                        this.sistema.getPedidos().add(pedido);
                    }
                }
                informacionCargada++;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
//        this.sistema.mostraTiendas();
//        System.out.println("");
//        this.sistema.mostrarPedidos();
//        System.out.println("");
//        this.sistema.mostrarClinetes();
//        System.out.println("");
//        this.sistema.mostrarEmpleados();
//        System.out.println("");
//        this.sistema.mostrarProductos();
//        System.out.println("");
//        this.sistema.mostrarTiemposDeEnvio();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarDatos;
    private javax.swing.JButton btnIngresarCliente;
    private javax.swing.JButton btnIniciarSesionEmpleado;
    private javax.swing.JButton btnaCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtEMPLEADO;
    private javax.swing.JTextField txtIngresarCliente;
    // End of variables declaration//GEN-END:variables
}
