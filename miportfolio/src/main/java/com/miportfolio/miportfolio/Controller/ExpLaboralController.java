
package com.miportfolio.miportfolio.Controller;

import com.miportfolio.miportfolio.Dto.DtoExpLaboral;
import com.miportfolio.miportfolio.Entity.ExpLaboral;
import com.miportfolio.miportfolio.Security.Controller.Mensaje;
import com.miportfolio.miportfolio.Service.ExpLaboralService;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpLaboralController {
    @Autowired
    ExpLaboralService expLaboralService;
    
    //trae una lista de experiencias laborales
    @GetMapping("/lista")
    public ResponseEntity<List<ExpLaboral>> list(){
        List<ExpLaboral> list = expLaboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
   
    //crea una experiencia laboral
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExpLaboral dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombre_empresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expLaboralService.existByNombreExp(dtoExp.getNombre_empresa()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        ExpLaboral expLaboral = new ExpLaboral(dtoExp.getNombre_empresa(), dtoExp.getFecha_inicio(), dtoExp.getFecha_fin(),
                                                dtoExp.getDescripcion(), dtoExp.getUrl_logo());
        expLaboralService.save(expLaboral);
        
        return new ResponseEntity(new Mensaje("Experiencia laboral agregada"), HttpStatus.OK);
    }
    
    //edita una experiencia laboral
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExpLaboral dtoExp){
        //validamos si existe el ID
        if(!expLaboralService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //compara nombre de experiencias
        if(expLaboralService.existByNombreExp(dtoExp.getNombre_empresa()) && expLaboralService.getByNombreExp(dtoExp.getNombre_empresa()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        //no puede estar vacio
        if(StringUtils.isBlank(dtoExp.getNombre_empresa()))
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExpLaboral expLaboral = expLaboralService.getOne(id).get();
        expLaboral.setNombre_empresa(dtoExp.getNombre_empresa());
        expLaboral.setFecha_inicio(dtoExp.getFecha_inicio());
        expLaboral.setFecha_fin(dtoExp.getFecha_fin());
        expLaboral.setDescripcion(dtoExp.getDescripcion());
        expLaboral.setUrl_logo(dtoExp.getUrl_logo());
        
        expLaboralService.save(expLaboral);
        return new ResponseEntity(new Mensaje("Experiencia laboral actualizada"), HttpStatus.OK);
    }
    
    //elimina una experiencia laboral
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //validamos si el ID existe
        if(!expLaboralService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        expLaboralService.delete(id);
        return new ResponseEntity(new Mensaje("La experiencia laboral fue eliminada correctamente"), HttpStatus.OK);
    }
    
}
