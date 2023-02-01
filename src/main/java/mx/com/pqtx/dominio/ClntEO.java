package mx.com.pqtx.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clnts")
@NamedQueries({
    @NamedQuery(name = "ClntEO.findAll", query = "SELECT c FROM ClntEO c")
    , @NamedQuery(name = "ClntEO.findById", query = "SELECT c FROM ClntEO c WHERE c.id = :id")
    , @NamedQuery(name = "ClntEO.findByName", query = "SELECT c FROM ClntEO c WHERE c.name = :name")
    , @NamedQuery(name = "ClntEO.findByLastName", query = "SELECT c FROM ClntEO c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "ClntEO.findByPhone", query = "SELECT c FROM ClntEO c WHERE c.phone = :phone")})
public class ClntEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 45)
    private String name;
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;
    private Integer phone;

    public ClntEO() {
    }

    public ClntEO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
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
        if (!(object instanceof ClntEO)) {
            return false;
        }
        ClntEO other = (ClntEO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClntEO{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + '}';
    }

    
    
}
