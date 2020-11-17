/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.demo;

/**
 *
 * @author kevin
 */
import com.ecodeup.controller.ControllerCliente;

import com.ecodeup.model.Cliente;

public class CrudJavaDemo {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Keeeevin", "Rosales", "kevin", "contras", "micorreo");

        // controlador
        ControllerCliente controller = new ControllerCliente();

        // guarda un cliente a través del controlador
        controller.registrar(cliente);

        // ver clientes
        controller.verClientes();

        // editar un cliente por medio del id
        cliente.setUser_id(1);
        cliente.setName("Santiago");
        controller.actualizar(cliente);
        
        // ver clientes
        controller.verClientes();

        // eliminar un cliente por medio del id
        cliente.setUser_id(1);
        controller.eliminar(cliente);
    }
}
