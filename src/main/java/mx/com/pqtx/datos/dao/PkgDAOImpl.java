package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.PkgDTO;
import mx.com.pqtx.dominio.PkgEO;
import mx.com.pqtx.mapper.PkgMapper;


@Stateless
public class PkgDAOImpl implements PkgDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<PkgDTO> findAllPkgs() {
        List<PkgEO> pkgs = em.createNamedQuery("PkgEO.findAll").getResultList();
        return pkgs.stream().map(PkgMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public PkgDTO findPkgByType(PkgDTO pkgDTO) {
        Query query = em.createNamedQuery("PkgEO.findByType");
        query.setParameter("type", pkgDTO.getType());
        PkgEO pkgEO = (PkgEO) query.getSingleResult();
        return PkgMapper.INSTANCE.toDTO(pkgEO);
    }

    @Override
    public PkgDTO findPkgByDescription(PkgDTO pkgDTO) {
        Query query = em.createNamedQuery("PkgEO.findByDescription");
        query.setParameter("description", pkgDTO.getDescription());
        PkgEO pkgEO = (PkgEO) query.getSingleResult();
        return PkgMapper.INSTANCE.toDTO(pkgEO);
    }

    @Override
    public void insertPkg(PkgDTO pkgDTO) {
        PkgEO pkgEO = PkgMapper.INSTANCE.toEntity(pkgDTO);
        em.persist(pkgEO);
    }

    @Override
    public void updatePkg(PkgDTO pkgDTO) {
        PkgEO pkgEO = PkgMapper.INSTANCE.toEntity(pkgDTO);
        em.merge(pkgEO);
    }

    @Override
    public void deletePkg(PkgDTO pkgDTO) {
        PkgEO pkgEO = em.find(PkgEO.class, pkgDTO.getType());
        em.remove(pkgEO);
    }
}
