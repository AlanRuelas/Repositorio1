package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.AddrDTO;
import mx.com.pqtx.dominio.AddrEO;
import mx.com.pqtx.mapper.AddrMapper;

@Stateless
public class AddrDAOImpl implements AddrDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<AddrDTO> findAllAddrs() {
        List<AddrEO> addrs = em.createNamedQuery("AddrEO.findAll").getResultList();
        return addrs.stream().map(AddrMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public AddrDTO findAddrById(AddrDTO addrDTO) {
        Query query = em.createNamedQuery("AddrEO.findById");
        query.setParameter("id", addrDTO.getId());
        AddrEO addrEO = (AddrEO) query.getSingleResult();
        return AddrMapper.INSTANCE.toDTO(addrEO);
    }

    @Override
    public AddrDTO findAddrByLocation(AddrDTO addrDTO) {
        Query query = em.createNamedQuery("AddrEO.findByLocation");
        query.setParameter("location", addrDTO.getLocation());
        AddrEO addrEO = (AddrEO) query.getSingleResult();
        return AddrMapper.INSTANCE.toDTO(addrEO);    
    }

    @Override
    public AddrDTO findAddrByType(AddrDTO addrDTO) {
        Query query = em.createNamedQuery("AddrEO.findByType");
        query.setParameter("type", addrDTO.getType());
        AddrEO addrEO = (AddrEO) query.getSingleResult();
        return AddrMapper.INSTANCE.toDTO(addrEO);
    }

    @Override
    public void insertAddr(AddrDTO addrDTO) {
        AddrEO addrEO = AddrMapper.INSTANCE.toEntity(addrDTO);
        em.persist(addrEO);
    }

    @Override
    public void updateAddr(AddrDTO addrDTO) {
        AddrEO addrEO = AddrMapper.INSTANCE.toEntity(addrDTO);
        em.merge(addrEO);
    }

    @Override
    public void deleteAddr(AddrDTO addrDTO) {
        AddrEO addrEO = em.find(AddrEO.class, addrDTO.getId());
        em.remove(addrEO);
    }
    
}
