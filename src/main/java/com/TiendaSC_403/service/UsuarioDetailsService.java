package com.TiendaSC_403.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioDetailsService {
    //Metodo
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException; //recibe el user name
    
}
