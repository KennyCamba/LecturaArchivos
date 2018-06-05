/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Carrera;

/**
 *
 * @author CltControl
 */
public class CarreraDataTexto {
    
    private String filename;
   
    /**
     * Constructor de la clase
     * @param filename 
     */
    public CarreraDataTexto(String filename){
        this.filename = filename;
    }
    
    /**
     * Lee las carreras en el filename
     * @return List
     */
    public List<Carrera> leerCarreras(){
        
        ArrayList<Carrera> carreras = new ArrayList<>();
        try(BufferedReader buffer = new BufferedReader(new FileReader(filename))){
            String line;
        
            while((line = buffer.readLine()) != null){
                String[] carreraText = line.split(",");
                carreras.add(new Carrera(carreraText[0], carreraText[1].replace(" ", "")));
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return carreras;
    } 
    
    /**
     * Escribe carreras en el filename
     * @param carreras 
     */
    public void escribirCarreras(List<Carrera> carreras){
       
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Carrera ca: carreras){
                String line = ca.getCodigo()+", "+ca.getNombre();
                bw.write(line);
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
