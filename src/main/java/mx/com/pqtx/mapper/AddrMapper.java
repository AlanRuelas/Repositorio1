package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.AddrDTO;
import mx.com.pqtx.dominio.AddrEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddrMapper {
    AddrMapper INSTANCE = Mappers.getMapper(AddrMapper.class);

    AddrDTO toDTO(AddrEO addrEO);
    AddrEO toEntity(AddrDTO addrDTO);
}
