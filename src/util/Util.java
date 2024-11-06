package util;
import java.util.LinkedList;
import java.util.PriorityQueue;

import modelo.Cotizante;

public class Util {

    // M�todo para imprimir los elementos de una PriorityQueue
    public static void imprimirCola(PriorityQueue<Cotizante> cola) {
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }

    // M�todo para imprimir los elementos de una lista
    public static void imprimirLista(LinkedList<Cotizante> lista) {
        for (Cotizante cotizante : lista) {
            System.out.println(cotizante);
        }
    }
}
