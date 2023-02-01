/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pqtx.datos.dao; 

import java.util.List;
import mx.com.pqtx.datos.dto.PkgDTO;
import mx.com.pqtx.datos.dto.PkgDTO;

/**
 * 
 * @author practidesarrollo
 */
public interface PkgDAO {
    public List<PkgDTO> findAllPkgs();
    
    public PkgDTO findPkgByType(PkgDTO pkgDTO);
    
    public PkgDTO findPkgByDescription(PkgDTO pkgDTO);
    
    public void insertPkg(PkgDTO pkgDTO);
    
    public void updatePkg(PkgDTO pkgDTO);
    
    public void deletePkg(PkgDTO pkgDTO);

}
