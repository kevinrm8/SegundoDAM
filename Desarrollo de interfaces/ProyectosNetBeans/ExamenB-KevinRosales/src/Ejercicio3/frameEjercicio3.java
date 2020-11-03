/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author kevmar
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class frameEjercicio3 extends JFrame {

    private JPanel panelFondo, panelRadioButton;

    private JRadioButton rbLinux, rbWindows, rbMacintosh;

    private JButton aceptar;

    private JLabel mostrarImagen = new JLabel();

    private ImageIcon imgs[] = new ImageIcon[3];

    public frameEjercicio3() {

        setTitle("Swing JRadioButton Demo");
        setSize(500, 500);
        panelFondo = new JPanel(new GridLayout(3, 1, 10, 10));
        add(panelFondo);

        panelRadioButton = new JPanel();
        panelFondo.add(panelRadioButton);

        rbLinux = new JRadioButton("Linux");
        rbWindows = new JRadioButton("Windows");
        rbMacintosh = new JRadioButton("Macintosh");

        //Agrupo los RadioButtons
        ButtonGroup bg = new ButtonGroup();

        bg.add(rbLinux);
        bg.add(rbWindows);
        bg.add(rbMacintosh);

        panelRadioButton.add(rbLinux);
        panelRadioButton.add(rbWindows);
        panelRadioButton.add(rbMacintosh);

        //CARGAR LAS IMAGENES EN EL VECTOR
        imgs[0] = new ImageIcon(getClass().getResource("/imagesExamB/linux.jpg"));
        imgs[1] = new ImageIcon(getClass().getResource("/imagesExamB/windows.jpg"));
        imgs[2] = new ImageIcon(getClass().getResource("/imagesExamB/mac.jpg"));

        //CAMBIAR LAS IMAGENES
        rbLinux.addItemListener(new ManejadorOpciones());
        rbWindows.addItemListener(new ManejadorOpciones());
        rbMacintosh.addItemListener(new ManejadorOpciones());
       
        //Mostrar imagen seleccionada
        panelFondo.add(mostrarImagen);

        //añadir boton
        aceptar = new JButton("OK");
        panelFondo.add(aceptar);

        
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //toma el indice del elemnto seleccionado de la list
                if (rbLinux.isSelected()) {
                    //antes de borrarlo muestro un mensaje al usuario con el elemento a borrar
                    JOptionPane.showMessageDialog(null,
                            "You select: Linux");
                }
                if (rbWindows.isSelected()) {
                    //antes de borrarlo muestro un mensaje al usuario con el elemento a borrar
                    JOptionPane.showMessageDialog(null,
                            "You select: Windows");
                }
                if (rbMacintosh.isSelected()) {
                    //antes de borrarlo muestro un mensaje al usuario con el elemento a borrar
                    JOptionPane.showMessageDialog(null,
                            "You select: Macintosh");
                }

            }
        });

    }

    private class ManejadorOpciones implements ItemListener {

        public ManejadorOpciones() {

        }

        public void itemStateChanged(ItemEvent ie) {
            if (rbLinux.isSelected()) {
                mostrarImagen.setIcon(imgs[0]);
            }
            if (rbWindows.isSelected()) {
                mostrarImagen.setIcon(imgs[1]);
            }
            if (rbMacintosh.isSelected()) {
                mostrarImagen.setIcon(imgs[2]);
            }

        }
    }

}
