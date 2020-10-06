/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.io.*;
import java.util.*;

public class Estudiante {

    private String nombre;
    private String apellidos;
    private String DNI;
    private String NotaLetra;
    private int NotaNumero;

    public Estudiante(String nombre, String apellidos, String DNI, int NotaNumero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.NotaNumero = NotaNumero;

        if (NotaNumero < 0) {
            this.NotaLetra = "NotPresent";
        } else {
            if (NotaNumero < 5) {
                this.NotaLetra = "Suspendido";
            } else {
                if (NotaNumero < 7) {
                    this.NotaLetra = "Approved";
                } else {
                    if (NotaNumero < 9) {
                        this.NotaLetra = "Notable";
                    } else {
                        if (NotaNumero < 10) {
                            this.NotaLetra = "Outstanding";
                        } else {
                            if (NotaNumero == 10) {
                                this.NotaLetra = "Honors";
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return nombre +" " + apellidos + " " + DNI + " " + NotaLetra + " " + NotaNumero ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNotaLetra() {
        return NotaLetra;
    }

    public void setNotaLetra(String NotaLetra) {
        this.NotaLetra = NotaLetra;
    }

    public int getNotaNumero() {
        return NotaNumero;
    }

    public void setNotaNumero(int NotaNumero) {
        this.NotaNumero = NotaNumero;
        
        if (NotaNumero < 0) {
            this.NotaLetra = "NotPresent";
        } else {
            if (NotaNumero < 5) {
                this.NotaLetra = "Suspendido";
            } else {
                if (NotaNumero < 7) {
                    this.NotaLetra = "Approved";
                } else {
                    if (NotaNumero < 9) {
                        this.NotaLetra = "Notable";
                    } else {
                        if (NotaNumero < 10) {
                            this.NotaLetra = "Outstanding";
                        } else {
                            if (NotaNumero == 10) {
                                this.NotaLetra = "Honors";
                            }
                        }
                    }
                }
            }
        }
        
    }

}
