/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author SONY
 */
import java.util.PriorityQueue;
import modelo.Turno;

public class CreadorTurnos {

    public PriorityQueue<Turno> obtenerTurnosVuelosNacionales() {
        PriorityQueue<Turno> turnosNacio = new PriorityQueue<>();
        Turno turno3 = new Turno(6,false);
        Turno turno1 = new Turno(4,false);
        Turno turno2 = new Turno(1,true);
        turnosNacio.add(turno1);
        turnosNacio.add(turno2);
        turnosNacio.add(turno3);
        return turnosNacio;
    }

    public PriorityQueue<Turno> obtenerTurnosVuelosInternacionales() {
        PriorityQueue<Turno> turnosInter = new PriorityQueue<>();
        Turno turno1 = new Turno(3,false);
        Turno turno2 = new Turno(2,true);
        Turno turno3 = new Turno(5,true);
        turnosInter.add(turno1);
        turnosInter.add(turno2);
        turnosInter.add(turno3);
        return turnosInter;
    }
}

