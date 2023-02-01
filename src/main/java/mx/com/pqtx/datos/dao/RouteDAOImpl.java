package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.RouteDTO;
import mx.com.pqtx.dominio.RouteEO;
import mx.com.pqtx.mapper.RouteMapper;

@Stateless
public class RouteDAOImpl implements RouteDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<RouteDTO> findAllRoutes() {
        List<RouteEO> routes = em.createNamedQuery("RouteEO.findAll").getResultList();
        return routes.stream().map(RouteMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public RouteDTO findRouteById(RouteDTO routeDTO) {
        Query query = em.createNamedQuery("RouteEO.findById");
        query.setParameter("id", routeDTO.getId());
        RouteEO routeEO = (RouteEO) query.getSingleResult();
        return RouteMapper.INSTANCE.toDTO(routeEO);
    }

    @Override
    public List<RouteDTO> findRoutesByDaysOfTravel(RouteDTO routeDTO) {
        Query query = em.createNamedQuery("RouteEO.findByDaysOfTravel");
        query.setParameter("daysOfTravel", routeDTO.getDaysOfTravel());
        List<RouteEO> routes = query.getResultList();
        return routes.stream().map(RouteMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override 
    public List<RouteDTO> findRoutesByOrgnBranch(RouteDTO routeDTO) {
        return null;
    }

    @Override
    public List<RouteDTO> findRoutesByDestBranch(RouteDTO routeDTO) {
        return null;
    }

    @Override
    public void insertRoute(RouteDTO routeDTO) {
        RouteEO routeEO = RouteMapper.INSTANCE.toEntity(routeDTO);
        em.persist(routeEO);
    }

    @Override
    public void updateRoute(RouteDTO routeDTO) {
        RouteEO routeEO = RouteMapper.INSTANCE.toEntity(routeDTO);
        em.merge(routeEO);    }

    @Override
    public void deleteRoute(RouteDTO routeDTO) {
        RouteEO routeEO = em.find(RouteEO.class, routeDTO.getId());
        em.remove(routeEO);
    }
    
}
