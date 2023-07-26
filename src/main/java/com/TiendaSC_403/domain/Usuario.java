package com.TiendaSC_403.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    //Vesión de Serialización//
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue( strategy =GenerationType.IDENTITY ) 
    @Column(name="id_usuario") 
    private Long idUsuario;
    
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String nombre;    
    private String apellidos;    
    private String correo;    
    private String telefono;    
    private String rutaImagen;    
    private String activo;
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
    
    
    
}
