/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kevin
 */
public class frame extends JFrame {

    private JPanel panelFondo, panelImagen, panelJugadores, panelPlayer1 = new JPanel(new GridLayout(3, 1, 10, 10)), panelPlayer2 = new JPanel(new GridLayout(4, 1, 10, 10));
    private JPasswordField pass = new JPasswordField();
    private char[] vc;
    private JButton aceptarPlayer1, aceptarPlayer2, botonImagenes = new JButton();
    private JLabel palabra = new JLabel("Word to guess"), letra = new JLabel("Letter"), resolver = new JLabel();
    private JTextArea letraAdivinar = new JTextArea();
    private ImageIcon imgs[] = new ImageIcon[5];

    public frame() {

        setSize(800, 500);
        setTitle("JuegoAhorcado");
        panelFondo = new JPanel(new GridLayout(1, 2, 10, 10));
        add(panelFondo);

        panelImagen = new JPanel();
        panelFondo.add(panelImagen);
        panelJugadores = new JPanel(new GridLayout(2, 1, 10, 10));
        panelFondo.add(panelJugadores);

        //BORDES DE LOS PANELES
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Image");
        panelImagen.setBorder(title);

        title = BorderFactory.createTitledBorder("Player1");
        panelPlayer1.setBorder(title);
        panelJugadores.add(panelPlayer1);

        title = BorderFactory.createTitledBorder("Player2");
        panelPlayer2.setBorder(title);
        panelJugadores.add(panelPlayer2);

        //CARGAR LAS IMAGENES EN EL VECTOR
        imgs[0] = new ImageIcon(getClass().getResource("/imagenes/foto1.png"));
        imgs[1] = new ImageIcon(getClass().getResource("/imagenes/foto2.png"));
        imgs[2] = new ImageIcon(getClass().getResource("/imagenes/foto3.png"));
        imgs[3] = new ImageIcon(getClass().getResource("/imagenes/foto4.png"));
        imgs[4] = new ImageIcon(getClass().getResource("/imagenes/foto5.png"));

        //PANEL IMAGENES
        botonImagenes.setIcon(imgs[0]);
        panelImagen.add(botonImagenes);

        //PANEL JUGADOR 1
        panelPlayer1.add(palabra);
        panelPlayer1.add(pass);
        aceptarPlayer1 = new JButton("Accept");
        panelPlayer1.add(aceptarPlayer1);

        //PANEL JUGADOR 2
        panelPlayer2.add(letra);
        panelPlayer2.add(letraAdivinar);
        aceptarPlayer2 = new JButton("Accept");
        aceptarPlayer2.setEnabled(false);
        panelPlayer2.add(aceptarPlayer2);
        
        aceptarPlayer1.addActionListener(l -> {
            introducirPalabraSecreta();
        });

    }

    private void introducirPalabraSecreta() {
        char[] respuestas;
        String pal;
        vc = pass.getPassword();
        respuestas = new char[vc.length];
        
        
         // Rellenamos palabras ocn guiones
        for(int i = 0; i < respuestas.length; i++){
            respuestas[i] = '-';
        }
        
        aceptarPlayer1.setEnabled(false);
        aceptarPlayer2.setEnabled(true);
        
        panelPlayer2.add(aceptarPlayer2);
        System.out.println(vc);

    }
}
