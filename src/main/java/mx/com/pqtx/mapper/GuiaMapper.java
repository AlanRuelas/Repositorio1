
package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.GuiaDTO;
import mx.com.pqtx.dominio.GuiaEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GuiaMapper {
    GuiaMapper INSTANCE = Mappers.getMapper(GuiaMapper.class);
    
    GuiaDTO toDTO(GuiaEO guiaEO);
    GuiaEO toEntity(GuiaDTO guiaDTO);
}
