package mx.com.gm.servicio;

import java.util.*;
import mx.com.gm.domain.Usuario;

public interface UsuarioService {
    
    public List<Usuario> listarUsuario();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public Usuario encontrarUsuario(Usuario usuario);
    
}
