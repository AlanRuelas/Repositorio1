package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.RouteServCostDTO;
import mx.com.pqtx.dominio.RouteServCostEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T12:53:15-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class RouteServCostMapperImpl implements RouteServCostMapper {

    @Override
    public RouteServCostDTO toDTO(RouteServCostEO routeServCostEO) {
        if ( routeServCostEO == null ) {
            return null;
        }

        RouteServCostDTO routeServCostDTO = new RouteServCostDTO();

        routeServCostDTO.setRoute( routeServCostEO.getRoute() );
        routeServCostDTO.setServ( routeServCostEO.getServ() );
        routeServCostDTO.setCost( routeServCostEO.getCost() );

        return routeServCostDTO;
    }

    @Override
    public RouteServCostEO toEntity(RouteServCostDTO routeServCostDTO) {
        if ( routeServCostDTO == null ) {
            return null;
        }

        RouteServCostEO routeServCostEO = new RouteServCostEO();

        routeServCostEO.setRoute( routeServCostDTO.getRoute() );
        routeServCostEO.setServ( routeServCostDTO.getServ() );
        routeServCostEO.setCost( routeServCostDTO.getCost() );

        return routeServCostEO;
    }
}
