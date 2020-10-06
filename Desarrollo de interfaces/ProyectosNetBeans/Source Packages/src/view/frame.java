/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.show;
//import controller.controller;


public class frame extends JFrame {
    private JPanel panel1= new JPanel();
    private JPanel panel2= new JPanel();
    private JPanel panel3= new JPanel();
    private JButton b1,b2,b3,b4,b5,b6,b7;
    private JLabel e1,e2,e3,e4,e5,e6;
    private JTextField t1,t2,t3,t4,t5,t6;

    public frame(){
    setSize(500,300);
        setTitle("My series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(7,2,10,10));
        panel3.setLayout(new FlowLayout());
        add(panel1);
        panel1.add(panel3,BorderLayout.NORTH);
        panel1.add(panel2,BorderLayout.CENTER);
    }
}
