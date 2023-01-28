/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pqtx.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author practidesarrollo
 */
@Entity
@Table(name = "servs")
@NamedQueries({
    @NamedQuery(name = "ServEO.findAll", query = "SELECT s FROM ServEO s")
    , @NamedQuery(name = "ServEO.findByType", query = "SELECT s FROM ServEO s WHERE s.type = :type")
    , @NamedQuery(name = "ServEO.findByDescription", query = "SELECT s FROM ServEO s WHERE s.description = :description")})
public class ServEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(min = 1, max = 45)
    private String type;
    @Size(max = 45)
    private String description;

    public ServEO() {
    }

    public ServEO(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServEO)) {
            return false;
        }
        ServEO other = (ServEO) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.pqtx.dominio.ServEO[ type=" + type + " ]";
    }
    
}
