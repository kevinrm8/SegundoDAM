/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import domain.Coche;
import domain.Propietario;

import java.sql.*;
import java.util.*;

/**
 * @author kevin
 */

public class CocheDAO {

    private static final String SQL_SELECT = "SELECT Matricula,Marca,Precio,DNI from coches";
    private static final String SQL_INSERT = "INSERT INTO coches(Matricula,Marca,Precio,DNI) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE coches SET Matricula=?,Marca=?,Precio=? WHERE DNI=?";
    private static final String SQL_DELETE = "DELETE from coches where DNI=?"; // NOSE SI USAR DNI O MATRICULA

    public ArrayList<Coche> seleccionar(String dni) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Coche co;
        ArrayList<Coche> coches = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT+" WHERE DNI='"+dni+"'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                String Matricula = rs.getString(1);
                String Marca = rs.getString(2);
                int Precio = rs.getInt(3);
                String DNI = rs.getString(4);
                co = new Coche(Matricula,Marca,Precio,DNI);
                coches.add(co);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return coches;

    }

    public int insertar(Coche coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        PropietarioDAO p = new PropietarioDAO();
        Propietario pAux = new Propietario();
        
        
        try {
            pAux = p.buscarPropietario(coche.getDNI());
            if(pAux!= null){
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, coche.getMatricula());
            stmt.setString(2, coche.getMarca());
            stmt.setInt(3, coche.getPrecio());
            stmt.setString(4, coche.getDNI());
            registros = stmt.executeUpdate();
            }else {
                System.out.println("No existe propietario con ese DNI.");
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int actualizar(Coche coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, coche.getMatricula());
            stmt.setString(2, coche.getMarca());
            stmt.setInt(3, coche.getPrecio());
            stmt.setString(4, coche.getDNI());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int eliminar(Coche coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, coche.getDNI());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
        public Coche buscarCoche(String matricula) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Coche co = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT + " WHERE Matricula='" + matricula + "'"); // Selecciono el coche con este DNI en concreto
            rs = stmt.executeQuery();
            while (rs.next()) {
                String MATRICULA = rs.getString(1);
                String marca = rs.getString(2);
                int precio = rs.getInt(3);
                String DNI = rs.getString(4);
                co = new Coche(MATRICULA,marca,precio,DNI); // Guardo coche
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return co;
    }
    
    
       public int eliminarCochesDelPropietario(Coche coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, coche.getDNI());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
