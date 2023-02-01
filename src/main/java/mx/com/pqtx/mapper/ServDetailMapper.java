
package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.ServDetailDTO;
import mx.com.pqtx.dominio.ServDetailEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServDetailMapper {
    ServDetailMapper INSTANCE = Mappers.getMapper(ServDetailMapper.class);
    
    ServDetailDTO toDTO(ServDetailEO servDetailEO);
    ServDetailEO toEntity(ServDetailDTO servDetailDTO);
}
