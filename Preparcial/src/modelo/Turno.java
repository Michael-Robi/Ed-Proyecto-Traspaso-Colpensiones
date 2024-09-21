/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author SONY
 */
import java.util.*;
import java.util.SortedSet;

public class Turno implements Comparable<Turno>{
    
    public int secuencia;
    public boolean despachado;
    
    public Turno(int secuencia, boolean atendido) {
        this.secuencia = secuencia;
        this.despachado = atendido;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public boolean getDespachado() {
        return despachado;
    }

    public void setDespachado(boolean despachado) {
        this.despachado = despachado;
    }

    @Override
    public int compareTo(Turno o) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
//        if(this.secuencia<o.getSecuencia()){
//            return -1;
//        }
//        if(this.secuencia>o.getSecuencia()){
//            return 1;
//        }
//            return 0;
            
//        return Integer.compare(this.secuencia, o.getSecuencia()); // Ordenar por ID
        return this.secuencia - o.getSecuencia(); // Ordenar por ID
    }

    @Override
    public String toString() {
        return "Turno{" + "secuencia=" + secuencia + ", despachado=" + despachado + '}';
    }
}
