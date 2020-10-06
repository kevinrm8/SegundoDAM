/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.listShow;
import model.show;
//import view.frame;

public class Series {
   public static void main(String[] args){
       
       /*
       frame f = new frame();
       f.setVisible(true);
       */
       
       //create an instance of one serie:
       show sh = new show("Breaking Bad","Vicent Guilligan",5,"Drama",5);
       
       show sh1 = new show("JGame of thrones","David Benioff",6,"1",6);

       listShow ls = new listShow();

       ls.setShow(sh);
       ls.setShow(sh1);

       access.saveLS(ls);
       System.out.println("save series");
        
    
       
        show sh2 = new show();
        sh2 = ls.getShow(1);
        System.out.println(sh2.getTitle());
  
       
   }
}
