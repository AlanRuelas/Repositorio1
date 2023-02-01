
package mx.com.pqtx.mapper;


import mx.com.pqtx.datos.dto.PkgDetailDTO;
import mx.com.pqtx.dominio.PkgDetailEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PkgDetailMapper {
    PkgDetailMapper INSTANCE = Mappers.getMapper(PkgDetailMapper.class);
    
    PkgDetailDTO toDTO(PkgDetailEO pkgDetailEO);
    PkgDetailEO toEntity(PkgDetailDTO pkgDetailDTO);
}
