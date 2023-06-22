package com.TiendaSC_403.service;
//Contrato, lo que ofrece mas no la lóica con el DAO//
import com.TiendaSC_403.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //modificador:Public, private
    //retorno:void, int, etc, lista
    //método:Debe ser PLURAL
    //parámetros: lo que va a recibir
    
    //Método que retorna la lista de categoría// 
    //domain categoria//
    //va a recibir sólo activos
    public List<Categoria> getCategorias(boolean activos);//Se cierra con ;
    
    // Se obtiene un Categoria, a partir del id de un categoria
    public Categoria getCategoria(Categoria categoria); //cuando devolvemos es en singular
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío, o sea si viene un 0 en el long
    // Se actualiza un categoria si el id del categoria NO esta vacío, o sea si viene un valor se puede actualizar
    public void save(Categoria categoria);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Categoria categoria);
    
}
