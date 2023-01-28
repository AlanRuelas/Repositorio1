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
@Table(name = "routes")
@NamedQueries({
    @NamedQuery(name = "RouteEO.findAll", query = "SELECT r FROM RouteEO r")
    , @NamedQuery(name = "RouteEO.findById", query = "SELECT r FROM RouteEO r WHERE r.id = :id")
    , @NamedQuery(name = "RouteEO.findByTime", query = "SELECT r FROM RouteEO r WHERE r.time = :time")})
public class RouteEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(min = 1, max = 45)
    private String id;
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    private String time;
    @JoinColumn(name = "orgn_branch", referencedColumnName = "name")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BranchEO orgnBranch;
    @JoinColumn(name = "dest_branch", referencedColumnName = "name")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BranchEO destBranch;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route", fetch = FetchType.EAGER)
    private List<GuiaEO> guias;

    public RouteEO() {
    }

    public RouteEO(String id) {
        this.id = id;
    }

    public RouteEO(String id, String time) {
        this.id = id;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BranchEO getOrgnBranch() {
        return orgnBranch;
    }

    public void setOrgnBranch(BranchEO orgnBranch) {
        this.orgnBranch = orgnBranch;
    }

    public BranchEO getDestBranch() {
        return destBranch;
    }

    public void setDestBranch(BranchEO destBranch) {
        this.destBranch = destBranch;
    }

    public List<GuiaEO> getGuias() {
        return guias;
    }

    public void setGuias(List<GuiaEO> guias) {
        this.guias = guias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RouteEO)) {
            return false;
        }
        RouteEO other = (RouteEO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.pqtx.dominio.RouteEO[ id=" + id + " ]";
    }
    
}
