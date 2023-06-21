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
    
}
