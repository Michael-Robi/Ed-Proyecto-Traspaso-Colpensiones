package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;

import modelo.Caracterizacion;
import modelo.Solicitante;
import services.EvaluadorCotizantes;

import java.util.HashMap;

    public class Main {
        public static void main(String[] args) {
            
            //Ruta Proyecto
            String rutaDinamicaProyecto = System.getProperty("user.dir");
            //System.out.println("rutaProyecto; "+rutaDinamicaProyecto);
            
            // Ruta de los archivos CSV
            String solicitanteFile = rutaDinamicaProyecto+"\\src\\files\\solicitante.csv";
            String caracterizacionFile = rutaDinamicaProyecto+"\\src\\files\\caracterizacion.csv";

            // Crear una instancia del EvaluadorCotizantes
            EvaluadorCotizantes evaluador = new EvaluadorCotizantes();

            evaluador.cargarDatos(solicitanteFile, caracterizacionFile);

            // Cargar los datos desde los archivos CSV
            // Imprimir los resultados de la clasificaci�n
            evaluador.imprimirResultados();
        }
    }
