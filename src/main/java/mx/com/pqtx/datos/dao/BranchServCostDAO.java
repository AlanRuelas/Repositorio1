package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.datos.dto.BranchServCostDTO;

public interface BranchServCostDAO {
    public List<BranchServCostDTO> findAllBranchServCosts();
    
    public BranchServCostDTO findCostByBranchAndServ(BranchServCostDTO branchServCostDTO);
    
    public List<BranchServCostDTO> findCostsByBranch(BranchDTO branchDTO);
    
    public void insertBranchServCost(BranchServCostDTO branchServCostDTO);
    
    public void updateBranchServCost(BranchServCostDTO branchServCostDTO);
    
    public void deleteBranchServCost(BranchServCostDTO branchServCostDTO);
}
