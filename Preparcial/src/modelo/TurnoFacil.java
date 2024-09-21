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
public class TurnoFacil implements Comparable<TurnoFacil>{
    public int secuencia;

    public TurnoFacil(int secuencia) {
        this.secuencia = secuencia;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    @Override
    public String toString() {
        return "TurnoFacil{" + "secuencia=" + secuencia + '}';
    }

    @Override
    public int compareTo(TurnoFacil o) {
        return Integer.compare(this.secuencia, o.getSecuencia());
    }
}
