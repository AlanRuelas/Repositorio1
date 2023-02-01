package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.BranchServCostDTO;
import mx.com.pqtx.dominio.BranchServCostEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchServCostMapper {
    BranchServCostMapper INSTANCE = Mappers.getMapper(BranchServCostMapper.class);
    
    BranchServCostDTO toDTO(BranchServCostEO branchServCostEO);
    BranchServCostEO toEntity(BranchServCostDTO branchServCostDTO);

}
