/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entrega1.ejercicio2;

import datos.CocheDAO;
import datos.PropietarioDAO;
import domain.Coche;
import domain.Propietario;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Kevin Rosales Fecha: 28/10/2020 Asignatura: Acceso a Datos. 2ºDAM
 *
 * Creacion de un concesionario con sus propietarios y coches asociados a la
 * base de datos
 */
public class Entrega1Ejerc2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        PropietarioDAO propietario = new PropietarioDAO();
        Propietario pr = new Propietario();
        CocheDAO coche = new CocheDAO();
        Coche co = new Coche();
        ArrayList<Propietario> listaPropietarios = new ArrayList<>();
        ArrayList<Coche> listaCoche = new ArrayList<>();

        String dni, nombre;
        String matricula, marca;
        int edad, precio;

        int opc = -1; // Opcion del menu
        try {
            do {// Creacion del menu
                System.out.println("0-Salir\n1-Insertar Propietario\n2-Insertar Coche\n3-Actualizar Propietario\n4-Actualizar Coche\n5-Eliminar Propietario\n6-Eliminar Coche\n7-Ver Propietario y sus Coches");
                opc = scanner.nextInt();
                scanner.nextLine();

                //CARGAR LOS DATOS
                listaPropietarios = propietario.seleccionar();

                switch (opc) {
                    case 0:// Salir del programa
                        System.out.println("Adios!");
                        break;
                    case 1: // INSERTAR PROPIETARIO
                        System.out.println("DNI del propietario:");
                        dni = scanner.nextLine();
                        System.out.println("Nombre:");
                        nombre = scanner.nextLine();
                        System.out.println("Edad:");
                        edad = scanner.nextInt();
                        scanner.nextLine();
                        // Creo propietario y lo añado a la base de datos
                        pr = new Propietario(dni, nombre, edad);
                        propietario.insertar(pr);
                        break;

                    case 2:// Insertar coche y asociarlo al DNI
                        System.out.println("Datos del coche a introducir:");
                        System.out.println("Matricula:");
                        matricula = scanner.nextLine();
                        System.out.println("Marca:");
                        marca = scanner.nextLine();
                        System.out.println("Precio:");
                        precio = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("DNI del propietario:");
                        dni = scanner.nextLine();

                        pr = propietario.buscarPropietario(dni); // Busca si existe propietario con ese DNI
                        //Si existe el DNI crea el coche y lo asocia al DNI
                        if (pr != null) {
                            coche.insertar(new Coche(matricula, marca, precio, dni));
                        } else {
                            System.out.println("No hay propietario con ese DNI");
                        }
                        break;
                    case 3: // Actualizar datos del Propietario, pedimos DNI para saber quien actualizar
                        System.out.println("DNI del propietario a actualizar");
                        dni = scanner.nextLine();
                        System.out.println("Nombre:");
                        nombre = scanner.nextLine();
                        System.out.println("Edad:");
                        edad = scanner.nextInt();
                        scanner.nextLine();
                        pr = propietario.buscarPropietario(dni); // Busca si existe propietario con ese DNI
                        if (pr != null) {
                            pr = new Propietario(dni, nombre, edad);
                        } else {
                            System.out.println("No hay propietario con ese DNI");
                        }
                        propietario.actualizar(pr);
                        break;
                    case 4: // Actualizar coche dando su matricula
                        System.out.println("Matricula del coche a actualizar:");
                        matricula = scanner.nextLine();
                        System.out.println("DNI del propietario");
                        dni = scanner.nextLine();
                        System.out.println("Marca:");
                        marca = scanner.nextLine();
                        System.out.println("Precio:");
                        precio = scanner.nextInt();
                        scanner.nextLine();
                        co = coche.buscarCoche(matricula);
                        if (co != null) {
                            coche.actualizar(new Coche(matricula, marca, precio, dni));
                        } else {
                            System.out.println("No existe un coche con esa Matricula");
                        }
                        break;
                    case 5: // Eliminar propietario y sus coches
                        System.out.println("Digame el dni del propietario a borrar:");
                        dni = scanner.nextLine();

                        pr = propietario.buscarPropietario(dni); // Busca si existe propietario con ese DNI
                        if (pr != null) {
                            listaCoche = coche.seleccionar(dni); // Guardo los coches con ese DNI en un array
                            listaCoche.forEach(t -> {
                                coche.eliminarCochesDelPropietario(t); // Borro los coches con ese DNI
                            });
                            propietario.eliminar(pr); //Elimino el propietario
                        } else {
                            System.out.println("No hay propietario con ese DNI");
                        }

                        break;
                    case 6: // Eliminar un coche dando su matricula
                        System.out.println("Matricula del coche a eliminar:");
                        matricula = scanner.nextLine();

                        co = coche.buscarCoche(matricula); // Guardo el coche con esa matricula
                        if (co != null) {
                            coche.eliminar(co);// Borro coche 
                        } else {
                            System.out.println("No hay coche con esa Matricula");
                        }
                        break;
                    case 7: //Ver propietario y sus coches dando el DNI
                        System.out.println("Digame el dni del propietario para ver sus datos:");
                        dni = scanner.nextLine();
                        pr = propietario.buscarPropietario(dni); // Busca si existe propietario con ese DNI
                        if (pr != null) {
                            propietario.mostrarPropietarioCoches(dni);
                        } else {
                            System.out.println("No hay propietario con ese DNI");
                        }
                        break;
                    default:
                        System.out.println("Opcion fuera de rango");
                        break;
                }

            } while (opc != 0 || opc < 0 || opc > 7);
        } catch (InputMismatchException ex) {
            System.out.println("Debe ingresar un numero entero");
        }
    }
}
