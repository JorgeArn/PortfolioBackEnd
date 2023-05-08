/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfolio.miportfolio.Security.Service;

//UserDetailImp se llama asi por UserDetail Implements

import com.miportfolio.miportfolio.Security.Entity.UsuarioPrincipal;
import com.miportfolio.miportfolio.Security.Entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService {
    @Autowired
    UsuariosService usuariosService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuarios usuarios = usuariosService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuarios);
    }
    
    
}
