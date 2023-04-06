
package com.miportfolio.miportfolio.Repository;

import com.miportfolio.miportfolio.Entity.ExpLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpLaboralRepository extends JpaRepository<ExpLaboral, Integer> {
    public Optional<ExpLaboral> findByNombre_empresa(String nombre_empresa);
    public Boolean existByNombre_empresa(String nombre_empresa);
    
}
