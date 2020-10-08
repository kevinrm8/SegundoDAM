/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;
import java.util.*;

public class listShow implements Serializable{

    private ArrayList<show> seriesList;

    public listShow() {
        seriesList = new ArrayList<>();
    }

    public show getShow(int p) {
        return seriesList.get(p);
    }

    public void setShow(show s) {
        seriesList.add(s);
    }

    public int longitud() {
        return seriesList.size();
    }
}
