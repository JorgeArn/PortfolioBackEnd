
package com.miportfolio.miportfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Year;


@Entity
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nombreEmpresa;
   private Year fechaInicio;
   private Year fechaFin;
   private String descripcion;
   private String urlLogo;
   
   
   //Constructores

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombreEmpresa, Year fechaInicio, Year fechaFin, String descripcion, String urlLogo) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
    }
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
