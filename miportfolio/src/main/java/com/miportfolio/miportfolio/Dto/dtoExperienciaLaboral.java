
package com.miportfolio.miportfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import java.time.Year;



public class dtoExperienciaLaboral {
    @NotBlank
    private String nombreEmpresa;
    private Year fechaInicio;
    private Year fechaFin;
    @NotBlank
    private String descripcion;
    private String urlLogo;
    
    //Constructores

    public dtoExperienciaLaboral() {
    }

    public dtoExperienciaLaboral(String nombreEmpresa, Year fechaInicio, Year fechaFin, String descripcion, String urlLogo) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
    }
    
    //Getters and Setters

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
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
