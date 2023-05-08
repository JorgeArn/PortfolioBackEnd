/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfolio.miportfolio.Security.Service;

import com.miportfolio.miportfolio.Security.Entity.Usuarios;
import com.miportfolio.miportfolio.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UsuariosService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuarios> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByCorreo(String correo){
        return iusuarioRepository.existsByCorreo(correo);
    }
    
    public void save(Usuarios usuarios){
        iusuarioRepository.save(usuarios); 
    }
}
