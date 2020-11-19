/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.vista;

import com.ecodeup.controller.ControllerCliente;
import com.ecodeup.model.Cliente;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author kevin
 */
public class NuevoCliente extends JDialog {

    private JPanel panelFondo = new JPanel(new BorderLayout()), panelDatos = new JPanel(new GridLayout(7, 2, 10, 10));

    private JLabel Lname, Llast_name, Luser_name, Lpassword, Lemail;
    private JTextField tfName, tfLast_name, tfUser_name, tfPassword, tfEmail;
    private JButton aceptar, salir;

    ControllerCliente controller = new ControllerCliente();

    public NuevoCliente(ViewCliente vc, boolean modal) {
        super(vc, modal);

        setSize(400, 400);
        setTitle("Crear un nuevo Cliente");
        setLocationRelativeTo(null);
        add(panelFondo);
        panelFondo.add(panelDatos);

        Lname = new JLabel("Nombre");
        tfName = new JTextField(50);
        panelDatos.add(Lname);
        panelDatos.add(tfName);
        Llast_name = new JLabel("Last Name");
        tfLast_name = new JTextField(50);
        panelDatos.add(Llast_name);
        panelDatos.add(tfLast_name);
        Luser_name = new JLabel("User Name");
        tfUser_name = new JTextField(50);
        panelDatos.add(Luser_name);
        panelDatos.add(tfUser_name);
        Lpassword = new JLabel("Password");
        tfPassword = new JTextField(50);
        panelDatos.add(Lpassword);
        panelDatos.add(tfPassword);
        Lemail = new JLabel("Email");
        tfEmail = new JTextField(50);
        panelDatos.add(Lemail);
        panelDatos.add(tfEmail);

        aceptar = new JButton("Aceptar");
        panelDatos.add(aceptar);
        salir = new JButton("Salir");
        panelDatos.add(salir);

        aceptar.addActionListener(l -> {

            Cliente cliente = new Cliente(tfName.getText(), tfLast_name.getText(), tfUser_name.getText(), tfPassword.getText(), tfEmail.getText());
            controller.registrar(cliente);
            setVisible(false);
        });
        
        salir.addActionListener(s->{
            setVisible(false);
        });
        
        setVisible(true);
    }
}
