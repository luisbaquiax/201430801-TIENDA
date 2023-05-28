/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontend;

import com.backend.conectionDB.ConeccionDB;
import com.backend.conectionDB.modelo.ClienteDB;
import com.backend.conectionDB.modelo.PedidoDB;
import com.backend.conectionDB.modelo.ProductReportDB;
import com.backend.conectionDB.modelo.TiendaDB;
import com.backend.conectionDB.modelo.manejoPedidoDB.DatoPedidoDB;
import com.backend.entidad.Cliente;
import com.backend.entidad.Compra;
import com.backend.entidad.DetallePedido;
import com.backend.entidad.Pedido;
import com.backend.entidad.Producto;
import com.backend.entidad.Reporte;
import com.backend.entidad.Sistema;
import com.backend.entidad.Tienda;
import com.tienda.utiles.ContendioReporte;
import com.tienda.utiles.Panel;
import com.tienda.utiles.PathReport;
import com.tienda.utiles.Utiles;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public final class ReportWindow extends javax.swing.JFrame {

    private Sistema sistema;
    private VentanaTienda ventanaTienda;
    private Tienda tiendaActual;
    private DefaultTableModel dfm;

    private Reporte reporte;
    private String path;
    private PathReport pathReport;
    private List<Pedido> pedidosAuxi;
    private List<DetallePedido> detallePedidos;
    private DatoPedidoDB datoPedidoDB;
    private ContendioReporte contendioReporte;
    private List<Pedido> pedidosSinRegistrar;
    private List<Pedido> pedidosAtrasados;
    private List<Pedido> pedidosSalenDeTienda;
    private List<Cliente> clientes;
    private List<Pedido> pedidosPorCliente;
    private List<Producto> productosMasVendidos;
    private ProductReportDB productReportDB;
    private List<Tienda> tiendas;

    /**
     * Creates new form Reporte
     *
     * @param ventanaTienda
     * @param sistema
     * @param tiendaActual
     * @throws SQLException
     */
    public ReportWindow(VentanaTienda ventanaTienda, Sistema sistema, Tienda tiendaActual) throws SQLException {
        initComponents();
        this.reporte = new Reporte();
        this.path = "";
        this.pathReport = new PathReport();
        this.pedidosAuxi = new ArrayList<>();
        this.detallePedidos = new ArrayList<>();
        this.datoPedidoDB = new DatoPedidoDB(sistema);
        this.contendioReporte = new ContendioReporte();
        this.productReportDB = new ProductReportDB();
        Utiles utiles = new Utiles();
        int tam = 35;

        utiles.ponerIconoButton(btnOutoff, "/iconos/outRed.jpeg", tam);
        utiles.ponerIconoButton(btnRegresar, "/iconos/previous.png", tam);
        utiles.ponerIconoLabel(labelTitleReport, "/iconos/report.png", tam);
        utiles.ponerIconoButton(btnReport1, "/iconos/saveBlue.jpeg", tam);
        utiles.ponerIconoButton(btnSaveReport3, "/iconos/saveBlue.jpeg", tam);
        utiles.ponerIconoButton(btnSave4, "/iconos/saveBlue.jpeg", tam);
        utiles.ponerIconoButton(btnSave5, "/iconos/saveBlue.jpeg", tam);
        utiles.ponerIconoButton(btnSave6, "/iconos/saveBlue.jpeg", tam);
        utiles.ponerIconoButton(btnSave7, "/iconos/saveBlue.jpeg", tam);
        utiles.ponerIconoButton(btnSave8, "/iconos/saveBlue.jpeg", tam);
        utiles.ponerIconoButton(jButton2, "/iconos/saveBlue.jpeg", tam);
        utiles.ponerIconoButton(btnMarcar, "/iconos/comprobado.png", Utiles.TAM_25);
        utiles.ponerIconoButton(btnMarcar2, "/iconos/comprobado.png", Utiles.TAM_25);
        utiles.ponerIconoButton(btnMarcarComoAtrasado, "/iconos/comprobado.png", Utiles.TAM_25);
        utiles.ponerIconoButton(btnRealizarConsultaProductos, "/iconos/search.png", Utiles.TAM_25);
        utiles.ponerIconoButton(btnProductoMasVendido, "/iconos/search.png", Utiles.TAM_25);
        utiles.ponerIconoButton(btnRealizarConsultaProductoTienda, "/iconos/search.png", Utiles.TAM_25);
        utiles.ponerIconoButton(btnVerSinFiltro, "/iconos/search.png", Utiles.TAM_25);
        this.sistema = sistema;
        this.ventanaTienda = ventanaTienda;
        this.tiendaActual = tiendaActual;

        this.clientes = this.sistema.getClienteDB().getClientesAllClientes(ConeccionDB.getConnection(), ClienteDB.SELECT_ALL_CLIENTES);
        this.tiendas = this.sistema.getTiendaDB().getTiendas(TiendaDB.SELECT_TIENDAS);
        actualizarTablas();
        llenarCompo();
        llenarComboClientes(clientes, this.comoClientesCompras);
        llenarComboClientes(clientes, this.comboClientesPedidos);
        llenarComboTiendas();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/tiendaIcono.png")));
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jPanel1 = new Panel("/iconos/fondo.jpeg");
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListaPedidosLlegaran = new javax.swing.JTable();
        btnReport1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMarcarComoAtrasado = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        radioEstadoProducot = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableReport2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnMarcar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableReport3 = new javax.swing.JTable();
        btnSaveReport3 = new javax.swing.JButton();
        btnMarcar2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        btnSave4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        btnSave5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comoClientesCompras = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnSave6 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        table6 = new javax.swing.JTable();
        comboClientesPedidos = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table7 = new javax.swing.JTable();
        btnSave7 = new javax.swing.JButton();
        fecha1Producto = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        fecha2Producto = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btnRealizarConsultaProductos = new javax.swing.JButton();
        btnProductoMasVendido = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comoTiendas = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        dateChoserFecha1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        dateChoserFecha2 = new com.toedter.calendar.JDateChooser();
        btnRealizarConsultaProductoTienda = new javax.swing.JButton();
        btnVerSinFiltro = new javax.swing.JButton();
        btnSave8 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        table8 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnOutoff = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        labelTitleReport = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTabbedPane1.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        tableListaPedidosLlegaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "NIT-cliente", "Total", "Anticipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableListaPedidosLlegaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListaPedidosLlegaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableListaPedidosLlegaran);
        if (tableListaPedidosLlegaran.getColumnModel().getColumnCount() > 0) {
            tableListaPedidosLlegaran.getColumnModel().getColumn(0).setResizable(false);
            tableListaPedidosLlegaran.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        btnReport1.setText("Exportar datos");
        btnReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de pedidos que llegarán a  esta tienda");

        btnMarcarComoAtrasado.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnMarcarComoAtrasado.setText("Marcar como atrasado");
        btnMarcarComoAtrasado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarComoAtrasadoActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estado del pedido:");

        radioEstadoProducot.setForeground(new java.awt.Color(0, 0, 0));
        radioEstadoProducot.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReport1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnMarcarComoAtrasado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(radioEstadoProducot, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioEstadoProducot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMarcarComoAtrasado))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnReport1))
        );

        jTabbedPane1.addTab("1", jPanel2);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        tableReport2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "NIT CLIENTE", "TOTAL", "ANTICIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableReport2);
        if (tableReport2.getColumnModel().getColumnCount() > 0) {
            tableReport2.getColumnModel().getColumn(0).setResizable(false);
            tableReport2.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnMarcar.setBackground(new java.awt.Color(47, 174, 191));
        btnMarcar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnMarcar.setForeground(new java.awt.Color(0, 0, 0));
        btnMarcar.setText("Marcar como pedido verificado su ingreso");
        btnMarcar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMarcarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMarcarMouseExited(evt);
            }
        });
        btnMarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnMarcar)
                        .addGap(0, 975, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnMarcar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pedidos atrasados");

        tableReport3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "NIT", "TOTAL", "ANTICIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableReport3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tableReport3);

        btnSaveReport3.setText("Exportar reporte");

        btnMarcar2.setBackground(new java.awt.Color(0, 204, 204));
        btnMarcar2.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnMarcar2.setForeground(new java.awt.Color(0, 0, 0));
        btnMarcar2.setText("Marcar como verificado");
        btnMarcar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnMarcar2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSaveReport3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMarcar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveReport3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "NIT-CLIENTE", "TOTAL", "ANTICIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table4);

        btnSave4.setText("Exportar");
        btnSave4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pedidos que salieron de la tienda y que están en tránsito");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
                    .addComponent(btnSave4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("4", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Compras por cliente");

        table5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Nit-cliente", "Total", "Ver detalle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(table5);

        btnSave5.setText("Exportar");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Selecione cliente");

        comoClientesCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comoClientesComprasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(comoClientesCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comoClientesCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSave5)
                .addContainerGap())
        );

        jTabbedPane1.addTab("5", jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pedidos en curso de un cliente");

        btnSave6.setText("Exportar");

        table6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "NIT-Cliente", "Total", "Anticipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(table6);

        comboClientesPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesPedidosActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Selecione cliente:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(comboClientesPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboClientesPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSave6)
                .addContainerGap())
        );

        jTabbedPane1.addTab("6", jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("10 PRODUCTOS MÁS VENDIDOS");

        table7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fabricante", "Cantidad artículos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(table7);

        btnSave7.setText("Exportar");

        fecha1Producto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fecha 1:");

        fecha2Producto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha 2:");

        btnRealizarConsultaProductos.setText("Realizar cosulta");
        btnRealizarConsultaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarConsultaProductosActionPerformed(evt);
            }
        });

        btnProductoMasVendido.setText("Ver productos sin filtro");
        btnProductoMasVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoMasVendidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane7)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(fecha1Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha2Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRealizarConsultaProductos)
                        .addGap(18, 18, 18)
                        .addComponent(btnProductoMasVendido)
                        .addGap(0, 587, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRealizarConsultaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProductoMasVendido))
                    .addComponent(jLabel11)
                    .addComponent(fecha1Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha2Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSave7)
                .addContainerGap())
        );

        jTabbedPane1.addTab("7", jPanel9);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("10 Productos más vendidos por tienda");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Seleccione tienda (código, nombre:)");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fecha 1:");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha 2:");

        btnRealizarConsultaProductoTienda.setText("Realizar consulta");
        btnRealizarConsultaProductoTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarConsultaProductoTiendaActionPerformed(evt);
            }
        });

        btnVerSinFiltro.setText("Ver sin filtro");
        btnVerSinFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSinFiltroActionPerformed(evt);
            }
        });

        btnSave8.setText("Exportar reporte");

        table8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fabricante", "Cantidad artículos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(table8);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addComponent(btnSave8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(comoTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChoserFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChoserFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRealizarConsultaProductoTienda)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerSinFiltro)
                        .addGap(0, 189, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(comoTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(dateChoserFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(dateChoserFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRealizarConsultaProductoTienda)
                        .addComponent(btnVerSinFiltro)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSave8)
                .addContainerGap())
        );

        jTabbedPane1.addTab("8", jPanel10);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1302, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("9", jPanel12);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jComboBox1.setBackground(new java.awt.Color(0, 0, 255));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnOutoff.setBackground(new java.awt.Color(204, 0, 51));
        btnOutoff.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnOutoff.setForeground(new java.awt.Color(255, 255, 255));
        btnOutoff.setText("Salir");
        btnOutoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutoffActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 204, 0));
        btnRegresar.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        labelTitleReport.setBackground(new java.awt.Color(0, 0, 102));
        labelTitleReport.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        labelTitleReport.setForeground(new java.awt.Color(255, 255, 255));
        labelTitleReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitleReport.setText("Reportes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
            .addComponent(labelTitleReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOutoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(labelTitleReport)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18)
                .addComponent(btnOutoff)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
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

    private void btnReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport1ActionPerformed
        // TODO add your handling code here:
        String htmlTable = "";
        htmlTable += "<table class=\"table\">\n"
                + "<thead class=\"thead-dark\">"
                + "<tr>\n"
                + "    <th>ID</th>\n"
                + "    <th>Fecha del pedido</th>\n"
                + "    <th>NIT-cliente</th>\n"
                + "    <th>Código producto</th>\n"
                + "    <th>Cantidad de artículos</th>\n"
                + "    <th>Total</th>\n"
                + "    <th>Anticipo</th>\n"
                + "  </tr>"
                + " </thead>";

        for (Pedido pedido : this.pedidosAuxi) {
            this.detallePedidos = this.sistema.getDetallePedidoDB().getDetallePedido(pedido.getCodigoPedido());
            htmlTable += "<tr>"
                    + "<td>" + pedido.getCodigoPedido() + "</td>"
                    + "<td>" + pedido.getFecha() + "</td>"
                    + "<td>" + pedido.getNitCliente() + "</td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td>" + pedido.getTotalPagar() + "</td>"
                    + "<td>" + pedido.getAnticipo() + "</td>"
                    + "</tr>";
            for (DetallePedido d : this.detallePedidos) {
                htmlTable += "<tr>"
                        + "<td></td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "<td>" + d.getCodigoProduco() + "</td>"
                        + "<td>" + d.getCantidadArticulos() + "</td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "</tr>";
            }
        }
        this.path = this.pathReport.getPath();
        if (!path.equals("")) {
            this.reporte.reporteHTML(path + "-listaTodosPedidos-" + tiendaActual.getCodigo() + ".html", this.contendioReporte.getBody(htmlTable));
            JOptionPane.showMessageDialog(this, "Datos exportados");
            this.path = "";
        }
    }//GEN-LAST:event_btnReport1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        this.jTabbedPane1.setSelectedIndex(this.jComboBox1.getSelectedIndex());
        actualizarTablas();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnOutoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutoffActionPerformed
        // TODO add your handling code here:
        System.exit(DEFAULT_CURSOR);
    }//GEN-LAST:event_btnOutoffActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        this.ventanaTienda.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        setVisible(false);
        this.ventanaTienda.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnMarcarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcarMouseEntered
        // TODO add your handling code here:
        this.btnMarcar.setBackground(new Color(56, 197, 217));
    }//GEN-LAST:event_btnMarcarMouseEntered

    private void btnMarcarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcarMouseExited
        // TODO add your handling code here:
        this.btnMarcar.setBackground(new Color(47, 174, 191));
    }//GEN-LAST:event_btnMarcarMouseExited

    private void btnMarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarActionPerformed
        // TODO add your handling code here:
        int fila = this.tableReport2.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir un pedido para poder marcarlo.", "Marcar pedido como registrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Pedido auxi = this.pedidosSinRegistrar.get(fila);
            auxi.setRegistrado(true);
            if (this.sistema.getPedidoDB().actualizar(auxi)) {
                JOptionPane.showMessageDialog(this, "Se ha registrado el pedido como registrado");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo realizar la tarea", "Marcar pedido como registrado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        this.pedidosSinRegistrar = this.datoPedidoDB.getPedidosLlegaranSinRegistradosSinFecha(this.tiendaActual.getCodigo());
        llenarTabla(this.pedidosSinRegistrar, tableReport2, dfm);
    }//GEN-LAST:event_btnMarcarActionPerformed

    private void btnMarcarComoAtrasadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarComoAtrasadoActionPerformed
        // TODO add your handling code here:
        int fila = this.tableListaPedidosLlegaran.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona el pedido para marcar como atrasado.");
        } else {
            Pedido auxi = this.pedidosAuxi.get(fila);
            auxi.setAtrasado(true);
            if (this.sistema.getPedidoDB().actualizar(auxi)) {
                JOptionPane.showMessageDialog(this, "Se ha marcado el pedido como atrasado.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo marcar el pedido como atrasado.");
            }
        }
        this.pedidosAuxi = this.sistema.getPedidoDB().getPedidosPorTienda(this.tiendaActual.getCodigo(), PedidoDB.PEDIDO_QUE_LLEGARAN_A_LA_TIENDA_SIN_FECHA);
        llenarTabla(this.pedidosAuxi, tableListaPedidosLlegaran, dfm);
    }//GEN-LAST:event_btnMarcarComoAtrasadoActionPerformed

    private void tableListaPedidosLlegaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListaPedidosLlegaranMouseClicked
        // TODO add your handling code here:
        int fila = this.tableListaPedidosLlegaran.getSelectedRow();
        if (fila > -1) {
            this.radioEstadoProducot.setSelected(this.pedidosAuxi.get(fila).isAtrasado());
            if (this.pedidosAuxi.get(fila).isAtrasado()) {
                this.radioEstadoProducot.setText("Atrasado");
            } else {
                this.radioEstadoProducot.setText("A tiempo");
            }
        }

    }//GEN-LAST:event_tableListaPedidosLlegaranMouseClicked

    private void btnSave4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave4ActionPerformed

    private void comoClientesComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comoClientesComprasActionPerformed
        // TODO add your handling code here:
        llenarTablaCompras();
    }//GEN-LAST:event_comoClientesComprasActionPerformed

    private void comboClientesPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesPedidosActionPerformed
        // TODO add your handling code here:
        this.pedidosPorCliente = this.datoPedidoDB.getPedidosByCustomerEnCurso(this.clientes.get(comboClientesPedidos.getSelectedIndex()).getNit());
        llenarTabla(this.pedidosPorCliente, table6, dfm);
    }//GEN-LAST:event_comboClientesPedidosActionPerformed

    private void btnProductoMasVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoMasVendidoActionPerformed
        // TODO add your handling code here:
        this.productosMasVendidos = this.productReportDB.getProductosMasVendido();
        llenarTablaProductoMasVendido(this.productosMasVendidos, table7);
    }//GEN-LAST:event_btnProductoMasVendidoActionPerformed

    private void btnRealizarConsultaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarConsultaProductosActionPerformed
        // TODO add your handling code here:
        Date date = fecha1Producto.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha1 = String.valueOf(sdf.format(date));
        Date date2 = fecha2Producto.getDate();
        SimpleDateFormat hola = new SimpleDateFormat("yyyy-MM-dd");
        String fecha2 = String.valueOf(hola.format(date2));
        this.productosMasVendidos = this.productReportDB.getProductosMasVendido(fecha1, fecha2);
        llenarTablaProductoMasVendido(this.productosMasVendidos, table7);
    }//GEN-LAST:event_btnRealizarConsultaProductosActionPerformed

    private void btnVerSinFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSinFiltroActionPerformed
        this.productosMasVendidos = productReportDB.getProductosMasVendidoPorTienda(this.tiendas.get(comoTiendas.getSelectedIndex()).getCodigo());
        llenarTablaProductoMasVendido(productosMasVendidos, table8);
    }//GEN-LAST:event_btnVerSinFiltroActionPerformed

    private void btnRealizarConsultaProductoTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarConsultaProductoTiendaActionPerformed
        Date date = dateChoserFecha1.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha1 = String.valueOf(sdf.format(date));
        Date date2 = dateChoserFecha2.getDate();
        SimpleDateFormat hola = new SimpleDateFormat("yyyy-MM-dd");
        String fecha2 = String.valueOf(hola.format(date2));
        this.productosMasVendidos = productReportDB.getProductosMasVendidoPorTienda(this.tiendas.get(comoTiendas.getSelectedIndex()).getCodigo(), fecha1, fecha2);
        llenarTablaProductoMasVendido(productosMasVendidos, table8);
    }//GEN-LAST:event_btnRealizarConsultaProductoTiendaActionPerformed

    private void btnMarcar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcar2ActionPerformed
        int fila = this.tableReport3.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir un pedido para poder marcarlo.", "Marcar pedido como registrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Pedido auxi = this.pedidosAtrasados.get(fila);
            auxi.setRegistrado(true);
            if (this.sistema.getPedidoDB().actualizar(auxi)) {
                JOptionPane.showMessageDialog(this, "Se ha registrado el pedido como registrado");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo realizar la tarea", "Marcar pedido como registrado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        this.pedidosAtrasados = this.sistema.getPedidoDB().getPedidosPorTienda(this.tiendaActual.getCodigo(), PedidoDB.PEDIDOS_ATRASADOS);
        llenarTabla(this.pedidosAtrasados, tableReport3, dfm);
    }//GEN-LAST:event_btnMarcar2ActionPerformed

    public void llenarTabla(List<Pedido> pedidos, JTable tabla, DefaultTableModel dfm) {
        dfm = (DefaultTableModel) tabla.getModel();
        dfm.setRowCount(0);
        for (Pedido pedido : pedidos) {
            String[] datos = {
                pedido.getCodigoPedido() + "",
                pedido.getFecha(),
                pedido.getNitCliente(),
                pedido.getTotalPagar() + "",
                pedido.getAnticipo() + "",};
            dfm.addRow(datos);
        }
    }

    public void llenarTablaCompras() {
        dfm = (DefaultTableModel) this.table5.getModel();
        dfm.setRowCount(0);
        for (Compra compra : this.sistema.getCompraDB().getCompraByCliente(this.clientes.get(comoClientesCompras.getSelectedIndex()).getNit())) {
            String[] datos = new String[]{
                compra.getId() + "",
                compra.getFecha(),
                compra.getNitCliente(),
                compra.getTotal() + "",
                "Ver detalle"
            };
            dfm.addRow(datos);
        }
    }

    public void llenarTablaProductoMasVendido(List<Producto> productos, JTable table) {
        dfm = (DefaultTableModel) table.getModel();
        dfm.setRowCount(0);
        for (Producto producto : productos) {
            String[] datos = new String[]{
                producto.getCodigo(),
                producto.getNombre(),
                producto.getFabricante(),
                producto.getCantidad() + ""
            };
            dfm.addRow(datos);
        }
    }

    private void llenarCompo() {
        for (int i = 0; i < reportes().length; i++) {
            this.jComboBox1.addItem(reportes()[i]);
        }
    }

    private void llenarComboClientes(List<Cliente> clientes, JComboBox comboBox) {
        for (Cliente clientesAllCliente : clientes) {
            comboBox.addItem(clientesAllCliente.getInfoVenta());
        }
    }

    private void llenarComboTiendas() {
        for (Tienda t : this.tiendas) {
            this.comoTiendas.addItem(t.getInfo());
        }
    }

    private String[] reportes() {
        return new String[]{
            "Listado de pedidos que llegarán a la tienda",
            "Pedidos que están en tiempo de estar en la tienda pero debe verificarse",
            "Pedidos atrasados",
            "Pedidos que salieron y en tránsito",
            "Compras por cliente",
            "Pedidos en curso por cliente",
            "10 productos más vendido",
            "Productos más vendidos por tienda",
            "Productos nunca vendidos por tienda"
        };
    }

    private void actualizarTablas() {
        this.pedidosAuxi = this.sistema.getPedidoDB().getPedidosPorTienda(this.tiendaActual.getCodigo(), PedidoDB.PEDIDO_QUE_LLEGARAN_A_LA_TIENDA_SIN_FECHA);
        this.pedidosSinRegistrar = this.datoPedidoDB.getPedidosLlegaranSinRegistradosSinFecha(tiendaActual.getCodigo());
        this.pedidosAtrasados = this.sistema.getPedidoDB().getPedidosPorTienda(this.tiendaActual.getCodigo(), PedidoDB.PEDIDOS_ATRASADOS);
        this.pedidosSalenDeTienda = this.sistema.getPedidoDB().getPedidosSalenDeTienda(this.tiendaActual.getCodigo());
        llenarTabla(pedidosAuxi, tableListaPedidosLlegaran, dfm);
        llenarTabla(pedidosSinRegistrar, tableReport2, dfm);
        llenarTabla(pedidosAtrasados, tableReport3, dfm);
        llenarTabla(pedidosSalenDeTienda, table4, dfm);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMarcar;
    private javax.swing.JButton btnMarcar2;
    private javax.swing.JButton btnMarcarComoAtrasado;
    private javax.swing.JButton btnOutoff;
    private javax.swing.JButton btnProductoMasVendido;
    private javax.swing.JButton btnRealizarConsultaProductoTienda;
    private javax.swing.JButton btnRealizarConsultaProductos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReport1;
    private javax.swing.JButton btnSave4;
    private javax.swing.JButton btnSave5;
    private javax.swing.JButton btnSave6;
    private javax.swing.JButton btnSave7;
    private javax.swing.JButton btnSave8;
    private javax.swing.JButton btnSaveReport3;
    private javax.swing.JButton btnVerSinFiltro;
    private javax.swing.JComboBox<String> comboClientesPedidos;
    private javax.swing.JComboBox<String> comoClientesCompras;
    private javax.swing.JComboBox<String> comoTiendas;
    private com.toedter.calendar.JDateChooser dateChoserFecha1;
    private com.toedter.calendar.JDateChooser dateChoserFecha2;
    private com.toedter.calendar.JDateChooser fecha1Producto;
    private com.toedter.calendar.JDateChooser fecha2Producto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelTitleReport;
    private javax.swing.JRadioButton radioEstadoProducot;
    private javax.swing.JTable table4;
    private javax.swing.JTable table5;
    private javax.swing.JTable table6;
    private javax.swing.JTable table7;
    private javax.swing.JTable table8;
    private javax.swing.JTable tableListaPedidosLlegaran;
    private javax.swing.JTable tableReport2;
    private javax.swing.JTable tableReport3;
    // End of variables declaration//GEN-END:variables
}
