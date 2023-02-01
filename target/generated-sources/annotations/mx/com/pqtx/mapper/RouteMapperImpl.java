package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.RouteDTO;
import mx.com.pqtx.dominio.RouteEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T11:18:38-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class RouteMapperImpl implements RouteMapper {

    @Override
    public RouteDTO toDTO(RouteEO routeEO) {
        if ( routeEO == null ) {
            return null;
        }

        RouteDTO routeDTO = new RouteDTO();

        routeDTO.setId( routeEO.getId() );
        routeDTO.setDaysOfTravel( routeEO.getDaysOfTravel() );
        routeDTO.setOrgnBranch( routeEO.getOrgnBranch() );
        routeDTO.setDestBranch( routeEO.getDestBranch() );

        return routeDTO;
    }

    @Override
    public RouteEO toEntity(RouteDTO routeDTO) {
        if ( routeDTO == null ) {
            return null;
        }

        RouteEO routeEO = new RouteEO();

        routeEO.setId( routeDTO.getId() );
        routeEO.setDaysOfTravel( routeDTO.getDaysOfTravel() );
        routeEO.setOrgnBranch( routeDTO.getOrgnBranch() );
        routeEO.setDestBranch( routeDTO.getDestBranch() );

        return routeEO;
    }
}
