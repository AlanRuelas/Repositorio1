package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.datos.dto.BranchServCostDTO;
import mx.com.pqtx.dominio.BranchServCostEO;
import mx.com.pqtx.mapper.BranchServCostMapper;
 
@Stateless
public class BranchServCostDAOImpl implements BranchServCostDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<BranchServCostDTO> findAllBranchServCosts() {
        List<BranchServCostEO> costs = em.createNamedQuery("BranchServCostEO.findAll").getResultList();
        return costs.stream().map(BranchServCostMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public BranchServCostDTO findCostByBranchAndServ(BranchServCostDTO branchServCostDTO) {
        Query query = em.createNamedQuery("BranchServCostEO.findByBranchAndServ");
        query.setParameter("branch", branchServCostDTO.getBranch());
        query.setParameter("serv", branchServCostDTO.getServ());
        BranchServCostEO cost = (BranchServCostEO) query.getSingleResult();
        return BranchServCostMapper.INSTANCE.toDTO(cost);
    }
    
    @Override
    public List<BranchServCostDTO> findCostsByBranch(BranchDTO branchDTO){
        Query query = em.createNamedQuery("BranchServCostEO.findByBranch");
        query.setParameter("branch", branchDTO.getName());
        List<BranchServCostEO> costs = query.getResultList();
        return costs.stream().map(BranchServCostMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }


    @Override
    public void insertBranchServCost(BranchServCostDTO branchServCostDTO) {
        BranchServCostEO branchServCostEO = BranchServCostMapper.INSTANCE.toEntity(branchServCostDTO);
        em.persist(branchServCostEO);
    }

    @Override
    public void updateBranchServCost(BranchServCostDTO branchServCostDTO) {
        BranchServCostEO branchServCostEO = BranchServCostMapper.INSTANCE.toEntity(branchServCostDTO);
        em.merge(branchServCostEO);
    }

    @Override
    public void deleteBranchServCost(BranchServCostDTO branchServCostDTO) {
        BranchServCostEO branchServCostEO = em.find(BranchServCostEO.class, branchServCostDTO.getBranch());
        em.remove(branchServCostEO);
    }
    
}
