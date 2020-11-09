/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus.ejemplos;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author kevmar
 */
public class DialogoModal extends JDialog {

    private JTextField textField;

    public DialogoModal(JFrame MenusEjemplos) {
        super(MenusEjemplos, true);

        setTitle("Mete un dato");
        textField = new JTextField(20);
        add(textField);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });
    }

    public String getText() {
        return textField.getText();
    }
}
