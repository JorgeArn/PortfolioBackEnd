
package com.miportfolio.miportfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Year;


@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Year fechaInicio;
    private Year fechaFin;
    private String descripcion;
    private String urlImagen;
    
    //Constructores

    public Proyectos() {
    }

    public Proyectos(String nombre, Year fechaInicio, Year fechaFin, String descripcion, String urlImagen) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }
    
    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Year getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Year fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Year getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Year fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
}
