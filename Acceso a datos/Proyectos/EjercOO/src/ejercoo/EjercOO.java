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
        String nombre, opcionIngreso;
        double cantidad = 0, ret;

        Cuenta nCuenta;

        System.out.println("Nombre de la cuenta:");
        nombre = scanner.nextLine();

        System.out.println("Desea realizar un ingreso (Si o No)");
        opcionIngreso = scanner.nextLine();

        if (opcionIngreso.equals("Si")) {
            System.out.println("Cantidad a ingresar en la cuenta?");
            cantidad = scanner.nextDouble();
        }
        //Creo la cuenta e ingreso la cantidad pasada por teclado
        nCuenta = new Cuenta(nombre);
        nCuenta.ingresar(cantidad);

        //Pido cantidad a retirar
        System.out.println("Cantidad a retirar");
        ret = scanner.nextDouble();

        nCuenta.Retirar(ret);
        System.out.println(nCuenta.toString());

    }


}
