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
 *
 * @author Kevin Rosales
 * Fecha: 28/10/2020
 * Asignatura: Acceso a Datos. 2ºDAM
 * 
 * Creacion de un concesionario con sus propietarios y coches asociados a la base de datos
 */

public class CocheDAO {

    private static final String SQL_SELECT = "SELECT Matricula,Marca,Precio,DNI from coches";
    private static final String SQL_INSERT = "INSERT INTO coches(Matricula,Marca,Precio,DNI) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE coches SET DNI=?,Marca=?,Precio=? WHERE Matricula=?";
    private static final String SQL_DELETE = "DELETE from coches where DNI=?"; // NOSE SI USAR DNI O MATRICULA

    // Guardo en un ArrayList todos los coches con un DNI especifico
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

    public int insertar(Coche coche) { // Inserto un coche nuevo en la base da datos
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
    
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, coche.getMatricula());
            stmt.setString(2, coche.getMarca());
            stmt.setInt(3, coche.getPrecio());
            stmt.setString(4, coche.getDNI());
            registros = stmt.executeUpdate();
    
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

    public int actualizar(Coche coche) { // Actualizar datos del coche
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, coche.getDNI());
            stmt.setString(2, coche.getMarca());
            stmt.setInt(3, coche.getPrecio());
            stmt.setString(4, coche.getMatricula());
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

    public int eliminar(Coche coche) { // Elimino un coche
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
    
        public Coche buscarCoche(String matricula) throws SQLException { // Busco si existe el coche dada su Matricula
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
    
    
       public int eliminarCochesDelPropietario(Coche coche) { // Elimino el coche del DNI en concreto
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
