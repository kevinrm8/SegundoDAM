
package accesodatosproyectos;

import java.util.*;

public class AccesoDatosProyectos {
//PRIMEROS EJERCICIOS DIA 22/10/2020
    //Kevin Rosales         2ºDAM

    public static void main(String[] args) {

        //Llamar al ejercicio Para probar algun ejercicio descomentar
        
        // Ejercicio1(); 
        // Ejercicio2();
        // Ejercicio3();
        //Ejercicio4();
        //Ejercicio5();
    }

    public static void Ejercicio1() {
        Scanner scanner = new Scanner(System.in);
        int tipo;
        int alcohol;

        System.out.println("Tipo ( 1 o 2)");
        tipo = scanner.nextInt();

        do {
            System.out.println("Porcentaje alcohol en sangre:");
            alcohol = scanner.nextInt();
            if (alcohol < 0 || alcohol > 100) {
                System.out.println("Porcentaje no valido");
            }
        } while (alcohol < 0 || alcohol > 100);

        switch (tipo) {
            case 1:
                if (alcohol > 30) {
                    System.out.println("No puede conducir");
                } else {
                    System.out.println("Puedes conducir");
                }

                break;
            case 2:
                if (alcohol > 50) {
                    System.out.println("No puede conducir");
                } else {
                    System.out.println("Puedes conducir");
                }
                break;

        }
    }

    public static void Ejercicio2() {

        Scanner scanner = new Scanner(System.in);

        int a, b, c;

        System.out.println("Dime los 3 lados del triangulo:");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        if (a + b > c) {
            System.out.println("Si es un triangulo");
        } else {
            System.out.println("No es un triangulo");
        }

    }

    public static void Ejercicio3() {

        Scanner scanner = new Scanner(System.in);

        int numero;

        System.out.println("Dime un numero: ");
        numero = scanner.nextInt();

        System.out.println("Sus divisores son: ");

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                System.out.println("El numero " + i + " es divisor");
            }
        }
    }

    public static void Ejercicio4() {

        Scanner scanner = new Scanner(System.in);

        int numero;

        System.out.println("Dime un numero: ");
        numero = scanner.nextInt();

        for (int i = 1; i <= numero; i++) {
            System.out.print(i + " ");

            if (i * 2 < numero) {
                System.out.print(i * 2 + " ");
            }

            if (i * 3 < numero) {
                System.out.print(i * 3 + " ");
            }
            System.out.println();

        }

    }

    public static void Ejercicio5() {

        int[][] Vect = new int[5][3]; // Creo la matriz

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                int n = random.nextInt(90); // Numero random entre 1-90
                Vect[i][j] = n;
                if (j != 2) {
                    System.out.print(Vect[i][j] + " - ");
                } else {
                    System.out.print(Vect[i][j]);
                }

            }
            System.out.println();
        }

    }

}
