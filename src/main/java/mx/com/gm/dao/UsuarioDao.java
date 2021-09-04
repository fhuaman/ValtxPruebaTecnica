package mx.com.gm.dao;

import mx.com.gm.domain.Usuario;
import org.springframework.data.repository.*;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{ //Long = tipo de variable codSucursal
    
}
