package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.ServDetailDTO;
import mx.com.pqtx.dominio.ServDetailEO;
import mx.com.pqtx.mapper.ServDetailMapper;

@Stateless
public class ServDetailDAOImpl implements ServDetailDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<ServDetailDTO> findAllServDetails() {
        List<ServDetailEO> details = em.createNamedQuery("ServDetailEO.findAll").getResultList();
        return details.stream().map(ServDetailMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ServDetailDTO findDetailByGuiaAndServ(ServDetailDTO servDetailDTO) {
        Query query = em.createNamedQuery("ServDetailEO.findByGuiaAndServ");
        query.setParameter("guia", servDetailDTO.getGuia());
        query.setParameter("serv", servDetailDTO.getServ());
        ServDetailEO detail = (ServDetailEO) query.getSingleResult();
        return ServDetailMapper.INSTANCE.toDTO(detail);
    }

    @Override
    public void insertServDetail(ServDetailDTO servDetailDTO) {
        ServDetailEO servDetailEO = ServDetailMapper.INSTANCE.toEntity(servDetailDTO);
        em.persist(servDetailEO);
    }

    @Override
    public void updateServDetail(ServDetailDTO servDetailDTO) {
        ServDetailEO servDetailEO = ServDetailMapper.INSTANCE.toEntity(servDetailDTO);
        em.merge(servDetailEO);
    }

    @Override
    public void deleteServDetail(ServDetailDTO servDetailDTO) {
        ServDetailEO servDetailEO = em.find(ServDetailEO.class, servDetailDTO.getGuia());
        em.remove(servDetailEO);
    }
    
}
