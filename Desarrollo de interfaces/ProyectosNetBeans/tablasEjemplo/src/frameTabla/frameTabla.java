/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameTabla;

import Conexion.ConexionTabla;
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

        // Headers for the columns of the table
        String[] headers = new String[]{
            "Name", "Address", "Telephone", "Car?"
        };
        jTable1 = new JTable();

        // Data for the table
//        Object[][] data = new Object[][]{
//            {"Alfons González Pi", "Argentona, Barcelona", new Long(933333333), true},
//            {"Ana María Cuesta Suñer", "Gijón, Asturias", new Long(984454545), false},
//            {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
//            {"Pedro Aguado Rodríguez", "Madrid", new Long(912804574), true}
//        };
//        jTable1.setModel(new DefaultTableModel(data, headers) {
//            // Types of each column
//            Class[] tipoColumn = {String.class,
//                String.class,
//                Long.class,
//                Boolean.class};
//            // override the getColumnClass method
//
//            @Override
//            public Class getColumnClass(int indColum) {
//                return tipoColumn[indColum];
//            }
//        });
        jScrollPanel1 = new JScrollPane(jTable1);
        add(jScrollPanel1);
        setSize(500, 500);

        DefaultTableModel model = new DefaultTableModel();

        // configuration columns of the DefaultTableModel
        Object[] tags = new Object[2];
        tags[0] = "Id";
        tags[1] = "Notes";
        model.setColumnIdentifiers(tags);

        //CARGAR DATOS MYSQL
        try {
            
            ConexionTabla db_Connection = new ConexionTabla();
            Statement s = 
            ResultSet rs = s.executeQuery("select * from clients");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // We prepare the query 
        // We go through the result, while there are records to read
        // add each record to the DefaultDataModel
        int rowNumber = 0;
        while (rs.next()) {
            // The row for the table model is created and filled.
            Object[] rowData = new Object[model.getColumnCount()];
            rowData[0] = rs.getObject(1);
            rowData[1] = rs.getObject(2);
            model.addRow(rowData);
            rowNumber++;
        }
        // We close the connection to the database. 
        rs.close();
        s.close();
        con.close();

        jTable1.setModel(model);
        //add(jTable1);

    }
}
