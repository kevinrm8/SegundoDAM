/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.idao;
import java.util.List;
 
import com.ecodeup.model.Cliente;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kevin
 */
public interface IClienteDao {
    	public boolean registrar(Cliente cliente);
	public DefaultTableModel obtener();
	public boolean actualizar(Cliente cliente);
	public boolean eliminar(Cliente cliente);
}
