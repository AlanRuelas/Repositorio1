package mx.com.pqtx.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.pqtx.core.Enlister;
import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.datos.dto.ServDTO;

@Named("pkgBean")
@ViewScoped
public class PkgBean implements Serializable{
        
    @Inject
    private Enlister enlister;
    
    private List<BranchDTO> branches;
    private BranchDTO selectedBranch;
    
    private List<ServDTO> services;
    private ServDTO selectedService;
    

    public PkgBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        this.branches = enlister.enlistBranches();
    }

    public List<BranchDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDTO> branches) {
        this.branches = branches;
    }

    public BranchDTO getSelectedBranch() {
        return selectedBranch;
    }

    public void setSelectedBranch(BranchDTO selectedBranch) {
        this.selectedBranch = selectedBranch;
    }

    public List<ServDTO> getServices() {
        return services;
    }

    public void setServices(List<ServDTO> services) {
        this.services = services;
    }

    public ServDTO getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(ServDTO selectedService) {
        this.selectedService = selectedService;

    }

    public void onBranchChange(){
        System.out.println("selected branch" + this.selectedBranch);

        if(selectedBranch != null){
            this.services = enlister.enlistServicesByBranch(selectedBranch);
        }
    }
    
}
