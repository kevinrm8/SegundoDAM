/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameAppCasa;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author kevmar
 */
public class frameAppCasa extends JFrame {

    private JPanel panelFondo = new JPanel(new BorderLayout());
    private JMenuBar menuBar;
    private JMenu menuCasa, menuExtra, menuHabitaciones, menuExtras;
    private JMenuItem menuItemHabitacion1, menuItemHabitacion2, garaje, trastero;
    private ImageIcon imagen;
    private JCheckBoxMenuItem salon;
    private JRadioButtonMenuItem cocina, bano;

    public frameAppCasa() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aplicacion Casa");
        setBounds(500, 500, 500, 500);

        menuBar = new JMenuBar();
        menuCasa = new JMenu("Casa");
        menuExtra = new JMenu("Extras");

        menuHabitaciones = new JMenu("Habitaciones");
        imagen = new ImageIcon(getClass().getResource("/Imagen/imgCasa.png"));
        menuCasa.setIcon(imagen);
        menuCasa.add(menuHabitaciones);

        menuItemHabitacion1 = new JMenuItem("Habitacion 1");
        menuItemHabitacion2 = new JMenuItem("Habitacion 2");
        menuHabitaciones.add(menuItemHabitacion1);
        menuHabitaciones.add(menuItemHabitacion2);

        salon = new JCheckBoxMenuItem("Salon");
        salon.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        menuCasa.add(salon);
        menuCasa.addSeparator();

        cocina = new JRadioButtonMenuItem("Cocina");
        cocina.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        bano = new JRadioButtonMenuItem("Baño");
        bano.setAccelerator(KeyStroke.getKeyStroke('B', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        ButtonGroup bg = new ButtonGroup();
        bg.add(cocina);
        bg.add(bano);

        menuCasa.add(cocina);
        menuCasa.add(bano);

        garaje = new JMenuItem("Garaje");
        garaje.setAccelerator(KeyStroke.getKeyStroke('G', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        trastero = new JMenuItem("Trastero");
        trastero.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        menuExtra.add(garaje);
        menuExtra.add(trastero);

        menuBar.add(menuCasa);
        menuBar.add(menuExtra);
        add(panelFondo);
        panelFondo.add(menuBar, BorderLayout.NORTH);
    }
}
