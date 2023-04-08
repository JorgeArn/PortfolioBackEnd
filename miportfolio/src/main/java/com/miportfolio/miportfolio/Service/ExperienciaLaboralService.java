
package com.miportfolio.miportfolio.Service;

import com.miportfolio.miportfolio.Entity.ExperienciaLaboral;
import com.miportfolio.miportfolio.Repository.ExperienciaLaboralRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ExperienciaLaboralService {
    @Autowired
    ExperienciaLaboralRepository experienciaLaboralRepository;
    
    public List<ExperienciaLaboral> list(){
        return experienciaLaboralRepository.findAll();
    }
    
    public Optional<ExperienciaLaboral> getOne(int id){
        return experienciaLaboralRepository.findById(id);
    }
    
    public Optional<ExperienciaLaboral> getByNombreEmpresa(String nombreEmpresa){
        return experienciaLaboralRepository.findByNombreEmpresa(nombreEmpresa);
    }
    
    public void save(ExperienciaLaboral expLaboral){
        experienciaLaboralRepository.save(expLaboral);
    }
    
    public void delete(int id){
        experienciaLaboralRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return experienciaLaboralRepository.existsById(id);
    }
    
    public boolean existsByNombreEmpresa(String nombreEmpresa){
        return experienciaLaboralRepository.existsByNombreEmpresa(nombreEmpresa);
    }
}
