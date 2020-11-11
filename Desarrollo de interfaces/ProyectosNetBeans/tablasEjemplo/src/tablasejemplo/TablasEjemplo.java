/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablasejemplo;

import frameTabla.frameTabla;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevmar
 */
public class TablasEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here // TODO code application logic here
        frameTabla f = null;
        try {
            f = new frameTabla();
        } catch (Exception ex) {
            Logger.getLogger(TablasEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.setVisible(true);
    }
    
}
