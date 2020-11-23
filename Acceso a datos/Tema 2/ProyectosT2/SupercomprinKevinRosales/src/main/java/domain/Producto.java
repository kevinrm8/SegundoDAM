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
    private int puntosProducto;

    public Producto() {
    }

    public Producto(String nombreProducto, float precioProducto, int puntosProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.puntosProducto = puntosProducto;
    }

    public Producto(int idProducto, String nombreProducto, float precioProducto, int puntosProducto) {
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

    public int getPuntosProducto() {
        return puntosProducto;
    }

    public void setPuntosProducto(int puntosProducto) {
        this.puntosProducto = puntosProducto;
    }



    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", puntosProducto=" + puntosProducto+ '}';
    }

}
