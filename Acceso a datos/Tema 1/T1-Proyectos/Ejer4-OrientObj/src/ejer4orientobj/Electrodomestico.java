/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4orientobj;

public class Electrodomestico {

    private double precioBase;
    private String color;
    private char consumoEnergito;
    private double peso;

    public Electrodomestico() {
        this.precioBase = 100;
        this.color = "blanco";
        this.consumoEnergito = 'F';
        this.peso = 5;
    }

    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.color = "blanco";
        this.consumoEnergito = 'F';
        this.peso = peso;
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergito, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergito = comprobarConsumoEnergito(consumoEnergito);
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergito() {
        return consumoEnergito;
    }

    public double getPeso() {
        return peso;
    }

    private char comprobarConsumoEnergito(char letra) {

        if (letra != 'A' && letra != 'B' && letra != 'C' && letra != 'D' && letra != 'E' && letra != 'F') {
            return 'F';
        } else {
            return letra;
        }

    }

    private String comprobarColor(String color) {

        if (!color.equals("blanco") && !color.equals("negro") && !color.equals("rojo") && !color.equals("azul") && !color.equals("gris")) {
            return "blanco";
        }
        return color;
    }

    public double precioFinal() {
        double precio=precioBase; // Añado el precio base
            
        //Sumo al precio base segun consumo
        if (consumoEnergito == 'A') {
            precio += 100;
        } else {
            if (consumoEnergito == 'B') {
                precio += 80;
            } else {
                if (consumoEnergito == 'C') {
                    precio += 60;
                } else {
                    if (consumoEnergito == 'D') {
                        precio += 50;
                    }
                    if (consumoEnergito == 'E') {
                        precio += 30;
                    } else {
                        if (consumoEnergito == 'F') {
                            precio += 10;
                        }
                    }
                }
            }
        }
        // Despues sumo segun el peso al precio
        if (peso < 20) {
            precio += 10;
        } else {
            if (peso >= 20 && peso < 50) {
                precio += 50;
            } else {
                if (peso <= 50 && peso < 80) {
                    precio += 80;
                } else {
                    if (peso >= 80) {
                        precio += 100;
                    }
                }
            }
        }
        
        return precio;
    }

}
