/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.access;
import model.listShow;
import model.show;

public class controller {

    private int position;
    private listShow ls;
    private access acc = new access();

    public controller() {

        position = 0;
        ls = new listShow();
        ls = acc.LoadLS();
    }

    public show first() {
        position = 0;
        return ls.getShow(position);
    }

    public show previous() {

        if (position > 0) {
            position--;
        }
        return ls.getShow(position);
    }

    public show next() {
        position++;
        if (position == ls.longitud()) {
            position--;
        }
        return ls.getShow(position);
    }

    public void nuevo(show s) {
        ls.setShow(s);
        position = ls.longitud() - 1;
        acc.saveLS(ls);
    }

    public show last() {
        position = ls.longitud() - 1;
        return ls.getShow(position);
    }
}
