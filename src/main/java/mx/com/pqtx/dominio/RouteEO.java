/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pqtx.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    , @NamedQuery(name = "RouteEO.findByDaysOfTravel", query = "SELECT r FROM RouteEO r WHERE r.daysOfTravel = :daysOfTravel")})
public class RouteEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(min = 1, max = 45)
    private String id;
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "days_of_travel")
    private Integer daysOfTravel;
    @Column(name = "orgn_branch")
    private String orgnBranch;
    @Column(name = "dest_branch")
    private String destBranch;

    public RouteEO() {
    }

    public RouteEO(String id) {
        this.id = id;
    }

    public RouteEO(String id, Integer daysOfTravel) {
        this.id = id;
        this.daysOfTravel = daysOfTravel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDaysOfTravel() {
        return daysOfTravel;
    }

    public void setDaysOfTravel(Integer daysOfTravel) {
        this.daysOfTravel = daysOfTravel;
    }

    public String getOrgnBranch() {
        return orgnBranch;
    }

    public void setOrgnBranch(String orgnBranch) {
        this.orgnBranch = orgnBranch;
    }

    public String getDestBranch() {
        return destBranch;
    }

    public void setDestBranch(String destBranch) {
        this.destBranch = destBranch;
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
