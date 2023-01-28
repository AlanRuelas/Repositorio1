/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pqtx.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author practidesarrollo
 */
@Entity
@Table(name = "guias")
@NamedQueries({
    @NamedQuery(name = "GuiaEO.findAll", query = "SELECT g FROM GuiaEO g")
    , @NamedQuery(name = "GuiaEO.findByGuiaNum", query = "SELECT g FROM GuiaEO g WHERE g.guiaNum = :guiaNum")
    , @NamedQuery(name = "GuiaEO.findByHour", query = "SELECT g FROM GuiaEO g WHERE g.hour = :hour")
    , @NamedQuery(name = "GuiaEO.findByPromiseDate", query = "SELECT g FROM GuiaEO g WHERE g.promiseDate = :promiseDate")
    , @NamedQuery(name = "GuiaEO.findByDlvryDate", query = "SELECT g FROM GuiaEO g WHERE g.dlvryDate = :dlvryDate")
    , @NamedQuery(name = "GuiaEO.findBySubtotal", query = "SELECT g FROM GuiaEO g WHERE g.subtotal = :subtotal")
    , @NamedQuery(name = "GuiaEO.findByIva", query = "SELECT g FROM GuiaEO g WHERE g.iva = :iva")
    , @NamedQuery(name = "GuiaEO.findByTotal", query = "SELECT g FROM GuiaEO g WHERE g.total = :total")
    , @NamedQuery(name = "GuiaEO.findByComments", query = "SELECT g FROM GuiaEO g WHERE g.comments = :comments")})
public class GuiaEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "guia_num")
    private Integer guiaNum;
    @Temporal(TemporalType.TIME)
    private Date hour;
    @Column(name = "promise_date")
    @Temporal(TemporalType.DATE)
    private Date promiseDate;
    @Column(name = "dlvry_date")
    @Temporal(TemporalType.DATE)
    private Date dlvryDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Float subtotal;
    private Float iva;
    private Float total;
    @Size(max = 45)
    private String comments;
    @JoinColumn(name = "orgn_clnt_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ClntEO orgnClnt;
    @JoinColumn(name = "dest_clnt_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ClntEO destClnt;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RouteEO route;

    public GuiaEO() {
    }

    public GuiaEO(Integer guiaNum) {
        this.guiaNum = guiaNum;
    }

    public Integer getGuiaNum() {
        return guiaNum;
    }

    public void setGuiaNum(Integer guiaNum) {
        this.guiaNum = guiaNum;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public Date getPromiseDate() {
        return promiseDate;
    }

    public void setPromiseDate(Date promiseDate) {
        this.promiseDate = promiseDate;
    }

    public Date getDlvryDate() {
        return dlvryDate;
    }

    public void setDlvryDate(Date dlvryDate) {
        this.dlvryDate = dlvryDate;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ClntEO getOrgnClnt() {
        return orgnClnt;
    }

    public void setOrgnClnt(ClntEO orgnClnt) {
        this.orgnClnt = orgnClnt;
    }

    public ClntEO getDestClnt() {
        return destClnt;
    }

    public void setDestClnt(ClntEO destClnt) {
        this.destClnt = destClnt;
    }

    public RouteEO getRoute() {
        return route;
    }

    public void setRoute(RouteEO route) {
        this.route = route;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guiaNum != null ? guiaNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaEO)) {
            return false;
        }
        GuiaEO other = (GuiaEO) object;
        if ((this.guiaNum == null && other.guiaNum != null) || (this.guiaNum != null && !this.guiaNum.equals(other.guiaNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GuiaEO{" + "guiaNum=" + guiaNum + ", hour=" + hour + ", promiseDate=" + promiseDate + ", dlvryDate=" + dlvryDate + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", comments=" + comments + ", orgnClnt=" + orgnClnt + ", destClnt=" + destClnt + ", route=" + route + '}';
    }

    
    
}
