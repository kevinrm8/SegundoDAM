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
    private final String NombreCiudades[] = {"Valencia", "Barcelona", "Madrid", "Murcia", "Asturias", "Galicia", "Bilbao","Londres", "Sheffield", "Paris", "Roma"};
    private JLabel SelCity= new JLabel(),CitySelected= new JLabel();
    
    private JPanel panel = new JPanel();
    
  public SeleccionarCiudad(){
      
        setSize(800, 600);
        setTitle("SimpleList");
        add(panel);
        
        Combo = new JComboBox(NombreCiudades);

 

}
    
}
