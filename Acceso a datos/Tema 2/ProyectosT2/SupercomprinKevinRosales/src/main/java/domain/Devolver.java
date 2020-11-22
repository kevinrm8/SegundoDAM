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
    private eWallet ewallet;
    private Producto producto;

    public Devolver() {
    }

    public Devolver(int idDevolver, eWallet ewallet, Producto producto) {
        this.idDevolver = idDevolver;
        this.ewallet = ewallet;
        this.producto = producto;
    }

    public int getIdDevolver() {
        return idDevolver;
    }

    public void setIdDevolver(int idDevolver) {
        this.idDevolver = idDevolver;
    }

    public eWallet getEwallet() {
        return ewallet;
    }

    public void setEwallet(eWallet ewallet) {
        this.ewallet = ewallet;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Devolver{" + "idDevolver=" + idDevolver + ", ewallet=" + ewallet + ", producto=" + producto + '}';
    }
    
}
