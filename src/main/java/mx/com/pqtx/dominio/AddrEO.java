package mx.com.pqtx.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "addrs")
@NamedQueries({
    @NamedQuery(name = "AddrEO.findAll", query = "SELECT a FROM AddrEO a")
    , @NamedQuery(name = "AddrEO.findById", query = "SELECT a FROM AddrEO a WHERE a.id = :id")
    , @NamedQuery(name = "AddrEO.findByLocation", query = "SELECT a FROM AddrEO a WHERE a.location = :location")
    , @NamedQuery(name = "AddrEO.findByType", query = "SELECT a FROM AddrEO a WHERE a.type = :type")})
public class AddrEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 45)
    private String location;
    @Size(max = 45)
    private String type;
    private Integer clienteId;

    public AddrEO() {
    }

    public AddrEO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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
        if (!(object instanceof AddrEO)) {
            return false;
        }
        AddrEO other = (AddrEO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AddrEO{" + "id=" + id + ", location=" + location + ", type=" + type + '}';
    }

    
    
}
