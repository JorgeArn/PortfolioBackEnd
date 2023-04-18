
package com.miportfolio.miportfolio.Dto;

import javax.validation.constraints.NotBlank;





public class dtoSkills {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    
    //Constructores

    public dtoSkills() {
    }

    public dtoSkills(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
    
    //Getter and Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}

