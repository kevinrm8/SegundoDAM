/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author kevmar
 */
public class Ventana extends JFrame {

    JPanel panel = new JPanel();
    private JButton blue, pink, yellow, green;

    public Ventana() {

        setTitle("Example with several buttons");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());
        blue = new JButton("Blue");
        Dimension d = new Dimension();
        d.height = 40;
        d.width = 100;
        blue.setPreferredSize(d);
        green = new JButton("Green");
        d.height = 40;
        d.width = 100;
        green.setPreferredSize(d);
        yellow = new JButton("Yellow");
        d.height = 40;
        d.width = 100;
        yellow.setPreferredSize(d);
        pink = new JButton("Pink");
        d.height = 40;
        d.width = 100;
        pink.setPreferredSize(d);
        panel.add(blue, BorderLayout.SOUTH);
        panel.add(green, BorderLayout.NORTH);
        panel.add(yellow, BorderLayout.EAST);
        panel.add(pink, BorderLayout.WEST);
        add(panel);
        panel.setBackground(Color.red);

        blue.addActionListener(new listener_button("blue"));
        green.addActionListener(new listener_button("green"));
        pink.addActionListener(new listener_button("pink"));
        yellow.addActionListener(new listener_button("yellow"));

    }

    class listener_button implements ActionListener {

        private final String color;

        public listener_button(String color) {
            this.color = color;
        }

        public void actionPerformed(ActionEvent e) {
            switch (color) {
                case "blue":
                    panel.setBackground(Color.blue);
                    break;
                case "green":
                    panel.setBackground(Color.green);
                    break;
                case "yellow":
                    panel.setBackground(Color.yellow);
                    break;
                case "pink":
                    panel.setBackground(Color.pink);
                    break;
            }

        }

    }
} // of frame

