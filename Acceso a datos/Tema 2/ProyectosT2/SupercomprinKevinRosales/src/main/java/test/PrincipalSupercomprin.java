/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.eWalletDAO;
import domain.eWallet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class PrincipalSupercomprin {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        int opc = -1;
        int cantidad;

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            eWalletDAO eWDAO = new eWalletDAO(conexion);
            eWallet ewallet = new eWallet();
            do { // CREAR EL MENU
                System.out.println("0-Salir\n1-Crear nuevo eWallet\n2-Mostrar todos los eWallet\n3-Ingresar Saldo");
                opc = scanner.nextInt();
                scanner.nextLine();
                switch (opc) {
                    case 0:
                        System.out.println("Gracias por visitar nuestra tienda, adios!");
                        break;
                    case 1:
                        insertarNuevoeWallet(conexion);
                        break;
                    case 2:
                        eWDAO.seleccionar_todos().forEach(action -> {
                            System.out.println(action.toString());
                        });
                        break;
                    case 3:
                        ewallet = ComprobareWallet();
                        if (ewallet != null) {
                            System.out.println("Cantidad a ingresar en la eWallet de " + ewallet.getNombre() + ":");
                            cantidad = scanner.nextInt();
                            scanner.nextLine();
                            ewallet.setSaldo(cantidad);
                            eWDAO.actualizar(ewallet);
                        }
                        break;
                }
                conexion.commit();
                System.out.println("Se ha hecho commit de la transaccion");

            } while (opc != 0 || opc < 0 || opc > 5);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static int calcularAnios(Date fechaNac) {

        //Fecha actual
        java.util.Date actual = new java.util.Date();

        //Cojo los datos necesarios
        int diaActual = actual.getDate();
        int mesActual = actual.getMonth() + 1;
        int anioActual = actual.getYear() + 1900;

        //Diferencia de años
        int diferencia = anioActual - (fechaNac.getYear() + 1900);

        //Si el mes actual es menor que el que me pasan le resto 1
        //Si el mes es igual y el dia que me pasan es mayor al actual le resto 1
        //Si el mes es igual y el dia que me pasan es menor al actual no le resto 1
        if (mesActual <= fechaNac.getMonth()) {
            //si
            if (mesActual == fechaNac.getMonth() + 1) {
                if (fechaNac.getDay() > diaActual) {
                    diferencia--;
                }
            } else {
                diferencia--;
            }
        }
        return diferencia;

    }

    private static void insertarNuevoeWallet(Connection conexion) throws SQLException {
        eWalletDAO eWDAO = new eWalletDAO(conexion);
        eWallet insert_eWallet = new eWallet();
        String nombre;
        int dia, mes, anio;
        String dni;
        int telefono;
        System.out.println("Escribe tu nombre:");
        nombre = scanner.nextLine();
        System.out.println("Tu DNI:");
        dni = scanner.nextLine();
        System.out.println("Fecha de nacimiento(dd mm aaaa):");
        dia = scanner.nextInt();
        mes = scanner.nextInt();
        anio = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Telefono de contacto:");
        telefono = scanner.nextInt();
        scanner.nextLine();

        Date fechanac = new Date(anio, mes - 1, dia);

        insert_eWallet.setNombre(nombre);
        insert_eWallet.setDNI(dni);
        insert_eWallet.setEdad(calcularAnios(fechanac));
        insert_eWallet.setFecha_nacimiento(Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(anio));
        insert_eWallet.setTelefono(telefono);
        eWDAO.insertar(insert_eWallet);

        if (calcularAnios(fechanac) < 18) { // Si tiene menos de 18 hacemos rollback para no introducir el nuevo eWallet
            System.out.println("Para poder crear un nuevo eWallet, debes de tener +18");
            conexion.rollback();
        }
    }

    private static eWallet ComprobareWallet() throws SQLException {
        eWalletDAO eWDAO = new eWalletDAO();
        eWallet ewallet = new eWallet();

        String dni;
        System.out.println("DNI del eWallet donde ingresar el dinero:");
        dni = scanner.nextLine();
        ewallet = eWDAO.obtener(dni);
        if (ewallet == null) {
            System.out.println("No existe ewallet con ese DNI");
        }
        return ewallet;
    }
}
