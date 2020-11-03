/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author kevmar
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class frameEjercicio2 extends JFrame {

    private JPanel panelFondo, panelButton, panelToggleButton, panelCheckBox, panelRadioButton;
    private JButton BMortadelo, BFilemon, BCarpanta, BRompetechos, BPepeGotera, BOtilio;
    private JToggleButton TBMortadelo, TBFilemon, TBCarpanta, TBRompetechos, TBPepeGotera, TBOtilio;
    private JCheckBox CBMortadelo, CBFilemon, CBCarpanta, CBRompetechos, CBPepeGotera, CBOtilio;
    private JRadioButton RBMortadelo, RBFilemon, RBCarpanta, RBRompetechos, RBPepeGotera, RBOtilio;

    public frameEjercicio2() {

        setTitle("Tutorial de Java, Swing");
        setSize(800, 500);
        panelFondo = new JPanel(new GridLayout(4, 1, 10, 10));
        add(panelFondo);

        panelButton = new JPanel();
        panelToggleButton = new JPanel();
        panelCheckBox = new JPanel();
        panelRadioButton = new JPanel();

        //BORDES DE LOS PANELES
        TitledBorder title;

        title = BorderFactory.createTitledBorder("JButton");
        panelButton.setBorder(title);
        panelFondo.add(panelButton);

        title = BorderFactory.createTitledBorder("JToggleButton");
        panelToggleButton.setBorder(title);
        panelFondo.add(panelToggleButton);

        title = BorderFactory.createTitledBorder("JCheckBox");
        panelCheckBox.setBorder(title);
        panelFondo.add(panelCheckBox);

        title = BorderFactory.createTitledBorder("JRadioButton");
        panelRadioButton.setBorder(title);
        panelFondo.add(panelRadioButton);

        //Añadir botones
        BMortadelo = new JButton("Mortadelo");
        BFilemon = new JButton("Filemon");
        BCarpanta = new JButton("Carpanta");
        BRompetechos = new JButton("Rompetechos");
        BPepeGotera = new JButton("Pepe Gotera");
        BOtilio = new JButton("Otilio");

        panelButton.add(BMortadelo);
        panelButton.add(BFilemon);
        panelButton.add(BCarpanta);
        panelButton.add(BRompetechos);
        panelButton.add(BPepeGotera);
        panelButton.add(BOtilio);

        //Añadir ToggleButton 
        TBMortadelo = new JToggleButton("Mortadelo");
        TBFilemon = new JToggleButton("Filemon");
        TBCarpanta = new JToggleButton("Carpanta");
        TBRompetechos = new JToggleButton("Rompetechos");
        TBPepeGotera = new JToggleButton("Pepe Gotera");
        TBOtilio = new JToggleButton("Otilio");

        panelToggleButton.add(TBMortadelo);
        panelToggleButton.add(TBFilemon);
        panelToggleButton.add(TBCarpanta);
        panelToggleButton.add(TBRompetechos);
        panelToggleButton.add(TBPepeGotera);
        panelToggleButton.add(TBOtilio);

        //Añadir CheckBoxes
        CBMortadelo = new JCheckBox("Mortadelo");
        CBFilemon = new JCheckBox("Filemon");
        CBCarpanta = new JCheckBox("Carpanta");
        CBRompetechos = new JCheckBox("Rompetechos");
        CBPepeGotera = new JCheckBox("Pepe Gotera");
        CBOtilio = new JCheckBox("Otilio");

        panelCheckBox.add(CBMortadelo);
        panelCheckBox.add(CBFilemon);
        panelCheckBox.add(CBCarpanta);
        panelCheckBox.add(CBRompetechos);
        panelCheckBox.add(CBPepeGotera);
        panelCheckBox.add(CBOtilio);

        //Añadir RadioButtons
        RBMortadelo = new JRadioButton("Mortadelo");
        RBFilemon = new JRadioButton("Filemon");
        RBCarpanta = new JRadioButton("Carpanta");
        RBRompetechos = new JRadioButton("Rompetechos");
        RBPepeGotera = new JRadioButton("Pepe Gotera");
        RBOtilio = new JRadioButton("Otilio");

        //Agrupo los RadioButtons
        ButtonGroup bg = new ButtonGroup();

        bg.add(RBMortadelo);
        bg.add(RBFilemon);
        bg.add(RBCarpanta);
        bg.add(RBRompetechos);
        bg.add(RBPepeGotera);
        bg.add(RBOtilio);

        panelRadioButton.add(RBMortadelo);
        panelRadioButton.add(RBFilemon);
        panelRadioButton.add(RBCarpanta);
        panelRadioButton.add(RBRompetechos);
        panelRadioButton.add(RBPepeGotera);
        panelRadioButton.add(RBOtilio);

    }
}
