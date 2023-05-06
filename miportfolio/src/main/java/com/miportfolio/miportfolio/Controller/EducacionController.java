
package com.miportfolio.miportfolio.Controller;

import com.miportfolio.miportfolio.Dto.dtoEducacion;
import com.miportfolio.miportfolio.Entity.Educacion;
import com.miportfolio.miportfolio.Security.Controller.Mensaje;
import com.miportfolio.miportfolio.Service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired 
    EducacionService educacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }    
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        educacionService.delete(id);
        
        return new ResponseEntity(new Mensaje("Educacion eliminada correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(educacionService.existsByNombre(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(dtoeducacion.getNombre(), dtoeducacion.getFechaInicio(), dtoeducacion.getFechaFin(),
                                            dtoeducacion.getDescripcion(), dtoeducacion.getUrlLogo());
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(educacionService.existsByNombre(dtoeducacion.getNombre()) && educacionService.getByNombre(dtoeducacion.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }  
        
        if(StringUtils.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre de la educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }    
        
        Educacion educacion = educacionService.getOne(id).get();
        educacion.setNombre(dtoeducacion.getNombre());
        educacion.setFechaInicio(dtoeducacion.getFechaInicio());
        educacion.setFechaFin(dtoeducacion.getFechaFin());
        educacion.setDescripcion(dtoeducacion.getDescripcion());
        educacion.setUrlLogo(dtoeducacion.getUrlLogo());
        
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion modificada correctamente"), HttpStatus.OK);
    }
}
