
package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.RouteDTO;
import mx.com.pqtx.dominio.RouteEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteMapper {
    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);
    
    RouteDTO toDTO(RouteEO routeEO);
    RouteEO toEntity(RouteDTO routeDTO);
}
