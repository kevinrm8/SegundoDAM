/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisewithjlist;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.*;

public class ExerciseWithJList extends JFrame {

    private JComboBox Combo;
    private JList ListaAmigos;
    private final String Amigos[] = {"Hector", "Pablo", "Axel", "Adrian","Eric", "Javi", "Oscar", "Miguel"," Antonio"};

    private final String NombreCiudades[] = {"Valencia", "Barcelona", "Madrid", "Murcia", "Asturias", "Galicia", "Bilbao", "Londres", "Sheffield", "Paris", "Roma"};
    private JLabel SelCity = new JLabel(), CitySelected = new JLabel(),SelAmigos = new JLabel(),Friend = new JLabel();

    private JLabel test = new JLabel();
    
    private JPanel panel = new JPanel();

    public ExerciseWithJList() {

        setBounds(400, 400, 500, 200); //Los dos primeros datos sirven para colocar el panel en un lugar concreto de la pantall y los dos ultimos para el tamaño
        setTitle("ExerciseWithJList");
        add(panel);

        ListaAmigos = new JList(Amigos);
        ListaAmigos.setVisibleRowCount(2);
        ListaAmigos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        SelCity.setText("Select your city: ");
        SelCity.setForeground(Color.red);

        Combo = new JComboBox(NombreCiudades);
        //Con estas dos lineas tengo preseleccionado la primera ciudad del combo
        CitySelected.setText(Combo.getSelectedItem().toString() + " is selected");
        CitySelected.setForeground(Color.blue);

        Combo.addItemListener((ItemListener) new ManejarOpciones());
        ListaAmigos.addListSelectionListener(new ListListener());

        Friend.setText("Choose a Friend:");
        Friend.setForeground(Color.green);
        
        panel.add(SelCity);
        panel.add(Combo);
        panel.add(CitySelected);
        panel.add(Friend);
        panel.add(new JScrollPane(ListaAmigos));
        test = CitySelected;
;       //panel.add(test);
        panel.add(SelAmigos);


    }

     private class ListListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            SelAmigos.setText("I will go with "+Amigos[(ListaAmigos.getSelectedIndex())]);
            SelAmigos.setForeground(Color.cyan);
        }
    }

    private class ManejarOpciones implements ItemListener{

        public ManejarOpciones() {
 
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            CitySelected.setText(Combo.getSelectedItem().toString() + " is selected");
            CitySelected.setForeground(Color.blue);
        }
    }
}
