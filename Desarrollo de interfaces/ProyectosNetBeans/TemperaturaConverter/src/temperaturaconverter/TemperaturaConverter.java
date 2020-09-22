/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperaturaconverter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperaturaConverter extends JFrame {

    JTextField textField1, textField2;
    JLabel Celsius, Kelvin;

    JPanel panel = new JPanel();

    public TemperaturaConverter() {

        setTitle("JTextField example");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 2, 20, 20));

        Celsius = new JLabel("Grados Celsius");
        textField1 = new JTextField(10);

        // Add a listener
        textField1.addActionListener(new TextFieldListener());

        // Assign a black border line.
        textField1.setBorder(BorderFactory.createLineBorder(Color.black));

        Kelvin = new JLabel("Grados Kelvin");

        textField2 = new JTextField(20);

        textField2.addActionListener(new KelvinToCelsius());

        textField2.setBorder(BorderFactory.createLineBorder(Color.blue));

        JButton button = new JButton("Clear");

        button.addActionListener(new ButtonListener());

        // Add the elements to the panel
        panel.add(Celsius);

        panel.add(textField1);

        panel.add(Kelvin);

        panel.add(textField2);

        panel.add(button);

        add(panel);
    }

    // textfield listener
    class TextFieldListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // get the text typed in textfield1
            // and assign it to the other textfield.
            String text = textField1.getText();
            double GCel;
            GCel = Double.parseDouble(text);
            GCel = GCel + 273.15;
            text = String.valueOf(GCel);
            textField2.setText(text);
        }
    }

    class KelvinToCelsius implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // get the text typed in textfield1
            // and assign it to the other textfield.
            String text = textField2.getText();
            double GCel;
            GCel = Double.parseDouble(text);
            GCel = GCel - 273.15;
            text = String.valueOf(GCel);
            textField1.setText(text);
        }
    }

    // listener of the button.
    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // clean the textfields.
            textField1.setText("");
            textField1.requestFocus(); // Give focus to textfield1
            textField2.setText("");
        }
    }
}
