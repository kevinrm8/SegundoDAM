/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.apache.logging.log4j.*;
import javax.persistence.*;
import mx.com.gm.sga.domain.Contacto;

public class GestionContactos {

    static Logger log = LogManager.getFormatterLogger();

    public void altaContacto(String nombre, String email, int telefono) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos persistencia
        tx.begin();
        Contacto contacto1 = new Contacto(nombre, email, telefono);
        log.debug(contacto1);
        em.persist(contacto1);
        tx.commit();
        em.clear();

    }

    public void eliminarContacto(int id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Contacto contacto = new Contacto();
        contacto = em.find(Contacto.class, id);

        em.remove(contacto);

        tx.commit();
        em.clear();

    }

    public List<Contacto> recuperarContactos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        String jpql = "SELECT c From Contacto c";
        Query qr = em.createQuery(jpql);
        List<Contacto> contacts = (List<Contacto>) qr.getResultList();

        tx.commit();
        em.clear();
        
        return contacts;
    }

    public List<Contacto> buscarContacto(String email) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String jpql = "SELECT c From Contacto c Where c.email='" + email + "'";
        Query qr = em.createQuery(jpql);
        List<Contacto> contacts = (List<Contacto>) qr.getResultList();

        tx.commit();
        em.clear();

        return contacts;
    }

    public Contacto buscarContacto2(String email) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String jpql = "SELECT c From Contacto c Where c.email='" + email + "'";
        Query qr = em.createQuery(jpql);
        Contacto contacto = (Contacto) qr.getSingleResult();

        tx.commit();
        em.clear();

        return contacto;
    }
}
