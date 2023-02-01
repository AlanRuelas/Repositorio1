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
@Table(name = "pkgs_details")
@NamedQueries({ 
    @NamedQuery(name = "PkgDetailEO.findAll", query = "SELECT p FROM PkgDetailEO p"),
    @NamedQuery(name = "PkgDetailEO.findByGuiaAndPkg", 
            query = "SELECT p FROM PkgDetailEO p WHERE p.guia = :guia AND p.pkg = :pkg")})
public class PkgDetailEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @Column(name = "guia_num")
    private Integer guia;
    
    @Id
    private String pkg;
    
    @Basic (optional = false)
    private float cost;
     

    public PkgDetailEO() {
    }

    public Integer getGuia() {
        return guia;
    }

    public void setGuia(Integer guia) {
        this.guia = guia;
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
        return "BranchPkgCostsEO{" + "guia=" + guia + ", pkg=" + pkg + ", cost=" + cost + '}';
    }
    
}
