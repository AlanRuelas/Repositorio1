package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EliminarObjetoJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Inicia la transaccion
        //Paso 1 Inicia transaccion
        tx.begin();

        //Paso 2 Ejecuta SQL de tipo SELECT
        Persona persona1 = em.find(Persona.class, 4);
        
        //Paso 3 Termina transaccion 1
        tx.commit();
        
        //Objeto en estado detached
        log.debug("Objeto recuperado: " + persona1);
        
        //Paso 4 Inicia transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //Paso 5 Ejecuta SQL de tipo DELETE
        em.remove(em.merge(persona1));
        
        //Paso 6 Termina transaccion 2
        tx2.commit();
        
        //Objeto en estado detached ya eliminado
        log.debug("Objeto eliminado: " + persona1);
        
        //Cerramos el enity manager
        em.close();
    }
}
