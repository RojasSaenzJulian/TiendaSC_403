package com.TiendaSC_403.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller /*Esto se llama anotación*/
public class IndexController {
    
//    mapping:URL a los que responde
   
    @RequestMapping("/")
    public String page(Model model, HttpSession session) {
        model.addAttribute("mensaje", "Hola desde el controlador");
        //qué vista se tiene que msotrar, NO son als de static, son las de tempaltes
        String imagen = (String) session.getAttribute("usuarioImagen");
        model.addAttribute("avatar", imagen);
        return "index";
    }
    
}
