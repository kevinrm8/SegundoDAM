/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.controller;

import com.ecodeup.dao.ClienteDaoImpl;
import com.ecodeup.idao.IClienteDao;
import com.ecodeup.model.Cliente;
import javax.swing.table.DefaultTableModel;

/**
 * @author kevin
 * Fecha: 19/11/2020
 * Asignature: Interface Design
 */

//Clase para controlar lo que vamos a ejecutar, paso intermedio entre la Interfaz y el DAO
//En cada metodo llamaremos a dao para ejecutar cada instruccion
public class ControllerCliente {

    public ControllerCliente() {
    }

    //llama al DAO para guardar un cliente
    public void registrar(Cliente cliente) {
        IClienteDao dao = new ClienteDaoImpl();
        dao.registrar(cliente);
    }

    public void actualizar(Cliente cliente) {
        IClienteDao dao = new ClienteDaoImpl();
        dao.actualizar(cliente);
    }
    //llama al DAO para eliminar un cliente

    public void eliminar(Cliente cliente) {
        IClienteDao dao = new ClienteDaoImpl();
        dao.eliminar(cliente);
    }
    //llama al DAO para obtener todos los clientes y luego los muestra en la vista

    public DefaultTableModel verClientes() {
        DefaultTableModel client;

        IClienteDao dao = new ClienteDaoImpl();
        client = dao.obtener_todos();
        //vista.verClientes(clientes); Es para mostrar clientes por pantalla
        return client;
    }

    public void borrar_todos() {
        IClienteDao dao = new ClienteDaoImpl();
        dao.borrar_todos();
    }

    public Cliente obtener(int idCliente) {
        IClienteDao dao = new ClienteDaoImpl();
        return dao.obtener(idCliente);
    }
}
