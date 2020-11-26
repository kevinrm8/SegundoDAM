/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.ComprarDAO;
import datos.Conexion;
import datos.DevolverDAO;
import datos.ProductoDAO;
import datos.eWalletDAO;
import domain.Comprar;
import domain.Devolver;
import domain.Producto;
import domain.eWallet;

//import java.util.Date;
import java.sql.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class PrincipalSupercomprin {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException, InterruptedException {
        int opc = -1; // Inicializo opc para el menu
        try {

            eWallet ewallet;
            Comprar compra;
            do { // CREAR EL MENU
                System.out.println("0-Salir\n1-Crear nuevo eWallet\n2-Mostrar todos los eWallet\n3-Ingresar Saldo\n4-Comprar Producto\n5-Devolver Producto");
                opc = scanner.nextInt();
                scanner.nextLine();
                switch (opc) {
                    case 0:
                        System.out.println("Gracias por visitar nuestra tienda.\nHasta pronto!");
                        break;
                    case 1:
                        insertarNuevoeWallet();
                        break;
                    case 2:
                        MostrareWallets();
                        break;
                    case 3:
                        ewallet = ComprobareWallet();
                        if (ewallet != null) {
                            IngresarSaldo(ewallet);
                        }
                        break;
                    case 4:
                        ewallet = ComprobareWallet();
                        if (ewallet != null) {
                            ComprarUnProducto(ewallet);
                        }
                        break;
                    case 5:
                        compra = comprobarCompra();
                        DevolverProducto(compra);
                        break;
                }

            } while (opc != 0 || opc < 0 || opc > 5);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Exception main");

        }
    }

    public static int calcularAnios(java.util.Date fechaNacimiento) {

        LocalDate fechanac = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Transformo la fecha Date en LocalDate para poder hacer los calculos 
        LocalDate fechaHOY = LocalDate.now(); // GUARDO LA FECHA HOY
        Period periodo = Period.between(fechanac, fechaHOY); // CALCULO LA DIFERENCIA DE TIEMPO ENTRE FECHA NACIMIENTO Y HOY

        return periodo.getYears(); // DEVUELVO LOS AÑOS QUE TIENE ACTUALMENTE
    }

    private static void insertarNuevoeWallet() throws SQLException, ParseException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            eWalletDAO eWDAO = new eWalletDAO(conexion);
            eWallet insert_eWallet = new eWallet();

            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("DNI:");
            String dni = scanner.nextLine();

            System.out.println("Numero de telefono:");
            int telefono = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Fecha de nacimiento(yyyy-MM-dd):");
            String fechanacimiento = scanner.nextLine();

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd"); // DAR FORMATO A LA FECHA
            java.util.Date fechaJAVA = formatoFecha.parse(fechanacimiento); // INTRODUCIR FECHA DE NACIMIENTO
            Date fechaSQL = new Date(fechaJAVA.getTime()); // PASAR fecha de util.date a sql.date

            insert_eWallet.setNombre(nombre);
            insert_eWallet.setDNI(dni);
            insert_eWallet.setEdad(calcularAnios(fechaJAVA)); // Con el metodo CalcularAnios calculamos la edad que tiene
            insert_eWallet.setFecha_nacimiento(fechaSQL);
            insert_eWallet.setTelefono(telefono);
            try {
                eWDAO.insertar(insert_eWallet);
            } catch (SQLException ex) {
                System.out.println("El DNI de la eWallet ya existe");
                // ex.printStackTrace(System.out); Para ver el error
            }
            if (insert_eWallet.getEdad() < 18) { // Si tiene menos de 18 hacemos rollback para no introducir el nuevo eWallet
                System.out.println("Para poder crear un nuevo eWallet, debes de tener +18");
                try {
                    conexion.rollback();
                } catch (SQLException ex1) {
                    System.out.println("Entramos al rollback // InsertarNuevoWallet");
                    // ex.printStackTrace(System.out); Para ver el error
                }
            } else { // Si es mayor de edad hace el commit 
                conexion.commit();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private static void MostrareWallets() throws SQLException {
        eWalletDAO eWDAO = new eWalletDAO();
        eWDAO.seleccionar_todos().forEach(action -> {
            System.out.println(action.toString());
        });
    }

    private static eWallet ComprobareWallet() throws SQLException {
        Connection conexion = null;
        eWallet ewallet = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            eWalletDAO eWDAO = new eWalletDAO();

            String dni;
            System.out.println("DNI del eWallet:");
            dni = scanner.nextLine();
            ewallet = eWDAO.obtener(dni);
            if (ewallet == null) {
                System.out.println("No existe ewallet con ese DNI");
            }
            return ewallet;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Exception from Comprobar eWallet");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        return ewallet;
    }

    private static void ComprarUnProducto(eWallet ewallet) throws SQLException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            eWalletDAO ewalletDAO = new eWalletDAO(conexion);
            ComprarDAO comprarDAO = new ComprarDAO(conexion);
            Comprar comprar;
            ProductoDAO productoDAO = new ProductoDAO(conexion);
            Producto producto = null;

            int idproducto;
            System.out.println("++++++++++++++++++++\n" + ewallet.verSaldoyPuntos() + "\n++++++++++++++++++++");
            //Muestro todos los productos que se pueden comprar
            productoDAO.seleccionar_todos().forEach(l -> {
                System.out.println(l.toString());
            });
            System.out.println("Id del Producto que desea comprar: ");
            idproducto = scanner.nextInt();
            scanner.nextLine();
            producto = productoDAO.obtener(idproducto);
            if (producto == null) {
                System.out.println("El id del producto indicado, no existe.");
            } else {
                System.out.println("Desea pagar con Puntos?(Y-N)");
                String eleccionPagar = scanner.nextLine().toLowerCase();

                if (eleccionPagar.equals("n")) {// OPERACION PARA PAGAR CON DINERO
                    float saldoAntesDeComprar = ewallet.getSaldo(); // Guardo el dinero de la ewallet antes de hacer ninguna operacion
                    System.out.println("****************************************");
                    System.out.println("Saldo de la eWallet " + ewallet.getSaldo() + "€\nPuntos de la eWallet " + ewallet.getPuntos());
                    System.out.println("---------------------------------------------");
                    System.out.println("El precio del producto es " + producto.getPrecioProducto() + "\nPuntos del producto " + producto.getPuntosProducto());
                    System.out.println("****************************************");
                    ewallet.restarSaldo(producto.getPrecioProducto()); // Restar el precio del producto a la eWallet
                    ewallet.sumarPuntos(producto.getPuntosProducto());
                    System.out.println("Saldo final de la eWallet: " + ewallet.getSaldo() + "\nPuntos finales de la eWallet " + ewallet.getPuntos());
                    System.out.println("****************************************");
                    ewalletDAO.actualizar(ewallet); // Actualizar la eWallet con el nuevo saldo y puntos    
                    comprar = new Comprar(ewallet, producto); // Creo la compra?
                    try {
                        comprarDAO.insertar(comprar);   // Inserto la compra a la base de datos
                    } catch (SQLException ex) {
                        System.out.println("Error al insertar compra");
                    }
                    //Compruebo si hay suficiente saldo para comprar, si no lo hay, hacemos rollback para no comprar el producto
                    if (saldoAntesDeComprar < producto.getPrecioProducto()) {
                        System.out.println("No hay suficiente dinero para comprar " + producto.getNombreProducto());
                        try {
                            conexion.rollback();
                        } catch (SQLException ex1) {
                            ex1.printStackTrace(System.out);
                        }
                    } else {
                        System.out.println("Compra realizada correctamente.");
                        conexion.commit();
                    }
                } else {//OPERACION PARA PAGAR CON PUNTOS
                    float puntosAntesComprar = ewallet.getPuntos();//Guardo los puntos que tiene la eWallet antes de hacer ninguna operacion
                    System.out.println("****************************************");
                    System.out.println("Saldo de la eWallet " + ewallet.getSaldo() + "€\nPuntos de la eWallet " + ewallet.getPuntos());
                    System.out.println("---------------------------------------------");
                    System.out.println("El precio del producto es " + producto.getPrecioProducto() + "\nPuntos del producto " + producto.getPuntosProducto());
                    System.out.println("****************************************");
                    ewallet.restarPuntos(producto.getPrecioProducto()); // Restar el precio del producto a los puntos del eWallet
                    ewallet.sumarPuntos(producto.getPuntosProducto());  //Sumo los puntos del producto a la eWallet
                    System.out.println("Saldo final de la eWallet: " + ewallet.getSaldo() + "\nPuntos finales de la eWallet " + ewallet.getPuntos());
                    System.out.println("****************************************");
                    ewalletDAO.actualizar(ewallet); // Actualizar la eWallet con el nuevo saldo y puntos    
                    comprar = new Comprar(ewallet, producto); // Creo la compra?

                    comprarDAO.insertar(comprar);   // Inserto la compra a la base de datos

                    if (producto.getPrecioProducto() < 5 || puntosAntesComprar <= producto.getPrecioProducto()) { // Condicion de que el precio sea mayor que 5 y se pueda comprar integramente con puntos
                        System.out.println("No tiene suficientes puntos para comprar el producto " + producto.getNombreProducto());
                        try {
                            conexion.rollback();
                        } catch (SQLException ex1) {
                            ex1.printStackTrace(System.out);
                        }
                    } else {
                        System.out.println("Compra realizada correctamente.");
                        conexion.commit();
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Exception from IngresarSaldo");
        }

    }

    private static void IngresarSaldo(eWallet ewallet) throws SQLException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            float cantidad;
            eWalletDAO eWDAO = new eWalletDAO(conexion);

            System.out.println("Cantidad a ingresar en la eWallet de " + ewallet.getNombre() + ":");
            cantidad = scanner.nextFloat();
            ewallet.sumarSaldo(cantidad);
            eWDAO.actualizar(ewallet);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaHOY = LocalDate.now(); // GUARDO LA FECHA HOY
            System.out.println("DIAS: " + fechaHOY.getDayOfMonth());

            if (fechaHOY.getDayOfMonth() > 5) { // Si el dia del mes es mayor que 5, no podemos hacer un ingreso.
                System.out.println("Solo se permiten hacer ingresos durante los 5 primeros dias del mes");
                try {
                    conexion.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace(System.out);
                }
            } else {
                conexion.commit();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Exception from IngresarSaldo");

        }

    }

    private static Comprar comprobarCompra() throws SQLException {
        Connection conexion = null;
        Comprar compra = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            ComprarDAO compraDAO = new ComprarDAO(conexion);
            int idCompra;
            System.out.println("Digame el id de la compra a devolver:");
            idCompra = scanner.nextInt();
            scanner.nextLine();
            compra = compraDAO.obtener(idCompra);
            if (compra == null) {
                System.out.println("No existe ewallet con ese DNI");
            }
            return compra;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Exception from IngresarSaldo");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        return compra;
    }

    private static void DevolverProducto(Comprar compra) throws InterruptedException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            System.out.println("Preparando la devolucion de su compra.\n Espere...");
            Thread.sleep(3000);

            eWalletDAO eWDAO = new eWalletDAO(conexion);
            eWallet ewallet;
            Producto producto;

            DevolverDAO devolverdao = new DevolverDAO(conexion);
            Devolver devolver;

            ewallet = compra.geteWalletQueCompra();
            producto = compra.getProductoQueCompra();

            System.out.println("****************************************");
            System.out.println("Saldo de la eWallet " + ewallet.getSaldo() + "€\nPuntos de la eWallet " + ewallet.getPuntos());
            System.out.println("---------------------------------------------");
            System.out.println("El precio del producto es " + producto.getPrecioProducto() + "\nPuntos del producto " + producto.getPuntosProducto());
            System.out.println("****************************************");
            //Debo restar los puntos y sumar el saldo a la eWallet
            ewallet.sumarSaldo(producto.getPrecioProducto());
            ewallet.restarPuntos(producto.getPuntosProducto());
            System.out.println("Saldo final de la eWallet: " + ewallet.getSaldo() + "\nPuntos finales de la eWallet " + ewallet.getPuntos());
            System.out.println("****************************************");

            eWDAO.actualizar(ewallet);

            devolver = new Devolver(ewallet, producto, compra);
            //Para capturar error al intentar devolver una compra que ya esta devuelta
            try {
                devolverdao.insertar(devolver);
            } catch (SQLException ex) {
                System.out.println("La compra ya ha sido devuelta.");
                ex.printStackTrace(System.out);
            }
            //Comprobacion de los puntos para poder hacer la devolucion
            if (ewallet.getPuntos() < 5) {
                System.out.println("***ATENCION***\nLa eWallet se queda con menos de 5 Puntos, no es posible hacer la devolucion.");
                try {
                    conexion.rollback();
                } catch (SQLException ex1) {
                    System.out.println("Entramos en el Rollback // DevolverProducto");
                    // ex1.printStackTrace(System.out); Para ver el error
                }
            } else {
                conexion.commit();
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Exception from IngresarSaldo");

        }

    }
}
