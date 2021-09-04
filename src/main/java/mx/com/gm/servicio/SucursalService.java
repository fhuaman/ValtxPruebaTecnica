package mx.com.gm.servicio;

import java.util.*;
import mx.com.gm.domain.Sucursal;

public interface SucursalService {
    
    public List<Sucursal> listarSucursal();
    
    public void guardar(Sucursal sucursal);
    
    public void eliminar(Sucursal sucursal);
    
    public Sucursal encontrarSucursal(Sucursal sucursal);
    
}
