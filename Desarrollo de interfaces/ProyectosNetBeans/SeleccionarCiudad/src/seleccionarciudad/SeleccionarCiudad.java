/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccionarciudad;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SeleccionarCiudad extends JFrame {

    private JComboBox Combo;
    private final String NombreCiudades[] = {"Valencia", "Barcelona", "Madrid", "Murcia", "Asturias", "Galicia", "Bilbao", "Londres", "Sheffield", "Paris", "Roma"};
    private JLabel SelCity = new JLabel(), CitySelected = new JLabel();

    private JPanel panel = new JPanel();

    public SeleccionarCiudad() {

        //setSize(300, 300);
        setBounds(400, 400, 400, 100); //Los dos primeros datos sirven para colocar el panel en un lugar concreto de la pantall y los dos ultimos para el tamaño
        setTitle("SimpleList");
        add(panel);

        SelCity.setText("Select your city: ");
        SelCity.setForeground(Color.red);
        
        Combo = new JComboBox(NombreCiudades);
        //Con estas dos lineas tengo preseleccionado la primera ciudad del combo
        CitySelected.setText(Combo.getSelectedItem().toString()+" is selected");
        CitySelected.setForeground(Color.blue);

        Combo.addItemListener(new ManejarOpciones());
        
        panel.add(SelCity);
        panel.add(Combo);
        panel.add(CitySelected);

    }

    private class ManejarOpciones implements ItemListener {

        public ManejarOpciones() {
                        
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            CitySelected.setText(Combo.getSelectedItem().toString()+" is selected");
            CitySelected.setForeground(Color.blue);
        }
    }

}
