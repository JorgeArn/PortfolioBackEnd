
package com.miportfolio.miportfolio.Controller;

import com.miportfolio.miportfolio.Dto.dtoExperienciaLaboral;
import com.miportfolio.miportfolio.Entity.ExperienciaLaboral;
import com.miportfolio.miportfolio.Security.Controller.Mensaje;
import com.miportfolio.miportfolio.Service.ExperienciaLaboralService;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "https://miportfoliojlarn.web.app")
public class ExperienciaLaboralController {
    @Autowired
    ExperienciaLaboralService experienciaLaboralService;
    
    //Trae una lista de las experiencias laborales
    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list(){
        List<ExperienciaLaboral> list = experienciaLaboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //Trae una experiencia laboral por id
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id){
        if(!experienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        ExperienciaLaboral experienciaLaboral = experienciaLaboralService.getOne(id).get();
        return new ResponseEntity(experienciaLaboral, HttpStatus.OK);
    }
    
    //Crea una nueva experiencia laboral
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoExperienciaLaboral dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaLaboralService.existsByNombreEmpresa(dtoexp.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("Esa experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(dtoexp.getNombreEmpresa(), dtoexp.getFechaInicio(), dtoexp.getFechaFin(), dtoexp.getDescripcion(), dtoexp.getUrlLogo());
        experienciaLaboralService.save(experienciaLaboral);
        
        return new ResponseEntity(new Mensaje("Experiencia laboral agregada correctamente"), HttpStatus.OK);
    }
    
    //Edita una experiencia laboral
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperienciaLaboral dtoexp){
        //Validacion si existe el ID
        if(!experienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias laborales
        if(experienciaLaboralService.existsByNombreEmpresa(dtoexp.getNombreEmpresa()) && experienciaLaboralService.getByNombreEmpresa(dtoexp.getNombreEmpresa()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral experienciaLaboral = experienciaLaboralService.getOne(id).get();
        experienciaLaboral.setNombreEmpresa(dtoexp.getNombreEmpresa());
        experienciaLaboral.setFechaInicio(dtoexp.getFechaInicio());
        experienciaLaboral.setFechaFin(dtoexp.getFechaFin());
        experienciaLaboral.setDescripcion(dtoexp.getDescripcion());
        experienciaLaboral.setUrlLogo(dtoexp.getUrlLogo());
        
        experienciaLaboralService.save(experienciaLaboral);
        return new ResponseEntity(new Mensaje("La experiencia laboral fue modificada correctamente"), HttpStatus.OK);
    }
    
    //Elimina una experiencia laboral
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        experienciaLaboralService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia laboral eliminada"), HttpStatus.OK);
    }
}
