package com.TiendaSC_403.dao;
//Data Access Object//
import com.TiendaSC_403.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
//T:Nombre de clase, ID: Tipo de datos//
public interface ProductoDao extends JpaRepository<Producto, Long> {
    //Mas adelante vamos a tener métodos ampliados//
    
}
