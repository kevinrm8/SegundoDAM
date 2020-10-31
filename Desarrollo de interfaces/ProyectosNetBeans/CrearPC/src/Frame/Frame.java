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
 * @author kevin
 */
public class Frame extends JFrame {

    //componentes micros, Ram,Monitors,Miscellanea
    private String[][] micros = {{"Intel 1", "300"}, {"Intel 2", "350"}, {"AMD 1", "200"}, {"AMD 2", "250"}};
    private String[][] ram = {{"RAM 1 GB", "50"}, {"RAM 2 GB", "75"}, {"RAM 4 GB", "100"}, {"RAM 8 GB", "200"}};
    private String[][] monitors = {{"LG1", "100"}, {"LG2", "175"}, {"HP1", "200"}, {"HP2", "300"}};
    private String[][] miscellanea = {{"Mouse normal", "20"}, {"Mouse pro", "149"}, {"Keyboard normal", "49"}, {"Keyboard pro", "299"}};

    private JPanel panelFondo, panelListas, panelMicro, panelRam, panelMonitor, panelMiscell, panelBotonesPreview;
    private JButton imprimirPDF, preview;

    private JTextArea previewFactura;

    private String factura = "";
    private int precioTotal = 0;

    public Frame() {

        setSize(500, 700);
        setTitle("Montar PC");
        panelFondo = new JPanel(new GridLayout(2, 1, 10, 10));
        add(panelFondo);
        panelListas = new JPanel(new GridLayout(1, 4, 10, 10));
        panelFondo.add(panelListas);

        panelBotonesPreview = new JPanel(new BorderLayout());
        panelFondo.add(panelBotonesPreview);

        panelMicro = new JPanel();
        panelRam = new JPanel();
        panelMonitor = new JPanel();
        panelMiscell = new JPanel();
        previewFactura = new JTextArea();
        imprimirPDF = new JButton("Imprimir PDF");
        preview = new JButton("Preview");

        panelListas.add(panelMicro);
        panelListas.add(panelRam);
        panelListas.add(panelMonitor);
        panelListas.add(panelMiscell);
        panelBotonesPreview.add(imprimirPDF, BorderLayout.NORTH);
        panelBotonesPreview.add(preview, BorderLayout.SOUTH);
        panelBotonesPreview.add(previewFactura, BorderLayout.CENTER);

        TitledBorder title;

        title = BorderFactory.createTitledBorder("Micros");
        panelMicro.setBorder(title);
        panelMicro.setLayout(new GridLayout(micros.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("RAM");
        panelRam.setBorder(title);
        panelRam.setLayout(new GridLayout(ram.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("Monitors");
        panelMonitor.setBorder(title);
        panelMonitor.setLayout(new GridLayout(monitors.length, 1, 10, 10));

        title = BorderFactory.createTitledBorder("Miscellanea");
        panelMiscell.setBorder(title);
        panelMiscell.setLayout(new GridLayout(miscellanea.length, 1, 10, 10));

        ButtonGroup bgMicros = new ButtonGroup();
        for (int i = 0; i < micros.length; i++) {
            JRadioButton jb = new JRadioButton(micros[i][0]);
            bgMicros.add(jb);
            panelMicro.add(jb);
        }
        ButtonGroup bgRam = new ButtonGroup();
        for (int i = 0; i < ram.length; i++) {
            JRadioButton jb = new JRadioButton(ram[i][0]);
            bgRam.add(jb);
            panelRam.add(jb);
        }
        ButtonGroup bgMonitor = new ButtonGroup();
        for (int i = 0; i < monitors.length; i++) {
            JRadioButton jb = new JRadioButton(monitors[i][0]);
            bgMonitor.add(jb);
            panelMonitor.add(jb);
        }
        for (int i = 0; i < miscellanea.length; i++) {
            JCheckBox jb = new JCheckBox(miscellanea[i][0]);
            panelMiscell.add(jb);
        }

        preview.addActionListener(e -> {
            factura = crearFactura();
            previewFactura.setText(factura);
        });
        imprimirPDF.addActionListener(l -> {
            try {
                factura = crearFactura();
                createPDF(factura);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public String crearFactura() {
        String factura = "";
        int precio, total = 0;
        //Panel de micros
        for (int i = 0; i < panelMicro.getComponentCount(); i++) {
            JRadioButton rb = (JRadioButton) panelMicro.getComponent(i);
            if (rb.isSelected()) {
                precio = Integer.parseInt(micros[i][1]);
                total += precio;
                factura += rb.getText() + "\t\t\t PRECIO: " + precio + "\n";

            }
        }
        //Panel de RAM
        for (int i = 0; i < panelRam.getComponentCount(); i++) {
            JRadioButton rb = (JRadioButton) panelRam.getComponent(i);
            if (rb.isSelected()) {
                precio = Integer.parseInt(ram[i][1]);
                total += precio;
                factura += rb.getText() + "\t\t\t PRECIO: " + precio + "\n";

            }
        }
        //Panel de Monitor
        for (int i = 0; i < panelMonitor.getComponentCount(); i++) {
            JRadioButton rb = (JRadioButton) panelMonitor.getComponent(i);
            if (rb.isSelected()) {
                precio = Integer.parseInt(monitors[i][1]);
                total += precio;
                factura += rb.getText() + "\t\t\t PRECIO: " + precio + "\n";

            }
        }

        //Panel de Miscellanea
        for (int i = 0; i < panelMiscell.getComponentCount(); i++) {
            JCheckBox rb = (JCheckBox) panelMiscell.getComponent(i);
            if (rb.isSelected()) {
                precio = Integer.parseInt(miscellanea[i][1]);
                total += precio;
                factura += rb.getText() + "\t\t\t PRECIO: " + precio + "\n";

            }
        }

        return factura + "\t\t TOTAL: \t" + total;
    }

        public void createPDF(String factura) throws FileNotFoundException {
        try {

            //esta parte es fija, no se cambia
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72) {};
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
