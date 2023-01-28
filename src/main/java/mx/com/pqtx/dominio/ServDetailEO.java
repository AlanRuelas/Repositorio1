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
@Table(name = "servs_details")
@NamedQueries({ 
    @NamedQuery(name = "ServDetailEO.findAll", query = "SELECT s FROM ServDetailEO s"),
    @NamedQuery(name = "ServDetailEO.findByGuiaAndServ", 
            query = "SELECT s FROM ServDetailEO s WHERE s.guia = :guia AND p.pkg = :serv")})
public class ServDetailEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @JoinColumn(name = "guia_num", referencedColumnName = "guia_num")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private int guia;
    
    @Id
    @JoinColumn(name = "serv", referencedColumnName = "type")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private String serv;
    
    @Basic (optional = false)
    @Column(name = "cost" ) 
    private String cost;
     

    public ServDetailEO() {
    }

    public int getGuia() {
        return guia;
    }

    public void setGuia(int guia) {
        this.guia = guia;
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
        return "BranchPkgCostsEO{" + "guia=" + guia + ", serv=" + serv + ", cost=" + cost + '}';
    }
    
}
