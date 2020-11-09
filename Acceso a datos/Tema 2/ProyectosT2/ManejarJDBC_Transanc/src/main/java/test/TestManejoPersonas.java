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

public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas = personaDao.seleccionar();

        //insertano nuevo objeto de tipo persona
        // Persona personaNueva = new Persona("carlos", "perez","correo@email.com", 54);
        //personaDao.insertar(personaNueva);
        //MODIFICAR
        Persona personaModificar = new Persona(1, "Juanito", "Bonito", "Correo@gmail.com", 33);
        personaDao.actualizar(personaModificar);
        //ELIMINAR
        Persona personaEliminar = new Persona(7);
        personaDao.eliminar(personaEliminar);

        personas = personaDao.seleccionar();

        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

    }

}
