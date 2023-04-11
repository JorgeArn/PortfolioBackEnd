
package com.miportfolio.miportfolio.Controller;

import com.miportfolio.miportfolio.Entity.Persona;
import com.miportfolio.miportfolio.Interface.IPersonaService;
import java.sql.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    //trae una lista de personas
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
    
    //crea una persona
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente"; 
    }
    
    //borra una persona
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //modifica o edita una persona por id
    //URL:PUERTO/personas/editar/4/nombre & apellido & fechaNac & etc.
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("fechaNac") Date nuevaFechaNac,
                               @RequestParam("acerca_de") String nuevoAcercaDe,
                               @RequestParam("url_foto") String nuevaUrlFoto,
                               @RequestParam("correo") String nuevoCorreo){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setFechaNac(nuevaFechaNac);
        persona.setAcerca_de(nuevoAcercaDe);
        persona.setUrl_foto(nuevaUrlFoto);
        persona.setCorreo(nuevoCorreo);
        
        ipersonaService.savePersona(persona);
        return persona;
        
    }
    
    //trae o selecciona una persona
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
}
