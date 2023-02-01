package mx.com.pqtx.mapper;

import javax.annotation.Generated;
import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.dominio.BranchEO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T11:18:37-0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class BranchMapperImpl implements BranchMapper {

    @Override
    public BranchDTO toDTO(BranchEO branchEO) {
        if ( branchEO == null ) {
            return null;
        }

        BranchDTO branchDTO = new BranchDTO();

        branchDTO.setName( branchEO.getName() );

        return branchDTO;
    }

    @Override
    public BranchEO toEntity(BranchDTO branchDTO) {
        if ( branchDTO == null ) {
            return null;
        }

        BranchEO branchEO = new BranchEO();

        branchEO.setName( branchDTO.getName() );

        return branchEO;
    }
}
