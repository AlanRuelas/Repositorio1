package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.BranchPkgCostDTO;

public interface BranchPkgCostDAO {
    public List<BranchPkgCostDTO> findAllBranchPkgCosts();
    
    public BranchPkgCostDTO findCostByBranchAndPkg(BranchPkgCostDTO branchPkgCostDTO);
    
    public void insertBranchPkgCost(BranchPkgCostDTO branchPkgCostDTO);
    
    public void updateBranchPkgCost(BranchPkgCostDTO branchPkgCostDTO);
    
    public void deleteBranchPkgCost(BranchPkgCostDTO branchPkgCostDTO);
}
