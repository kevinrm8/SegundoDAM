/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import domain.Comprar;
import domain.Producto;
import domain.eWallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class ComprarDAO {

    private static final String SQL_SELECT = "SELECT idCompra,eWallet_id_eWallet,Producto_idProducto FROM compra";
    private static final String SQL_INSERT = "INSERT INTO compra(eWallet_id_eWallet,Producto_idProducto) VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE from compra where idCompra=?";
    private Connection conexionTransaccional;

    public ComprarDAO() {
    }

    public ComprarDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Comprar> seleccionar_todas_compras() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comprar compra = null;
        List<Comprar> listaCompras = new ArrayList<>();
        eWalletDAO ewalletDAO = new eWalletDAO();
        eWallet eWalletQueCompra = new eWallet();
        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoQueCompra = new Producto();
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCompra = rs.getInt("idCompra");
                int ideWallet = rs.getInt("eWallet_id_eWallet");
                int idProducto = rs.getInt("Producto_idProducto");

                eWalletQueCompra = ewalletDAO.obtenerByID(ideWallet); // A partir del ID me guardo los datos de la ewallet que compra
                productoQueCompra = productoDAO.obtener(idProducto);// A partir del ID me guardo los datos del Producto que compra
                compra = new Comprar(idCompra, eWalletQueCompra, productoQueCompra);
                listaCompras.add(compra);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return listaCompras;

    }

    public Comprar obtener(int idCompra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comprar compra = null;

        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();
            
            eWalletDAO ewalletDAO = new eWalletDAO();
            eWallet eWalletQueCompra;
            ProductoDAO productoDAO = new ProductoDAO();
            Producto productoQueCompra;
            
            stmt = conn.prepareStatement("SELECT idCompra,eWallet_id_eWallet,Producto_idProducto FROM compra WHERE idCompra='" + idCompra + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ideWallet = rs.getInt(2);
                int idProd = rs.getInt(3);

                eWalletQueCompra = ewalletDAO.obtenerByID(ideWallet); // A partir del ID me guardo los datos de la ewallet que compra
                productoQueCompra = productoDAO.obtener(idProd);// A partir del ID me guardo los datos del Producto que compra

                compra = new Comprar(idCompra, eWalletQueCompra, productoQueCompra);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return compra;
    }

    public int insertar(Comprar compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, compra.geteWalletQueCompra().getIdeWallet());
            stmt.setInt(2, compra.getProductoQueCompra().getIdProducto());
            registros = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
            }
        }
        return registros;
    }

    public int eliminar(Comprar compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, compra.getIdCompra());
            stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
            }
        }
        return registros;
    }

}
