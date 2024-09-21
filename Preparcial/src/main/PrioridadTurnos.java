/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import modelo.*;

/**
 *
 * @author SONY
 */
public class PrioridadTurnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Persona> listaP = new ArrayList<>();
        listaP.add(new Persona(2,"carlos",67));
        listaP.add(new Persona(1,"carlos2",65));
        listaP.add(new Persona(3,"carlos1",60));
        
        //Llamar Clase
        Comparador comparadorPersona = new Comparador();
        
        Collections.sort(listaP,comparadorPersona);
        
        Iterator<Persona> itPersona = listaP.iterator();
        
        while (itPersona.hasNext()) {
            Persona p = itPersona.next();
            
            if(p.getId()==2){
                itPersona.remove();
            }
        }
        
        for (Persona persona : listaP) {
            System.out.println(persona);
        }
    }
    
}
