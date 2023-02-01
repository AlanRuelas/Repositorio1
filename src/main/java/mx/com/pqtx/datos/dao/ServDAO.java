
package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.ServDTO;


public interface ServDAO {
    public List<ServDTO> findAllServs();
    
    public ServDTO findServByType(ServDTO servDTO);
    
    public ServDTO findServByDescription(ServDTO servDTO);
    
    public void insertServ(ServDTO servDTO);
    
    public void updateServ(ServDTO servDTO);
    
    public void deleteServ(ServDTO servDTO);
}
