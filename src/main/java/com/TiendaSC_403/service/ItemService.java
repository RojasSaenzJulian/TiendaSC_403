package com.TiendaSC_403.service;
//Contrato, lo que ofrece mas no la lóica con el DAO//
import com.TiendaSC_403.domain.Item;
import java.util.ArrayList;
import java.util.List;

public interface ItemService {     
    List<Item> listaItems = new ArrayList<>();
    
    public List<Item> gets();
    
    //Se recupera el registro que tiene el idItem pasado por parámetro
    //si no existe en la tabla se retorna null
    public Item get(Item item);
    
    //Se elimina el registro que tiene el idItem pasado por parámetro
    public void delete(Item item);
    
    //Si el objeto item tiene un idItem que existe en la tabla item
    //El registro de actualiza con la nueva información
    //Si el idItem NO existe en la tabla, se crea el registro con esa información
    public void save(Item item);
    
    public void actualiza(Item item);
    
    public void facturar();
}

