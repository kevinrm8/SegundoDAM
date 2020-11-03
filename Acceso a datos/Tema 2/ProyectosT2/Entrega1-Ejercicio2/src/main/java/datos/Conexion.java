/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;

/**
 *
 * @author Kevin Rosales
 * Fecha: 28/10/2020
 * Asignatura: Acceso a Datos. 2ºDAM
 * 
 * Creacion de un concesionario con sus propietarios y coches asociados a la base de datos
 */
public class Conexion {
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/concesionario?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root"; // NOMBRE DE USUARIO
    private static final String JDBC_PASSWORD = "123456789"; // MI CONTRASEÑA PARA CONECTAR A LA BASE DE DATOS

    public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
