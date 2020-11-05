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

    public frameGalore() {

        setBounds(600, 300, 500, 100);
        setTitle("OptionGalore");

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
            num = JOptionPane.showInputDialog(null, "Escribe un numero para multiplicar por 2","Entrada",
                    JOptionPane.QUESTION_MESSAGE);
                // the icon will be a questioner
            try{
                
            }catch(Exception e){
            
            }
            
                break;
            case 5:
                break;
            case 6:
                break;

        }

    }

}
