/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pqtx.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author practidesarrollo
 */
@Entity
@Table(name = "branches_pkgs_costs")
@NamedQueries({ 
    @NamedQuery(name = "BranchPkgCostEO.findAll", query = "SELECT b FROM BranchPkgCostEO b"),
    @NamedQuery(name = "BranchPkgCostEO.findByBranchAndPkg", 
            query = "SELECT b FROM BranchPkgCostEO b WHERE b.branch = :branch AND b.pkg = :pkg")})
public class BranchPkgCostEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    private String branch;
    
    @Id
    private String pkg;
    
    @Basic (optional = false)
    @Column(name = "cost" ) 
    private float cost;
     

    public BranchPkgCostEO() {
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BranchPkgCostsEO{" + "branch=" + branch + ", pkg=" + pkg + ", cost=" + cost + '}';
    }
    
}
