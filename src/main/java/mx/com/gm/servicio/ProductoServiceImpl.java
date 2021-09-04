package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import mx.com.gm.dao.ProductoDao;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = true) //readOnly = true, no abre una transaccion
    public List<Producto> listarProducto() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void eliminar(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto encontrarProducto(Producto producto) {
        return productoDao.findById(producto.getCodProducto()).orElse(null);
    }
    
}
