package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.ClntDTO;
import mx.com.pqtx.dominio.ClntEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T12:53:15-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class ClntMapperImpl implements ClntMapper {

    @Override
    public ClntDTO toDTO(ClntEO clntEO) {
        if ( clntEO == null ) {
            return null;
        }

        ClntDTO clntDTO = new ClntDTO();

        clntDTO.setId( clntEO.getId() );
        clntDTO.setName( clntEO.getName() );
        clntDTO.setLastName( clntEO.getLastName() );
        clntDTO.setPhone( clntEO.getPhone() );

        return clntDTO;
    }

    @Override
    public ClntEO toEntity(ClntDTO clntDTO) {
        if ( clntDTO == null ) {
            return null;
        }

        ClntEO clntEO = new ClntEO();

        clntEO.setId( clntDTO.getId() );
        clntEO.setName( clntDTO.getName() );
        clntEO.setLastName( clntDTO.getLastName() );
        clntEO.setPhone( clntDTO.getPhone() );

        return clntEO;
    }
}
