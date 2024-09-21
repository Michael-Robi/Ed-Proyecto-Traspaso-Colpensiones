/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author SONY
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import modelo.TurnoFacil;

public class MainTurnoFacil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PriorityQueue<TurnoFacil> turnos = new PriorityQueue<>();
        
        TurnoFacil turnol = new TurnoFacil(1); 
        TurnoFacil turno15 = new TurnoFacil(15); 
        TurnoFacil turno4 = new TurnoFacil(4); 
        TurnoFacil turno70 = new TurnoFacil(70);
        
        turnos.add(turnol);
        turnos.add(turno15);
        turnos.add(turno4);
        turnos.add(turno70);
        
        System.out.println("El contenido de la PriorityQueue es: "); 
        System.out.println(turnos); 
        System.out.println();
      
        System.out.println("Al recorrer con un foreach obtengo: "); 
        for (TurnoFacil turno: turnos) {
            System.out.println(turno);
        }
        System.out.println();

        // Extraer y mostrar los elementos en orden de prioridad (menor secuencia primero) con poll
        LinkedList<TurnoFacil> listaTurnosFaciles = new LinkedList<>();
        
        while (!turnos.isEmpty()) {
            TurnoFacil turno = turnos.poll();
            listaTurnosFaciles.add(turno);
        }
        
        System.out.println("Al recorrer con un Iterador obtengo: "); 
        Iterator<TurnoFacil> iterador = listaTurnosFaciles.iterator();
        
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
        System.out.println();

    }
    
}
