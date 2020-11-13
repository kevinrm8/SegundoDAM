/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameTabla;

import com.sun.jdi.connect.spi.Connection;
import java.awt.BorderLayout;
import java.beans.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author kevmar
 */
public class frameTabla extends JFrame {

    private JTable jTable1;
    private JScrollPane jScrollPanel1;

    public frameTabla() throws SQLException, Exception {
        jTable1 = new JTable();
        jScrollPanel1 = new JScrollPane(jTable1);

        setSize(500, 500);
        add(jScrollPanel1);

        // Headers for the columns of the table
        String[] headers = new String[]{
            "Name", "Address", "Telephone", "Car?"
        };

        // Data for the table
        Object[][] data = new Object[][]{
            {"Alfons González Pi", "Argentona, Barcelona", new Long(933333333), true},
            {"Ana María Cuesta Suñer", "Gijón, Asturias", new Long(984454545), false},
            {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
            {"Pedro Aguado Rodríguez", "Madrid", new Long(912804574), true}
        };
        jTable1.setModel(new DefaultTableModel(data, headers) {
            // Types of each column
            Class[] tipoColumn = {String.class,
                String.class,
                Long.class,
                Boolean.class};
            // override the getColumnClass method

            @Override
            public Class getColumnClass(int indColum) {
                return tipoColumn[indColum];
            }
        });

    }
}
