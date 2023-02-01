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
@Table(name = "servs_details")
@NamedQueries({ 
    @NamedQuery(name = "ServDetailEO.findAll", query = "SELECT s FROM ServDetailEO s"),
    @NamedQuery(name = "ServDetailEO.findByGuiaAndServ", 
            query = "SELECT s FROM ServDetailEO s WHERE s.guia = :guia AND s.serv = :serv")})
public class ServDetailEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @Column(name = "guia_num")
    private Integer guia;
    
    @Id
    private String serv;
    
    @Basic (optional = false) 
    private float cost;
     

    public ServDetailEO() {
    }

    public Integer getGuia() {
        return guia;
    }

    public void setGuia(Integer guia) {
        this.guia = guia;
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
        return "BranchPkgCostsEO{" + "guia=" + guia + ", serv=" + serv + ", cost=" + cost + '}';
    }
    
}
