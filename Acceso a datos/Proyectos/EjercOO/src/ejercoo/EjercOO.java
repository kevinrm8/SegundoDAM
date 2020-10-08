/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercoo;

import java.util.*;
import java.awt.*;

/**
 *
 * @author kevmar
 */
public class EjercOO {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String nombre;
        double cantidad,ret;
        boolean aux;

        Cuenta nCuenta;

        System.out.println("Nombre de la cuenta:");
        nombre = scanner.nextLine();

        System.out.println("Cantidad a ingresar en tu nueva cuenta?");
        cantidad = scanner.nextDouble();

        nCuenta = new Cuenta();
        nCuenta.ingresar(cantidad);     
        System.out.println("Cantidad a retirar");
        ret = scanner.nextDouble();
        nCuenta.Retirar(ret);
        System.out.println(nCuenta.toString());
    }

}
