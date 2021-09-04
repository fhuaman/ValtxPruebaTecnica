package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProducto;
    
    @NotEmpty
    private String nombre;
    
    @NotNull
    private double precio;
    
}
