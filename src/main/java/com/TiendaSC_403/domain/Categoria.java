package com.TiendaSC_403.domain;
import jakarta.persistence.*;//antes decia entity, ahora * para que aplique con todas//
import java.io.Serializable;
import lombok.Data;

//va a sevir como na entidad para mapear los campos categoria de la tabla de mysql
@Data //Crea set and get sin que se muestre en pantalla//
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{ //Serializablepermite que ese objeto se pueda convertir en pieza y luego reconstruirse/
    
    //Vesión de Serialización//
    private static final long serialVersionUID = 1L;
    
    //Atributos de la DB//
    @Id //porque es una identidad//
    @GeneratedValue( strategy =GenerationType.IDENTITY ) //para crear nuvos registros y crear un ID//
    @Column(name="id_categoria") //Para saber con cuál columna de tabla se va a asociar//
    private Long idCategoria; //se escribe en este formato, es id_categoria//
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        //Se selecciona todos MENOS el id//
    }
    
    
    
}
