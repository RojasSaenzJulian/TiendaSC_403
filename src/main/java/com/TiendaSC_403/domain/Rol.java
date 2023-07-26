package com.TiendaSC_403.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table (name="rol")
public class Rol implements Serializable {
    //Vesión de Serialización//
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue( strategy =GenerationType.IDENTITY ) 
    @Column(name="id_rol") 
    private Long idRol;
    
    @NotEmpty //Si el objeto tiene ese dato vacio, lanza una alerta
    private String nombre;
    
    @Column(name = "id_usuario")
    private Long idUsuario;
    
}
