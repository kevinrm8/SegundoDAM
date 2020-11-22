/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import java.util.*;
import java.sql.*;

import domain.eWallet;

/**
 *
 * @author kevin
 */
public class eWalletDAO {

    private static final String SQL_SELECT = "SELECT id_eWallet,Nombre,DNI,Edad,FechaNacimiento,Telefono,Saldo,Puntos FROM ewallet";
    private static final String SQL_INSERT = "INSERT INTO ewallet(Nombre,DNI,Edad,FechaNacimiento,Telefono,Saldo,Puntos) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ewallet SET Nombre=?, DNI=?,Edad=?,FechaNacimiento=?,Telefono=?,Saldo=?,Puntos=? WHERE id_eWallet=?";
    private static final String SQL_DELETE = "DELETE from ewallet where id_eWallet=?";
    private Connection conexionTransaccional;

    public eWalletDAO() {
    }

    public eWalletDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<eWallet> seleccionar_todos() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        eWallet ewallet = null;
        List<eWallet> listaewallets = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_eWallet");
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DNI");
                int edad = rs.getInt("Edad");
                String fechaNacim = rs.getString("FechaNacimiento");
                int telefono = rs.getInt("Telefono");
                int saldo = rs.getInt("Saldo");
                int puntos = rs.getInt("Puntos");

                ewallet = new eWallet(idPersona, nombre, dni, edad, fechaNacim, telefono, saldo, puntos);
                listaewallets.add(ewallet);

            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return listaewallets;

    }

    public eWallet obtener(String dni) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        eWallet ewallet = null;
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT + " WHERE DNI='" + dni + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int edad = rs.getInt(4);
                String fnac = rs.getString(5);
                int tlf = rs.getInt(6);
                int saldo = rs.getInt(7);
                int puntos = rs.getInt(8);
                ewallet = new eWallet(id, name, dni, edad, fnac, tlf, saldo, puntos);
            }

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return ewallet;

    }

    public int insertar(eWallet ewallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ewallet.getNombre());
            stmt.setString(2, ewallet.getDNI());
            stmt.setInt(3, ewallet.getEdad());
            stmt.setString(4, ewallet.getFecha_nacimiento());
            stmt.setInt(5, ewallet.getTelefono());
            stmt.setFloat(6, ewallet.getSaldo());
            stmt.setInt(7, ewallet.getPuntos());

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

    public int actualizar(eWallet ewallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();
//    private static final String SQL_UPDATE = "UPDATE ewallet SET Nombre=?,
// DNI=?,Edad=?,FechaNacimiento=?,Telefono=?,Saldo=?,Puntos=? WHERE id_eWallet=?";

            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ewallet.getNombre());
            stmt.setString(2, ewallet.getDNI());
            stmt.setInt(3, ewallet.getEdad());
            stmt.setString(4, ewallet.getFecha_nacimiento());
            stmt.setInt(5, ewallet.getTelefono());
            stmt.setFloat(6, ewallet.getSaldo());
            stmt.setInt(7, ewallet.getPuntos());
            stmt.setInt(8, ewallet.getIdeWallet());
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

    public int eliminar(eWallet ewallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null
                    ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, ewallet.getIdeWallet());
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
