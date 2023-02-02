package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.PkgDTO;
import mx.com.pqtx.dominio.PkgEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T12:53:15-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class PkgMapperImpl implements PkgMapper {

    @Override
    public PkgDTO toDTO(PkgEO pkgEO) {
        if ( pkgEO == null ) {
            return null;
        }

        PkgDTO pkgDTO = new PkgDTO();

        pkgDTO.setType( pkgEO.getType() );
        pkgDTO.setDescription( pkgEO.getDescription() );

        return pkgDTO;
    }

    @Override
    public PkgEO toEntity(PkgDTO pkgDTO) {
        if ( pkgDTO == null ) {
            return null;
        }

        PkgEO pkgEO = new PkgEO();

        pkgEO.setType( pkgDTO.getType() );
        pkgEO.setDescription( pkgDTO.getDescription() );

        return pkgEO;
    }
}
