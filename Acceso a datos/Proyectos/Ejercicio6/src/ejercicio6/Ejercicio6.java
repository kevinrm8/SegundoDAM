package ejercicio6;

import java.util.*;

public class Ejercicio6 {

    /*6. Creeu un programa anomenat venedors que creï
    una matriu de 18 X 10 que indiqui que som propietaris d'una empresa de 
    18 proveïdors cadascun dels quals ven 10 productes.
    La matriu emmagatzema els ingressos obtinguts per cada venedor en cada producte,
    de manera que un menú li permet emmagatzemar els ingressos, revisar el total 
    de cada venedor i obtenir els ingressos totals.  */
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        int[][] matriz;
        int opc, fila, columna, posX=0, posY=0;

        /*Dar de alta las dimensiones de la matriz */
        System.out.println("Dimensiones matriz(fila y columna)");
        fila = scanner.nextInt();
        columna = scanner.nextInt();

        matriz = new int[fila][columna];

        RellenarMatriz(matriz, fila, columna);
        VerMatriz(matriz, fila, columna); //PROBAR LA MATRIZ Y VERLA POR PANALLA

        do {

            System.out.println("MENU: \n1-Ver dato en posicion indicada\n2-Cambiar dato de la posicion indicada\n3- Sumar todos los valores de la matriz\n4-Mostrar matriz\n5-Salir");

            opc = scanner.nextInt();
            
            if(opc !=3 && opc !=4 && opc!=5){
                System.out.println("Dime una posicion en la cual trabajar(Fila - Columna):");
                posX = scanner.nextInt();
                posY = scanner.nextInt();
            }

            switch (opc) {
                case 1:
                    VerDato(matriz, posX, posY);
                    break;
                case 2:
                    CambiarDato(matriz, posX, posY);
                    break;
                case 3:
                    SumaMatriz(matriz, fila, columna);
                    break;
                case 4:
                    VerMatriz(matriz, fila, columna);
                    break;
                default: System.out.println("ADIOS!");
                    break;
            }
        } while (opc != 5);
    }

    private static void RellenarMatriz(int[][] matriz, int fila, int columna) {

        for (int i = 0; i < fila; i++) {

            for (int j = 0; j < columna; j++) {
                int r = random.nextInt(100);
                matriz[i][j] = r;
            }
        }
    }

    private static void VerMatriz(int[][] matriz, int fila, int columna) {

        for (int i = 0; i < fila; i++) {

            for (int j = 0; j < columna; j++) {
                if (j != columna - 1) {
                    System.out.print(matriz[i][j] + " - ");
                } else {
                    System.out.println(matriz[i][j]);
                }
            }
            System.out.println();
        }

    }

    private static void VerDato(int[][] matriz, int posX, int posY) {
        System.out.println("El dato de la posicion [" + posX + "][" + posY + "]es: ");
        System.out.println(matriz[posX][posY]);
    }

    private static void CambiarDato(int[][] matriz, int posX, int posY) {
        int nuevo;
        System.out.println("Introduce el nuevo numero: ");
        nuevo = scanner.nextInt();
        matriz[posX][posY] = nuevo;
    }

    private static void SumaMatriz(int[][] matriz, int fila, int columna) {
        int sumatotal = 0;

        for (int i = 0; i < fila; i++) {

            for (int j = 0; j < columna; j++) {
                if (j != columna - 1) {
                } else {
                    sumatotal += matriz[i][j];
                }
            }
        }
        System.out.println("La suma total de la matriz es: " + sumatotal);

    }

}
