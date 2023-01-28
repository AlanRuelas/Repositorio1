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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "branches")
@NamedQueries({
    @NamedQuery(name = "BranchEO.findAll", query = "SELECT b FROM BranchEO b")
    , @NamedQuery(name = "BranchEO.findByName", query = "SELECT b FROM BranchEO b WHERE b.name = :name")})
public class BranchEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(min = 1, max = 45)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgnBranch", fetch = FetchType.EAGER)
    private List<RouteEO> routeEOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destBranch", fetch = FetchType.EAGER)
    private List<RouteEO> routeEOList1;

    public BranchEO() {
    }

    public BranchEO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RouteEO> getRouteEOList() {
        return routeEOList;
    }

    public void setRouteEOList(List<RouteEO> routeEOList) {
        this.routeEOList = routeEOList;
    }

    public List<RouteEO> getRouteEOList1() {
        return routeEOList1;
    }

    public void setRouteEOList1(List<RouteEO> routeEOList1) {
        this.routeEOList1 = routeEOList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchEO)) {
            return false;
        }
        BranchEO other = (BranchEO) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BranchEO{" + "name=" + name + '}';
    }

    
    
}
