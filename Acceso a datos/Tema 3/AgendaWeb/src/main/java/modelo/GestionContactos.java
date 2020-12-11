/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.apache.logging.log4j.*;
import javax.persistence.*;
import mx.com.gm.sga.domain.Contacto;

public class GestionContactos {
    static Logger log = LogManager.getFormatterLogger();

    public void altaContacto() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Iniciamos persistencia
        tx.begin();
        Contacto contacto1 = new Contacto("Kevin","kevin@email.com",81812812);
        log.debug(contacto1);
        em.persist(contacto1);
        tx.commit();
        em.clear();
        
    }

}
