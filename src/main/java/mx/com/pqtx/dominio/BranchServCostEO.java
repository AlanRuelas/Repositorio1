package mx.com.pqtx.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "branches_servs_costs")
@NamedQueries({ 
    @NamedQuery(name = "BranchServCostEO.findAll", query = "SELECT b FROM BranchServCostEO b"),
    @NamedQuery(name = "BranchServCostEO.findByBranch", 
            query = "SELECT b FROM BranchServCostEO b WHERE b.branch = :branch"),
    @NamedQuery(name = "BranchServCostEO.findByBranchAndServ", 
            query = "SELECT b FROM BranchServCostEO b WHERE b.branch = :branch AND b.serv = :serv")})
public class BranchServCostEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    private String branch;
    
    @Id
    private String serv;
    
    @Basic (optional = false)
    @Column(name = "cost" ) 
    private float cost;
     

    public BranchServCostEO() {
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getServ() {
        return serv;
    }

    public void setServ(String serv) {
        this.serv = serv;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BranchServCostEO{" + "branch=" + branch + ", serv=" + serv + ", cost=" + cost + '}';
    }

    
    
}

