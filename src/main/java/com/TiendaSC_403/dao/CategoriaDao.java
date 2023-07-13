package com.TiendaSC_403.dao;
//Data Access Object//
import com.TiendaSC_403.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//T:Nombre de clase, ID: Tipo de datos//
public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    //Mas adelante vamos a tener métodos ampliados//
//    Aquí se busca lo que uno ingrese, en este caso la descripcion de la cat
    List<Categoria> findByDescripcion(String descripcion);
}
