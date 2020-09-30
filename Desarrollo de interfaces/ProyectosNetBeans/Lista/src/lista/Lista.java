/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author kevmar
 */
public class Lista extends JFrame {
    
    private JList listJListColours;
    private final String namesColours[] = {"Black", "Blue", "Cyan", "Dark grey", "Grey", "Green", "Light grey", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
    private final Color colores[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    private JPanel panel = new JPanel();
    
    public Lista() {
        setSize(800, 600);
        setTitle("SimpleList");
        add(panel);
        listJListColours = new JList(namesColours);
        listJListColours.setVisibleRowCount(5);
        listJListColours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        panel.setLayout(new FlowLayout());
        panel.add(new JScrollPane(listJListColours));
        
        listJListColours.addListSelectionListener(new ListListener());
    }
    
    private class ListListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            panel.setBackground(colores[listJListColours.getSelectedIndex()]);
        }
    }
    
}
