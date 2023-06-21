package com.TiendaSC_403.dao;
//Data Access Object//
import com.TiendaSC_403.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
//T:Nombre de clase, ID: Tipo de datos//
public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    //Mas adelante vamos a tener métodos ampliados//
    
}
