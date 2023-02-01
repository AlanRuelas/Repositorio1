package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.ClntDTO;
import mx.com.pqtx.dominio.ClntEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClntMapper {
    ClntMapper INSTANCE = Mappers.getMapper(ClntMapper.class);
    
    ClntDTO toDTO(ClntEO clntEO);
    ClntEO toEntity(ClntDTO clntDTO);
}
