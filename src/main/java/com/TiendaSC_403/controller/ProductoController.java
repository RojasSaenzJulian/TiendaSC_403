package com.TiendaSC_403.controller;

import com.TiendaSC_403.domain.Categoria;
import com.TiendaSC_403.domain.Producto;
import com.TiendaSC_403.service.CategoriaService;
import com.TiendaSC_403.service.ProductoService;
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
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;
    
    @Autowired//pa obtener las categorias
    CategoriaService categoriaService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        log.info("Consumiendo el recurso /producto/listado");
        List<Producto> productos = productoService.getProductos(false);
        //se crea lista de categ
        List<Categoria> categorias = categoriaService.getCategorias(true);

        model.addAttribute("productos", productos);
        //se crea model de categ
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalProductos", productos.size());
        return "/producto/listado";
    }
     @GetMapping("/nuevo")//lo unico que va a ahcer es inyectar catgria vacio y retornar una vista que se llama modifica
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        return "/producto/modifica";
    }
    
}
