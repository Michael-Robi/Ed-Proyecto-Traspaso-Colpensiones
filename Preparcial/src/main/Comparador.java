/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Comparator;
import modelo.Persona;

/**
 *
 * @author SONY
 */
public class Comparador implements Comparator<Persona>{
    @Override
    public int compare(Persona p1,Persona p2){
        
        boolean mayorp1 = p1.getEdad() >= 60;
        boolean mayorp2 = p2.getEdad() >= 60;
        
        if (mayorp1&&!mayorp2) {
            return -1;
        }
        else if (!mayorp1&&mayorp2) {
            return 1;
        }
        
        return Integer.compare(p1.getId(), p2.getId());
    }
}
