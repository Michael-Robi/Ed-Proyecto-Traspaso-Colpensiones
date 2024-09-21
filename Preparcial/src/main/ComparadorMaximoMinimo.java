/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author SONY
 */
public class ComparadorMaximoMinimo <T extends Comparable<T>>{
    private T elemento1;
    private T elemento2;

    public ComparadorMaximoMinimo(T elemento1, T elemento2) {
        this.elemento1 = elemento1;
        this.elemento2 = elemento2;
    }
    
    // Método que retorna el elemento máximo
    public T max() {
        return (elemento1.compareTo(elemento2) > 0) ? elemento1 : elemento2;
    }

    // Método que retorna el elemento mínimo
    public T min() {
        return (elemento1.compareTo(elemento2) < 0) ? elemento1 : elemento2;
    }

    public static void main(String[] args) {
        // Ejemplo de uso con números enteros
        ComparadorMaximoMinimo<Integer> comparadorInt;
        comparadorInt = new ComparadorMaximoMinimo<>(5, 10);
        System.out.println("Maximo: " + comparadorInt.max());
        System.out.println("Minimo: " + comparadorInt.min());

        // Ejemplo de uso con cadenas de texto
        ComparadorMaximoMinimo<String> comparadorStr;
        comparadorStr = new ComparadorMaximoMinimo<>("Manzana", "Banana");
        System.out.println("Maximo: " + comparadorStr.max());
        System.out.println("Minimo: " + comparadorStr.min());
    }
}
