
package mx.com.pqtx.core;

import mx.com.pqtx.datos.dto.ClntDTO;


public interface Validator {
    public void addClient(ClntDTO clntDTO);
    
    public boolean exists(ClntDTO clntDTO);
}
