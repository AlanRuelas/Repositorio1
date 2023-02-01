package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.BranchPkgCostDTO;
import mx.com.pqtx.dominio.BranchPkgCostEO;
import mx.com.pqtx.mapper.BranchPkgCostMapper;

@Stateless
public class BranchPkgCostDAOImpl implements BranchPkgCostDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<BranchPkgCostDTO> findAllBranchPkgCosts() {
        List<BranchPkgCostEO> costs = em.createNamedQuery("BranchPkgCostEO.findAll").getResultList();
        return costs.stream().map(BranchPkgCostMapper.INSTANCE::toDTO).collect(Collectors.toList());

    }

    @Override
    public BranchPkgCostDTO findCostByBranchAndPkg(BranchPkgCostDTO branchPkgCostDTO) {
        Query query = em.createNamedQuery("BranchPkgCostEO.findByBranchAndPkg");
        query.setParameter("branch", branchPkgCostDTO.getBranch());
        query.setParameter("pkg", branchPkgCostDTO.getPkg());
        BranchPkgCostEO cost = (BranchPkgCostEO) query.getSingleResult();
        return BranchPkgCostMapper.INSTANCE.toDTO(cost);
    }

    @Override
    public void insertBranchPkgCost(BranchPkgCostDTO branchPkgCostDTO) {
        BranchPkgCostEO branchPkgCostEO = BranchPkgCostMapper.INSTANCE.toEntity(branchPkgCostDTO);
        em.persist(branchPkgCostEO);
    }

    @Override
    public void updateBranchPkgCost(BranchPkgCostDTO branchPkgCostDTO) {
        BranchPkgCostEO branchPkgCostEO = BranchPkgCostMapper.INSTANCE.toEntity(branchPkgCostDTO);
        em.merge(branchPkgCostEO);
    }

    @Override
    public void deleteBranchPkgCost(BranchPkgCostDTO branchPkgCostDTO) {
        BranchPkgCostEO branchPkgCostEO = em.find(BranchPkgCostEO.class, branchPkgCostDTO.getBranch());
        em.remove(branchPkgCostEO);
    }
    
}
