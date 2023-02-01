
package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.PkgDTO;
import mx.com.pqtx.dominio.PkgEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PkgMapper {
    PkgMapper INSTANCE = Mappers.getMapper(PkgMapper.class);
    
    PkgDTO toDTO(PkgEO pkgEO);
    PkgEO toEntity(PkgDTO pkgDTO);
}
