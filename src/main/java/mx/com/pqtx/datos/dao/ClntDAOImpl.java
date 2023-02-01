package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.ClntDTO;
import mx.com.pqtx.dominio.ClntEO;
import mx.com.pqtx.mapper.ClntMapper;

@Stateless
public class ClntDAOImpl implements ClntDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<ClntDTO> findAllClnts() {
        List<ClntEO> clnts = em.createNamedQuery("ClntEO.findAll").getResultList();
        return clnts.stream().map(ClntMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ClntDTO findClntById(ClntDTO clntDTO) {
        Query query = em.createNamedQuery("ClntEO.findById");
        query.setParameter("id", clntDTO.getId());
        ClntEO clntEO = (ClntEO) query.getSingleResult();
        return ClntMapper.INSTANCE.toDTO(clntEO);
    }

    @Override
    public List<ClntDTO> findClntsByName(ClntDTO clntDTO) {
        Query query = em.createNamedQuery("ClntEO.findByName");
        query.setParameter("name", clntDTO.getName());
        List<ClntEO> clnts = query.getResultList();
        return clnts.stream().map(ClntMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClntDTO> findClntsByLastName(ClntDTO clntDTO) {
        Query query = em.createNamedQuery("ClntEO.findByLastName");
        query.setParameter("lastName", clntDTO.getLastName());
        List<ClntEO> clnts = query.getResultList();
        return clnts.stream().map(ClntMapper.INSTANCE::toDTO).collect(Collectors.toList());    
    }

    @Override
    public ClntDTO findClntByPhone(ClntDTO clntDTO) {
        Query query = em.createNamedQuery("ClntEO.findByPhone");
        query.setParameter("phone", clntDTO.getPhone());
        ClntEO clntEO = (ClntEO) query.getSingleResult();
        return ClntMapper.INSTANCE.toDTO(clntEO);
    }

    @Override
    public void insertClnt(ClntDTO clntDTO) {
        ClntEO clntEO = ClntMapper.INSTANCE.toEntity(clntDTO);
        em.persist(clntEO);
    }

    @Override
    public void updateClnt(ClntDTO clntDTO) {
        ClntEO clntEO = ClntMapper.INSTANCE.toEntity(clntDTO);
        em.merge(clntEO);
    }

    @Override
    public void deleteClnt(ClntDTO clntDTO) {
        ClntEO clntEO = em.find(ClntEO.class, clntDTO.getId());
        em.remove(clntEO);
    }
    
}
