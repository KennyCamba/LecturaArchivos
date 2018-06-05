/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerarchivos;

import data.CarreraDataTexto;
import java.util.List;
import modelo.Carrera;


/**
 *
 * @author CltControl
 */
public class TallerArchivos {
    static String path = "src/recurso";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarreraDataTexto cdt = new CarreraDataTexto(path+"/carrera.txt");
        List<Carrera> ca = cdt.leerCarreras();
        
        for(Carrera c: ca){
            System.out.println(c);
        }
        
        ca.add(new Carrera("0003", "Ing Telecomunicacines"));
        cdt.escribirCarreras(ca);
    }
    
}
