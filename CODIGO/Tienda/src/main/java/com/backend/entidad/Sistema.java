/*
 * Clase que contiene todas las listas de los objetos que se cargarán enl carga de datos 
 */
package com.backend.entidad;

import com.backend.conection.Conection;
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

    private Conection conection = new Conection();

    public Sistema() {
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
        for (Tienda tienda : getTiendas()) {
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
     * Metodo para ordenar los tiempos de envio de menor a mayor
     */
    public void ordenarTiempoDeEnvio() {
        Collections.sort(this.getTiemposDeEnvio());
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
        for (Tienda tienda : getTiendas()) {
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

    public boolean conDatos() {
        if (this.getClientes() != null) {
            return true;
        }
        return false;
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

    /**
     * @return the conection
     */
    public Conection getConection() {
        return conection;
    }

}
