package com.TiendaSC_403.service.impl;
//Depende si es SQL y Oracle. Es la lógica del Service

import com.TiendaSC_403.dao.CategoriaDao;
import com.TiendaSC_403.domain.Categoria;
import com.TiendaSC_403.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//SE HACE EN EL EXÁMEN SI O SI
@Service
public class CategoriaServiceImpl implements CategoriaService {

    //Permtie que cree una ariable de un bojeto, y si no existe este l ocrea
    @Autowired//Dao
    private CategoriaDao categoriaDao;
    
    //Se debe hacer para traer os métodos que se encuentren en el implements
    @Override
    @Transactional(readOnly=true)//Springframework  //readOnly:
    public List<Categoria> getCategorias(boolean activos) {
        //Esto es un objeto
        List<Categoria> lista = categoriaDao.findAll();//trae TODOS los registros de categoría
        
        if(activos){
            //Para remover las categorías donde activo = false     
            lista.removeIf(x -> !x.isActivo());//lista se remueve si:primero se pone un alias, en este caso x           

        }
        
        return lista;
    }

}
