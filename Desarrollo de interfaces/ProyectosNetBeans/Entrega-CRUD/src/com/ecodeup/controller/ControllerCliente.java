/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.controller;

import java.util.ArrayList;
import java.util.List;
 
import com.ecodeup.dao.ClienteDaoImpl;
import com.ecodeup.idao.IClienteDao;
import com.ecodeup.model.Cliente;
import com.ecodeup.vista.ViewCliente;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kevin
 */
public class ControllerCliente {
	
	//private ViewCliente vista= new ViewCliente();
	
	public ControllerCliente() {
	}
	
	//llama al DAO para guardar un cliente
	public void registrar(Cliente cliente ) {
		IClienteDao dao= new  ClienteDaoImpl();
		dao.registrar(cliente);
	}
	
	//llama al DAO para actualizar un cliente
	public void actualizar(Cliente cliente) {
		IClienteDao dao= new  ClienteDaoImpl();
		dao.actualizar(cliente);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Cliente cliente) {
		IClienteDao dao= new  ClienteDaoImpl();
		dao.eliminar(cliente);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public DefaultTableModel verClientes(){
                DefaultTableModel client;
                
		IClienteDao dao= new  ClienteDaoImpl();
		client=dao.obtener();
		//vista.verClientes(clientes); Es para mostrar clientes por pantalla
                return client;
	}
}
