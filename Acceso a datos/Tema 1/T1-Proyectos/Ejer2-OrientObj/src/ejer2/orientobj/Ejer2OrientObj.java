/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer2.orientobj;

import java.util.*;

/**
 *
 * @author kevin
 */
public class Ejer2OrientObj {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String nombrePersona;
        int edadPersona;
        char sexoPersona;
        double pesoPersona, alturaPersona;

        System.out.println("Nombre;");
        nombrePersona = scanner.nextLine();
        System.out.println("edad");
        edadPersona = scanner.nextInt();
        scanner.nextLine();
        System.out.println("sexo(H o M)");
        sexoPersona = scanner.next().toUpperCase().charAt(0);
        System.out.println("Peso ");
        pesoPersona = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Altura");
        alturaPersona = scanner.nextDouble();
        scanner.nextLine();

        //Crea 3 objetos de la clase Persona
        Persona P1 = new Persona(nombrePersona, edadPersona, sexoPersona, pesoPersona, alturaPersona); //Objeto con las variables

        Persona P2 = new Persona(nombrePersona, edadPersona, sexoPersona);//Obejto con las variables menos peso y altura

        Persona P3 = new Persona(); //Objeto por defecto pero le damos los atributos por los metodos set
        P3.setNombre(nombrePersona);
        P3.setEdad(edadPersona);
        P3.setSexo(sexoPersona);
        P3.setPeso(pesoPersona);
        P3.setAltura(alturaPersona);

        System.out.println(P1.toString());

        P1.calcularIMC();

        P2.calcularIMC();

        P3.calcularIMC();
    }

}
