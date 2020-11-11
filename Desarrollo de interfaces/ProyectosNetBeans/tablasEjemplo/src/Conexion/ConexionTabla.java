/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.*;
/**
 *
 * @author kevmar
 */
public class ConexionTabla {
    
    
    public Connection OpenConnection() {
        Connection con = null; // install a connection
        try {
            String urlOdbc = "jdbc:mysql://localhost:3306/di?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

// create connection. NOTE in my case MySql user -> root, empty password
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "123456789"));
        } catch (Exception e) {// SQLException and ClassNotFoundException
            e.printStackTrace();
        }
        return con;
    }
}
