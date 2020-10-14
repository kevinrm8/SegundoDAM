/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.show;
import controller.controller;
//import controller.controller;

public class frame extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();

    // private JPanel panel4 = new JPanel();
    private JButton b1, b2, b3, b4, b5, b6, b7;
    private JLabel e1, e2, e3, e4, e5, e6, e7;
    private JTextField t1, t2, t3, t4, t5, t6, t7 = new JTextField();

    private JComboBox combo;
    private final String plataformas[] = {"HBO", "NETFLIX", "DISNEY+", "AMAZON PRIME"};

    private controller c = null;

    public frame(controller control) {

        c = control;
        setSize(500, 300);
        setTitle("My series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(7, 2, 10, 10));
        panel3.setLayout(new FlowLayout());
        add(panel1);
        panel1.add(panel3, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.CENTER);

        //Inicializo el JComboBox
        combo = new JComboBox(plataformas);

        //Creo los botones
        b1 = new JButton("|<");
        b2 = new JButton("<");
        b3 = new JButton(">");
        b4 = new JButton(">|");
        b5 = new JButton("+");
        b6 = new JButton("-");
        b7 = new JButton("*");
        //Añado los botones al panel 3 
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);
        panel3.add(b4);
        panel3.add(b5);
        panel3.add(b6);
        panel3.add(b7);

        //Creo los Label y TextField y los añado al panel2
        e1 = new JLabel("Title");
        t1 = new JTextField(50);
        panel2.add(e1);
        panel2.add(t1);
        e2 = new JLabel("ScreenWriter");
        t2 = new JTextField(50);
        panel2.add(e2);
        panel2.add(t2);
        e3 = new JLabel("Season");
        t3 = new JTextField(50);
        panel2.add(e3);
        panel2.add(t3);
        e4 = new JLabel("Genre");
        t4 = new JTextField(50);
        panel2.add(e4);
        panel2.add(t4);
        e5 = new JLabel("Seen Seasons");
        t5 = new JTextField(50);
        panel2.add(e5);
        panel2.add(t5);
        e6 = new JLabel("Plataforma");
        t6 = new JTextField(50);
        panel2.add(e6);
        panel2.add(t6);
        e7 = new JLabel("Plataforma:");
        panel2.add(e7);
        panel2.add(combo);
        e7.setVisible(false);
        combo.setVisible(false);

        //Evitar la modificacion de los TextFields
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);

        //Add buttons Listener
        buttonsListener bl = new buttonsListener();
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        b4.addActionListener(bl);
        b5.addActionListener(bl);
        b6.addActionListener(bl);
        b7.addActionListener(bl);

        //Precargar primero
        show s = new show();
        s = c.first();
        updating(s);

        //Guardar seleccion del combom
        combo.addItemListener((ItemListener) new ManejarOpciones());
    }

    class buttonsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) { // ACCION PARA CADA BOTON
            show s = new show();
            if (e.getSource() == b1) {
                s = c.first();
            }
            if (e.getSource() == b2) {
                s = c.previous();
            }
            if (e.getSource() == b3) {
                s = c.next();
            }
            if (e.getSource() == b4) {
                s = c.last();
            }
            if (e.getSource() == b5) {
                if (b5.getText().equals("+")) {
                    //vaciar textfield
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");

                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);

                    //Cambiar texto de b5
                    b5.setText("+++");

                    t1.setEditable(true);
                    t2.setEditable(true);
                    t3.setEditable(true);
                    t4.setEditable(true);
                    t5.setEditable(true);

                    //No muestro la paltaforma
                    e6.setVisible(false);
                    t6.setVisible(false);
                    //Muestro la seleccion de paltaforma
                    e7.setVisible(true);
                    combo.setVisible(true);
                    //Preseleccionar la primera opcion
                    t6.setText(combo.getSelectedItem().toString());

                } else {
                    //Habilitar botones
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b6.setEnabled(true);
                    b7.setEnabled(true);

                    t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    t6.setEditable(false);
                    //Vuelvo a mostrar la paltaforma
                    e6.setVisible(true);
                    t6.setVisible(true);
                    //Escondo la seleccion de plataforma
                    e7.setVisible(false);
                    combo.setVisible(false);

                    //cambiar texto de b5
                    b5.setText("+");

                    s = fillShow();
                    c.nuevo(s);
                }
            }
            if (e.getSource() == b6) {
                // Para hacer poppup     JOptionPane.OK_CANCEL_OPTION --- JOptionPane.showConfirmDialog(rootPane, s)
//                Object[] options = {"SI", "NO"};
//                int n = JOptionPane.showOptionDialog(panel4, "Estas seguro?", "CONFIRMACION", JOptionPane.YES_NO_CANCEL_OPTION,
//                        JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
               
               // c.eliminarC();
                
            }
            //Para modificar
            if (e.getSource() == b7) {

                if (b7.getText().equals("*")) {
                    s = c.getShow();

                    t1.setEditable(true);
                    t2.setEditable(true);
                    t3.setEditable(true);
                    t4.setEditable(true);
                    t5.setEditable(true);
                    t6.setEditable(true);

                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);

                    //No muestro la paltaforma
                    e6.setVisible(false);
                    t6.setVisible(false);
                    //Muestro la seleccion de paltaforma
                    e7.setVisible(true);
                    combo.setVisible(true);
                    //Preseleccionar la primera opcion
                    t6.setText(combo.getSelectedItem().toString());

                    b7.setText("***");
                } else {

                    t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    t6.setEditable(false);

                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);

                    //Vuelvo a mostrar la paltaforma
                    e6.setVisible(true);
                    t6.setVisible(true);
                    //Escondo la seleccion de plataforma
                    e7.setVisible(false);
                    combo.setVisible(false);

                    b7.setText("*");
                    s = c.guardar(fillShow());
                }
            }

            updating(s);
        }
    }

    private void updating(show s) {
        t1.setText(s.getTitle());
        t2.setText(s.getScriptwriter());
        t3.setText(String.valueOf(s.getSeasons()));
        t4.setText(s.getGenre());
        t5.setText(String.valueOf(s.getViews()));
        t6.setText(s.getPlataforma());
    }

    private show fillShow() {
        show s;
        s = new show(t1.getText(), t2.getText(),
                Integer.parseInt(t3.getText()), t4.getText(),
                Integer.parseInt(t5.getText()), t7.getText());

        return s;
    }

    private class ManejarOpciones implements ItemListener {

        public ManejarOpciones() {
        }

        public void itemStateChanged(ItemEvent e) {
            t7.setText(combo.getSelectedItem().toString());

        }
    }
}
