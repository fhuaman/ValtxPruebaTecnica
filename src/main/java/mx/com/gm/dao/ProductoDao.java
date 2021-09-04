package mx.com.gm.dao;

import mx.com.gm.domain.Producto;
import org.springframework.data.repository.*;

public interface ProductoDao extends CrudRepository<Producto, Long>{ //Long = tipo de variable codSucursal
    
}
