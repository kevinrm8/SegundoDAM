/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.jdbc.entrega1.ejerc1;

import datos.UsuarioDAO;
import domain.Usuario;

import java.util.*;
import java.sql.*;

/**
 *
 * @author kevmar
 */
public class Entrega1Ejerc1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDAO.seleccionar();

        //Crear un usuario
//        Usuario usuarioNuevo = new Usuario("Kevin", "contraKevin");
//        usuarioDAO.insertar(usuarioNuevo);

         Usuario usuarioModificar = new Usuario(1,"Kevin", "kevinContra");
         usuarioDAO.actualizar(usuarioModificar);
        
        //Mostrar por pantalla todos los datos
        usuarios = usuarioDAO.seleccionar();

        usuarios.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

    }

}
