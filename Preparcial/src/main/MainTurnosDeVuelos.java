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
import java.util.Collection;
import java.util.*;
import modelo.Turno;
import prueba.CreadorTurnos;

public class MainTurnosDeVuelos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //1) Crear PQ
        CreadorTurnos gestorTu= new CreadorTurnos ();
        PriorityQueue<Turno> turnosNacio = gestorTu.obtenerTurnosVuelosNacionales(); 
        PriorityQueue<Turno> turnosInter = gestorTu.obtenerTurnosVuelosInternacionales();
        
        //2) Crear SET(o|)
        Collection<Turno> turnosordenados = imprimirTurnosOrdenados(turnosNacio, turnosInter); 
        
        //3) CO^(PY)
        LinkedList<Turno> turnosNoDespachados = imprimirTurnosAtendidos(turnosordenados); 
        
        //4) a(ll^)
        Turno [] turnosRecienDespachados = atenderTurnosPorLasPuntas(turnosNoDespachados); 
        
        //Imprimir
        imprimirTurnosRecienAtendidos(turnosRecienDespachados);

    }
    
    public static Set<Turno> imprimirTurnosOrdenados(Queue<Turno> turnosNacio, Queue<Turno> turnosInter) // Pasar las Queue a una estructura de datos ordenada de java
    {
        // Iterar con un iterator{
        // En cada iteración imprimir el Turno con un syso
        //}
//        return null; // Retornar la estructura de datos ordenada
        // Usamos TreeSet para mantener los turnos ordenados
        SortedSet<Turno> listaOrdenados = new TreeSet<>();
        
        // Añadimos todos los turnos de ambas colas al TreeSet
        listaOrdenados.addAll(turnosNacio);
        listaOrdenados.addAll(turnosInter);

        // Creamos el iterador para recorrer los turnos ordenados
        Iterator<Turno> ilistaOrdenados = listaOrdenados.iterator();
        
        // Iteramos sobre el conjunto ordenado e imprimimos cada turno
        //sout comando syso
        System.out.println("Ordenar Turnos");
        while (ilistaOrdenados.hasNext()) {
            Turno turno = ilistaOrdenados.next();
            System.out.println(turno);
        }

        // Devolvemos el conjunto ordenado
        return listaOrdenados;
        
    }
    
    public static LinkedList<Turno> imprimirTurnosAtendidos(Collection<Turno> turnosAtendidos) 
    { // Pasar la Collection turnosAtendidos a una List para poder utilizar un ListIterator
    // Iterar con un listIterator [
    // En cada iteración imprimir el turno si ya está despachado. 
    // En cada iteración remover el turno si ya está despachado.
//        return null; // Retornar los turnos sin despachar.
        
        // Usamos LinkedList para mantener los turnos despachados
        LinkedList<Turno> listaVuelosActuales = new LinkedList<>();
        listaVuelosActuales.addAll(turnosAtendidos);
        
        // Creamos el ListIterator para recorrer los turnos en la lista original
        ListIterator<Turno> ilistaVuelosActuales= listaVuelosActuales.listIterator();
        
        // Iteramos sobre la lista original
        System.out.println("\nVerificar Vuelos Despachados");
        while (ilistaVuelosActuales.hasNext()) {
            Turno turno = ilistaVuelosActuales.next();  // Obtenemos el siguiente elemento
            
            if (turno.getDespachado()) {
                // Si el turno está despachado, lo eliminamos de la lista original y lo añadimos a la nueva lista
                ilistaVuelosActuales.remove();  // Eliminar de turnosAtendidos
                System.out.println("Turno eliminado: " + turno);
            }
            
        }

        // Imprimir los turnos restantes
        System.out.println("Vuelos sin Despachar:");
        for (Turno turno : listaVuelosActuales) {
            System.out.println(turno);
        }

        // Devolver la lista de turnos atendidos (sin los eliminados)
        return listaVuelosActuales;
    }
    
    // Atender turnos pendientes
    public static Turno[] atenderTurnosPorLasPuntas(LinkedList<Turno> turnos) { 
        // Crear un arreglo de turnos, el arreglo es de tamaño 2.
        // Atender el último turno del LinkedList y guardarlo en el arreglo. 
        // Atender el primer turno del LinkedList y guardarlo en el arreglo.

//        return null; // Retornar el arreglo.

        Turno[] turnos2 = new Turno[2];
        
        Turno ultimo = turnos.pollLast();
        Turno primero = turnos.pollFirst();
        
        turnos2[0] = ultimo;
        turnos2[1] = primero;

        return turnos2;
    }
    
    public static void imprimirTurnosRecienAtendidos (Turno [] turnos) { 
        // Recorrer el arreglo de turnos e imprimirlo.
//        for (Turno turno : turnos) {
//            System.out.print(turno);
//        }
        
        System.out.println("\nImprimir los extremos de la lista en un array");
        for (int i = 0; i < turnos.length; i++) {
            System.out.println(turnos[i]); 
        }
    }

}
