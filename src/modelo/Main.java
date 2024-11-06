package modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    // PriorityQueue para los cotizantes no aptos
    private static PriorityQueue<Cotizante> descartarCotizante = new PriorityQueue<>();
    
    // Lista negra para los cotizantes embargados
    private static LinkedList<Cotizante> listaNegra = new LinkedList<>();
    
    // Cola de transferencias
    private static Queue<Cotizante> transpasos = new LinkedList<>();

    public static void main(String[] args) {
        String filePath = "src/files/cotizantes.csv"; // Ruta del archivo CSV
        
        try {
            cargarDatos(filePath);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Imprimir los datos cargados
        System.out.println("Cotizantes no aptos (en PriorityQueue):");
        imprimirCola(descartarCotizante);

        // Imprimir cotizantes de la lista negra
        System.out.println("Cotizantes en lista negra:");
        imprimirLista(listaNegra);
    }

    // Método para cargar datos desde el archivo CSV
    private static void cargarDatos(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(",");
            String nombre = datos[0];
            String id = datos[1];
            int semanasCotizadas = Integer.parseInt(datos[2]);
            String estado = datos[3];
            
            Cotizante cotizante = new Cotizante(nombre, id, semanasCotizadas, estado);
            
            if (estado.equalsIgnoreCase("No Apto")) {
                descartarCotizante.add(cotizante);
            } else if (estado.equalsIgnoreCase("Apto")) {
                cotizanteEmbargado(cotizante);
            }
        }
        
        br.close();
    }

    // Método para procesar cotizantes aptos
    private static void cotizanteEmbargado(Cotizante cotizante) {
        listaNegra.add(cotizante);
        transpasos.add(cotizante);
    }

    // Método para imprimir los elementos de una PriorityQueue
    private static void imprimirCola(PriorityQueue<Cotizante> cola) {
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }

    // Método para imprimir los elementos de una lista
    private static void imprimirLista(LinkedList<Cotizante> lista) {
        for (Cotizante cotizante : lista) {
            System.out.println(cotizante);
        }
    }
}
