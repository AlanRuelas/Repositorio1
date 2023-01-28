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
@Table(name = "routes_servs_costs")
@NamedQueries({ 
    @NamedQuery(name = "RouteServCostEO.findAll", query = "SELECT r FROM RouteServCostEO r"),
    @NamedQuery(name = "RouteServCostEO.findByRouteAndServ", 
            query = "SELECT r FROM RouteServCostEO r WHERE r.route = :route AND r.serv = :serv")})
public class RouteServCostEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @JoinColumn(name = "route", referencedColumnName = "route_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private String route;
    
    @Id
    @JoinColumn(name = "serv", referencedColumnName = "type")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private String serv;
    
    @Basic (optional = false)
    @Column(name = "cost" ) 
    private String cost;
     

    public RouteServCostEO() {
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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
        return "RouteServCostEO{" + "route=" + route + ", serv=" + serv + ", cost=" + cost + '}';
    }

    
    
}
