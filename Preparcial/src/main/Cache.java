/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author SONY
 */
import java.util.HashMap;
import java.util.Map;

// Clase que representa una caché con genéricos
public class Cache<K, V> {

    private Map<K, V> cacheMap;

    // Constructor que inicializa el Map
    public Cache() {
        this.cacheMap = new HashMap<>();
    }

    // Método para agregar un elemento a la caché
    public void agregarElemento(K clave, V valor) {
        cacheMap.put(clave, valor);
    }

    // Método para obtener un elemento por su identificador
    public V obtenerElemento(K clave) {
        return cacheMap.get(clave);
    }

    // Método para eliminar un elemento de la caché
    public void eliminarElemento(K clave) {
        cacheMap.remove(clave);
    }

    // Método para verificar si un elemento está en la caché
    public boolean contieneElemento(K clave) {
        return cacheMap.containsKey(clave);
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la caché con Integer como clave y String como valor
        Cache<Integer, String> cache = new Cache<>();
        cache.agregarElemento(1, "Elemento 1");
        cache.agregarElemento(2, "Elemento 2");

        System.out.println("Obtenido: " + cache.obtenerElemento(1));  // "Elemento 1"
        System.out.println("Contiene clave 2: " + cache.contieneElemento(2));  // true

        cache.eliminarElemento(2);
        System.out.println("Contiene clave 2 despues de eliminar: " + cache.contieneElemento(2));  // false
    }
}

