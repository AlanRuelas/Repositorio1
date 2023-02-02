package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.BranchServCostDTO;
import mx.com.pqtx.dominio.BranchServCostEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T12:53:15-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class BranchServCostMapperImpl implements BranchServCostMapper {

    @Override
    public BranchServCostDTO toDTO(BranchServCostEO branchServCostEO) {
        if ( branchServCostEO == null ) {
            return null;
        }

        BranchServCostDTO branchServCostDTO = new BranchServCostDTO();

        branchServCostDTO.setBranch( branchServCostEO.getBranch() );
        branchServCostDTO.setServ( branchServCostEO.getServ() );
        branchServCostDTO.setCost( branchServCostEO.getCost() );

        return branchServCostDTO;
    }

    @Override
    public BranchServCostEO toEntity(BranchServCostDTO branchServCostDTO) {
        if ( branchServCostDTO == null ) {
            return null;
        }

        BranchServCostEO branchServCostEO = new BranchServCostEO();

        branchServCostEO.setBranch( branchServCostDTO.getBranch() );
        branchServCostEO.setServ( branchServCostDTO.getServ() );
        branchServCostEO.setCost( branchServCostDTO.getCost() );

        return branchServCostEO;
    }
}
