/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.vista;

import com.ecodeup.controller.ControllerCliente;
import com.ecodeup.demo.CrudJavaDemo;
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
    private JPanel panelFondo = new JPanel(new BorderLayout()), panelTabla = new JPanel(), panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
    private JTable jTabla;
    private JScrollPane jScrollPane;
    private JMenuBar menuBar = new JMenuBar();
    ;
    private ImageIcon imagen, imagen_red;
    private JMenu opciones, administrador, help;
    private JMenuItem nuevo, editar, borrar, url_ayuda, salir;
    private JButton prueba = new JButton("PRUEBA"), prueba2 = new JButton("PRUEBA2");

    private ControllerCliente controller = new ControllerCliente();

    DefaultTableModel verTabla = null;

    public ViewCliente() {
        //DATO DE PRUEBA - Introducir manualmente un dato a modo de test

//        Cliente cliente = new Cliente("NPrueba", "LNPrueba", "UPrueba", "PPrueba", "EPrueba");
//        controller.registrar(cliente);
        setBounds(400, 200, 500, 600);
        setTitle("Ejercicio CRUD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Añadir los paneles y menuBar
        add(panelFondo);
        setJMenuBar(menuBar);
        panelFondo.add(panelTabla, BorderLayout.CENTER);
        panelFondo.add(panelBotones, BorderLayout.SOUTH);

        //Botones de prueba añadidos a su panel
        panelBotones.add(prueba);
        panelBotones.add(prueba2);

        //Añadiendo los JMenu y JMenuItem
        opciones = new JMenu("Opciones");
        nuevo = new JMenuItem("Nuevo");
        editar = new JMenuItem("Editar");
        administrador = new JMenu("Administrador");
        borrar = new JMenuItem("Borrar todo");
        help = new JMenu("Help");
        url_ayuda = new JMenuItem("Pagina de ayuda");
        salir = new JMenuItem("Salir");
        menuBar.add(opciones);
        opciones.add(nuevo);
        opciones.add(editar);
        opciones.add(administrador);
        administrador.add(borrar);
        menuBar.add(help);
        help.add(url_ayuda);
        help.add(salir);

        //Añado una imagen y ajusto su dimension al gusto, luego la incluyo en el JMenu opciones.
        imagen = new ImageIcon(getClass().getResource("/Imagen/IconoSerpis.jpeg"));
        Image img = imagen.getImage();
        Image img_nueva = img.getScaledInstance(45, 45, java.awt.Image.SCALE_AREA_AVERAGING); // Ajustar tamaño de la imagen
        imagen_red = new ImageIcon(img_nueva);
        opciones.setIcon(imagen_red);

        //Añadir ScrollPane al panel
        jTabla = new JTable();
        jScrollPane = new JScrollPane(jTabla);
        panelTabla.add(jScrollPane);

        //Cargar los datos y mostrar la tabla
        verTabla = controller.verClientes();
        jTabla.setModel(verTabla);

        //Crear un cliente nuevo
        nuevo.addActionListener(l -> {

            NuevoCliente v = new NuevoCliente(this, true);

            //Mostrar cliente creado en la tabla
            verTabla = controller.verClientes();
            jTabla.setModel(verTabla);
        });
        //Borrar todos los datos de la tabla
        borrar.addActionListener(l -> {

            int select = JOptionPane.showOptionDialog(
                    null, // parent component
                    "Seguro quieres borrar todos los daots?",
                    "Borrar Datos",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null for default icon or an icon.
                    new Object[]{"Si", "No"}, "mensaje");

            if (JOptionPane.OK_OPTION == select) {
                System.out.println("confirmed");
                controller.borrar();

                verTabla = controller.verClientes();
                jTabla.setModel(verTabla);
            } else {
                System.out.println("No borro nada");
            }

        });

        //Editar la fila que hay seleccionada
        editar.addActionListener(l -> {
            ListSelectionModel lineaSeleccionada = jTabla.getSelectionModel();
            if (lineaSeleccionada.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay nada seleccionado");
            } else {
                int id = lineaSeleccionada.getMinSelectionIndex() + 1;
                Cliente cAux = null;
                cAux = controller.obtener(id);

                EditarClienteJDialog ecjd = new EditarClienteJDialog(this, true);
                System.out.println("?¿");
                verTabla = controller.verClientes();
                jTabla.setModel(verTabla);

                System.out.println(id);
            }
        });
        //Cerrar el programa
        salir.addActionListener(l -> {
            System.exit(0);
        });
    }

}
