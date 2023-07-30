package com.TiendaSC_403.service.impl;

import com.TiendaSC_403.dao.UsuarioDao;
import com.TiendaSC_403.domain.Rol;
import com.TiendaSC_403.domain.Usuario;
import com.TiendaSC_403.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDtailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Buscar en DB el usuario
        Usuario usuario = usuarioDao.findByUsername(username);

        
        if(usuario == null){
            throw new UsernameNotFoundException("El usuario" + username+ " no existe");
        }
        
        //Variables de sesión
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //Extraer los roles
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol rol : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(usuario.getUsername(),usuario.getPassword(), roles);
    }
    
}
