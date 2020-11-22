/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kevin
 * Fecha: 19/11/2020
 * Asignature: Interface Design
 */
public class Conexion {
        public static Connection conectar() {
        Connection con = null;
        //Datos de la base de dat os
        String usuario = "root";
        String password = "";

        try {            
            con = DriverManager.getConnection("jdbc:mysql://localhost/sampledb?serverTimezone=UTC",usuario,password);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
}
