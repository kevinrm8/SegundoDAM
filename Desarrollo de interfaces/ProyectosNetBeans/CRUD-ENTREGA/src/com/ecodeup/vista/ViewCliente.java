/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.vista;

import com.ecodeup.controller.ControllerCliente;
import com.ecodeup.model.Cliente;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author kevin
 */
public class ViewCliente extends JFrame {

    private JPanel panelFondo = new JPanel(new BorderLayout()), panelTabla = new JPanel(), panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
    private JTable jTabla;
    private JScrollPane jScrollPane;
    private JMenuBar menuBar = new JMenuBar();

    private ImageIcon imagen, imagen_red;
    private JMenu opciones, administrador, help;
    private JMenuItem nuevo, editar, borrar, url_ayuda, salir;
    private JButton eres_admin = new JButton("¿Eres Administrador?"), borrar_seleccion = new JButton("Borrar Cliente");

    private ControllerCliente controller = new ControllerCliente();

    DefaultTableModel verTabla = null;
    int controlar_accion = 0;

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
        panelBotones.add(eres_admin);
        panelBotones.add(borrar_seleccion);

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
        VerTablaYOrdenarTabla();

        borrar.setEnabled(false);
        borrar_seleccion.setEnabled(false); // En un prinicipio no se podra borrar nada de la base de datos

        //Crear un cliente nuevo
        nuevo.addActionListener(l -> {
            NuevoCliente v = new NuevoCliente(this, true);

            //Mostrar cliente creado en la tabla
            VerTablaYOrdenarTabla();

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
                controller.borrar_todos();
                
                VerTablaYOrdenarTabla();

            } else {
                System.out.println("No borro nada");
            }

        });

        //Editar la fila que hay seleccionada
        editar.addActionListener(l -> {

            int linea = -1;

            linea = jTabla.getSelectedRow(); // Obtener linea

            if (linea == -1) {
                JOptionPane.showMessageDialog(null, "No hay nada seleccionado");
            } else {
                TableModel model = jTabla.getModel();
                int id_cl = (Integer) model.getValueAt(linea, 0);
                Cliente cAux = null;
                cAux = controller.obtener(id_cl);

                EditarCliente ec = new EditarCliente(this, true, cAux);
                VerTablaYOrdenarTabla();

            }
        });
        //Abrir pagina de internet
        url_ayuda.addActionListener(l -> {
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    try {
                        java.net.URI uri = new java.net.URI("https://www.iesserpis.org/");
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                    }
                }
            }

        });
        //Cerrar el programa
        salir.addActionListener(l -> {
            System.exit(0);
        });

        //BOTONES
        eres_admin.addActionListener(l -> {
            int select = JOptionPane.showOptionDialog(
                    null, // parent component
                    "Eres un administrador?\n El Administrador podrá borrar datos del sistema.",
                    "ADMINISTRADOR",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null for default icon or an icon.
                    new Object[]{"Si", "No"}, "mensaje");

            if (JOptionPane.OK_OPTION == select) {
                System.out.println("confirmed");
                borrar.setEnabled(true);
                borrar_seleccion.setEnabled(true);
            } else {
                borrar.setEnabled(false);
                borrar_seleccion.setEnabled(false);
            }

        });

        borrar_seleccion.addActionListener(l -> {
            int linea = -1;

            linea = jTabla.getSelectedRow(); // Obtener linea

            if (linea == -1) {
                JOptionPane.showMessageDialog(null, "No hay nada seleccionado");
            } else {

                TableModel model = jTabla.getModel();
                int id_cl = (Integer) model.getValueAt(linea, 0);

                Cliente cAux = null;
                cAux = controller.obtener(id_cl);
                controller.eliminar(cAux);

                VerTablaYOrdenarTabla();

            }
        });

    }

    public void VerTablaYOrdenarTabla() {
        verTabla = controller.verClientes();
        jTabla.setModel(verTabla);

        jTabla.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTabla.getColumnModel().getColumn(1).setPreferredWidth(20);
        jTabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabla.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTabla.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTabla.getColumnModel().getColumn(5).setPreferredWidth(50);

    }

}
