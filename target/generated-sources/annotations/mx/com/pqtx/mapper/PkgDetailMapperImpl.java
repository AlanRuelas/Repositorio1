package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.PkgDetailDTO;
import mx.com.pqtx.dominio.PkgDetailEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T12:53:15-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class PkgDetailMapperImpl implements PkgDetailMapper {

    @Override
    public PkgDetailDTO toDTO(PkgDetailEO pkgDetailEO) {
        if ( pkgDetailEO == null ) {
            return null;
        }

        PkgDetailDTO pkgDetailDTO = new PkgDetailDTO();

        pkgDetailDTO.setGuia( pkgDetailEO.getGuia() );
        pkgDetailDTO.setPkg( pkgDetailEO.getPkg() );
        pkgDetailDTO.setCost( pkgDetailEO.getCost() );

        return pkgDetailDTO;
    }

    @Override
    public PkgDetailEO toEntity(PkgDetailDTO pkgDetailDTO) {
        if ( pkgDetailDTO == null ) {
            return null;
        }

        PkgDetailEO pkgDetailEO = new PkgDetailEO();

        pkgDetailEO.setGuia( pkgDetailDTO.getGuia() );
        pkgDetailEO.setPkg( pkgDetailDTO.getPkg() );
        pkgDetailEO.setCost( pkgDetailDTO.getCost() );

        return pkgDetailEO;
    }
}
