/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import modelo.Estudiante;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Carrera;
/**
 *
 * @author Kenny Camba Torres
 */
public class EstudianteDataTexto {
    
    private String filename;
    private final String FILE_CARRERA = "src/recurso/carrera.txt";
    
    /**
     * Constructor de la calse
     * @param filename 
     */
    public EstudianteDataTexto(String filename){
        this.filename = filename;
    }
    
    /**
     * Lee los estudiante que estan en el filname
     * @return List;
     */
    public List<Estudiante> leerEstudiantes(){
        ArrayList<Estudiante> estudiantes = null;
        
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            estudiantes = new ArrayList<>();
            String line;
            while((line = br.readLine()) != null){
                String[] e = line.split(",");
                Carrera carrera = null;
                ArrayList<Carrera> carreras = (ArrayList)new CarreraDataTexto(FILE_CARRERA).leerCarreras();
                
                for(Carrera c: carreras){
                    if(c.getCodigo().equals(e[2])){
                        carrera = c;
                    }
                }
                estudiantes.add(new Estudiante(e[0], e[1], carrera, Double.parseDouble(e[3])));
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return estudiantes;
    }
    
    /**
     * Retorna un estudiante con el numero de matricula dado.
     * Devuelve null si el estudiante no existe
     * @param numeroMatricula
     * @return Estudiante
     */
    public Estudiante buscarEstudiante(String numeroMatricula){
        List<Estudiante> estudiantes = this.leerEstudiantes();
        for(Estudiante e: estudiantes){
            if(e.getMatricula().equals(numeroMatricula)){
                return e;
            }
        }
        return null;
    }
    
    /**
     * Escribe estudiantes en el filename
     * @param estudiantes 
     */
    public void escribirEstudiantes(List<Estudiante> estudiantes){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Estudiante e: estudiantes){
                String line = e.getMatricula()+", "+e.getNombre()+ ", "+ e.getCarrera().getCodigo()+", "+e.getPromedio();
                bw.write(line);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
