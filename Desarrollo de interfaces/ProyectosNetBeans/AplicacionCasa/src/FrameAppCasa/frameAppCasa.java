/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameAppCasa;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author kevmar
 */
public class frameAppCasa extends JFrame {

    private JPanel panelFondo = new JPanel();
    private JMenuBar menuBar;
    private JMenu menuCasa, menuExtra, menuHabitaciones, menuExtras;
    private JMenuItem menuItemHabitacion;
    private ImageIcon imagen;

    public frameAppCasa() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aplicacion Casa");
        setBounds(500, 500, 500, 500);

        menuBar = new JMenuBar();
        menuCasa = new JMenu("Casa");
        menuHabitaciones = new JMenu("Habitaciones");
        imagen = new ImageIcon(getClass().getResource("/Imagen/imgCasa.png"));

        menuCasa.setIcon(imagen);

    }
}
