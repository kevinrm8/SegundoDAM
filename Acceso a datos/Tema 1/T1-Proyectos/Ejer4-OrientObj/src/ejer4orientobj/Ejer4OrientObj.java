
package ejer4orientobj;

import java.util.*;

public class Ejer4OrientObj {

    public static void main(String[] args) {

        Electrodomestico listaElectrodomesticos[] = new Electrodomestico[10];

        Random r = new Random();

        //Añadir 10 electrodomesticos
        for (int i = 0; i < 10; i++) {
            int random = r.nextInt(3); // Creo un random entre 0-1-2
            if (random == 0) { // si el random es 0 creo un Electrodomestico
                listaElectrodomesticos[i] = new Electrodomestico();
            } else {
                if (random == 1) {// si el random es 1 creo una Lavadora
                    listaElectrodomesticos[i] = new Lavadora();
                } else {
                    if (random == 2) { // si el random es 2 creo una Television
                        listaElectrodomesticos[i] = new Television();
                    }
                }
            }
        }
        // INICIALIZO LOS PRECIOS TOTALES
        double precioElect = 0;
        double precioLav = 0;
        double precioTele = 0;

        for (int i = 0; i < listaElectrodomesticos.length; i++) {
            Electrodomestico aux = listaElectrodomesticos[i];

            // INSTANCEOF sirve para comprobar de que tipo es el objeto
            if (aux instanceof Television) {
                precioTele += aux.precioFinal();
                // System.out.println("TELE" + aux.precioFinal());
            } else {
                if (aux instanceof Lavadora) {
                    precioLav += aux.precioFinal();
                    //System.out.println("LAV" + aux.precioFinal());
                } else {
                    if (aux instanceof Electrodomestico) {
                        precioElect += aux.precioFinal(); // SUMO AL PRECIO FINAL EL PRECIO ESPECIFICO 
                        //System.out.println("ELE" + aux.precioFinal());
                    }
                }
            }
        }
        // SACAR POR PANTALLA LOS PRECIOS FINALES
        System.out.println(" ELECTRODOMESTICOS: " + precioElect + "\n LAVADORAS:" + precioLav + "\n TELEVISION:" + precioTele);
        System.out.println("Precio total de todos los electrodomesticos: " + (precioElect += precioLav + precioTele));
    }

}
