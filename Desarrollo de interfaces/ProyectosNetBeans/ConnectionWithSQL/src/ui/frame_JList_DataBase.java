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

        //Añadir provisional lista izquierda
        for (int i = 1; i <= 10; i++) {
            listModelIzquierda.addElement("Elemento " + i);
        }
        for (int i = 1; i <= 10; i++) {
            listModelDerecha.addElement("");
        }
        panel2.add(new JScrollPane(listElementIzquierda));
        panel4.add(new JScrollPane(listElementDerecha));

    }
    
    public void ActionListener(){
    
    }
}
