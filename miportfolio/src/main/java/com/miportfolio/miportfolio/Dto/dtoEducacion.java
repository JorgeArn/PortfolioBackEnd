
package com.miportfolio.miportfolio.Dto;


import com.miportfolio.miportfolio.Entity.Persona;
import javax.validation.constraints.NotBlank;



public class dtoEducacion {
    @NotBlank
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    @NotBlank
    private String descripcion;
    private String urlLogo;
    private Persona persona_id;
    
    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String nombre, String fechaInicio, String fechaFin, String descripcion, String urlLogo, Persona persona_id) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
        this.persona_id = persona_id;
    }
    
    //Getter and Setters

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

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
    
    public Persona getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Persona persona_id) {
        this.persona_id = persona_id;
    }
}
