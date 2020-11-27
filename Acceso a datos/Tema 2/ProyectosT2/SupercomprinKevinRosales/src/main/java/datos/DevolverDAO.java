/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import domain.Comprar;
import domain.Devolver;
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
public class DevolverDAO {

    private static final String SQL_SELECT = "SELECT idDevolucion,eWallet_id_eWallet,Producto_idProducto,Compra_idCompra FROM devolucion";
    private static final String SQL_INSERT = "INSERT INTO devolucion(eWallet_id_eWallet,Producto_idProducto,Compra_idCompra) VALUES(?,?,?)";
    private static final String SQL_DELETE = "DELETE from devolucion where idDevolucion=?";

    private Connection conexionTransaccional;

    public DevolverDAO() {
    }

    public DevolverDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Devolver> seleccionar_todas_devoluciones() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Devolver devolver = null;
        List<Devolver> listaDevoluciones = new ArrayList<>();
        eWalletDAO ewalletDAO = new eWalletDAO();
        eWallet eWalletQueCompra;
        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoQueCompra;
        ComprarDAO compraDAO = new ComprarDAO();
        Comprar ticketCompra;
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idDevolver = rs.getInt("idDevolucion");
                int ideWallet = rs.getInt("eWallet_id_eWallet");
                int idProducto = rs.getInt("Producto_idProducto");
                int idCompra = rs.getInt("Compra_idCompra");
                eWalletQueCompra = ewalletDAO.obtenerByID(ideWallet); // A partir del ID me guardo los datos de la ewallet que devuelve
                productoQueCompra = productoDAO.obtener(idProducto);// A partir del ID me guardo los datos del Producto que devuelve
                ticketCompra = compraDAO.obtener(idCompra);
                devolver = new Devolver(idDevolver, eWalletQueCompra, productoQueCompra,ticketCompra);
                listaDevoluciones.add(devolver);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return listaDevoluciones;

    }

    public int insertar(Devolver devolver) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, devolver.getEwallet().getIdeWallet());
            stmt.setInt(2, devolver.getProducto().getIdProducto());
            stmt.setInt(3, devolver.getCompra().getIdCompra());
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
    
        public int eliminar(Devolver devolver) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, devolver.getIdDevolver());
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
