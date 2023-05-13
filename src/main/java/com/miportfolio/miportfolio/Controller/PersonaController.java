
package com.miportfolio.miportfolio.Controller;

import com.miportfolio.miportfolio.Dto.dtoPersona;
import com.miportfolio.miportfolio.Entity.Persona;
import com.miportfolio.miportfolio.Security.Controller.Mensaje;
import com.miportfolio.miportfolio.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://miportfoliojlarn.web.app")
public class PersonaController {
    @Autowired 
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }    
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(personaService.existsByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido(), dtopersona.getFechaNac(),
                                            dtopersona.getAcerca_de(), dtopersona.getUrl_foto());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona creada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }  
        
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre de la persona es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopersona.getApellido())){
            return new ResponseEntity(new Mensaje("El apellido de la persona es obligatorio"), HttpStatus.BAD_REQUEST);
        }   
        
        if(StringUtils.isBlank(dtopersona.getAcerca_de())){
            return new ResponseEntity(new Mensaje("La descripción de la persona es obligatoria"), HttpStatus.BAD_REQUEST);
        } 
        
        if(StringUtils.isBlank(dtopersona.getUrl_foto())){
            return new ResponseEntity(new Mensaje("La foto de la persona es obligatoria"), HttpStatus.BAD_REQUEST);
        }    
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setFechaNac(dtopersona.getFechaNac());
        persona.setAcerca_de(dtopersona.getAcerca_de());
        persona.setUrl_foto(dtopersona.getUrl_foto());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona modificada correctamente"), HttpStatus.OK);
    }
}
