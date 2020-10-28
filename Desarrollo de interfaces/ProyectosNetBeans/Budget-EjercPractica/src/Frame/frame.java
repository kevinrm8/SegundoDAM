/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kevmar
 */
public class frame extends JFrame {
    
    private JPanel panel = new JPanel(), panel1 = new JPanel(), panel2 = new JPanel();
    private JTextArea texto;

    public frame() {
        setSize(1000, 700);
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //componentes micros
        String[][] micros = {{"Intel 1", "300"}, {"Intel 2", "350"}, {"AMD 1", "200"}, {"AMD 2", "250"}};
        
        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(1, 4, 10, 10));
        add(panel);
        panel.add(panel1, BorderLayout.CENTER);
        JButton button = new JButton("PRINT");
        panel.add(button, BorderLayout.SOUTH);
        panel.add(panel2);
        //la uso para imprimir, no la añado a ningún panel:
        texto = new JTextArea();
        //Borde al panel micros
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Micros");
        panel2.setBorder(title);
        panel2.setLayout(new GridLayout(micros.length, 1, 10, 10));

        //Creo radiobuttons agrupados
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < micros.length; i++) {
            JRadioButton jb = new JRadioButton(micros[i][0]);
            bg.add(jb);
            panel2.add(jb);
        }
    }
    
}
