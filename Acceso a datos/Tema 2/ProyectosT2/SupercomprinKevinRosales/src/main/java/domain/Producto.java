/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author kevin
 */
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private float precioProducto;
    private float puntosProducto;

    public Producto() {
    }

    public Producto(String nombreProducto, float precioProducto, float puntosProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.puntosProducto = puntosProducto;
    }

    public Producto(int idProducto, String nombreProducto, float precioProducto, float puntosProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.puntosProducto = puntosProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public float getPuntosProducto() {
        return puntosProducto;
    }

    public void setPuntosProducto(float puntosProducto) {
        this.puntosProducto = puntosProducto;
    }

    @Override
    public String toString() {
        return "ID_Producto: " + idProducto + "\tNombre: " + nombreProducto + "\tPrecio: " + precioProducto + "\tPuntos: " + puntosProducto;
    }

}
