package mx.com.pqtx.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "routes_servs_costs")
@NamedQueries({ 
    @NamedQuery(name = "RouteServCostEO.findAll", query = "SELECT r FROM RouteServCostEO r"),
    @NamedQuery(name = "RouteServCostEO.findByRouteAndServ", 
            query = "SELECT r FROM RouteServCostEO r WHERE r.route = :route AND r.serv = :serv")})
public class RouteServCostEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    private Integer route;
    
    @Id
    private String serv;
    
    @Basic (optional = false)
    private float cost;
     

    public RouteServCostEO() {
    }

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
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
        return "RouteServCostEO{" + "route=" + route + ", serv=" + serv + ", cost=" + cost + '}';
    }

    
    
}
