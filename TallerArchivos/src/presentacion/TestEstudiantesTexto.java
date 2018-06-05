/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import data.EstudianteDataTexto;
import java.util.Collections;
import java.util.List;
import modelo.Estudiante;

/**
 *
 * @author Municipio de Gye
 */
public class TestEstudiantesTexto {
    static String path = "src/recurso";
    public static void main(String[] args) {
        EstudianteDataTexto edt = new EstudianteDataTexto(path+"/estudiantes.txt");
        List<Estudiante> estudiantes = edt.leerEstudiantes();
        Collections.sort(estudiantes);
        for(Estudiante e: estudiantes){
            System.out.println(e);
        }
    }
}
