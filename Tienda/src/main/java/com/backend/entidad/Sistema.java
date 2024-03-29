/*
 * Clase que contiene todas las listas de los objetos que se cargarán enl carga de datos 
 */
package com.backend.entidad;

import com.backend.conectionDB.modelo.PedidoDB;
import com.backend.conectionDB.modelo.TiendaDB;
import com.backend.conectionDB.modelo.ProductoDB;
import com.backend.conectionDB.modelo.EnvioDB;
import com.backend.conectionDB.modelo.EmpleadoDB;
import com.backend.conectionDB.modelo.ClienteDB;
import com.backend.conectionDB.ConeccionDB;
import com.backend.conectionDB.modelo.CompraDB;
import com.backend.conectionDB.modelo.DetalleCompraDB;
import com.backend.conectionDB.modelo.DetallePedidoDB;
import com.backend.conectionDB.modelo.productoExistencia.ProductoExistenciaDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author luis
 */
public class Sistema {

    private ArrayList<Tienda> tiendas = new ArrayList<>();
    private ArrayList<TiempoDeEnvio> tiemposDeEnvio = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private ArrayList<String> datosErroneos = new ArrayList<>();
    private ArrayList<String> codigosExistentes = new ArrayList<>();

    private ConeccionDB conection = new ConeccionDB();

    private ClienteDB clienteDB;
    private EmpleadoDB empleadoDB;
    private EnvioDB envioDB;
    private PedidoDB pedidoDB;
    private ProductoDB productoDB;
    private TiendaDB tiendaDB;
    private DetallePedidoDB detallePedidoDB;
    private ProductoExistenciaDB productoExistenciaDB;
    private CompraDB compraDB;
    private DetalleCompraDB detalleCompraDB;

    public Sistema() throws SQLException {
        this.clienteDB = new ClienteDB();
        this.empleadoDB = new EmpleadoDB();
        this.envioDB = new EnvioDB();
        this.pedidoDB = new PedidoDB();
        this.productoDB = new ProductoDB();
        this.tiendaDB = new TiendaDB();
        this.detallePedidoDB = new DetallePedidoDB();
        this.productoExistenciaDB = new ProductoExistenciaDB();
        this.compraDB = new CompraDB();
        this.detalleCompraDB = new DetalleCompraDB();
    }

    /**
     * @return the detalleCompraDB
     */
    public DetalleCompraDB getDetalleCompraDB() {
        return detalleCompraDB;
    }

    public CompraDB getCompraDB() {
        return compraDB;
    }

    public ProductoExistenciaDB getProductoExistenciaDB() {
        return productoExistenciaDB;
    }

    public ClienteDB getClienteDB() {
        return clienteDB;
    }

    public EmpleadoDB getEmpleadoDB() {
        return empleadoDB;
    }

    public EnvioDB getEnvioDB() {
        return envioDB;
    }

    public PedidoDB getPedidoDB() {
        return pedidoDB;
    }

    public ProductoDB getProductoDB() {
        return productoDB;
    }

    public TiendaDB getTiendaDB() {
        return tiendaDB;
    }

    public DetallePedidoDB getDetallePedidoDB() {
        return detallePedidoDB;
    }

    /**
     * Verificamos si no se ha ingresado un producto con el mismo codigo
     *
     * @param codigoProducto
     * @return
     */
    public boolean yaExisteCodigoCadena(String codigoProducto) {
        for (String codigo : codigosExistentes) {
            if (codigo.equals(codigoProducto)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este método agrega un nueva Tienda a lista de tiendas
     *
     * @param tiendaNueva
     */
    public void agregarTiendaNueva(Tienda tiendaNueva) {
        this.getTiendas().add(tiendaNueva);
    }

    /**
     * Este método se encarga de agregar al listado de tiendas el codigo de las
     * tiendas existentes
     *
     * @param comboTiendas
     */
    public void agregarItemsTienda(JComboBox comboTiendas) {
        for (Tienda tienda : tiendaDB.getTiendas(TiendaDB.SELECT_TIENDAS)) {
            comboTiendas.addItem(tienda.getCodigo());
        }
    }

    /**
     * Método para ordenar tiendas
     */
    public void ordenarTiendas() {
        Collections.sort(this.getTiendas());
    }

    /**
     * metodo para agregar un tiempo de envío
     *
     * @param tiempoDeEnvioNueva
     */
    public void agregarTiempoDeEnvio(TiempoDeEnvio tiempoDeEnvioNueva) {
        this.getTiemposDeEnvio().add(tiempoDeEnvioNueva);
    }

    /**
     * Método para agregar un nuevo producto a la lista de producto
     *
     * @param producto
     */
    public void agregarProductoNuevo(Producto producto) {
        this.getProductos().add(producto);
    }

    /**
     * Método para ordenar los productos según el código del producto
     */
    public void ordenarProductosPorCodigo() {
        Collections.sort(this.getProductos());
    }

    /**
     * *
     * Metod para ordenar los producto por NOMBRE
     */
    public void ordenarProductosPorNombreAscendente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto c, Producto c1) {
                return c.getNombre().compareTo(c1.getNombre());
            }
        });
    }

    /**
     * para ordenar los producto por nombre descentemente
     */
    public void ordenarProductosPorNombreDescendente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto c, Producto c1) {
                return c.getNombre().compareTo(c1.getNombre());
            }
        });
        Collections.reverse(productos);
    }

    /**
     * Ordena los prodcuto por fabricatne ASCENDENTE
     */
    public void ordenarProductosPorFabricatneAscendente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto c, Producto c1) {
                return c.getFabricante().compareTo(c1.getFabricante());
            }
        });
    }

    /**
     * para ordenar los producto por fabricante descentemente
     */
    public void ordenarProductosPorFabricante_descendente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto c, Producto c1) {
                return c.getFabricante().compareTo(c1.getFabricante());
            }
        });
        Collections.reverse(productos);
    }

    /**
     * Ordena los producto por cantidad ASCENDENTEMENTE
     */
    public void ordenarProductosPorCantidadAscendente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p, Producto p1) {
                if (p.getCantidad() > p1.getCantidad()) {
                    return -1;
                } else if (p.getCantidad() < p1.getCantidad()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    /**
     * Ordena los producto por cantidad DESCENDENTEMENTE
     */
    public void ordenarProductosPorCantidadCantidadDescendente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p, Producto p1) {
                if (p.getCantidad() > p1.getCantidad()) {
                    return -1;
                } else if (p.getCantidad() < p1.getCantidad()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Collections.reverse(productos);
    }

    /**
     * ORDENA LOS PRODUCTO POR PRECIO > ASCENDENTEMENTE
     */
    public void ordenarProductosPorPrecioAscendente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p, Producto p1) {
                if (p.getPrecio() > p1.getPrecio()) {
                    return -1;
                } else if (p.getPrecio() < p1.getPrecio()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    /**
     * ORDENA LOS PRODUCTOS POR PRECIO > DESCENDENTEMENTE
     */
    public void ordenarProductosPorPrecioDescendente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p, Producto p1) {
                if (p.getPrecio() > p1.getPrecio()) {
                    return -1;
                } else if (p.getPrecio() < p1.getPrecio()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Collections.reverse(productos);
    }

    /**
     * Agrega un nuevo cliente a la lista de clientes
     *
     * @param cliente
     */
    public void agregarClienteNuevo(Cliente cliente) {
        this.getClientes().add(cliente);
    }

    /**
     * Método para ordenar a los clientes según el NIT
     */
    public void ordenarClientes() {
        Collections.sort(this.getClientes());
    }

    /**
     * Este método agrega un nuevo empleado a lista de empleados
     *
     * @param empleado
     */
    public void agregarEmpleadoNuevo(Empleado empleado) {
        this.getEmpleados().add(empleado);
    }

    /**
     * Metodo para ordenar a los empleados según su CODIOG_EMPLEADO de menor a
     * mayor
     */
    public void ordenarEmpleadosPorCodigo() {
        Collections.sort(this.getEmpleados());
    }

    public void agregarPedidoNuevo(Pedido pedido) {
        this.getPedidos().add(pedido);
    }

    /**
     * Metodo para buscar una tienda usando el codigo de la tienda
     *
     * @param codigoTienda
     * @return
     */
    public Tienda buscarTienda(String codigoTienda) {
        for (Tienda tienda : getTiendaDB().getTiendas(TiendaDB.SELECT_TIENDAS)) {
            if (tienda.getCodigo().equals(codigoTienda)) {
                return tienda;
            }
        }
        return null;
    }

    /**
     * Sirve para buscar un producto usando el codigo del producto
     *
     * @param codigoProducto
     * @return
     */
    public Producto buscarProducto(String codigoProducto) {
        for (Producto producto : getProductos()) {
            if (producto.getCodigo().equals(codigoProducto)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * *
     * Este método busca un cliente usando el nit
     *
     * @param NIT
     * @return retorna null si no existe el cliente que se busca
     */
    public Cliente buscarCliente(String NIT) {
        for (Cliente cliente : getClientes()) {
            if (cliente.getNit().equals(NIT)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Este método me sirve para buscar un empleado usando el código del mismo
     *
     * @param codigoEmleado
     * @return
     */
    public Empleado buscarEmpleado(String codigoEmleado) {
        for (Empleado empleado : getEmpleados()) {
            if (empleado.getCodigo().equals(codigoEmleado)) {
                return empleado;
            }
        }
        return null;
    }

    public void mostraTiendas() {
        for (Tienda tienda : this.getTiendas()) {
            tienda.mostrarDatos();
        }
    }

    public void mostrarTiemposDeEnvio() {
        for (TiempoDeEnvio tiempo : this.getTiemposDeEnvio()) {
            tiempo.mostrarDatos();
        }
    }

    public void mostrarProductos() {
        for (Producto producto : this.getProductos()) {
            producto.mostrarDatos();
        }
    }

    public void mostrarClinetes() {
        for (Cliente cliente : this.getClientes()) {
            cliente.mostarDatos();
        }
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : this.getEmpleados()) {
            empleado.mostarDatos();
        }
    }

    public void mostrarPedidos() {
        for (Pedido pedido : this.getPedidos()) {
            pedido.mostarDatos();
        }
    }

    /**
     * Método para agregar los datos erróneos
     *
     * @param datoErroneo
     */
    public void agregarDatoErroneo(String datoErroneo) {
        this.datosErroneos.add(datoErroneo);
    }

    /**
     * Me sirvió para ver los datos con errores
     */
    public void mostrarDatosErroneos() {
        System.out.println("datos erróneos");
        for (String errores : datosErroneos) {
            System.out.println(errores);
        }
    }

    /**
     * @return the tiendas
     */
    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    /**
     * @return the productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * @return the clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @return the pedidos
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @return the tiemposDeEnvio
     */
    public ArrayList<TiempoDeEnvio> getTiemposDeEnvio() {
        return tiemposDeEnvio;
    }

    /**
     * @return the empleados
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<String> getDatosErroneos() {
        return datosErroneos;
    }

    /**
     * Me permite alamacenar momentáneamente cadenas/codigos
     *
     * @return
     */
    public ArrayList<String> getCodigosExistentes() {
        return codigosExistentes;
    }

    /**
     * Clase Conection
     *
     * @return
     */
    public ConeccionDB getConection() {
        return conection;
    }

    /**
     * Método que verifica si una cadena es un decimal/Double
     *
     * @param cadena
     * @return
     */
    public boolean esDecimal(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Método que verifica si una cadena es un número entero
     *
     * @param cadena
     * @return
     */
    public boolean esNumeroEntero(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
