package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import mx.com.gm.dao.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly = true) //readOnly = true, no abre una transaccion
    public List<Usuario> listarUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getCodUsuario()).orElse(null);
    }

}