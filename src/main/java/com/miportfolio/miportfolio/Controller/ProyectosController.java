
package com.miportfolio.miportfolio.Controller;

import com.miportfolio.miportfolio.Dto.dtoProyectos;
import com.miportfolio.miportfolio.Entity.Proyectos;
import com.miportfolio.miportfolio.Security.Controller.Mensaje;
import com.miportfolio.miportfolio.Service.ProyectosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://miportfoliojlarn.web.app")
public class ProyectosController {
    @Autowired 
    ProyectosService proyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }    
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        proyectosService.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(proyectosService.existsByNombre(dtoproyectos.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre de proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = new Proyectos(dtoproyectos.getNombre(), dtoproyectos.getFechaInicio(), dtoproyectos.getFechaFin(),
                                            dtoproyectos.getDescripcion(), dtoproyectos.getUrlProyecto(), dtoproyectos.getUrlImagen());
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        if(!proyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(proyectosService.existsByNombre(dtoproyectos.getNombre()) && proyectosService.getByNombre(dtoproyectos.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }  
        
        if(StringUtils.isBlank(dtoproyectos.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        } 
        
        
        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombre(dtoproyectos.getNombre());
        proyectos.setFechaInicio(dtoproyectos.getFechaInicio());
        proyectos.setFechaFin(dtoproyectos.getFechaFin());
        proyectos.setDescripcion(dtoproyectos.getDescripcion());
        proyectos.setUrlProyecto(dtoproyectos.getUrlProyecto());
        proyectos.setUrlImagen(dtoproyectos.getUrlImagen());
        
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado correctamente"), HttpStatus.OK);
    }
}
