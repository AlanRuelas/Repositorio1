package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.PkgDetailDTO;

public interface PkgDetailDAO {
    public List<PkgDetailDTO> findAllPkgDetails();
    
    public PkgDetailDTO findDetailByGuiaAndPkg(PkgDetailDTO pkgDetailDTO);
    
    public void insertPkgDetail(PkgDetailDTO pkgDetailDTO);
    
    public void updatePkgDetail(PkgDetailDTO pkgDetailDTO);
    
    public void deletePkgDetail(PkgDetailDTO pkgDetailDTO);
}
