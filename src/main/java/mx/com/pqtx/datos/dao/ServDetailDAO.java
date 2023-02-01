package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.ServDetailDTO;

public interface ServDetailDAO {
    public List<ServDetailDTO> findAllServDetails();
    
    public ServDetailDTO findDetailByGuiaAndServ(ServDetailDTO servDetailDTO);
    
    public void insertServDetail(ServDetailDTO servDetailDTO);
    
    public void updateServDetail(ServDetailDTO servDetailDTO);
    
    public void deleteServDetail(ServDetailDTO servDetailDTO);
}
