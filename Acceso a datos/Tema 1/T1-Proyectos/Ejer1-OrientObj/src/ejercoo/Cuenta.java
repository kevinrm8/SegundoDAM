/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercoo;
import java.util.*;

public class Cuenta {

    private String titular;
    private double saldo;

    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.saldo = cantidad;
    }

    public Cuenta(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    public Cuenta() {
    }

    @Override
    public String toString() {
        return "Cuenta{" + "titular=" + titular + ", cantidad=" + saldo + '}';
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return saldo;
    }

    public void setCantidad(double cantidad) {
        this.saldo = cantidad;
    }

    public void ingresar(double cantidad) {

        double cantidadIngresar = cantidad;

        if (cantidadIngresar >= 0) {
            this.saldo = cantidad;
        }
    }

    public void Retirar(double cantidad) {

        double cant = cantidad;

        if ((saldo - cant) < 0) {
            saldo = 0;
        } else {
            saldo -= cant;
        }

    }
}
