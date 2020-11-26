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
    private Comprar compra;

    public Devolver() {
    }

    public Devolver(eWallet ewallet, Producto producto, Comprar compra) {
        this.ewalletDevuelve = ewallet;
        this.productoDevuelve = producto;
        this.compra = compra;
    }

    public Devolver(int idDevolver, eWallet ewallet, Producto producto, Comprar compra) {
        this.idDevolver = idDevolver;
        this.ewalletDevuelve = ewallet;
        this.productoDevuelve = producto;
        this.compra = compra;
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

    public Comprar getCompra() {
        return compra;
    }

    public void setCompra(Comprar compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "Devolver{" + "idDevolver=" + idDevolver + ", ewallet=" + ewalletDevuelve + ", producto=" + productoDevuelve + '}';
    }

}
