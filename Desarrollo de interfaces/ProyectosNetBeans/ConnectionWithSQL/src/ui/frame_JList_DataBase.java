/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author kevmar 22-10-2020 Ejercicio Jlist y Database
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import DAO.ClientDAO;
import DAO.Connection_DB;
import DAO.client;
import java.sql.*;
import java.util.*;

public class frame_JList_DataBase extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JButton derecha, izquierda, print;
    private JList listElementIzquierda, listElementDerecha;
    private DefaultListModel listModelIzquierda = new DefaultListModel(), listModelDerecha = new DefaultListModel();

    public frame_JList_DataBase() {

        setSize(800, 500);
        setTitle("Selection and print");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new GridLayout(3, 1, 10, 10));
        panel4.setLayout(new FlowLayout());

        //Añado los DefaultModel a los JList
        listElementIzquierda = new JList(listModelIzquierda);
        listElementDerecha = new JList(listModelDerecha);

        //Tamaño fijo de las listas
        listElementIzquierda.setFixedCellHeight(30);
        listElementIzquierda.setFixedCellWidth(200);

        listElementDerecha.setFixedCellHeight(30);
        listElementDerecha.setFixedCellWidth(200);
        //listElementDerecha.setVisibleRowCount(10);
        add(panel1);
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);

        derecha = new JButton(">>>");
        izquierda = new JButton("<<<");
        print = new JButton("Print");
        panel3.add(derecha);
        panel3.add(izquierda);
        panel3.add(print);


        panel2.add(new JScrollPane(listElementIzquierda));
        panel4.add(new JScrollPane(listElementDerecha));
        
        
        //CARGAR DATOS DEL MYSQL
        
        try {
            Connection_DB db_Connection = new Connection_DB();
            Connection with = (Connection) db_Connection.OpenConnection();
            ClientDAO customerDAO = new ClientDAO();
                    //Añado todos los elementos en la arraylist aux
            ArrayList<client> aux = new ArrayList<client>();
            aux = customerDAO.findAll(with);
            //Introduzco uno a uno los elemenots de la Array en el Model
            for(int i =0; i<aux.size();i++){
            listModelIzquierda.addElement(aux.get(i));
            }
            db_Connection.CloseConnection(with);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Boton para añadir a la derecha
        derecha.addActionListener(e -> {

            int index;
            index = listElementIzquierda.getSelectedIndex();
            //VER FORMA PROVISIONAL EL INDICE
            //System.out.println(index);
            if (index >= 0) {
                listModelDerecha.addElement(listElementIzquierda.getSelectedValue());
                listModelIzquierda.removeElement(listElementIzquierda.getSelectedValue());
            }
        });
        
        //Boton para volver a la izquierda
        izquierda.addActionListener(e -> {

            int index;
            index = listElementDerecha.getSelectedIndex();
            //VER FORMA PROVISIONAL EL INDICE
            //System.out.println(index);
            if (index >= 0) {

                listModelIzquierda.addElement(listElementDerecha.getSelectedValue());
                listModelDerecha.removeElement(listElementDerecha.getSelectedValue());
            }
        });
    }
}
