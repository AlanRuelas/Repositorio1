package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.ServDTO;
import mx.com.pqtx.dominio.ServEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T11:18:37-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class ServMapperImpl implements ServMapper {

    @Override
    public ServDTO toDTO(ServEO servEO) {
        if ( servEO == null ) {
            return null;
        }

        ServDTO servDTO = new ServDTO();

        servDTO.setType( servEO.getType() );
        servDTO.setDescription( servEO.getDescription() );

        return servDTO;
    }

    @Override
    public ServEO toEntity(ServDTO servDTO) {
        if ( servDTO == null ) {
            return null;
        }

        ServEO servEO = new ServEO();

        servEO.setType( servDTO.getType() );
        servEO.setDescription( servDTO.getDescription() );

        return servEO;
    }
}
