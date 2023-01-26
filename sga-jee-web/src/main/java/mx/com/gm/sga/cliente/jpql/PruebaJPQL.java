/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author practidesarrollo
 */
public class PruebaJPQL {
    static Logger log  = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        // 1 Consulta de todos los objetos de tipo persona
        log.debug("\n1. Consulta de todas las Personas: ");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        // 2 Consulta de la persona con id 1
        log.debug("\n2. Consulta de la Personas con id = 1: ");
        jpql = "select p from Persona p where p.idPersona = 1";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        //log.debug(persona);
        
        // 3 Consulta de la persona con nombre karla
        log.debug("\n3. Consulta de la Personas con nombre Karla: ");
        jpql = "select p from Persona p where p.nombre = 'Karla'";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        // 4 Consulta de datos individuales, se crea un arreglo (tupla) de tipo object de 3 columnas
        log.debug("\n4. Consulta de datos individuales, se crea un arreglo (tupla) de tipo object de 3 columnas");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //log.debug("nombre: " + nombre +", apellido: " + apellido + ", email: " + email);
        }
        
        // 5. Obtiene el objeto persona y el id, se crea el arreglo de tipo Object con 2 columnas
        log.debug("\n5. Obtiene el objeto persona y el id, se crea el arreglo de tipo Object con 2 columnas");
        jpql = "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            log.debug("Objeto persona: " + persona);
            log.debug("Id de persona: " + idPersona);
        }
        
        // 6 Consulta de todas las personas
        log.debug("\n6. Consulta de todas las personas");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        // 7 Regresa el valor maximo y minimo del idPersonas (scaler result)
        log.debug("\n7. Regresa el valor maximo y minimo del idPersonas (scaler result)");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            int idMin = (int) tupla[0];
            int idMax = (int) tupla[1];
            Long count = (Long) tupla[2];
            //log.debug("idMin: " + idMin + ", idMax: " + idMax + ", count: " + count);
        }
        
        // 8 Cuenta los nombres de las personas que son distintos
        log.debug("\n8. Cuenta los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        //log.debug("Numero de personas con nombre distinto: " + contador);
        
        // 9 Concatena y convierte a mayusculas el nombre y apellido
        log.debug("\n9 Concatena y convierte a mayusculas el nombre y apellido");
        jpql = "select CONCAT(p.nombre, ' ', p.apellido) as nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for(String nombreCompleto : nombres){
            //log.debug(nombreCompleto);
        }
        
        // 10 Obtiene el objeto Persona con id igual al parametro proporcionado
        log.debug("\n10. Obtiene el objeto Persona con id igual al parametro proporcionado");
        int idPersona = 5;
        jpql = "select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        //log.debug(persona);
        
        // 11 Obtiene las personas que contengan una letra a en el nombre, sin importar si es mayuscula o minuscula
        log.debug("\n11. Obtiene las personas que contengan una letra a en el nombre, sin importar si es mayuscula o minuscula");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametroString = "%a%"; //es el caracter que utiliza la sentencia like
        q = em.createQuery(jpql);
        q.setParameter("parametro", parametroString);
        personas = q.getResultList();
        //mostrarPersonas(personas);
        
        //12 Uso de between 
        log.debug("\n12 Uso de between");
        jpql = "select p from Persona p where p.idPersona between 1 and 2";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //13 Uso de ordenamiento
        log.debug("\n13 Uso de ordenamiento");
        jpql = "select p from Persona p where p.idPersona > 1 order by p.nombre desc, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //14 Uso de subquery
        log.debug("\n14 Uso de subquery");
        jpql = "select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //15 Uso de join con lazy loading
        log.debug("\n15 Uso de join con lazy loading");
        jpql = "select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        //mostrarUsuarios(usuarios);
        
        //16 Uso de left join con eager loading
        log.debug("\n16 Uso de left join con eager loading");
        jpql = "select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona persona : personas){
            log.debug(persona);
        }
    }

    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for(Usuario usuario : usuarios){
            log.debug(usuario);
        }
    }
}
