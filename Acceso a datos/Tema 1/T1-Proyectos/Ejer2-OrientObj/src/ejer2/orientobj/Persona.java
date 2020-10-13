/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer2.orientobj;

import java.util.*;

public class Persona {

    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    static Random random = new Random();

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.DNI = generarDNI();
        this.sexo = 'H';
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = generarDNI();
        this.sexo = 'H';
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = generarDNI();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + '}';
    }

    public String generarDNI() {
        String DNI = "";
        int r;
        //Para poner los numeros
        for (int i = 0; i < 8; i++) {
            r = random.nextInt(10);
            DNI += r;
        }
        //Para asignar la letra

        String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";

        int modulo = Integer.parseInt(DNI) % 23;

        char letra = juegoCaracteres.charAt(modulo);

        DNI = DNI + letra;

        return DNI;
    }

    public void calcularIMC() {
        double ideal;
        int dev = 2;
        ideal = peso / (altura * altura);
        if (altura == 0) {
            System.out.println("No hay valores de altura para poder calcular el IMC");
        } else {
            if (ideal < 20) {
                dev = -1;
                System.out.println("Por debajo de tu peso");
            } else {
                if (ideal >= 20 && ideal <= 25) {
                    dev = 0;
                    System.out.println("Tu peso es ideal.");
                } else {
                    if (ideal > 25) {
                        dev = 1;
                        System.out.println("Tienes sobrepeso.");
                    }
                }
            }
        }

    }
    //esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.

    public boolean esMayorDeEdad() {
        boolean mayor = false;

        if (edad >= 18) {
            mayor = true;
        }
        return mayor;
    }

    //comprobarSexo(char sexo): comprueba que el sexo introducido es
    //correcto. Si no es correcto, sera H. No sera visible al exterior.
    public void comrpobarSexo(char sexo) {

        if (sexo != 'H' && sexo != 'M') {
            sexo = 'H';
        }

    }

}

