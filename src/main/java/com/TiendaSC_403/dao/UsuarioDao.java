package com.TiendaSC_403.dao;

import com.TiendaSC_403.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username); //Buscar usuario por username, no lista porque no se repite y es único
    
}
