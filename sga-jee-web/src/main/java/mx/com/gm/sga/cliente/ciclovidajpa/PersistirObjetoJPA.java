package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;


public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        
        //Paso 1 Crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Alan", "Ruelas", "aruelas@mail.com", "6681604697");
        
        //Paso 2 Inicia transaccion
        tx.begin();
        
        //Paso 3 Ejecuta SQL
        em.persist(persona1);
        
        //Paso 4 commit/rollback
        tx.commit();
        
        //Objeto en estado de detached
        log.debug("Objeto persistido - estado detached:" + persona1);
        
        //Cerramos el enity manager
        em.close();
    }
}
