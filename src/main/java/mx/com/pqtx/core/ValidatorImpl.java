
package mx.com.pqtx.core;

import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.pqtx.datos.dao.ClntDAO;
import mx.com.pqtx.datos.dto.ClntDTO;

@Stateless
public class ValidatorImpl implements Validator{

    @Inject
    ClntDAO clntDAO;
    
    @Override
    public void addClient(ClntDTO clntDTO) {
        if(exists(clntDTO) == false){   
            clntDAO.insertClnt(clntDTO);
        }
    }
    
    @Override
    public boolean exists(ClntDTO clntDTO){
        ClntDTO clnt = clntDAO.findClntByPersonalData(clntDTO);
        if(clnt != null){
            return true; 
        }
        return false;
    }
    
    
}
