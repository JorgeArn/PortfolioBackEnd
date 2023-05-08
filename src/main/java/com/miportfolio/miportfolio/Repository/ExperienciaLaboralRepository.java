
package com.miportfolio.miportfolio.Repository;

import com.miportfolio.miportfolio.Entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer> {
    public Optional<ExperienciaLaboral> findByNombreEmpresa(String nombreEmpresa);
    public boolean existsByNombreEmpresa(String nombreEmpresa);
}
