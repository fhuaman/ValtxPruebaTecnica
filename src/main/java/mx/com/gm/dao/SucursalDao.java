package mx.com.gm.dao;

import mx.com.gm.domain.Sucursal;
import org.springframework.data.repository.*;

public interface SucursalDao extends CrudRepository<Sucursal, Long>{ //Long = tipo de variable codSucursal
    
}
