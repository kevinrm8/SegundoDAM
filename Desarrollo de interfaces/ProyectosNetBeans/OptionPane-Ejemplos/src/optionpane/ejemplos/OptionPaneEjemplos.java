/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionpane.ejemplos;

import java.awt.BorderLayout;
import javax.swing.*;


/**
 *
 * @author kevmar
 */
public class OptionPaneEjemplos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JOptionPane.showMessageDialog(null, "Operation Successful");

        JOptionPane.showMessageDialog(null, "Message inside window",
                "Message in the title bar",
                JOptionPane.WARNING_MESSAGE);
        //showConfirmDialog
        int confirmed = JOptionPane.showConfirmDialog(null, "Do you confirm this?");

        if (JOptionPane.OK_OPTION == confirmed) {
            System.out.println("confirmed");
        } else {
            System.out.println("ok ... I don't delete anything ...");
        }

        // showOptionDialog
        int select = JOptionPane.showOptionDialog(
                null, // parent component
                "Select option",
                "Options Selector",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null for default icon or an icon.
                new Object[]{"option 1", "option 2", "option 3"},
                // null for YES, NO and CANCEL
                "option 1");
        if (select != -1) {
            System.out.println("selected option" + (select + 1));
        }

        // With text box
        String sel = JOptionPane.showInputDialog(
                null,
                "Input dialog",
                JOptionPane.QUESTION_MESSAGE); // the icon will be a questioner

        System.out.println("The user has typed " + sel);

        // With JCombobox
        Object selec = JOptionPane.showInputDialog(
                null,
                "Select option",
                "Options Selector",
                JOptionPane.QUESTION_MESSAGE,
                null, // null for default icon
                new Object[]{"option 1", "option 2", "option 3"},
                "option 1");

        System.out.println("The user has chosen" + selec);

        
        
    }

}
