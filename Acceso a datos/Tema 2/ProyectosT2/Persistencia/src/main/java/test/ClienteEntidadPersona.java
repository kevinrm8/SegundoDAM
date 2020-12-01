package test;

import org.apache.logging.log4j.*;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;

public class ClienteEntidadPersona {
    static Logger log = LogManager.getFormatterLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //iniciamos la transicción
        
        tx.begin();
        Persona persona1 = new Persona("Kevin","Rosales","miCorreo",28);
        log.debug("Objeto a persistir "+persona1);
        //persisimos objeto
        em.persist(persona1);
        //terminamos la transicción
        tx.commit();
        log.debug("Objeto persistido "+persona1);
        em.clear();
    }
}
