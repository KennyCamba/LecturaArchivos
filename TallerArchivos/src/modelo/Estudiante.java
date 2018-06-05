/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author CltControl
 */
public class Estudiante implements Serializable, Comparable<Estudiante> {
    
    private String matricula;
    private String nombre;
    private Carrera carrera;
    private double promedio;

    /**
     * Construnctor de la clase
     * @param matricula
     * @param nombre
     * @param carrera
     * @param promedio 
     */
    public Estudiante(String matricula, String nombre, Carrera carrera, double promedio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombre=" + nombre + ", carrera=" + carrera + ", promedio=" + promedio + '}';
    }

    @Override
    public int compareTo(Estudiante e) {
        if(this.getPromedio() == e.getPromedio()){
            return 0;
        }else if(this.getPromedio() < e.getPromedio()){
            return -1;
        }else{
            return 1;
        }
    }
}
