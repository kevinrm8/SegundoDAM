/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer3.orientobj.pass;

import java.util.*;

public class Password {

    private String contrasena;
    private int longitud;

    static Random random = new Random();

    public Password() {
        this.longitud = 8;
        this.contrasena = GenerarContrasena();

    }

    public Password(int longitud) {
        this.longitud = longitud;
        this.contrasena = GenerarContrasena();
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    private String GenerarContrasena() {

        String pass = "";
        String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE0123456789abcdefghijklmnñopqrstuvwxyz";
        char letra;
        int r;
        //Para poner los numeros
        for (int i = 0; i < longitud; i++) {
            r = random.nextInt(juegoCaracteres.length());

            letra = juegoCaracteres.charAt(r);
            pass += letra;
        }
        return pass;
    }

    public boolean esFuerte() {
        int contMayus = 0, contMin = 0, contNum = 0;
        char letra;
        String MAYUS = "ABCDEFGHIJKLMNÑOPQRSTUVWYZ";
        String MIN = "abcdefghijklmnñopqrstuvwxyz";
        String NUM = "0123456789";

        //Contar las veces que aparecen las mayusculas
        for (int i = 0; i < contrasena.length(); i++) {
            for (int j = 0; j < MAYUS.length(); j++) {
                letra = contrasena.charAt(i);
                if (letra == MAYUS.charAt(j)) {
                    contMayus++;
                }
            }
        }
        //Contar las veces que aparecen las minusculas
        for (int i = 0; i < contrasena.length(); i++) {
            for (int j = 0; j < MIN.length(); j++) {
                letra = contrasena.charAt(i);
                if (letra == MIN.charAt(j)) {
                    contMin++;
                }
            }
        }
        //Contar las veces que aparecen numeros
        for (int i = 0; i < contrasena.length(); i++) {
            for (int j = 0; j < NUM.length(); j++) {
                letra = contrasena.charAt(i);
                if (letra == NUM.charAt(j)) {
                    contNum++;
                }
            }
        }
        //PRUEBA PARA VER SI CUENTA BIEN
        //System.out.println("MAYUS: " + contMayus + " MIN: " + contMin + " NUM: " + contNum);
        
        // CONDICIONES PARA QUE SEA FUERTE
        if (contMayus > 2 && contMin > 1 && contNum > 5) {
            return true;
        } else {
            return false;

        }
    }
}
