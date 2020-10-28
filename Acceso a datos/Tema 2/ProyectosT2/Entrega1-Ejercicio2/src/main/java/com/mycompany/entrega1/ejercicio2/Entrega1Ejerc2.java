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
 * @author kevin
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

//        //CARGAR LOS DATOS
//        listaPropietarios = propietario.seleccionar();
//        listaCoche = coche.seleccionar();
        String dni, nombre;
        String matricula, marca;
        int edad, precio;

        int opc = -1;
        do {
            System.out.println("0-Salir\n1-Insertar Propietario\n2-Insertar Coche\n3-Actualizar Propietario\n4-Actualizar Coche\n5-Eliminar Propietario\n6-Eliminar Coche\n7-Ver Propietario y sus Coches");
            opc = scanner.nextInt();
            scanner.nextLine();

            //CARGAR LOS DATOS
            listaPropietarios = propietario.seleccionar();
            // listaCoche = coche.seleccionar();

            switch (opc) {
                case 1:
                    System.out.println("DNI del propietario:");
                    dni = scanner.nextLine();
                    System.out.println("Nombre:");
                    nombre = scanner.nextLine();
                    System.out.println("Edad:");
                    edad = scanner.nextInt();
                    scanner.nextLine();
                    pr = new Propietario(dni, nombre, edad);
                    propietario.insertar(pr);
                    break;

                case 2:
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

                    coche.insertar(new Coche(matricula, marca, precio, dni));

                    break;
                case 3:
                    System.out.println("DNI del propietario a actualizar");
                    dni = scanner.nextLine();
                    System.out.println("Nombre:");
                    nombre = scanner.nextLine();
                    System.out.println("Edad:");
                    edad = scanner.nextInt();
                    scanner.nextLine();
                    pr = new Propietario(dni, nombre, edad);
                    propietario.actualizar(pr);
                    break;
                case 4:
                    System.out.println("DNI del propietario del coche");
                    dni = scanner.nextLine();
                    System.out.println("Matricula:");
                    matricula = scanner.nextLine();
                    System.out.println("Marca:");
                    marca = scanner.nextLine();
                    System.out.println("Precio:");
                    precio = scanner.nextInt();
                    scanner.nextLine();
                    coche.actualizar(new Coche(matricula, marca, precio, dni));
                    break;
                case 5:
                    System.out.println("Digame el dni del propietario a borrar:");
                    dni = scanner.nextLine();

                    listaCoche = coche.seleccionar(dni); // Guardo los coches con ese DNI en un array
                    listaCoche.forEach(t -> {
                        coche.eliminarCochesDelPropietario(t); // Borro los coches con ese DNI
                    });
                    pr = propietario.buscarPropietario(dni); //Busco el propietario
                    propietario.eliminar(pr); //Elimino el propietario

                    break;
                case 6:
                    System.out.println("Matricula del coche a eliminar:");
                    matricula = scanner.nextLine();
                    
                    co = coche.buscarCoche(matricula); // Guardo el coche con esa matricula
                    coche.eliminar(co);// Borro coche 
                    break;
                case 7:
                    System.out.println("Digame el dni del propietario para ver sus datos:");
                    dni = scanner.nextLine();

                    propietario.mostrarPropietarioCoches(dni);
                    break;
            }

        } while (opc != 0);

    }

    private static void mostrarPropietarioCoches(String dni, ArrayList<Propietario> listaPropietarios, ArrayList<Coche> listaCoche) {
        System.out.println("Los datos del propietario son: ");
        listaPropietarios.forEach(p -> {
            if (p.getDNI().equals(dni)) {
                System.out.println(p.toString());
            }
        });

        System.out.println("Los coches del propietario son: ");
        listaCoche.forEach(c -> {
            if (c.getDNI().equals(dni)) {
                System.out.println(c.toString());
            }
        });
    }

}
