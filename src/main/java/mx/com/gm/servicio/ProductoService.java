package mx.com.gm.servicio;

import java.util.*;
import mx.com.gm.domain.Producto;

public interface ProductoService {
    
    public List<Producto> listarProducto();
    
    public void guardar(Producto producto);
    
    public void eliminar(Producto producto);
    
    public Producto encontrarProducto(Producto producto);
    
}
