package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Data
@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codSucursal;
    
    @NotEmpty
    private String nombre;
    
}
