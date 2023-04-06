
package com.miportfolio.miportfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import java.time.Year;



public class DtoExpLaboral {
    @NotBlank
    private String nombre_empresa;
    
    @NotBlank
    private Year fecha_inicio;
    
    private Year fecha_fin;
    
    @NotBlank
    private String descripcion;
 
    private String url_logo;
    
    //constructores

    public DtoExpLaboral() {
    }

    public DtoExpLaboral(String nombre_empresa, Year fecha_inicio, Year fecha_fin, String descripcion, String url_logo) {
        this.nombre_empresa = nombre_empresa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
        this.url_logo = url_logo;
    }
    
    //getters and setters

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public Year getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Year fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Year getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Year fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }
    
}
