package mx.com.pqtx.datos.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.pqtx.datos.dto.RouteServCostDTO;
import mx.com.pqtx.dominio.RouteServCostEO;
import mx.com.pqtx.mapper.RouteServCostMapper;

@Stateless
public class RouteServCostDAOImpl implements RouteServCostDAO{
    
    @PersistenceContext(name = "GuiaPU")
    EntityManager em;

    @Override
    public List<RouteServCostDTO> findAllRouteServCosts() {
        List<RouteServCostEO> costs = em.createNamedQuery("RouteServCostEO.findAll").getResultList();
        return costs.stream().map(RouteServCostMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public RouteServCostDTO findCostByRouteAndServ(RouteServCostDTO routeServCostDTO) {
        Query query = em.createNamedQuery("RouteServCostEO.findByRouteAndServ");
        query.setParameter("route", routeServCostDTO.getRoute());
        query.setParameter("serv", routeServCostDTO.getServ());
        RouteServCostEO cost = (RouteServCostEO) query.getSingleResult();
        return RouteServCostMapper.INSTANCE.toDTO(cost);
    }

    @Override
    public void insertRouteServCost(RouteServCostDTO routeServCostDTO) {
        RouteServCostEO routeServCostEO = RouteServCostMapper.INSTANCE.toEntity(routeServCostDTO);
        em.persist(routeServCostEO);
    }

    @Override
    public void updateRouteServCost(RouteServCostDTO routeServCostDTO) {
        RouteServCostEO routeServCostEO = RouteServCostMapper.INSTANCE.toEntity(routeServCostDTO);
        em.merge(routeServCostEO);
    }

    @Override
    public void deleteRouteServCost(RouteServCostDTO routeServCostDTO) {
        RouteServCostEO routeServCostEO = em.find(RouteServCostEO.class, routeServCostDTO.getRoute());
        em.remove(routeServCostEO);
    }
    
}
