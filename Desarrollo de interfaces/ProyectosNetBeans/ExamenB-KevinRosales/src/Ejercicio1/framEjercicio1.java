/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author kevmar
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class framEjercicio1 extends JFrame {

    private JPanel panelFondo, panelNombreApellidoBoton,panelNombreApellido,panelBotonAnadir,panelListaBotonCombo;
    private JLabel Lnombre, Lapellido;
    private JTextArea TAnombre, TAapellidos;
    private JButton anadir,pasarBotonCombo;

    private JList listaPersonas;
    
    private DefaultListModel listModelIzquierda;
    
    private JComboBox comboPersonas = new JComboBox();
    
    public framEjercicio1() {

        setTitle("Ejercicio1");
        setSize(800, 500);

        panelFondo = new JPanel(new GridLayout(2, 1, 10, 10));
        add(panelFondo); // Panel global

        panelNombreApellidoBoton = new JPanel(new GridLayout(2, 1, 10, 10));
        panelFondo.add(panelNombreApellidoBoton); // añador panel parte superior, hasta boton añadir

        panelNombreApellido = new JPanel(new GridLayout(2,2,10,10));
        panelNombreApellidoBoton.add(panelNombreApellido); // añado panel donde van los label y text area de nombre y apellido
        //Introduzco labels y JTextArea al panel
        Lnombre = new JLabel("Nombre");
        Lapellido = new JLabel("Apellidos");

        TAnombre = new JTextArea();
        TAapellidos = new JTextArea();
        
        panelNombreApellido.add(Lnombre);
        panelNombreApellido.add(TAnombre);

        panelNombreApellido.add(Lapellido);
        panelNombreApellido.add(TAapellidos);
        
        //Añado panel del boton 
        panelBotonAnadir = new JPanel();
        panelNombreApellidoBoton.add(panelBotonAnadir);
        anadir = new JButton("Añadir");
        panelBotonAnadir.add(anadir);
        
        
        //parte inferior, Lista Boton y Combo
        
        panelListaBotonCombo = new JPanel(new GridLayout(1,3,10,10));
        panelFondo.add(panelListaBotonCombo);
        
       listModelIzquierda = new DefaultListModel();
       listaPersonas = new JList(listModelIzquierda);
       
       
         //Tamaño fijo de las listas
        listaPersonas.setFixedCellHeight(30);
        listaPersonas.setFixedCellWidth(200);
        
        panelListaBotonCombo.add(listaPersonas);
       
        pasarBotonCombo = new JButton("->");
        panelListaBotonCombo.add(pasarBotonCombo);
        
        panelListaBotonCombo.add(comboPersonas);
        
        //Añadir nombre y apellidos de los TextArea a la lista
        anadir.addActionListener(l->{
            String nombreApellidos="";
            
            nombreApellidos = TAnombre.getText() +" "+ TAapellidos.getText();
            listModelIzquierda.addElement(nombreApellidos.toString());
            TAnombre.setText("");
            TAapellidos.setText("");
        });
        
    }
}
