package ejercicio7;

import java.util.*;
import java.util.*;

public class Ejercicio7 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Estudiante> ListaAlumnos = new ArrayList<Estudiante>();

        //EJEMPLO DE METER UN ESTUDIANTE EN LA ARRAY Y MOSTRARLO
        //Estudiante e = new Estudiante("Kevin", "apellido", "DNI", 0);       
        //ListaAlumnos.add(e);
        // System.out.println(ListaAlumnos.get(0).getNombre());
        int opc;

        do {
            System.out.println("-----MENU-----\n1-Anadir nuevo Estudiante\n2-Eliminar un estudiante\n3-Cambiar datos del alumno\n4-Mostrar lista de alumnos\n5-Cambiar nota\n6-Mostrar el nombre del alumno segun su nota");
            opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    AnadirAlumno(ListaAlumnos);
                    break;
                case 2:
                    EliminarAlumno(ListaAlumnos);
                    break;
                case 3:
                    CambiarDatos(ListaAlumnos);
                    break;
                case 4:
                    MostrarLista(ListaAlumnos);
                    break;
                case 5:
                    CambiarNota(ListaAlumnos);
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Adios!");
                default:
                    break;
            }

        } while (opc != 7);

    }

    private static void AnadirAlumno(ArrayList<Estudiante> ListaAlumnos) {
        String nombre;
        String apellido;
        String DNI;
        int nota;

        System.out.println("Nombre: ");
        nombre = scanner.nextLine();
        System.out.println("Apellidos:");
        apellido = scanner.nextLine();
        System.out.println("DNI:");
        DNI = scanner.nextLine();
        System.out.println("Nota");
        nota = scanner.nextInt();

        Estudiante e = new Estudiante(nombre, apellido, DNI, nota);
        ListaAlumnos.add(e);
    }

    private static void EliminarAlumno(ArrayList<Estudiante> ListaAlumnos) {
        int pos;
        System.out.println("Posicion del alumno a eliminar");
        pos = scanner.nextInt();
        scanner.nextLine();

        if (pos-1 > ListaAlumnos.size() || pos < 0) {
            System.out.println("Alumno no encontrado");
        } else {
            ListaAlumnos.remove(pos-1);

        }

    }

    private static void CambiarDatos(ArrayList<Estudiante> ListaAlumnos) {
        int pos;

        String nombre;
        String apellido;
        String DNI;

        System.out.println("Posicion del alumno a eliminar");
        pos = scanner.nextInt();
        scanner.nextLine();

        if (pos > ListaAlumnos.size() || pos < 0) {
            System.out.println("Alumno no encontrado");
        } else {
            System.out.println("Introduce los nuevos datos:");

            System.out.println("Nombre: ");
            nombre = scanner.nextLine();
            System.out.println("Apellidos:");
            apellido = scanner.nextLine();
            System.out.println("DNI:");
            DNI = scanner.nextLine();

            ListaAlumnos.get(pos - 1).setNombre(nombre);
            ListaAlumnos.get(pos - 1).setApellidos(apellido);
            ListaAlumnos.get(pos - 1).setDNI(DNI);

        }
    }

    private static void MostrarLista(ArrayList<Estudiante> ListaAlumnos) {
        Estudiante aux;
        Iterator iter = ListaAlumnos.iterator();

        while (iter.hasNext()) {
            aux = (Estudiante) iter.next();
            System.out.println(aux.toString());
        }
    }

    private static void CambiarNota(ArrayList<Estudiante> ListaAlumnos) {
        int nota;
        int pos;

        System.out.println("Posicion del alumno a eliminar");
        pos = scanner.nextInt();
        scanner.nextLine();

        if (pos > ListaAlumnos.size() || pos < 0) {
            System.out.println("Alumno no encontrado");
        } else {
            System.out.println("Nota nueva del alumno "+ListaAlumnos.get(pos-1).getNombre()+":");
            nota = scanner.nextInt();
            
            ListaAlumnos.get(pos-1).setNotaNumero(nota);
        }
    }

}
