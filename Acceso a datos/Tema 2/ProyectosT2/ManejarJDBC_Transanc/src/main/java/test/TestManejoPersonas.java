/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.*;
import java.sql.*;
import datos.PersonaDAO;
import domain.Persona;
import datos.Conexion;

public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDAO personaDao = new PersonaDAO(conexion);

            Persona insert_persona = new Persona();
            insert_persona.setNombre("Axel");
            insert_persona.setApellidos("No deberia insertar");
            insert_persona.setEmail("coorre@asdad");
            insert_persona.setEdad(18);
            personaDao.insertar(insert_persona);

            conexion.rollback(); // Obligar a que falle el insert anterior

            insert_persona.setNombre("Axel");
            insert_persona.setApellidos("SI DEBE INSERTAR");
            insert_persona.setEmail("coorre@asdad");
            insert_persona.setEdad(18);
            personaDao.insertar(insert_persona);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
            
            
            personaDao.seleccionar().forEach(action->{
                System.out.println(action.toString());
            });

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
