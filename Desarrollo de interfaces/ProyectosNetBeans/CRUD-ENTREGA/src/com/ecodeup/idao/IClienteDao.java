/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.idao;

import com.ecodeup.model.Cliente;
import javax.swing.table.DefaultTableModel;

/**
 * @author kevin
 * Fecha: 19/11/2020
 * Asignature: Interface Design
 */
public interface IClienteDao {

    public boolean registrar(Cliente cliente);
    public DefaultTableModel obtener_todos();
    public boolean actualizar(Cliente cliente);
    public boolean eliminar(Cliente cliente);
    public boolean borrar_todos();
    public Cliente obtener(int idCliente);
    
}
