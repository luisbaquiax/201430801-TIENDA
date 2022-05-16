/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.conectionDB.modelo.productoExistencia.ProductoExistenciaDB;
import com.backend.entidad.*;
import com.frontend.venta.VentaForm;
import com.tienda.utiles.Utiles;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public final class VentanaTienda extends javax.swing.JFrame {

    private VentanaEmpleado ventanaEmpleado;
    private Sistema sistema;
    private String tiendaSeleccionada;
    private Empleado empleado;

    private RegistroNuevoProducto registroNuevoProducto;
    private RegistroNuevaTienda registroNuevaTienda;
    private TableStores tableStores;
    private VerificadorTiempoEnvio verifidorTiempoEnvio;
    private Tienda tiendaActual;
    private ReportWindow reportWindow;

    private DefaultTableModel dfm;

    /**
     * Creates new form VentanaTienda
     *
     * @param ventanaEmpleado
     * @param sistema
     * @param tiendaSeleccionada
     * @param empleado
     */
    public VentanaTienda(VentanaEmpleado ventanaEmpleado, Sistema sistema, String tiendaSeleccionada, Empleado empleado) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/tiendaIcono.png")));
        this.jTabbedPane1.setSelectedIndex(1);
        Utiles utiles = new Utiles();
        int tam = 35;
        labelPerfil.setFocusable(true);
        utiles.ponerIconoButton(btnRegitroTienda, "/iconos/store.png", tam);
        utiles.ponerIconoButton(btnAllProducts, "/iconos/newProducto.jpeg", tam);
        utiles.ponerIconoButton(btnNewProduct, "/iconos/addGreen.png", tam);
        utiles.ponerIconoButton(btnProducts, "/iconos/lis.png", tam);
        utiles.ponerIconoButton(btnTablaTiendas, "/iconos/lis.png", tam);
        utiles.ponerIconoButton(btnReportes, "/iconos/report.png", tam);
        utiles.ponerIconoButton(btnVentas, "/iconos/ventas.png", tam);
        utiles.ponerIconoButton(btnVERtiempoEnvio, "/iconos/time.png", tam);
        utiles.ponerIconoLabel(labelPerfil, "/iconos/user.jpeg");
        utiles.ponerIconoLabel(labelEntregaPedidos, "/iconos/hacer-un-pedido.png");
        this.labelNameUser.setText("Usuario: " + empleado.getCodigo());
        this.ventanaEmpleado = ventanaEmpleado;
        this.sistema = sistema;
        this.tiendaSeleccionada = tiendaSeleccionada;
        this.tiendaActual = this.sistema.getTiendaDB().getTiendaByCodigo(tiendaSeleccionada);
        this.empleado = empleado;
        llenarTableProductosTienda(sistema.getProductoExistenciaDB().getAllProductosByTienda(tiendaSeleccionada));

        super.setTitle("                 TIENDA: " + tiendaActual.getNombreTienda());
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.txtFiltroNOMBRE.setToolTipText("Búsqueda por nombre");
        this.txtFiltroCodigo.setToolTipText("Búsqueda por código");
        this.txtFiltroTIenda.setToolTipText("Búsqueda por código de tienda");
        this.btnMostrarTodosProductos.setToolTipText("Pulse el botón para ver todos los productos");
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
        panelTienda = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFiltroNOMBRE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFiltroCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFiltroTIenda = new javax.swing.JTextField();
        btnMostrarTodosProductos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        txtFechaSistema = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTiendaEnCuestion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnRegitroTienda = new javax.swing.JButton();
        btnAllProducts = new javax.swing.JButton();
        btnTablaTiendas = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        labelPerfil = new javax.swing.JLabel();
        labelNameUser = new javax.swing.JLabel();
        btnVERtiempoEnvio = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnNewProduct = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        panelEntregaPedidos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelEntregaPedidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        panelTienda.setBackground(new java.awt.Color(0, 0, 0));

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRODUCTOS");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Filtrar nombre: ");

        txtFiltroNOMBRE.setToolTipText("");
        txtFiltroNOMBRE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroNOMBREKeyReleased(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Filtar código:");

        txtFiltroCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroCodigoKeyReleased(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Filtrar codigo de tienda:");

        txtFiltroTIenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroTIendaKeyReleased(evt);
            }
        });

        btnMostrarTodosProductos.setText("Mostrar todos los productos");
        btnMostrarTodosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodosProductosActionPerformed(evt);
            }
        });

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "TIENDA (codigo)", "FABRICANTE", "CANTIDAD", "PRECIO", "DESCRIPCIÓN", "GARANTÍA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableProducts);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1482, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroTIenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarTodosProductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtFiltroNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtFiltroTIenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMostrarTodosProductos))
                    .addComponent(txtFechaSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos");

        tableTiendaEnCuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Codigo", "Fabricante", "Cantidad", "Precio Unitario", "Editar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTiendaEnCuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTiendaEnCuestionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableTiendaEnCuestion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1470, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", jPanel4);

        javax.swing.GroupLayout panelTiendaLayout = new javax.swing.GroupLayout(panelTienda);
        panelTienda.setLayout(panelTiendaLayout);
        panelTiendaLayout.setHorizontalGroup(
            panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelTiendaLayout.setVerticalGroup(
            panelTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        btnRegitroTienda.setBackground(new java.awt.Color(0, 0, 255));
        btnRegitroTienda.setForeground(new java.awt.Color(255, 255, 255));
        btnRegitroTienda.setText("Nueva tienda");
        btnRegitroTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegitroTiendaActionPerformed(evt);
            }
        });

        btnAllProducts.setBackground(new java.awt.Color(0, 0, 255));
        btnAllProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnAllProducts.setText("Ver todos los productos");
        btnAllProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllProductsActionPerformed(evt);
            }
        });

        btnTablaTiendas.setBackground(new java.awt.Color(0, 0, 255));
        btnTablaTiendas.setForeground(new java.awt.Color(255, 255, 255));
        btnTablaTiendas.setText("Ver tiendas");
        btnTablaTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaTiendasActionPerformed(evt);
            }
        });

        btnVentas.setBackground(new java.awt.Color(0, 0, 255));
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        labelPerfil.setPreferredSize(new java.awt.Dimension(89, 89));

        labelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        labelNameUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameUser.setText("Usuario");

        btnVERtiempoEnvio.setBackground(new java.awt.Color(0, 0, 255));
        btnVERtiempoEnvio.setForeground(new java.awt.Color(255, 255, 255));
        btnVERtiempoEnvio.setText("Ver tiempo de envío a otras tiendas");
        btnVERtiempoEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVERtiempoEnvioActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(0, 0, 255));
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnNewProduct.setBackground(new java.awt.Color(0, 0, 255));
        btnNewProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnNewProduct.setText("Nuevo producto");
        btnNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProductActionPerformed(evt);
            }
        });

        btnProducts.setBackground(new java.awt.Color(0, 0, 255));
        btnProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnProducts.setText("Productos");
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(204, 0, 0));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opción", "Regresar", "Salir" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        panelEntregaPedidos.setBackground(new java.awt.Color(0, 0, 255));
        panelEntregaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEntregaPedidosMouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Entrega de pedidos");

        javax.swing.GroupLayout panelEntregaPedidosLayout = new javax.swing.GroupLayout(panelEntregaPedidos);
        panelEntregaPedidos.setLayout(panelEntregaPedidosLayout);
        panelEntregaPedidosLayout.setHorizontalGroup(
            panelEntregaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntregaPedidosLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(labelEntregaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEntregaPedidosLayout.setVerticalGroup(
            panelEntregaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntregaPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntregaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(labelEntregaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTablaTiendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegitroTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVERtiempoEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
            .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAllProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(labelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panelEntregaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegitroTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTablaTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVERtiempoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAllProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelEntregaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnAllProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllProductsActionPerformed
        // TODO add your handling code here:
        this.jTabbedPane1.setSelectedIndex(0);
        dfm.setRowCount(0);
        llenarTablaProductos(sistema.getProductoExistenciaDB().getAllProductos());
    }//GEN-LAST:event_btnAllProductsActionPerformed

    private void btnRegitroTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegitroTiendaActionPerformed
        // TODO add your handling code here:
        this.registroNuevaTienda = new RegistroNuevaTienda(this, ventanaEmpleado, verifidorTiempoEnvio, sistema);
        this.registroNuevaTienda.setVisible(true);
        super.setVisible(false);
    }//GEN-LAST:event_btnRegitroTiendaActionPerformed

    private void btnTablaTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaTiendasActionPerformed
        // TODO add your handling code here:
        this.tableStores = new TableStores(this, sistema);
        this.tableStores.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnTablaTiendasActionPerformed

    private void btnVERtiempoEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVERtiempoEnvioActionPerformed
        // TODO add your handling code here:
        this.verifidorTiempoEnvio = new VerificadorTiempoEnvio(this, this.sistema, this.tiendaActual);
        this.verifidorTiempoEnvio.setVisible(true);
        //this.verifidorTiempoEnvio.getDfm().setRowCount(0);
    }//GEN-LAST:event_btnVERtiempoEnvioActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        try {
            setVisible(false);
            this.reportWindow = new ReportWindow(this, sistema, tiendaActual);
            this.reportWindow.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnReportesActionPerformed

    private void txtFiltroNOMBREKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNOMBREKeyReleased
        // TODO add your handling code here:
        dfm.setRowCount(0);
        llenarTablaProductos(
                sistema.getProductoExistenciaDB()
                        .getAllProductosWhitFilter(
                                txtFiltroNOMBRE.getText(),
                                ProductoExistenciaDB.ALL_PRODUCTO_EXISTENCIA_FILTER_NOMBRE));
    }//GEN-LAST:event_txtFiltroNOMBREKeyReleased

    private void txtFiltroCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroCodigoKeyReleased
        // TODO add your handling code here:
        dfm.setRowCount(0);
        llenarTablaProductos(
                sistema.getProductoExistenciaDB()
                        .getAllProductosWhitFilter(
                                txtFiltroCodigo.getText(),
                                ProductoExistenciaDB.ALL_PRODUCTO_EXISTENCIA_FILTER_CODIGO));
    }//GEN-LAST:event_txtFiltroCodigoKeyReleased

    private void txtFiltroTIendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroTIendaKeyReleased
        // TODO add your handling code here:
        dfm.setRowCount(0);

        llenarTablaProductos(
                sistema.getProductoExistenciaDB()
                        .getAllProductosWhitFilter(
                                txtFiltroTIenda.getText(),
                                ProductoExistenciaDB.ALL_PRODUCTO_EXISTENCIA_FILTER_TIENDA));
    }//GEN-LAST:event_txtFiltroTIendaKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        super.setVisible(false);
        this.ventanaEmpleado.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProductActionPerformed
        // TODO add your handling code here:
        this.registroNuevoProducto = new RegistroNuevoProducto(this, sistema, this.tiendaSeleccionada);
        this.registroNuevoProducto.setVisible(true);
        dfm.setRowCount(0);
        super.setVisible(false);

    }//GEN-LAST:event_btnNewProductActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        try {
            // TODO add your handling code here:
            VentaForm ventaForm = new VentaForm(this, tiendaActual, sistema);
            setVisible(false);
            ventaForm.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        // TODO add your handling code here:
        dfm.setRowCount(0);
        this.jTabbedPane1.setSelectedIndex(1);
        llenarTableProductosTienda(sistema.getProductoExistenciaDB().getAllProductosByTienda(this.tiendaSeleccionada));
    }//GEN-LAST:event_btnProductsActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String o = jComboBox1.getSelectedItem().toString();
        switch (o) {
            case "Salir":
                System.exit(0);
                break;
            case "Regresar":
                super.setVisible(false);
                this.ventanaEmpleado.setVisible(true);
                break;
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnMostrarTodosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosProductosActionPerformed
        // TODO add your handling code here:
        this.txtFiltroCodigo.setText("");
        this.txtFiltroNOMBRE.setText("");
        this.txtFiltroTIenda.setText("");
        dfm.setRowCount(0);
        llenarTablaProductos(sistema.getProductoExistenciaDB().getAllProductos());
    }//GEN-LAST:event_btnMostrarTodosProductosActionPerformed

    private void tableTiendaEnCuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTiendaEnCuestionMouseClicked
        // TODO add your handling code here:
        int fila = this.tableTiendaEnCuestion.getSelectedRow();
        int columna = this.tableTiendaEnCuestion.getSelectedColumn();

        if (columna == 5) {
            setVisible(false);
            EditProduct edit = new EditProduct(sistema, this, sistema.getProductoExistenciaDB().getAllProductosByTienda(tiendaSeleccionada).get(fila), tiendaActual);
            edit.setVisible(true);
        }
    }//GEN-LAST:event_tableTiendaEnCuestionMouseClicked

    private void panelEntregaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEntregaPedidosMouseClicked
        // TODO add your handling code here:
        System.out.println("hola");
    }//GEN-LAST:event_panelEntregaPedidosMouseClicked

    public void llenarTablaProductos(List<Producto> productos) {
        dfm = (DefaultTableModel) tableProducts.getModel();
        for (Producto producto : productos) {
            String[] datos = {
                producto.getCodigo(),
                producto.getNombre(),
                producto.getTiendaDondeExiste(),
                producto.getFabricante(),
                producto.getCantidad() + "",
                producto.getPrecio() + "",
                producto.getDescripcion(),
                producto.getGarantia()
            };
            dfm.addRow(datos);

        }
    }

    public void llenarTableProductosTienda(List<Producto> productos) {
        dfm = (DefaultTableModel) tableTiendaEnCuestion.getModel();

        for (Producto producto : productos) {
            String[] datos = {
                producto.getNombre(),
                producto.getCodigo(),
                producto.getFabricante(),
                producto.getCantidad() + "",
                producto.getPrecio() + "",
                "Editar"
            };
            dfm.addRow(datos);
        }
    }

    public VerificadorTiempoEnvio getVerifidorTiempoEnvio() {
        return verifidorTiempoEnvio;
    }

    public DefaultTableModel getDfm() {
        return dfm;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllProducts;
    private javax.swing.JButton btnMostrarTodosProductos;
    private javax.swing.JButton btnNewProduct;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnRegitroTienda;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnTablaTiendas;
    private javax.swing.JButton btnVERtiempoEnvio;
    private javax.swing.JButton btnVentas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelEntregaPedidos;
    private javax.swing.JLabel labelNameUser;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JPanel panelEntregaPedidos;
    private javax.swing.JPanel panelTienda;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTable tableTiendaEnCuestion;
    private javax.swing.JLabel txtFechaSistema;
    private javax.swing.JTextField txtFiltroCodigo;
    private javax.swing.JTextField txtFiltroNOMBRE;
    private javax.swing.JTextField txtFiltroTIenda;
    // End of variables declaration//GEN-END:variables
}
