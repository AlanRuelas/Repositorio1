package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.BranchPkgCostDTO;
import mx.com.pqtx.dominio.BranchPkgCostEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T12:53:15-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class BranchPkgCostMapperImpl implements BranchPkgCostMapper {

    @Override
    public BranchPkgCostDTO toDTO(BranchPkgCostEO branchPkgCostEO) {
        if ( branchPkgCostEO == null ) {
            return null;
        }

        BranchPkgCostDTO branchPkgCostDTO = new BranchPkgCostDTO();

        branchPkgCostDTO.setBranch( branchPkgCostEO.getBranch() );
        branchPkgCostDTO.setPkg( branchPkgCostEO.getPkg() );
        branchPkgCostDTO.setCost( branchPkgCostEO.getCost() );

        return branchPkgCostDTO;
    }

    @Override
    public BranchPkgCostEO toEntity(BranchPkgCostDTO branchPkgCostDTO) {
        if ( branchPkgCostDTO == null ) {
            return null;
        }

        BranchPkgCostEO branchPkgCostEO = new BranchPkgCostEO();

        branchPkgCostEO.setBranch( branchPkgCostDTO.getBranch() );
        branchPkgCostEO.setPkg( branchPkgCostDTO.getPkg() );
        branchPkgCostEO.setCost( branchPkgCostDTO.getCost() );

        return branchPkgCostEO;
    }
}
