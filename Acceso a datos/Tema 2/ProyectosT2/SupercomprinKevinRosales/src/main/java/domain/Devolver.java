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
public class Devolver {
    private int idDevolver;
    private eWallet ewalletDevuelve;
    private Producto productoDevuelve;

    public Devolver() {
    }

    public Devolver(eWallet ewallet, Producto producto) {
        this.ewalletDevuelve = ewallet;
        this.productoDevuelve = producto;
    }

    public Devolver(int idDevolver, eWallet ewallet, Producto producto) {
        this.idDevolver = idDevolver;
        this.ewalletDevuelve = ewallet;
        this.productoDevuelve = producto;
    }

    public int getIdDevolver() {
        return idDevolver;
    }

    public void setIdDevolver(int idDevolver) {
        this.idDevolver = idDevolver;
    }

    public eWallet getEwallet() {
        return ewalletDevuelve;
    }

    public void setEwallet(eWallet ewallet) {
        this.ewalletDevuelve = ewallet;
    }

    public Producto getProducto() {
        return productoDevuelve;
    }

    public void setProducto(Producto producto) {
        this.productoDevuelve = producto;
    }

    @Override
    public String toString() {
        return "Devolver{" + "idDevolver=" + idDevolver + ", ewallet=" + ewalletDevuelve + ", producto=" + productoDevuelve + '}';
    }
    
}
