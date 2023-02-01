package mx.com.pqtx.mapper;

import mx.com.pqtx.datos.dto.BranchDTO;
import mx.com.pqtx.dominio.BranchEO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchMapper {
    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    BranchDTO toDTO(BranchEO branchEO);
    BranchEO toEntity(BranchDTO branchDTO);
}
