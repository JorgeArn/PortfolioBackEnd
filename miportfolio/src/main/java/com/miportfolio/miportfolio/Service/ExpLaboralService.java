
package com.miportfolio.miportfolio.Service;

import com.miportfolio.miportfolio.Entity.ExpLaboral;
import com.miportfolio.miportfolio.Repository.ExpLaboralRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ExpLaboralService {
    @Autowired
    ExpLaboralRepository expLaboralRepository;
    
    public List<ExpLaboral> list(){
        return expLaboralRepository.findAll();
    }
    
    public Optional<ExpLaboral> getOne(int id){
        return expLaboralRepository.findById(id);
    }
    
    public Optional<ExpLaboral> getByNombreExp(String nombre_empresa){
        return expLaboralRepository.findByNombre_empresa(nombre_empresa);
    }
    
    public void save(ExpLaboral expLab){
        expLaboralRepository.save(expLab);
    }
    
    public void delete(int id) {
        expLaboralRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return expLaboralRepository.existsById(id);
    }
    
    public boolean existByNombreExp(String nombre_empresa) {
        return expLaboralRepository.existByNombre_empresa(nombre_empresa);
    }
}
