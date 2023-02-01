package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.RouteServCostDTO;

public interface RouteServCostDAO {
    public List<RouteServCostDTO> findAllRouteServCosts();
    
    public RouteServCostDTO findCostByRouteAndServ(RouteServCostDTO routeServCostDTO);
    
    public void insertRouteServCost(RouteServCostDTO routeServCostDTO);
    
    public void updateRouteServCost(RouteServCostDTO routeServCostDTO);
    
    public void deleteRouteServCost(RouteServCostDTO routeServCostDTO);
}
