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

    private JPanel panel = new JPanel(), panel1 = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel(), panel4 = new JPanel(), panel5 = new JPanel();
    private JTextArea texto;
    private JButton button, pre;

    public frame() {
        setSize(500, 500);
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //componentes micros, Ram,Monitors,Miscellanea
        String[][] micros = {{"Intel 1", "300"}, {"Intel 2", "350"}, {"AMD 1", "200"}, {"AMD 2", "250"}};
        String[][] ram = {{"RAM 1 GB", "50"}, {"RAM 2 GB", "75"}, {"RAM 4 GB", "100"}, {"RAM 8 GB", "200"}};
        String[][] monitors = {{"LG1", "100"}, {"LG2", "175"}, {"HP1", "200"}, {"HP2", "300"}};
        String[][] miscellanea = {{"Mouse normal", "20"}, {"Mouse pro", "149"}, {"Keyboard normal", "49"}, {"Keyboard pro", "299"}};

        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(1, 4, 10, 10));
        add(panel);

        JPanel panelNuevo = new JPanel();
        panelNuevo.setLayout(new GridLayout(3, 1, 10, 10));
        panel.add(panelNuevo, BorderLayout.CENTER);
        panelNuevo.add(panel1);

        button = new JButton("PRINT");
        panelNuevo.add(button, new BorderLayout());
        pre = new JButton("Preview");
        panelNuevo.add(pre, new BorderLayout());

        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        panel1.add(panel5);

        //la uso para imprimir, no la añado a ningún panel:
        texto = new JTextArea();
        //Borde al panel micros
        TitledBorder title;

        title = BorderFactory.createTitledBorder("Micros");
        panel2.setBorder(title);
        panel2.setLayout(new GridLayout(micros.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("RAM");
        panel3.setBorder(title);
        panel3.setLayout(new GridLayout(ram.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("Monitors");
        panel4.setBorder(title);
        panel4.setLayout(new GridLayout(monitors.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("Miscellanea");
        panel5.setBorder(title);
        panel5.setLayout(new GridLayout(miscellanea.length, 1, 10, 10));

        //Creo radiobuttons agrupados
        ButtonGroup bgMicros = new ButtonGroup();
        for (int i = 0; i < micros.length; i++) {
            JRadioButton jb = new JRadioButton(micros[i][0]);
            bgMicros.add(jb);
            panel2.add(jb);
        }
        ButtonGroup bgRam = new ButtonGroup();
        for (int i = 0; i < ram.length; i++) {
            JRadioButton jb = new JRadioButton(ram[i][0]);
            bgRam.add(jb);
            panel3.add(jb);
        }
        ButtonGroup bgMonitors = new ButtonGroup();
        for (int i = 0; i < monitors.length; i++) {
            JRadioButton jb = new JRadioButton(monitors[i][0]);
            bgMonitors.add(jb);
            panel4.add(jb);
        }
        for (int i = 0; i < monitors.length; i++) {
            JCheckBox jb = new JCheckBox(miscellanea[i][0]);
            panel5.add(jb);
        }

    }

}
