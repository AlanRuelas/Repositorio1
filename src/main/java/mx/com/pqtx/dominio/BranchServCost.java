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
@Table(name = "branches_servs_costs")
@NamedQueries({ 
    @NamedQuery(name = "BranchServCostEO.findAll", query = "SELECT b FROM BranchServCostEO b"),
    @NamedQuery(name = "BranchServCostEO.findByBranchAndPkg", 
            query = "SELECT b FROM BranchServCostEO b WHERE b.branch = :branch AND b.serv = :serv")})
public class BranchServCost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @JoinColumn(name = "branch", referencedColumnName = "name")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private String branch;
    
    @Id
    @JoinColumn(name = "serv", referencedColumnName = "type")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private String serv;
    
    @Basic (optional = false)
    @Column(name = "cost" ) 
    private String cost;
     

    public BranchServCost() {
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BranchServCost{" + "branch=" + branch + ", serv=" + serv + ", cost=" + cost + '}';
    }

    
    
}
