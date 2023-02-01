package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.RouteDTO;

public interface RouteDAO {
    public List<RouteDTO> findAllRoutes();
    
    public RouteDTO findRouteById(RouteDTO routeDTO);
    
    public List<RouteDTO> findRoutesByDaysOfTravel(RouteDTO routeDTO);
    
    public List<RouteDTO> findRoutesByOrgnBranch(RouteDTO routeDTO);
        
    public List<RouteDTO> findRoutesByDestBranch(RouteDTO routeDTO);
    
    public void insertRoute(RouteDTO routeDTO);
    
    public void updateRoute(RouteDTO routeDTO);
    
    public void deleteRoute(RouteDTO routeDTO);
}
