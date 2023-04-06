package com.miportfolio.miportfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Year;


@Entity 
public class ExpLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String nombre_empresa;
    private Year fecha_inicio;
    private Year fecha_fin;
    private String descripcion;
    private String url_logo;
    
    //constructores

    public ExpLaboral() {
    }

    public ExpLaboral(String nombre_empresa, Year fecha_inicio, Year fecha_fin, String descripcion, String url_logo) {
        this.nombre_empresa = nombre_empresa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
        this.url_logo = url_logo;
    }
    
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
