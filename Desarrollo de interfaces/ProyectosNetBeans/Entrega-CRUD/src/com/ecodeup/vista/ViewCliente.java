/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.vista;

import com.ecodeup.controller.ControllerCliente;
import com.ecodeup.model.Cliente;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class ViewCliente extends JFrame {

//    public void verCliente(Cliente cliente) {
//        System.out.println("Datos del Cliente: " + cliente);
//    }
//
//    public void verClientes(List<Cliente> clientes) {
//        for (Cliente cliente : clientes) {
//            System.out.println("Datos del Cliente: " + cliente);
//        }
//    }
    // HASTA AQUI ERA EL EJEMPLO
    //--------------------------------------------------------//
    private JPanel panelFondo = new JPanel(new BorderLayout()),panelBar = new JPanel(),panelTabla = new JPanel();
    private JTable jTabla;
    private JScrollPane jScrollPane;
    private JMenuBar menuBar;
    private ImageIcon imagen, imagen_red;
    private JMenu opciones,nuevo;

    private ControllerCliente controller = new ControllerCliente();

    public ViewCliente() {
        //DATO DE PRUEBA
//        // controlador
//        Cliente cliente = new Cliente("NPrueba", "LNPrueba", "UPrueba", "PPrueba", "EPrueba");
//        controller.registrar(cliente);

        setSize(500, 500);
        setTitle("Ejercicio CRUD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panelFondo);
        panelFondo.add(panelBar, BorderLayout.NORTH);
        panelFondo.add(panelTabla, BorderLayout.CENTER);
        menuBar = new JMenuBar();
        opciones = new JMenu("Opciones");
        nuevo = new JMenu("Nuevo");
        
        imagen = new ImageIcon(getClass().getResource("/Imagen/IconoSerpis.jpeg"));
        Image img = imagen.getImage();
        Image img_nueva = img.getScaledInstance(15, 15, java.awt.Image.SCALE_AREA_AVERAGING);
        imagen_red = new ImageIcon(img_nueva);
        
        opciones.setIcon(imagen_red);
        opciones.add(nuevo);
        menuBar.add(opciones);
        panelBar.add(menuBar);
        
        //Añadir ScrollPane al panel
        jTabla = new JTable();
        jScrollPane = new JScrollPane(jTabla);
        panelTabla.add(jScrollPane);

        //Cargar los datos y mostrar la tabla
        DefaultTableModel verTablaModel = controller.verClientes();
        jTabla.setModel(verTablaModel);

    }

}
