
package com.miportfolio.miportfolio.Dto;


import javax.validation.constraints.NotBlank;



public class dtoExperienciaLaboral {
    @NotBlank
    private String nombreEmpresa;
    private String fechaInicio;
    private String fechaFin;
    @NotBlank
    private String descripcion;
    private String urlLogo;
    
    //Constructores

    public dtoExperienciaLaboral() {
    }

    public dtoExperienciaLaboral(String nombreEmpresa, String fechaInicio, String fechaFin, String descripcion, String urlLogo) {
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

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
    
}
