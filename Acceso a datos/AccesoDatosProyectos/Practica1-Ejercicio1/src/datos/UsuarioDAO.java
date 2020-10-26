/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.*;
import java.sql.*;

public class UsuarioDAO {
    
    private static final String SQL_SELECT = "SELECT id_persona,Nombre,Apellidos,Edad FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(Nombre,Apellidos,Email,Edad) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET Nombre=?, Apellidos=?,Email=?,Edad=? WHERE id_persona=?";
    private static final String SQL_DELETE = "DELETE from persona where id_persona=?";
    
}
