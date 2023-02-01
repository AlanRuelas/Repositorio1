
package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.ServDTO;
import mx.com.pqtx.dominio.ServEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServMapper {
    ServMapper INSTANCE = Mappers.getMapper(ServMapper.class);
    
    ServDTO toDTO(ServEO servEO);
    ServEO toEntity(ServDTO servDTO);
}
