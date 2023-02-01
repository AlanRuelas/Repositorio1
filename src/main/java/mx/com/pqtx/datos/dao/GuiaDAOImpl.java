package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.GuiaDTO;
import mx.com.pqtx.dominio.GuiaEO;
import mx.com.pqtx.mapper.GuiaMapper;

@Stateless
public class GuiaDAOImpl implements GuiaDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<GuiaDTO> findAllGuias() {
        List<GuiaEO> guias = em.createNamedQuery("GuiaEO.findAll").getResultList();
        return guias.stream().map(GuiaMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public GuiaDTO findGuiaByNum(GuiaDTO guiaDTO) {
        Query query = em.createNamedQuery("GuiaEO.findByGuiaNum");
        query.setParameter("guiaNum", guiaDTO.getGuiaNum());
        GuiaEO guiaEO = (GuiaEO) query.getSingleResult();
        return GuiaMapper.INSTANCE.toDTO(guiaEO);
    }

    @Override
    public void insertGuia(GuiaDTO guiaDTO) {
        GuiaEO guiaEO = GuiaMapper.INSTANCE.toEntity(guiaDTO);
        em.persist(guiaEO);
    }

    @Override
    public void updateGuia(GuiaDTO guiaDTO) {
        GuiaEO guiaEO = GuiaMapper.INSTANCE.toEntity(guiaDTO);
        em.merge(guiaEO);
    }

    @Override
    public void deleteGuia(GuiaDTO guiaDTO) {
        GuiaEO guiaEO = em.find(GuiaEO.class, guiaDTO.getGuiaNum());
        em.remove(guiaEO);
    }
    
}
