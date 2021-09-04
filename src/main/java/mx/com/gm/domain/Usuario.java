package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codUsuario;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String user;
    
    @NotEmpty
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "cod_sucursal")
    private Sucursal sucursal;
    
}
