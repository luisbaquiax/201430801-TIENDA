/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.conectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class ConeccionDB {

    private String URL = "jdbc:mysql://localhost:3306/TIENDA?allowPublicKeyRetrieval=true&useSSL=false";
    private String USER = "root";
    private String PASSWORD = "luisbaquiax1234";

    private static ConeccionDB conexionSingleton = null;

    private static Connection CONECCION = null;

//    public void probarConection(Connection connection) {
//
//        String query = "SELECT VERSION()";
//
//        try (Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(query)) {
//
//            if (resultSet.next()) {
//                System.out.println(resultSet.getString(1));
//            }
//            System.out.println("conexión exitosa");
//        } catch (SQLException e) {
//            System.out.println("Conection fallida");
//            System.out.println("Error: " + e.getMessage());
//
//        }
//    }
    public ConeccionDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            CONECCION = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexion exitosa");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (conexionSingleton == null) {
            conexionSingleton = new ConeccionDB();
        }
        return CONECCION;
    }

    /**
     * Metodo para agregar una tienda a la base de datos
     *
     * @param connection
     * @param nombre
     * @param direccion
     * @param codigo
     * @param telefono
     * @param telefono2
     * @param email
     * @param horario
     */
    public void crearTienda(Connection connection, String codigo, String nombre, String direccion, String telefono, String telefono2, String email, String horario) {
        String query = "INSERT INTO TIENDAS VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, direccion);
            preSt.setString(4, telefono);
            preSt.setString(5, telefono2);
            preSt.setString(6, email);
            preSt.setString(7, horario);

            preSt.executeUpdate();

            System.out.println("tienda agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Busca a las tiendas filtrando el nombre
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarTiendaNombre(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM TIENDAS WHERE nombre LIKE ? ORDER BY nombre ASC";

//  CODIGO VARCHAR(45) NOT NULL,
//  nombre VARCHAR(45) NOT NULL,
//  direccion VARCHAR(45) NOT NULL,
//  telefono VARCHAR(8) NOT NULL,
//  telefono2 VARCHAR(8),
//  email VARCHAR(45),
//  horario VARCHAR(45),
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(2),
                    result.getString(3),
                    result.getString(1),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
//            result.close();
//            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * BUsca a las tiendas filgrando el codigo de la misma
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarTiendaCodigo(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM TIENDAS WHERE CODIGO LIKE ? ORDER BY CODIGO ASC";

//  CODIGO VARCHAR(45) NOT NULL,
//  nombre VARCHAR(45) NOT NULL,
//  direccion VARCHAR(45) NOT NULL,
//  telefono VARCHAR(8) NOT NULL,
//  telefono2 VARCHAR(8),
//  email VARCHAR(45),
//  horario VARCHAR(45),
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(2),
                    result.getString(3),
                    result.getString(1),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
//            result.close();
//            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para agregar una tiempo de envío/traslado
     *
     * @param connection
     * @param codigoTiendaOrigen
     * @param codigoTiendaDestino
     * @param tiempo
     */
    public void crearTiempoDeEnvio(Connection connection, String codigoTiendaOrigen,
            String codigoTiendaDestino, String tiempo) {

        String query = "INSERT INTO ENVIOS (codigo_tienda_origen, codigo_tienda_destino, tiempo_traslado)VALUES (?,?,?)";
        //  codigo_tienda_origen VARCHAR(45) NOT NULL,
        //  codigo_tienda_destino VARCHAR(45) NOT NULL,
        //  tiempo_traslado INT NOT NULL,

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigoTiendaOrigen);
            preSt.setString(2, codigoTiendaDestino);
            preSt.setInt(3, Integer.parseInt(tiempo));

            preSt.executeUpdate();

            System.out.println("tiempo agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Métod para crear un producto en la base de datos
     *
     * @param connection
     * @param codigo
     * @param nombre
     * @param fabricante
     * @param descripcion
     * @param garantia
     */
    public void crearProducto(Connection connection,
            String codigo,
            String nombre,
            String fabricante,
            String descripcion,
            String garantia) {

//CODIGO VARCHAR(45) NOT NULL,
//	nombre VARCHAR(45) NOT NULL,
//	fabricante VARCHAR(45) NOT NULL,
//  descripcion VARCHAR(200),
//  garantia VARCHAR(45),
        String query = "INSERT INTO PRODUCTO (CODIGO, nombre, fabricante, descripcion, garantia)VALUES (?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, fabricante);
            preSt.setString(4, descripcion);
            preSt.setString(5, garantia);

            preSt.executeUpdate();

            System.out.println("producto agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void buscarProductoCodigo(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM PRODUCTO WHERE CODIGO LIKE ? ORDER BY CODIGO ASC";

//	CODIGO VARCHAR(45) NOT NULL,
//	nombre VARCHAR(45) NOT NULL,
//	fabricante VARCHAR(45) NOT NULL,
//  descripcion VARCHAR(200),
//  garantia VARCHAR(45),
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(2),
                    result.getString(3),
                    result.getString(1),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
//            result.close();
//            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Crea la existencia de un nuevo producto
     *
     * @param connection
     * @param cantidad
     * @param precio
     * @param tiendaDondeExiste
     * @param codgioProducto
     */
    public void crearExistentes(Connection connection,
            String cantidad,
            String precio,
            String tiendaDondeExiste,
            String codgioProducto) {

//  ID INT NOT NULL AUTO_INCREMENT,
//  cantidad INT NOT NULL,
//  precio DOUBLE NOT NULL,
//  CODIGO_TIENDA_EXISTENCIA VARCHAR(45) NOT NULL,
//  codigo_producto VARCHAR(45) NOT NULL,
        String query = "INSERT INTO EXISTENTES (cantidad, precio, CODIGO_TIENDA_EXISTENCIA, codigo_producto)VALUES (?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, Integer.parseInt(cantidad));
            preSt.setDouble(2, Double.parseDouble(precio));
            preSt.setString(3, tiendaDondeExiste);
            preSt.setString(4, codgioProducto);

            preSt.executeUpdate();

            System.out.println("existencia agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Modifica el precio de un producto
     *
     * @param connection
     * @param precio
     * @param codgioProducto
     * @param codigoTienda
     */
    public void modificarPrecioProducto(Connection connection,
            String precio,
            String codgioProducto,
            String codigoTienda) {

        String query = "UPDATE EXISTENTES SET precio = ? WHERE codigo_producto = ? AND CODIGO_TIENDA_EXISTENCIA = ?";
        String codigo_producto = codgioProducto;

//  ID INT NOT NULL AUTO_INCREMENT,
//  cantidad INT NOT NULL,
//  precio DOUBLE NOT NULL,
//  CODIGO_TIENDA_EXISTENCIA VARCHAR(45) NOT NULL,
//  codigo_producto VARCHAR(45) NOT NULL,
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setDouble(1, Double.parseDouble(precio));
            preSt.setString(2, codigo_producto);
            preSt.setString(3, codigoTienda);

            preSt.executeUpdate();

            System.out.println("precio actualizado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Modificamos la cantidad de artículos de la actual tienda
     *
     * @param connection
     * @param cantidad
     * @param codgioProducto
     * @param codigoTienda
     */
    public void modificarCantidadExistenciaProducto(Connection connection,
            String cantidad,
            String codgioProducto,
            String codigoTienda) {

        String query = "UPDATE EXISTENTES SET cantidad = ? WHERE codigo_producto = ? AND CODIGO_TIENDA_EXISTENCIA = ?";
        String codigo_producto = codgioProducto;

//  ID INT NOT NULL AUTO_INCREMENT,
//  cantidad INT NOT NULL,
//  precio DOUBLE NOT NULL,
//  CODIGO_TIENDA_EXISTENCIA VARCHAR(45) NOT NULL,
//  codigo_producto VARCHAR(45) NOT NULL,
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setDouble(1, Double.parseDouble(cantidad));
            preSt.setString(2, codigo_producto);
            preSt.setString(3, codigoTienda);

            preSt.executeUpdate();

            System.out.println("cantidad actualizado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para crear un cliente y luego se agregará a la base de datos
     *
     * @param connection
     * @param nit
     * @param nombre
     * @param telefono
     * @param dpi
     * @param credito
     * @param email
     * @param direccion
     */
    public void crearCliente(Connection connection,
            String nit,
            String nombre,
            String telefono,
            String dpi,
            String credito,
            String email,
            String direccion) {
//	NIT VARCHAR(13) NOT NULL,
//	nombre VARCHAR(45) NOT NULL,
//	telefono VARCHAR(8) NOT NULL,
//      dpi VARCHAR(13),
//      credito DOUBLE,
//      email VARCHAR(45),
//      direccion VARCHAR(45),

        String query = "INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nit);
            preSt.setString(2, nombre);
            preSt.setString(3, telefono);
            preSt.setString(4, dpi);
            preSt.setDouble(5, Double.parseDouble(credito));
            preSt.setString(6, email);
            preSt.setString(7, direccion);

            preSt.executeUpdate();

            System.out.println("cliente agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * MODIFICA UN CLIENTE EN LA BASE DE DATOS
     *
     * @param connection
     * @param nombre
     * @param telefono
     * @param dpi
     * @param credito
     * @param correo
     * @param direccion
     * @param nit
     */
    public void modificarCliente(Connection connection,
            String nombre,
            String telefono,
            String dpi,
            String credito,
            String correo,
            String direccion,
            String nit) {

        String query = "UPDATE CLIENTE SET nombre = ?, telefono = ?, dpi = ?, credito = ?, email = ?, direccion = ? WHERE NIT = ?";
        String NIT = nit;

//	NIT VARCHAR(13) NOT NULL,
//	nombre VARCHAR(45) NOT NULL,
//	telefono VARCHAR(8) NOT NULL,
//  dpi VARCHAR(13),
//  credito DOUBLE,
//  email VARCHAR(45),
//  direccion VARCHAR(45),
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, telefono);
            preSt.setString(3, dpi);
            preSt.setDouble(4, Double.parseDouble(credito));
            preSt.setString(5, correo);
            preSt.setString(6, direccion);
            preSt.setString(7, NIT);

            preSt.executeUpdate();

            System.out.println("Cliente actualizado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Busca al cliente filtrando su nombre
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarClienteNombre(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM CLIENTE WHERE nombre LIKE ? ORDER BY NIT ASC";

//	NIT VARCHAR(13) NOT NULL,
//	nombre VARCHAR(45) NOT NULL,
//	telefono VARCHAR(8) NOT NULL,
//  dpi VARCHAR(13),
//  credito DOUBLE,
//  email VARCHAR(45),
//  direccion VARCHAR(45),
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(2),
                    result.getString(3),
                    result.getString(1),
                    result.getString(5),
                    result.getString(4),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
//            result.close();
//            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarClienteNit(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM CLIENTE WHERE NIT LIKE ? ORDER BY NIT ASC";

//	NIT VARCHAR(13) NOT NULL,
//	nombre VARCHAR(45) NOT NULL,
//	telefono VARCHAR(8) NOT NULL,
//  dpi VARCHAR(13),
//  credito DOUBLE,
//  email VARCHAR(45),
//  direccion VARCHAR(45),
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(2),
                    result.getString(3),
                    result.getString(1),
                    result.getString(5),
                    result.getString(4),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
//            result.close();
//            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para crear un empleado y agregar a la base de datos
     *
     * @param connection
     * @param codigo
     * @param nombre
     * @param telefono
     * @param dpi
     * @param nit
     * @param email
     * @param direccion
     */
    public void crearEmpleado(Connection connection,
            String codigo,
            String nombre,
            String telefono,
            String dpi,
            String nit,
            String email,
            String direccion) {
//  CODIGO VARCHAR(45) NOT NULL,
//  nombre VARCHAR(45) NOT NULL,
//  telefono VARCHAR(8) NOT NULL,
//  DPI VARCHAR(13) NOT NULL,
//  NIT VARCHAR(13) NOT NULL,
//  EMAIL VARCHAR(45),
//  direccion VARCHAR(45),

        String query = "INSERT INTO EMPLEADO VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, telefono);
            preSt.setString(4, dpi);
            preSt.setString(5, nit);
            preSt.setString(6, email);
            preSt.setString(7, direccion);

            preSt.executeUpdate();

            System.out.println("empleado agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * *
     * MOdifica el empleado en la base de datos
     *
     * @param connection
     * @param codigo
     * @param nombre
     * @param telefono
     * @param dpi
     * @param nit
     * @param email
     * @param direccion
     */
    public void modificarEmpleado(Connection connection,
            String codigo,
            String nombre,
            String telefono,
            String dpi,
            String nit,
            String email,
            String direccion) {
//  CODIGO VARCHAR(45) NOT NULL,
//  nombre VARCHAR(45) NOT NULL,
//  telefono VARCHAR(8) NOT NULL,
//  DPI VARCHAR(13) NOT NULL,
//  NIT VARCHAR(13) NOT NULL,
//  EMAIL VARCHAR(45),
//  direccion VARCHAR(45),

        String query = "UPDATE EMPLEADO SET nombre = ?, telefono = ?, DPI = ?, NIT = ?, EMAIL = ?, direccion = ? WHERE CODIGO = ?";
        String CODIGO = codigo;

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, telefono);
            preSt.setString(3, dpi);
            preSt.setString(4, nit);
            preSt.setString(5, email);
            preSt.setString(6, direccion);
            preSt.setString(7, CODIGO);

            preSt.executeUpdate();

            System.out.println("empleado actualizado");

            //preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Busca el emplead por codigo
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarEmpleadoCodigo(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM EMPLEADO WHERE CODIGO LIKE ? ORDER BY CODIGO ASC";

//  CODIGO VARCHAR(45) NOT NULL,
//  nombre VARCHAR(45) NOT NULL,
//  telefono VARCHAR(8) NOT NULL,
//  DPI VARCHAR(13) NOT NULL,
//  NIT VARCHAR(13),
//  EMAIL VARCHAR(45) NOT NULL,
//  direccion VARCHAR(45) NOT NULL,
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(5),
                    result.getString(4),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
//            result.close();
//            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Busca al empleado usanto el nombre como filtro
     *
     * @param connection
     * @param filtro
     * @param dfm
     */
    public void buscarEmpleadoNombre(Connection connection, String filtro, DefaultTableModel dfm) {
        String query = "SELECT * FROM EMPLEADO WHERE nombre LIKE ? ORDER BY CODIGO ASC";

//  CODIGO VARCHAR(45) NOT NULL,
//  nombre VARCHAR(45) NOT NULL,
//  telefono VARCHAR(8) NOT NULL,
//  DPI VARCHAR(13) NOT NULL,
//  NIT VARCHAR(13),
//  EMAIL VARCHAR(45) NOT NULL,
//  direccion VARCHAR(45) NOT NULL,
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "%" + filtro + "%");
            ResultSet result = preSt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {

                String[] datos = {result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(5),
                    result.getString(4),
                    result.getString(6),
                    result.getString(7)
                };
                dfm.addRow(datos);
            }
//            result.close();
//            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método parra crear un pedido y agregar a la base de datos
     *
     * @param connection
     * @param codigo
     * @param fecha
     * @param cantidad
     * @param total
     * @param anticipo
     * @param tiendaOrigen
     * @param tiendaDestino
     * @param nitCliente
     * @param codigoProducto
     */
    public void crearPedido(Connection connection,
            String codigo,
            String fecha,
            String cantidad,
            String total,
            String anticipo,
            String tiendaOrigen,
            String tiendaDestino,
            String nitCliente,
            String codigoProducto) {
//ID INT NOT NULL AUTO_INCREMENT,
//  CODIGO VARCHAR(45) NOT NULL,
//  fecha DATE NOT NULL,
//  total DOUBLE,
//  anticipo DOUBLE,
//  cantidad_articulos INT NOT NULL,
//  tienda_origen VARCHAR(45) NOT NULL,
//  tienda_destino VARCHAR(45) NOT NULL,
//  NIT_cliente VARCHAR(13) NOT NULL,
//  codigo_producto VARCHAR(45),
        String query = "INSERT INTO PEDIDO (CODIGO, fecha, total, anticipo, cantidad_articulos, tienda_origen, tienda_destino, NIT_cliente, CODIGO_producto)VALUES (?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, fecha);
            preSt.setDouble(3, Double.parseDouble(total));
            preSt.setDouble(4, Double.parseDouble(anticipo));
            preSt.setInt(5, Integer.parseInt(cantidad));
            preSt.setString(6, tiendaOrigen);
            preSt.setString(7, tiendaDestino);
            preSt.setString(8, nitCliente);
            preSt.setString(9, codigoProducto);

            preSt.executeUpdate();

            System.out.println("pedido agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
