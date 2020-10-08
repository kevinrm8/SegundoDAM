/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercoo;

import java.util.*;

public class Persona {

    private String nombre;
    private int edad;
    private String DNI;
    private String sexo;
    private double peso;
    private double altura;

    static Random random = new Random();

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.DNI = generarDNI();
        this.sexo = "H";
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String DNI, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = generarDNI();
        this.sexo = "H";
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String DNI, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = generarDNI();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
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
        
        DNI = DNI+letra;

    return DNI ;
}

public void calcularIMC(double peso,double altura){
    double ideal;
    
    ideal = peso/(altura*altura);
    
        
    }
}
