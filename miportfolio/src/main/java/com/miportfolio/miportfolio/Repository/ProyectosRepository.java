

package com.miportfolio.miportfolio.Repository;

import com.miportfolio.miportfolio.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos > findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
