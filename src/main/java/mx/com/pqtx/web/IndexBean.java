
package mx.com.pqtx.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.pqtx.core.Enlister;
import mx.com.pqtx.core.Validator;
import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.datos.dto.ClntDTO;
import mx.com.pqtx.datos.dto.ServDTO;

@Named("indexBean")
@ViewScoped
public class IndexBean implements Serializable{
    @Inject
    private Enlister enlister;
    
    @Inject
    private Validator validator;
    
    List<BranchDTO> branches;
    private BranchDTO selectedBranch;
    
    List<ServDTO> services;
    private ServDTO selectedService;
    
    private ClntDTO client;
    

    public IndexBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        this.branches = enlister.enlistBranches();
        this.client = new ClntDTO();
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

    public ClntDTO getClient() {
        return client;
    }

    public void setClient(ClntDTO client) {
        this.client = client;
    }
    

    public void onBranchChange(){
        System.out.println("selected branch" + this.selectedBranch);

        if(selectedBranch != null){
            this.services = enlister.enlistServicesByBranch(selectedBranch);
        }
    }
    
    public void restart(){
        this.selectedBranch = new BranchDTO();
        this.client = new ClntDTO();
    }
    
    public void addClient(){
        System.out.println("Persona agregada");
        validator.addClient(client);
        restart();
    }
}
