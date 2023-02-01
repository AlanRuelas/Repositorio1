package mx.com.pqtx.core;

import java.util.List;
import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.datos.dto.ServDTO;

public interface Enlister {
    public List<ServDTO> enlistServicesByBranch(BranchDTO branchDTO);
    public List<BranchDTO> enlistBranches();
}
