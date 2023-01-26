package mx.com.gm.sga.cliente.criteria;

import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;


public class PruebaApiCriteria {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //Query utilizando el API de Criteria
        //1 Consulta de todas las personas
        
        //Paso 1. El objeto EntityManager crea instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        //Paso 2. Se crea una objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //Paso 3. Creamos el objeto raiz del query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //Paso 4. Seleccionamos los necesario del from
        criteriaQuery.select(fromPersona);
        
        //Paso 5. Creamos el query typedsafe
        query = em.createQuery(criteriaQuery);
        
        //Paso 6. Ejecutamos la consulta
        personas = query.getResultList();
        
        //mostrarPersonas(personas);

        //2-a Consulta de la persona con id = 1
        //jpql = "Select p from Persona p where idPersona = 1
        log.debug("\n2-a Consulta de la persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"),1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona persona : personas){
            log.debug(persona);
        }
    }
}
