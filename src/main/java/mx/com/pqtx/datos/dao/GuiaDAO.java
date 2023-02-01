package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.GuiaDTO;

public interface GuiaDAO {
    public List<GuiaDTO> findAllGuias();
    
    public GuiaDTO findGuiaByNum(GuiaDTO guiaDTO);
    
    public void insertGuia(GuiaDTO guiaDTO);
    
    public void updateGuia(GuiaDTO guiaDTO);
    
    public void deleteGuia(GuiaDTO guiaDTO);
}
