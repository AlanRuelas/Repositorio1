package mx.com.gm.sga.cliente.cascada;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Persona persona1 = new Persona("Hugo", "Sanchez", "hsanchez@mail.com", "72882842");
        Usuario usuario1 = new Usuario("hsanchez", "123", persona1);
        
        tx.begin();
        em.persist(usuario1);
        tx.commit();
        
        log.debug("Objeto usuario persistido: " + usuario1);
        log.debug("Objeto persona persistido: " + persona1);
        
        em.close();
    }
}
