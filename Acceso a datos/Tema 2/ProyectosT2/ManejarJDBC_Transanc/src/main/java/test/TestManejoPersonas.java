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
            PersonaDAO personaDAO = new PersonaDAO();
            Persona cambioPersona = new Persona();
            cambioPersona.setId_persona(8);
            cambioPersona.setNombre("Karla Ivonne");
            cambioPersona.setApellidos("Gomez");
            cambioPersona.setEmail("kgomez@mail.com");
            cambioPersona.setEdad(10);

            personaDAO.actualizar(cambioPersona);
            //cambioPersona.set("7713445678");
            Persona nuevaPersona = new Persona();
            nuevaPersona.setId_persona(10);
            nuevaPersona.setNombre("Federico");
            nuevaPersona.setApellidos("Ramirez");
            nuevaPersona.setEmail("popgjfghdhez@mail.com");
            nuevaPersona.setEdad(50);

            personaDAO.actualizar(nuevaPersona);

            Persona insert_persona = new Persona();

            insert_persona.setNombre("Axel566666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666");
            insert_persona.setApellidos("guapo");
            insert_persona.setEmail("coorre@asdad");
            insert_persona.setEdad(18);

            personaDAO.insertar(insert_persona);

            //  personaDAO.insertar(nuevaPersona);
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");

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
