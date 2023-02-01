package mx.com.pqtx.datos.dto;

import java.util.Date;

public class GuiaDTO {
    private Integer guiaNum;
    private Date hour;
    private Date promiseDate;
    private Date dlvryDate;
    private Float subtotal;
    private Float iva;
    private Float total;    
    private String comments;
    private Integer orgnClnt;
    private Integer destClnt;
    private Integer route;

    public GuiaDTO() {
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

    public Integer getOrgnClnt() {
        return orgnClnt;
    }

    public void setOrgnClnt(Integer orgnClnt) {
        this.orgnClnt = orgnClnt;
    }

    public Integer getDestClnt() {
        return destClnt;
    }

    public void setDestClnt(Integer destClnt) {
        this.destClnt = destClnt;
    }

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    

    
}
