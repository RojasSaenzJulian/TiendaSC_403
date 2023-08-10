package com.TiendaSC_403.controller;

import com.TiendaSC_403.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller /*Esto se llama anotación*/
public class IndexController {
    
//    mapping:URL a los que responde
   @Autowired
    ProductoService productoService;
   
   @RequestMapping("/")
    public String page(Model model, HttpSession session) { 
        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        return "index";
    }
   
//    @RequestMapping("/")
//    public String page(Model model, HttpSession session) {
//        model.addAttribute("mensaje", "Hola desde el controlador");
//        //qué vista se tiene que msotrar, NO son als de static, son las de tempaltes
//        String imagen = (String) session.getAttribute("usuarioImagen");
//        model.addAttribute("productos", imagen);
//        return "index";
//    }
    
}
