package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import mx.com.gm.dao.SucursalDao;

@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private SucursalDao sucursalDao;
    
    @Override
    @Transactional(readOnly = true) //readOnly = true, no abre una transaccion
    public List<Sucursal> listarSucursal() {
        return (List<Sucursal>) sucursalDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Sucursal sucursal) {
        sucursalDao.save(sucursal);
    }

    @Override
    @Transactional
    public void eliminar(Sucursal sucursal) {
        sucursalDao.delete(sucursal);
    }

    @Override
    @Transactional(readOnly = true)
    public Sucursal encontrarSucursal(Sucursal sucursal) {
        return sucursalDao.findById(sucursal.getCodSucursal()).orElse(null);
    }
    
}
