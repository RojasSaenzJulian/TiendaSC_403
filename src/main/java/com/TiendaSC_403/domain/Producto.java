package com.TiendaSC_403.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable {
    
    //Vesión de Serialización//
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue( strategy =GenerationType.IDENTITY ) 
    @Column(name="id_producto") 
    
    private Long idProducto;//se agrega el id de CAT porque está conectado
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne //relacion de muchos productos a una Categoria
    @JoinColumn(name="id_categoria")
    private Categoria categoria;//trae todo lo de la clase de categoria
    
    public Producto() {
    }

   
    
    
}
