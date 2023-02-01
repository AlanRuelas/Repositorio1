package mx.com.pqtx.datos.dto;


public class RouteServCostDTO {
    private Integer route;
    private String serv;
    private float cost;

    public RouteServCostDTO() {
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

    
}
