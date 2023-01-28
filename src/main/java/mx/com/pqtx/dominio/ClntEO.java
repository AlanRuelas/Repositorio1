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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author practidesarrollo
 */
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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addrs", referencedColumnName = "id")
    private AddrEO address;
    @OneToMany(mappedBy = "orgnClnt", fetch = FetchType.EAGER)
    private List<GuiaEO> guiasAsOrgn;
    @OneToMany(mappedBy = "destClnt", fetch = FetchType.EAGER)
    private List<GuiaEO> guiasAsDest;

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

    public AddrEO getAddress() {
        return address;
    }

    public void setAddress(AddrEO address) {
        this.address = address;
    }

    public List<GuiaEO> getGuiasAsOrgn() {
        return guiasAsOrgn;
    }

    public void setGuiasAsOrgn(List<GuiaEO> guiasAsOrgn) {
        this.guiasAsOrgn = guiasAsOrgn;
    }

    public List<GuiaEO> getGuiasAsDest() {
        return guiasAsDest;
    }

    public void setGuiasAsDest(List<GuiaEO> guiasAsDest) {
        this.guiasAsDest = guiasAsDest;
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
        return "ClntEO{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + '}';
    }

    
    
}
