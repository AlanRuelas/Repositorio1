package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.GuiaDTO;
import mx.com.pqtx.dominio.GuiaEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T12:53:16-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class GuiaMapperImpl implements GuiaMapper {

    @Override
    public GuiaDTO toDTO(GuiaEO guiaEO) {
        if ( guiaEO == null ) {
            return null;
        }

        GuiaDTO guiaDTO = new GuiaDTO();

        guiaDTO.setGuiaNum( guiaEO.getGuiaNum() );
        guiaDTO.setHour( guiaEO.getHour() );
        guiaDTO.setPromiseDate( guiaEO.getPromiseDate() );
        guiaDTO.setDlvryDate( guiaEO.getDlvryDate() );
        guiaDTO.setSubtotal( guiaEO.getSubtotal() );
        guiaDTO.setIva( guiaEO.getIva() );
        guiaDTO.setTotal( guiaEO.getTotal() );
        guiaDTO.setComments( guiaEO.getComments() );
        guiaDTO.setOrgnClnt( guiaEO.getOrgnClnt() );
        guiaDTO.setDestClnt( guiaEO.getDestClnt() );
        guiaDTO.setRoute( guiaEO.getRoute() );

        return guiaDTO;
    }

    @Override
    public GuiaEO toEntity(GuiaDTO guiaDTO) {
        if ( guiaDTO == null ) {
            return null;
        }

        GuiaEO guiaEO = new GuiaEO();

        guiaEO.setGuiaNum( guiaDTO.getGuiaNum() );
        guiaEO.setHour( guiaDTO.getHour() );
        guiaEO.setPromiseDate( guiaDTO.getPromiseDate() );
        guiaEO.setDlvryDate( guiaDTO.getDlvryDate() );
        guiaEO.setSubtotal( guiaDTO.getSubtotal() );
        guiaEO.setIva( guiaDTO.getIva() );
        guiaEO.setTotal( guiaDTO.getTotal() );
        guiaEO.setComments( guiaDTO.getComments() );
        guiaEO.setOrgnClnt( guiaDTO.getOrgnClnt() );
        guiaEO.setDestClnt( guiaDTO.getDestClnt() );
        guiaEO.setRoute( guiaDTO.getRoute() );

        return guiaEO;
    }
}
