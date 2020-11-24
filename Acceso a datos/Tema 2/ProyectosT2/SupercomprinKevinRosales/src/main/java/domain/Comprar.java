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
public class Comprar {
    
    private int idCompra;
    private eWallet eWalletQueCompra;
    private Producto productoQueCompra;

    public Comprar() {
    }

    public Comprar(eWallet eWalletQueCompra, Producto productoQueCompra) {
        this.eWalletQueCompra = eWalletQueCompra;
        this.productoQueCompra = productoQueCompra;
    }

    public Comprar(int idCompra, eWallet eWalletQueCompra, Producto productoQueCompra) {
        this.idCompra = idCompra;
        this.eWalletQueCompra = eWalletQueCompra;
        this.productoQueCompra = productoQueCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public eWallet geteWalletQueCompra() {
        return eWalletQueCompra;
    }

    public void seteWalletQueCompra(eWallet eWalletQueCompra) {
        this.eWalletQueCompra = eWalletQueCompra;
    }

    public Producto getProductoQueCompra() {
        return productoQueCompra;
    }

    public void setProductoQueCompra(Producto productoQueCompra) {
        this.productoQueCompra = productoQueCompra;
    }

    @Override
    public String toString() {
        return "Comprar{" + "idCompra=" + idCompra + ", eWalletQueCompra=" + eWalletQueCompra + ", productoQueCompra=" + productoQueCompra + '}';
    }
    
}
