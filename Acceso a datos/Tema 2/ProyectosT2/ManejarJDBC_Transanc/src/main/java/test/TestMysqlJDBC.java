/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package test;

import java.sql.*;

public class TestMysqlJDBC {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/TEST?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        //Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            //puede ser que sea requerido lo siguiente
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection(url, "root", "accesodatos");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, Nombre, Apellidos, Edad FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Id Persona: " + resultado.getInt("id_persona"));
                System.out.println("Nombre: " + resultado.getString("Nombre"));
                System.out.println("Apellidos " + resultado.getString("Apellidos"));
                System.out.println("Edad: " + resultado.getInt("Edad"));

            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
