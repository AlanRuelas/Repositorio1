package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.ClntDTO;

public interface ClntDAO {
    public List<ClntDTO> findAllClnts();
    
    public ClntDTO findClntById(ClntDTO clntDTO);
    
    public List<ClntDTO> findClntsByName(ClntDTO clntDTO);
    
    public List<ClntDTO> findClntsByLastName(ClntDTO clntDTO);
        
    public ClntDTO findClntByPhone(ClntDTO clntDTO);
    
    public void insertClnt(ClntDTO clntDTO);
    
    public void updateClnt(ClntDTO clntDTO);
    
    public void deleteClnt(ClntDTO clntDTO);
}
