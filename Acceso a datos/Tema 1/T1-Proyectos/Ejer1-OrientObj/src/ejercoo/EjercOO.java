/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercoo;

import java.util.*;

public class EjercOO {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //PARTE DE CREAR CUENTA INGRESOS Y RETIRADAS
        String nombre, opcion;
        double cantidad = 0, ret;

        Cuenta nCuenta;

        System.out.println("Nombre de la cuenta:");
        nombre = scanner.nextLine();

        nCuenta = new Cuenta(nombre);

        System.out.println("Desea realizar un ingreso (Si o No)");
        opcion = scanner.nextLine().toUpperCase();

        if (opcion.equals("SI")) {
            System.out.println("Cantidad a ingresar en la cuenta?");
            cantidad = scanner.nextDouble();
            scanner.nextLine();
            //Ingreso la cantidad pasada por teclado
            nCuenta.ingresar(cantidad);

            System.out.println("Desea realizar un retiro (Si o No)");
            opcion = scanner.nextLine().toUpperCase();
            if (opcion.equals("SI")) {
                System.out.println("Cantidad a retirar");
                ret = scanner.nextDouble();
                //Retiro la cantidad pasada por teclado
                nCuenta.Retirar(ret);

            }

        }

        //Muestro los detalles de la cuenta
        System.out.println(nCuenta.toString());

    }

}
