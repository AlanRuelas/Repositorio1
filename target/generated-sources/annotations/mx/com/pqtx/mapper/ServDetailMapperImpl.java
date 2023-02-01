package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.ServDetailDTO;
import mx.com.pqtx.dominio.ServDetailEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T11:18:38-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class ServDetailMapperImpl implements ServDetailMapper {

    @Override
    public ServDetailDTO toDTO(ServDetailEO servDetailEO) {
        if ( servDetailEO == null ) {
            return null;
        }

        ServDetailDTO servDetailDTO = new ServDetailDTO();

        servDetailDTO.setGuia( servDetailEO.getGuia() );
        servDetailDTO.setServ( servDetailEO.getServ() );
        servDetailDTO.setCost( servDetailEO.getCost() );

        return servDetailDTO;
    }

    @Override
    public ServDetailEO toEntity(ServDetailDTO servDetailDTO) {
        if ( servDetailDTO == null ) {
            return null;
        }

        ServDetailEO servDetailEO = new ServDetailEO();

        servDetailEO.setGuia( servDetailDTO.getGuia() );
        servDetailEO.setServ( servDetailDTO.getServ() );
        servDetailEO.setCost( servDetailDTO.getCost() );

        return servDetailEO;
    }
}
