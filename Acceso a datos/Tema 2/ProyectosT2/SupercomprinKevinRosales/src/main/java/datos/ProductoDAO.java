/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import domain.Producto;
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
public class ProductoDAO {

    private static final String SQL_SELECT = "SELECT idProducto,Nombre,Precio,Puntos,Stock FROM producto";
    private static final String SQL_INSERT = "INSERT INTO producto(Nombre,Precio,Puntos,Stock) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE producto SET Nombre=?, Precio=?,Puntos=?,Stock=? WHERE idProducto=?";
    private static final String SQL_DELETE = "DELETE from producto where idProducto=?";
    private Connection conexionTransaccional;

    public ProductoDAO() {
    }

    public ProductoDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Producto> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> listaProducto = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombreProducto = rs.getString("Nombre");
                int PrecioProducto = rs.getInt("Precio");
                int PuntosProducto = rs.getInt("Puntos");
                int StockProducto = rs.getInt("Stock");
                producto = new Producto(idProducto, nombreProducto, PrecioProducto, PuntosProducto, StockProducto);
                listaProducto.add(producto);

            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return listaProducto;

    }
    

    public int insertar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombreProducto());
            stmt.setFloat(2, producto.getPrecioProducto());
            stmt.setInt(3, producto.getPuntosProducto());
            stmt.setInt(4, producto.getStockProducto());
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

    public int actualizar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNombreProducto());
            stmt.setFloat(2, producto.getPrecioProducto());
            stmt.setInt(3, producto.getPuntosProducto());
            stmt.setInt(4, producto.getStockProducto());
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

    public int eliminar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getIdProducto());
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
