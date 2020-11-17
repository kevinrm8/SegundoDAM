/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.dao;

import java.sql.*;
import java.util.*;

import com.connection.Conexion;
import com.ecodeup.idao.IClienteDao;
import com.ecodeup.model.Cliente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class ClienteDaoImpl implements IClienteDao {

    @Override
    public boolean registrar(Cliente cliente) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO users values(NULL,'" + cliente.getName() + "','" + cliente.getLast_name()
                + "','" + cliente.getUser_name() + "','" + cliente.getPassword() + "','" + cliente.getEmail() + "')";

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public DefaultTableModel obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM users";

        DefaultTableModel listaCliente = new DefaultTableModel();

        // Hace falta poner la cabecera aqui para que aparezcan los datos en la tabla
        String[] headers = new String[]{
            "User_ID", "Name", "Last_Name", "User_Name", "Password", "Email"
        };
        listaCliente.setColumnIdentifiers(headers);

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {

                Object[] data = new Object[]{rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6)};
                listaCliente.addRow(data);

            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE users SET name='" + cliente.getName() + "', last_name='" + cliente.getLast_name()
                + "', user_name='" + cliente.getUser_name() + "', password='" + cliente.getPassword()
                + "', email='" + cliente.getEmail() + "'" + " WHERE user_id=" + cliente.getUser_id();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM users WHERE user_id=" + cliente.getUser_id();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

}
