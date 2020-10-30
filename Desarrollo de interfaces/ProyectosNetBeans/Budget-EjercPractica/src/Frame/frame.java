/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevmar
 */
public class frame extends JFrame {

    private String factura = "";
    private JPanel panel = new JPanel(), panel1 = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel(), panel4 = new JPanel(), panel5 = new JPanel();
    private JTextArea texto;
    private JButton print, pre;
    //componentes micros, Ram,Monitors,Miscellanea
    private String[][] micros = {{"Intel 1", "300"}, {"Intel 2", "350"}, {"AMD 1", "200"}, {"AMD 2", "250"}};
    private String[][] ram = {{"RAM 1 GB", "50"}, {"RAM 2 GB", "75"}, {"RAM 4 GB", "100"}, {"RAM 8 GB", "200"}};
    private String[][] monitors = {{"LG1", "100"}, {"LG2", "175"}, {"HP1", "200"}, {"HP2", "300"}};
    private String[][] miscellanea = {{"Mouse normal", "20"}, {"Mouse pro", "149"}, {"Keyboard normal", "49"}, {"Keyboard pro", "299"}};

    public frame() {
        setSize(500, 500);
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel1.setLayout(new GridLayout(1, 4, 10, 10));
        add(panel);
        panel.add(panel1);

        JPanel panelNuevo = new JPanel();
        panelNuevo.setLayout(new BorderLayout());
        panel.add(panelNuevo);

        print = new JButton("PRINT");
        panelNuevo.add(print, BorderLayout.NORTH);
        pre = new JButton("Preview");
        panelNuevo.add(pre, BorderLayout.SOUTH);

        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        panel1.add(panel5);

        //la uso para imprimir, no la añado a ningún panel:
        texto = new JTextArea();
        //  texto.setRows(5);
        //PROBAR PARA VISUALIZAR
        panelNuevo.add(texto, BorderLayout.CENTER);
        //Borde al panel micros
        TitledBorder title;

        title = BorderFactory.createTitledBorder("Micros");
        panel2.setBorder(title);
        panel2.setLayout(new GridLayout(micros.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("RAM");
        panel3.setBorder(title);
        panel3.setLayout(new GridLayout(ram.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("Monitors");
        panel4.setBorder(title);
        panel4.setLayout(new GridLayout(monitors.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("Miscellanea");
        panel5.setBorder(title);
        panel5.setLayout(new GridLayout(miscellanea.length, 1, 10, 10));

        //Creo radiobuttons agrupados
        ButtonGroup bgMicros = new ButtonGroup();
        for (int i = 0; i < micros.length; i++) {
            JRadioButton jb = new JRadioButton(micros[i][0]);
            bgMicros.add(jb);
            panel2.add(jb);
        }
        ButtonGroup bgRam = new ButtonGroup();
        for (int i = 0; i < ram.length; i++) {
            JRadioButton jb = new JRadioButton(ram[i][0]);
            bgRam.add(jb);
            panel3.add(jb);
        }
        ButtonGroup bgMonitors = new ButtonGroup();
        for (int i = 0; i < monitors.length; i++) {
            JRadioButton jb = new JRadioButton(monitors[i][0]);
            bgMonitors.add(jb);
            panel4.add(jb);
        }
        for (int i = 0; i < monitors.length; i++) {
            JCheckBox jb = new JCheckBox(miscellanea[i][0]);
            panel5.add(jb);
        }

        pre.addActionListener(e -> {
            try {

                factura = action();
                texto.setText(factura);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        print.addActionListener(e -> {

            try {
                factura = action();
                createPDF(factura);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    //BOTONES
    public String action() throws FileNotFoundException {
        String factura = "";
        int precio, total = 0;
        //Panel de micros
        for (int i = 0; i < panel2.getComponentCount(); i++) {
            JRadioButton rb = (JRadioButton) panel2.getComponent(i);
            if (rb.isSelected()) {
                precio = Integer.parseInt(micros[i][1]);
                total += precio;
                factura += rb.getText() + "\t\t\t PRECIO: " + precio + "\n";

            }
        }
        //Panel de Ram
        for (int i = 0; i < panel3.getComponentCount(); i++) {
            JRadioButton rb = (JRadioButton) panel3.getComponent(i);

            if (rb.isSelected()) {
                precio = Integer.parseInt(ram[i][1]);
                total += precio;
                factura += rb.getText() + "\t\t\t PRECIO: " + precio + "\n";
            }
        }

        //Panel de Monitores
        for (int i = 0; i < panel4.getComponentCount(); i++) {
            JRadioButton rb = (JRadioButton) panel4.getComponent(i);

            if (rb.isSelected()) {
                precio = Integer.parseInt(monitors[i][1]);
                total += precio;
                factura += rb.getText() + "\t\t\t PRECIO: " + precio + "\n";

            }
        }

        //Panel de Miscellanea
        for (int i = 0; i < panel5.getComponentCount(); i++) {
            JCheckBox rb = (JCheckBox) panel5.getComponent(i);

            if (rb.isSelected()) {
                precio = Integer.parseInt(miscellanea[i][1]);
                total += precio;
                factura += rb.getText() + "\t\t\t PRECIO: " + precio + "\n";

            }
        }

        return factura + "\n Precio total: " + total;

    }

    public void createPDF(String factura) throws FileNotFoundException {
        try {

            //esta parte es fija, no se cambia
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter.getInstance(doc, new FileOutputStream("FacturaPC.pdf"));
            doc.open();
            Paragraph p = new Paragraph(factura);
            p.setAlignment(Element.ALIGN_JUSTIFIED);

            doc.add(p);
            doc.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
