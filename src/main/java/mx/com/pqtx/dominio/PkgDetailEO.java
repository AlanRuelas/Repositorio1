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
@Table(name = "pkgs_details")
@NamedQueries({ 
    @NamedQuery(name = "PkgDetailEO.findAll", query = "SELECT p FROM PkgDetailEO p"),
    @NamedQuery(name = "PkgDetailEO.findByGuiaAndPkg", 
            query = "SELECT p FROM PkgDetailEO p WHERE p.guia = :guia AND p.pkg = :pkg")})
public class PkgDetailEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @JoinColumn(name = "guia_num", referencedColumnName = "guia_num")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private int guia;
    
    @Id
    @JoinColumn(name = "pkg", referencedColumnName = "type")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private String pkg;
    
    @Basic (optional = false)
    @Column(name = "cost" ) 
    private String cost;
     

    public PkgDetailEO() {
    }

    public int getGuia() {
        return guia;
    }

    public void setGuia(int guia) {
        this.guia = guia;
    }
    
    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BranchPkgCostsEO{" + "guia=" + guia + ", pkg=" + pkg + ", cost=" + cost + '}';
    }
    
}
