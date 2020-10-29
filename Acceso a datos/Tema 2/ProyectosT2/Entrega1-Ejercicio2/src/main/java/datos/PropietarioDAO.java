/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Kevin Rosales
 * Fecha: 28/10/2020
 * Asignatura: Acceso a Datos. 2ºDAM
 * 
 * Creacion de un concesionario con sus propietarios y coches asociados a la base de datos
 */
import static datos.Conexion.close;
import domain.Coche;
import domain.Propietario;
import java.util.*;
import java.sql.*;

public class PropietarioDAO {

    private static final String SQL_SELECT = "SELECT DNI,Nombre,Edad from propietarios";
    private static final String SQL_INSERT = "INSERT INTO propietarios(DNI,Nombre,Edad) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE propietarios SET Nombre=?,Edad=? WHERE DNI=?";
    private static final String SQL_DELETE = "DELETE from propietarios where DNI=?";

    public ArrayList<Propietario> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietario pr;
        ArrayList<Propietario> propietarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String DNI = rs.getString(1);
                String Nombre = rs.getString(2);
                int Edad = rs.getInt(3);
                pr = new Propietario(DNI, Nombre, Edad);
                propietarios.add(pr);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return propietarios;

    }

    public int insertar(Propietario propietario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, propietario.getDNI());
            stmt.setString(2, propietario.getNombre());
            stmt.setInt(3, propietario.getEdad());
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

    public int actualizar(Propietario propietario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, propietario.getNombre());
            stmt.setInt(2, propietario.getEdad());
            stmt.setString(3, propietario.getDNI());
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

    public int eliminar(Propietario propietario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, propietario.getDNI());
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

    public void mostrarPropietarioCoches(String dni) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietario pr = null;

        CocheDAO cdao = new CocheDAO();
        Coche cAux = new Coche();
        ArrayList<Coche> listaCoche = new ArrayList<>(); // ArrayList para guardar el listado de coches del propietario en cuestion

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT + " WHERE DNI='" + dni + "'"); // Selecciono el propietario con este DNI en concreto
            rs = stmt.executeQuery();
            while (rs.next()) {
                String DNI = rs.getString(1);
                String Nombre = rs.getString(2);
                int Edad = rs.getInt(3);
                pr = new Propietario(DNI, Nombre, Edad);
                System.out.println(pr.toString());  // Muestro por pantalla los datos del propietario
            }
            //Si existe un propietario con este DNI me busca sus coches y los imprimo por pantalla
            if (pr != null) {   
                listaCoche = cdao.seleccionar(pr.getDNI()); 
                listaCoche.forEach(z -> {
                    System.out.println(z.toString());
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

    }

    public Propietario buscarPropietario(String dni) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietario pr = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT + " WHERE DNI='" + dni + "'"); // Selecciono el propietario con este DNI en concreto
            rs = stmt.executeQuery();
            while (rs.next()) {
                String DNI = rs.getString(1);
                String Nombre = rs.getString(2);
                int Edad = rs.getInt(3);
                pr = new Propietario(DNI, Nombre, Edad); // Guardo propietario

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return pr;
    }
}
