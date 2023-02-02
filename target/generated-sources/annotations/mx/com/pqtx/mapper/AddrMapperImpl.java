package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.AddrDTO;
import mx.com.pqtx.dominio.AddrEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T12:53:15-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class AddrMapperImpl implements AddrMapper {

    @Override
    public AddrDTO toDTO(AddrEO addrEO) {
        if ( addrEO == null ) {
            return null;
        }

        AddrDTO addrDTO = new AddrDTO();

        addrDTO.setId( addrEO.getId() );
        addrDTO.setLocation( addrEO.getLocation() );
        addrDTO.setType( addrEO.getType() );

        return addrDTO;
    }

    @Override
    public AddrEO toEntity(AddrDTO addrDTO) {
        if ( addrDTO == null ) {
            return null;
        }

        AddrEO addrEO = new AddrEO();

        addrEO.setId( addrDTO.getId() );
        addrEO.setLocation( addrDTO.getLocation() );
        addrEO.setType( addrDTO.getType() );

        return addrEO;
    }
}
