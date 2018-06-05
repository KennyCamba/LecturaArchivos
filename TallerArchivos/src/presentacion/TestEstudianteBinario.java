/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import data.CarreraDataTexto;
import data.EstudianteDataBinario;
import data.EstudianteDataTexto;
import java.util.ArrayList;
import java.util.Collections;
import modelo.Estudiante;
import java.util.Scanner;
import modelo.Carrera;

/**
 *
 * @author Kenny Camba Torres
 */
public class TestEstudianteBinario {
    static String path = "src/recurso";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EstudianteDataTexto et = new EstudianteDataTexto(path+"/estudiantes.txt");
        ArrayList<Estudiante> estudiantes = 
                (ArrayList)et.leerEstudiantes();
        new EstudianteDataBinario(path+"/estudiantes.dat").escribirEstudiantes(estudiantes);
        
        ArrayList<Estudiante> es = (ArrayList)et.leerEstudiantes();
        Carrera carrera = null;
        System.out.println("Nuevo estudiante...");
        System.out.print("Matricula: ");
        String matricula = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Codigo carrera: ");
        String codigo = sc.nextLine();
        System.out.print("Promedio: ");
        Double promedio = sc.nextDouble();
        sc.nextLine();
        ArrayList<Carrera> carreras = (ArrayList)new CarreraDataTexto(path+"/carrera.txt").leerCarreras();
        for(Carrera c: carreras){
            if(c.getCodigo().equals(codigo)){
                carrera = c;
            }
        }
        es.add(new Estudiante(matricula, nombre, carrera, promedio));
        
        Collections.sort(es);
        for(Estudiante e: es){
            System.out.println(e);
        }
    }
}
