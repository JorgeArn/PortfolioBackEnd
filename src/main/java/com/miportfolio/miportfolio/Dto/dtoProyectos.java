
package com.miportfolio.miportfolio.Dto;

import java.time.Year;
import javax.validation.constraints.NotBlank;




public class dtoProyectos {
    @NotBlank
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    private String urlImagen;
    
    //Contructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String fechaInicio, String fechaFin, String descripcion, String urlImagen) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }
    
    //Getter and Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
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
