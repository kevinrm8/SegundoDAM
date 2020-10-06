/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;

public class access {

    private static File f = new File("Series.dat");

    public static void saveLS(listShow ls) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ls);
            oos.close();

        } catch (IOException ex) {
            System.out.println("Failed to open file");
        }
    }

    public static listShow LoadLS() {
        listShow ls = new listShow();
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ls = (listShow) ois.readObject();
            ois.close();
        } catch (IOException io) {
            System.out.println("Failed to open file");
        } finally {
            return ls;

        }

    }
}
