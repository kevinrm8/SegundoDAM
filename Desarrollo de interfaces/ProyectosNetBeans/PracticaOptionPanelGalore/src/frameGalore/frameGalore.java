/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameGalore;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author kevmar
 */
public class frameGalore extends JFrame {

    private JPanel panelFondo = new JPanel();
    private JButton Binfo, Badvertencia, Berror, Bconfirmacion, Btexto, Bcombo, Bmas;

    public static void main(String[] args) {
        frameGalore f = new frameGalore();
        f.setVisible(true);
    }

    public frameGalore() {

        setBounds(600, 300, 500, 150);
        setTitle("Montones de JOptionPane");

        add(panelFondo);

        Binfo = new JButton("Info");
        Badvertencia = new JButton("Advertencia");
        Berror = new JButton("Error");
        Bconfirmacion = new JButton("Confirmacion");
        Btexto = new JButton("Texto");
        Bcombo = new JButton("Combo");
        Bmas = new JButton("Mas");

        panelFondo.add(Binfo);
        panelFondo.add(Badvertencia);
        panelFondo.add(Berror);
        panelFondo.add(Bconfirmacion);
        panelFondo.add(Btexto);
        panelFondo.add(Bcombo);
        panelFondo.add(Bmas);

        Binfo.addActionListener(l -> {
            mostrarOptionPanel(0);
        });
        Badvertencia.addActionListener(l -> {
            mostrarOptionPanel(1);
        });
        Berror.addActionListener(l -> {
            mostrarOptionPanel(2);
        });
        Bconfirmacion.addActionListener(l -> {
            mostrarOptionPanel(3);
        });
        Btexto.addActionListener(l -> {
            mostrarOptionPanel(4);
        });
        Bcombo.addActionListener(l -> {
            mostrarOptionPanel(5);
        });
        Bmas.addActionListener(l -> {
            mostrarOptionPanel(6);
        });
    }

    private void mostrarOptionPanel(int numero) {

        switch (numero) {
            case 0:
                JOptionPane.showMessageDialog(null, "Este es un mensaje Simple tipo Informacion");
                JOptionPane.showMessageDialog(null, "Otro mensaje Simple tipo informacion per con titulo");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Este es un mensaje de Advertencia",
                        "WARNING_MESSAGE",
                        JOptionPane.WARNING_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Este es un mensaje de Error",
                        "ERROR_MESSAGE",
                        JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Este es un mensaje de confirmacion o pregunta",
                        "QUESTION_MESSAGE",
                        JOptionPane.QUESTION_MESSAGE);
                // the icon will be a questioner

                break;
            case 4:
                String num;
                int mult;
                num = JOptionPane.showInputDialog(null, "Escribe un numero para multiplicar por 2", "Entrada",
                        JOptionPane.QUESTION_MESSAGE);
                // the icon will be a questioner
                try {
                    mult = Integer.parseInt(num) * 2;
                    JOptionPane.showMessageDialog(null, "El resultado de la multiplicar 2 * " + Integer.parseInt(num) + " es:" + mult);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe introducir un numero",
                            "ERROR_MESSAGE",
                            JOptionPane.ERROR_MESSAGE);
                }

                break;
            case 5:
                Object selColores = JOptionPane.showInputDialog(null,
                        "Select option",
                        "Options Selector",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Amarillo", "Verde", "Azul", "Rojo"},
                        "Select");

                JOptionPane.showMessageDialog(null, "Color seleccionado: " + selColores, "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                break;
            case 6:
                int select = JOptionPane.showOptionDialog(
                        null, // parent component
                        "Select option",
                        "Options Selector",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, // null for default icon or an icon.
                        new Object[]{"Yes", "No", "Cancel"},
                        // null for YES, NO and CANCEL
                        "option 1");
//                if (select != -1) {
//                    System.out.println("selected option" + (select + 1));
//                }

                if (select == 0) {
                    JCheckBox cb = new JCheckBox("A veces");
                    JCheckBox cb1 = new JCheckBox("A menudo");
                    JCheckBox cb2 = new JCheckBox("Siempre");

                    Object[] params = {"Seleccione una opcion", cb, cb1, cb2};
                    //int n = JOptionPane.showMessageDialog(null, params);
                    JOptionPane.showMessageDialog(null, params, "Entrada",
                            JOptionPane.QUESTION_MESSAGE);
                }
                if (select == 1) {
                    JOptionPane.showMessageDialog(null, "Pues es muy útil", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

        }

    }

}
