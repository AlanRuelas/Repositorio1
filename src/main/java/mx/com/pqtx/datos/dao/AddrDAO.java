
package mx.com.pqtx.datos.dao;

import java.util.List;
import mx.com.pqtx.datos.dto.AddrDTO;

public interface AddrDAO {
    public List<AddrDTO> findAllAddrs();
    
    public AddrDTO findAddrById(AddrDTO addrDTO);
    
    public AddrDTO findAddrByLocation(AddrDTO addrDTO);
    
    public AddrDTO findAddrByType(AddrDTO addrDTO);
    
    public void insertAddr(AddrDTO addrDTO);
    
    public void updateAddr(AddrDTO addrDTO);
    
    public void deleteAddr(AddrDTO addrDTO);
}
