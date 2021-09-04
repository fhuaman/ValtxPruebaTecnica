package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.*;
import mx.com.gm.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import mx.com.gm.servicio.*;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private SucursalService sucursalService;
    
    @Autowired
    private UsuarioService usuarioService;
      
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("ejecutando el controlador Spring MVC");
        return "index";
    }
    
    @GetMapping("/sucursal")
    public String listarSucursal(Model model){
        var sucursales = sucursalService.listarSucursal();
        model.addAttribute("sucursales", sucursales);
        return "sucursal";
    }
    
    @GetMapping("/sucursal/agregar")
    public String agregarSucursal(Sucursal sucursal){
        return "modificarSucursal";
    }
    
    @PostMapping("/sucursal/guardar")
    public String guardarSucursal(@Valid Sucursal sucursal, Errors errores){
        if(errores.hasErrors()){
            return "modificarSucursal";
        }
        sucursalService.guardar(sucursal);
        return "redirect:/sucursal";
    }
    
    @GetMapping("/sucursal/editar/{codSucursal}")
    public String editarSucursal(Sucursal sucursal, Model model){
        sucursal = sucursalService.encontrarSucursal(sucursal);
        model.addAttribute("sucursal", sucursal);
        return "modificarSucursal";   
    }
    
    @GetMapping("/sucursal/eliminar")
    public String eliminarSucursal(Sucursal sucursal){
        sucursalService.eliminar(sucursal);
        return "redirect:/sucursal";
    }
    
    @GetMapping("/usuario")
    public String listarUsuario(Model model){
        var usuarios = usuarioService.listarUsuario();
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }
    
    @GetMapping("/usuario/agregar")
    public String agregarSucursal(Usuario usuario, Model model){
        var sucursales = sucursalService.listarSucursal();
        model.addAttribute("sucursales", sucursales);
        return "modificarUsuario";
    }
    
    @PostMapping("/usuario/guardar")
    public String guardarUsuario(@Valid Usuario usuario, Errors errores){
        if(errores.hasErrors()){
            return "modificarUsuario";
        }
        usuarioService.guardar(usuario);
        return "redirect:/usuario";
    }
    
    @GetMapping("/usuario/editar/{codUsuario}")
    public String editarUsuario(Usuario usuario, Model model){
        usuario = usuarioService.encontrarUsuario(usuario);
        var sucursales = sucursalService.listarSucursal(); 
        model.addAttribute("usuario", usuario);
        model.addAttribute("sucursales", sucursales);
        return "modificarUsuario";   
    }
    
    @GetMapping("/usuario/eliminar")
    public String eliminarUsuario(Usuario usuario){
        usuarioService.eliminar(usuario);
        return "redirect:/usuario";
    }
    
    @GetMapping("/producto")
    public String listarProducto(Model model){
        var productos = productoService.listarProducto();
        model.addAttribute("productos", productos);
        return "producto";
    }
    
    @GetMapping("/producto/agregar")
    public String agregarProducto(Producto producto){
        return "modificarProducto";
    }
    
    @PostMapping("/producto/guardar")
    public String guardarProducto(@Valid Producto producto, Errors errores){
        if(errores.hasErrors()){
            return "modificarProducto";
        }
        productoService.guardar(producto);
        return "redirect:/producto";
    }
    
    @GetMapping("/producto/editar/{codProducto}")
    public String editarProducto(Producto producto, Model model){
        producto = productoService.encontrarProducto(producto);
        model.addAttribute("producto", producto);
        return "modificarProducto";   
    }
    
    @GetMapping("/producto/eliminar")
    public String eliminarSucursal(Producto producto){
        productoService.eliminar(producto);
        return "redirect:/producto";
    }
}
