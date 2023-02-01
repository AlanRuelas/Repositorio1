
package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.BranchPkgCostDTO;
import mx.com.pqtx.dominio.BranchPkgCostEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchPkgCostMapper {
    BranchPkgCostMapper INSTANCE = Mappers.getMapper(BranchPkgCostMapper.class);

    BranchPkgCostDTO toDTO(BranchPkgCostEO branchPkgCostEO);
    BranchPkgCostEO toEntity(BranchPkgCostDTO branchPkgCostDTO);
}
