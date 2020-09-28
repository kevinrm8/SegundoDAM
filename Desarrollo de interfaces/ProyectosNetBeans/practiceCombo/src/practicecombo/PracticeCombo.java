/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicecombo;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class PracticeCombo extends JFrame {

    private JComboBox combo;
    private JLabel label;
    private JPanel panel;
    private String[] images = {"Rabbit", "Cat", "Dog", "Bird", "Pig"};
    private Icon img;

    public PracticeCombo() {
        setSize(500, 300);
        setTitle("Combos and images");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        combo = new JComboBox(images);

        //an object ImageIcon brings the image:
        img = new ImageIcon(getClass().getResource("images/Rabbit.gif"));
//    //Insantiate label
        label = new JLabel();
//    //label text:
        label.setText("Rabbit");
//    //set icon to label
        label.setIcon(img);

        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);

        label.setToolTipText("This is a Label");

        add(panel);
        panel.add(label, BorderLayout.CENTER);
        combo.addItemListener(new ListenerCombo());
        panel.add(combo, BorderLayout.NORTH);

    }
    
    private class ListenerCombo implements ItemListener{
        public void itemStateChanged( ItemEvent e){
            
            int indice = combo.getSelectedIndex();
            
            String s = images[indice];
            
            img = new ImageIcon( getClass().getResource("images/"+ s +".gif"));
            label.setIcon(img);
            label.setText(s);
        }
    }

}
