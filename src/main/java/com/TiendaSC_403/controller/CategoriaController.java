package com.TiendaSC_403.controller;

import com.TiendaSC_403.domain.Categoria;
import com.TiendaSC_403.service.CategoriaService;
import com.TiendaSC_403.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j //permite crear logs, para asegurar que entramos a un método
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;//Solo quiero conocer los metodos de Service, no SImpl
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        log.info("Consumiendo el recurso /categoria/listado");
        List<Categoria> categorias = categoriaService.getCategorias(false);
        
        //primero alias, luego el valor, en este caso el objeto
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());//size: devuelve cant de elementos que tiene
        return "/categoria/listado";
    }
     @GetMapping("/nuevo")//lo unico que va a ahcer es inyectar catgria vacio y retornar una vista que se llama modifica
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modifica";
    }
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            categoria.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            categoria.getIdCategoria()));
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
    
}
