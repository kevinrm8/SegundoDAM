
package ejer3.orientobj.pass;

import java.util.*;

public class Ejer3OrientObjPass {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Password> listaPassword = new ArrayList<Password>();
        ArrayList<Boolean> esFuerte = new ArrayList<Boolean>();

        int tamano, longitud;

        System.out.println("Cuantas contraseñas quiere generar? ");
        tamano = scanner.nextInt();
        System.out.println("Tamaño de las contraseñas: ");
        longitud = scanner.nextInt();
        scanner.nextLine();

        Password P;
        for (int i = 0; i < tamano; i++) {
            P = new Password(longitud);
            listaPassword.add(P);
            esFuerte.add(P.esFuerte());

            System.out.println("Contraseña" + (i + 1) + ": " + listaPassword.get(i).getContrasena() + "_" + esFuerte.get(i));
        }
    }

}
