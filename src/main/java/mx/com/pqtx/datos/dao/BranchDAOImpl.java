package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.dominio.BranchEO;
import mx.com.pqtx.mapper.BranchMapper;

@Stateless
public class BranchDAOImpl implements BranchDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<BranchDTO> findAllBranches() {
        List<BranchEO> branches = em.createNamedQuery("BranchEO.findAll").getResultList();
        return branches.stream().map(BranchMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public BranchDTO findBranchByName(BranchDTO branchDTO) {
        Query query = em.createNamedQuery("BranchEO.findByName");
        query.setParameter("name", branchDTO.getName());
        BranchEO branchEO = (BranchEO) query.getSingleResult();
        return BranchMapper.INSTANCE.toDTO(branchEO);
    }

    @Override
    public void insertBranch(BranchDTO branchDTO) {
        BranchEO branchEO = BranchMapper.INSTANCE.toEntity(branchDTO);
        em.persist(branchEO);
    }

    @Override
    public void updateBranch(BranchDTO branchDTO) {
        BranchEO branchEO = BranchMapper.INSTANCE.toEntity(branchDTO);
        em.merge(branchEO);
    }

    @Override
    public void deleteBranch(BranchDTO branchDTO) {
        BranchEO branchEO = em.find(BranchEO.class, branchDTO.getName());
        em.remove(branchEO);
    }
    
}
