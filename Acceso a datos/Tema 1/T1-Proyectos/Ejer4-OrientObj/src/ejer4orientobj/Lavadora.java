/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4orientobj;

public class Lavadora extends Electrodomestico {

    private double carga;

    public Lavadora() {
        super();
        this.carga = 5;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = 5;
    }

    public Lavadora(double carga, double precioBase, String color, char consumoEnergito, double peso) {
        super(precioBase, color, consumoEnergito, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    public double precioFinal() { // VERIFICAR SI ESTA BIEN
        double precioF;
        precioF = super.precioFinal(); // DEBO LLAMAR AL PRECIO DE ELECTRODOMESTICO
        if (carga > 30) {
            precioF += 50;
        } else {
            precioF += 0;
        }

        return precioF;

    }
}
