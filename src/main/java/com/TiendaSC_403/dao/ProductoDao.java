package com.TiendaSC_403.dao;
//Data Access Object//
import com.TiendaSC_403.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//T:Nombre de clase, ID: Tipo de datos//
public interface ProductoDao extends JpaRepository<Producto, Long> {
    //Mas adelante vamos a tener métodos ampliados//
    //Ejemplo de método utilizando Métodos de Query
    //Encontrar por precio y ordenar por la descripcion
public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

 //Ejemplo de método utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup); 
   
    
}
