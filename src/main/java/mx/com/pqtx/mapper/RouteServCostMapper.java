
package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.RouteServCostDTO;
import mx.com.pqtx.dominio.RouteServCostEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteServCostMapper {
    RouteServCostMapper INSTANCE = Mappers.getMapper(RouteServCostMapper.class);
    
    RouteServCostDTO toDTO(RouteServCostEO routeServCostEO);
    RouteServCostEO toEntity(RouteServCostDTO routeServCostDTO);
}
