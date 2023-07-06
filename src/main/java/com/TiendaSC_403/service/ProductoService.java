package com.TiendaSC_403.service;
//Contrato, lo que ofrece mas no la lóica con el DAO//
import com.TiendaSC_403.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activos);//Se cierra con ;
    
    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto); //cuando devolvemos es en singular
    
    // Se inserta un nuevo producto si el id del producto esta vacío, o sea si viene un 0 en el long
    // Se actualiza un producto si el id del producto NO esta vacío, o sea si viene un valor se puede actualizar
    public void save(Producto producto);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
    
}
