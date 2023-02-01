package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.ServDTO;
import mx.com.pqtx.dominio.ServEO;
import mx.com.pqtx.mapper.ServMapper;

@Stateless
public class ServDAOImpl implements ServDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<ServDTO> findAllServs() {
        List<ServEO> servs = em.createNamedQuery("ServEO.findAll").getResultList();
        return servs.stream().map(ServMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ServDTO findServByType(ServDTO servDTO) {
        Query query = em.createNamedQuery("ServEO.findByType");
        query.setParameter("type", servDTO.getType());
        ServEO servEO = (ServEO) query.getSingleResult();
        return ServMapper.INSTANCE.toDTO(servEO);
    }

    @Override
    public ServDTO findServByDescription(ServDTO servDTO) {
        Query query = em.createNamedQuery("ServEO.findByDescription");
        query.setParameter("description", servDTO.getDescription());
        ServEO servEO = (ServEO) query.getSingleResult();
        return ServMapper.INSTANCE.toDTO(servEO);
    }

    @Override
    public void insertServ(ServDTO servDTO) {
        ServEO servEO = ServMapper.INSTANCE.toEntity(servDTO);
        em.persist(servEO);
    }

    @Override
    public void updateServ(ServDTO servDTO) {
        ServEO servEO = ServMapper.INSTANCE.toEntity(servDTO);
        em.merge(servEO);
    }

    @Override
    public void deleteServ(ServDTO servDTO) {
        ServEO servEO = em.find(ServEO.class, servDTO.getType());
        em.remove(servEO);
    }
    
}
