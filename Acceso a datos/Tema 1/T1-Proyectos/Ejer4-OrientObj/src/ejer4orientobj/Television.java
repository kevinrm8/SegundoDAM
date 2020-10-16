/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4orientobj;

public class Television extends Electrodomestico {

    private double pulgadas;
    private boolean TDT;

    public Television() {
        this.pulgadas = 20;
        this.TDT = false;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.pulgadas = 20;
        this.TDT = false;
    }

    public Television(double pulgadas, boolean TDT, double precioBase, String color, char consumoEnergito, double peso) {
        super(precioBase, color, consumoEnergito, peso);
        this.pulgadas = pulgadas;
        this.TDT = TDT;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public boolean isTDT() {
        return TDT;
    }

    public double precioFinal() {
        double precioF = 0;
        precioF = super.precioFinal(); // DEBO LLAMAR AL PRECIO DE ELECTRODOMESTICO

        if (TDT) {
            precioF += 50;
        } else {
            precioF += 0;
        }
        if (pulgadas > 40) {
            precioF = precioF + (precioF * 0.3);
        }

        return precioF;
    }
}
