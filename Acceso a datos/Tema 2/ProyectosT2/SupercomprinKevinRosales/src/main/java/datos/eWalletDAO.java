/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import java.util.*;
import java.sql.*;

import domain.eWallet;


/**
 *
 * @author kevin
 */
public class eWalletDAO {
//    private static final String SQL_SELECT = "SELECT id_persona,Nombre,Apellidos,Edad FROM persona";
    private static final String SQL_INSERT = "INSERT INTO ewallet(Nombre,DNI,Edad,FechaNacimiento,Telefono,Saldo) VALUES(?,?,?,?,?,?)";
//    private static final String SQL_UPDATE = "UPDATE persona SET Nombre=?, Apellidos=?,Email=?,Edad=? WHERE id_persona=?";
//    private static final String SQL_DELETE = "DELETE from persona where id_persona=?";
    private Connection conexionTransaccional;

    public eWalletDAO() {
    }

    public eWalletDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public int insertar(eWallet ewallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        
        stmt = conn.prepareStatement(SQL_INSERT);
        stmt.setString(1,ewallet.getNombre());
        stmt.setString(2, ewallet.getDNI());
        stmt.setInt(3, ewallet.getEdad());
        stmt.setString(4,ewallet.getFecha_nacimiento());
        stmt.setInt(5, ewallet.getTelefono());
        stmt.setFloat(6,ewallet.getSaldo());
        registros = stmt.executeUpdate();
        } finally{
            try{
            close(stmt);
            if(this.conexionTransaccional == null){
            Conexion.close(conn);
            }
            }catch(SQLException ex){}
        }
        
        
        return registros;
    }
}
