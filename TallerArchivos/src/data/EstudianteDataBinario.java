/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;

/**
 *
 * @author Kenny Camba Torres
 */
public class EstudianteDataBinario {
    
    private String filename;
    
    public EstudianteDataBinario(String filename){
        this.filename = filename;
    }
    
    public void escribirEstudiantes(List<Estudiante> estudiantes){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))){
            os.writeObject(estudiantes);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public List<Estudiante> leerEstudiantes() {
        ObjectInputStream oi = null;
        ArrayList<Estudiante> estudiantes = null;
        try{
            oi = new ObjectInputStream(new FileInputStream(filename));
            try{
                while(true){
                    estudiantes = (ArrayList)oi.readObject();
                }
            }catch(EOFException e){
                System.out.println("Fin del archivo");
            }catch(ClassNotFoundException e){
                System.out.println("Archivo corrupto");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                oi.close();
            }catch(IOException e){
                System.err.println(e.getMessage());
            }
        }
        return estudiantes;
    }
}
