package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.PkgDetailDTO;
import mx.com.pqtx.dominio.PkgDetailEO;
import mx.com.pqtx.mapper.PkgDetailMapper;

@Stateless
public class PkgDetailDAOImpl implements PkgDetailDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<PkgDetailDTO> findAllPkgDetails() {
        List<PkgDetailEO> details = em.createNamedQuery("PkgDetailEO.findAll").getResultList();
        return details.stream().map(PkgDetailMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public PkgDetailDTO findDetailByGuiaAndPkg(PkgDetailDTO pkgDetailDTO) {
        Query query = em.createNamedQuery("PkgDetailEO.findByGuiaAndPkg");
        query.setParameter("guia", pkgDetailDTO.getGuia());
        query.setParameter("pkg", pkgDetailDTO.getPkg());
        PkgDetailEO detail = (PkgDetailEO) query.getSingleResult();
        return PkgDetailMapper.INSTANCE.toDTO(detail);
    }

    @Override
    public void insertPkgDetail(PkgDetailDTO pkgDetailDTO) {
        PkgDetailEO pkgDetailEO = PkgDetailMapper.INSTANCE.toEntity(pkgDetailDTO);
        em.persist(pkgDetailEO);
    }

    @Override
    public void updatePkgDetail(PkgDetailDTO pkgDetailDTO) {
        PkgDetailEO pkgDetailEO = PkgDetailMapper.INSTANCE.toEntity(pkgDetailDTO);
        em.merge(pkgDetailEO);
    }

    @Override
    public void deletePkgDetail(PkgDetailDTO pkgDetailDTO) {
        PkgDetailEO pkgDetailEO = em.find(PkgDetailEO.class, pkgDetailDTO.getGuia());
        em.remove(pkgDetailEO);
    }
    
}
