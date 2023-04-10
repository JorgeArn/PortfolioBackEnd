
package com.miportfolio.miportfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import java.time.Year;



public class dtoEducacion {
    @NotBlank
    private String nombre;
    private Year fechaInicio;
    private Year fechaFin;
    @NotBlank
    private String descripcion;
    private String urlLogo;
    
    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String nombre, Year fechaInicio, Year fechaFin, String descripcion, String urlLogo) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
    }
    
    //Getter and Setters

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

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
    
}
