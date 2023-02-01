package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.BranchDTO;


public interface BranchDAO {
    public List<BranchDTO> findAllBranches();
    
    public BranchDTO findBranchByName(BranchDTO branchDTO);
    
    public void insertBranch(BranchDTO branchDTO);
    
    public void updateBranch(BranchDTO branchDTO);
    
    public void deleteBranch(BranchDTO branchDTO);
}
