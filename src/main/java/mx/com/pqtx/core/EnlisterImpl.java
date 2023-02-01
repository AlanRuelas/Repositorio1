package mx.com.pqtx.core;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.pqtx.datos.dao.BranchDAO;
import mx.com.pqtx.datos.dao.BranchServCostDAO;
import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.datos.dto.BranchServCostDTO;
import mx.com.pqtx.datos.dto.ServDTO;

@Stateless
public class EnlisterImpl implements Enlister{
    
    @Inject
    private BranchServCostDAO costExtractor;
    
    @Inject
    private BranchDAO branchExtractor;
    
    @Override
    public List<ServDTO> enlistServicesByBranch(BranchDTO branchDTO) {
        List<BranchServCostDTO> costs = costExtractor.findCostsByBranch(branchDTO);
        List<ServDTO> services = new ArrayList<>();
        for( BranchServCostDTO cost : costs){
            ServDTO serv = new ServDTO();
            serv.setType(cost.getServ()); 
            services.add(serv);
        }
        return services;
    }
    
    @Override
    public List<BranchDTO> enlistBranches(){
        return branchExtractor.findAllBranches();
    }
    
}
