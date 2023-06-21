package com.TiendaSC_403.controller;

import com.TiendaSC_403.domain.Categoria;
import com.TiendaSC_403.service.CategoriaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@Controller
@Slf4j //permite crear logs, para asegurar que entramos a un método
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;//Solo quiero conocer los metodos de Service, no SImpl
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        log.info("Consumiendo el recurso /categoria/listado");
        List<Categoria> categorias = categoriaService.getCategorias(false);
        
        //primero alias, luego el valor, en este caso el objeto
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());//size: devuelve cant de elementos que tiene
        return "/categoria/listado";
    }
    
}
