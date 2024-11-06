package services;

import modelo.Solicitante;
import modelo.Caracterizacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import modelo.Solicitante;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class EvaluadorCotizantes {
    private LinkedList<Solicitante> aceptados = new LinkedList<>();
    private LinkedList<Solicitante> rechazados = new LinkedList<>();
    private LinkedList<Solicitante> procesarCivil = new LinkedList<>();//lista auxiliar
    private LinkedList<Solicitante> listaNegra = new LinkedList<>();

    //Lsta Auxiliar
    private LinkedList<String> listaAuxiliar = new LinkedList<>();
    
    public void cargarDatos(String datosBasicosFile, String caracterizacionFile) {
        leerDatossolicitud(datosBasicosFile);
        leerCaracterizaciones(caracterizacionFile);
    }

    private void leerDatossolicitud(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Omitir la cabecera
            br.readLine(); // Esta l�nea omite la primera l�nea (cabecera)

            while ((line = br.readLine()) != null) {
                String[] campos = line.split(",");

                // Asegurarse de que la l�nea contiene la cantidad correcta de campos
                if (campos.length != 10) {
                    System.err.println("L�nea inv�lida en datos b�sicos: " + line);
                    continue; // Ignorar esta l�nea
                }

                Solicitante solicitante = new Solicitante(
                    Integer.parseInt(campos[0]), // id_cotizante
                    Integer.parseInt(campos[1]),    //cedula
                    campos[2],                    // nombre
                    Integer.parseInt(campos[3]), // edad
                    campos[4],                    // genero
                    campos[5], // ciudad
                    Integer.parseInt(campos[6]), // semanasCotizadas
                    Boolean.parseBoolean(campos[7]), // declaraRenta
                    campos[8], // fondoPensiones
                    campos[9] //entidadPublica
                    //false // Inicialmente setea institucionPublica a false
                );

                // L�gica para clasificar cotizantes
                clasificarCotizante(solicitante);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void leerCaracterizaciones(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Omitir la cabecera
            br.readLine(); // Esta l�nea omite la primera l�nea (cabecera)

            while ((line = br.readLine()) != null) {
                String[] campos = line.split(",");

                // Asegurarse de que la l�nea contiene la cantidad correcta de campos
                if (campos.length != 11) {
                    System.err.println("L�nea inv�lida en caracterizaci�n: " + line);
                    continue; // Ignorar esta l�nea
                }

                // Asignar caracter�sticas a los cotizantes bas�ndose en el id_cotizante
                int CaracterizacionCedulaCotizante = Integer.parseInt(campos[1]);
                boolean CaracterizacionTieneCondecoraciones = Boolean.parseBoolean(campos[4]);
                boolean institucionPublica = campos[9].equalsIgnoreCase("Armada") || campos[9].equalsIgnoreCase("INPEC") || campos[9].equalsIgnoreCase("Policia");

                // Actualiza la institucionPublica en el cotizante correspondiente
                
//                System.out.println("dd"+aceptados);
//                listaAuxiliar.add(campos[0]+","+campos[1]+","+campos[2]+","+campos[3]+","+campos[4]+","+campos[5]+","+campos[6]
//                +","+campos[7]+","+campos[8]+","+campos[9]+","+campos[10]);
//                
//                System.out.println("dd1"+listaAuxiliar);
                    
                for (Solicitante cotizante : aceptados) {                      
//                    //System.out.println("pp"+cotizante.toString());
//                    if (cotizante.getCedula() == CaracterizacionCedulaCotizante && campos[9].equalsIgnoreCase("Armada")) {
//                        if (CaracterizacionTieneCondecoraciones) {
//                            cotizante.setFondoDePensiones("Colpensiones");
//                            cotizante.setEstadoSolicitud("Aprobado");
//                        }
////                        break;
//                    }

                    //Si la cedula del cotizante es igual a la cedula caracterizacion pertenece a Minsalud y tiene sancion
                    //Lista Negra Estado Rechazado
                    if (cotizante.getCedula() == CaracterizacionCedulaCotizante && campos[3].equalsIgnoreCase("Minsalud") && Boolean.parseBoolean(campos[10])) {
                        listaNegra.add(cotizante);
                        cotizante.setEstadoSolicitud("Rechazado");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void clasificarCotizante(Solicitante datos) {
        // L�gica para clasificar cotizantes
        
        
        //Asignar EsPensionado al Comienzo
//        datos.setEsPrePensionado(true);
        
//        System.out.println("pp"+datos);
        
    String ciudad[] = {"Bogota", "Medellin", "Cali", "Tunja"};
    
    if (datos.getEdad() > 35) {
        rechazados.add(datos);
        System.out.println("Solicitante rechazado por edad: " + datos);
    }
    
    else if (datos.getCiudad().equalsIgnoreCase(ciudad[0]) ||
        datos.getCiudad().equalsIgnoreCase(ciudad[1]) ||
        datos.getCiudad().equalsIgnoreCase(ciudad[2]) ||
        datos.getCiudad().equalsIgnoreCase(ciudad[3])) {
        
        rechazados.add(datos);
        System.out.println("Solicitante rechazado por ciudad: " + datos);
    }

    // Filtrar por entidad pública
    else if (datos.getEntidadPublica() == null || datos.getEntidadPublica().equalsIgnoreCase("Null")) {
        rechazados.add(datos);
        System.out.println("Solicitante rechazado por entidad pública: " + datos);
    }

    // Filtrar por pre-pensionado
    else if (datos.isEsPrePensionado()) {
        rechazados.add(datos);
        System.out.println("Solicitante rechazado por ser pre-pensionado: " + datos);
    }
    
    // Filtrar por FondoDePensiones: Porvenir && emanasCotizadas > 800
    else if (datos.getFondoDePensiones().equalsIgnoreCase("Porvenir") && datos.getSemanasCotizadas() > 800) {
        rechazados.add(datos);
        System.out.println("Solicitante rechazado por: " + datos.getFondoDePensiones()+", Semanas: "+datos.getSemanasCotizadas());
        System.out.println("Solicitante: " + datos);
    }
    
    // Filtrar por FondoDePensiones: Porvenir && emanasCotizadas > 800
    else if (datos.getFondoDePensiones().equalsIgnoreCase("Proteccion") && datos.getSemanasCotizadas() > 590) {
        rechazados.add(datos);
        System.out.println("Solicitante rechazado por FondoDePensiones: " + datos.getFondoDePensiones()+", Semanas: "+datos.getSemanasCotizadas());
        System.out.println("Solicitante: " + datos);
    }
    
    // Filtrar por FondoDePensiones: Colfondos && emanasCotizadas > 300
    else if (datos.getFondoDePensiones().equalsIgnoreCase("Colfondos") && datos.getSemanasCotizadas() > 300) {
        rechazados.add(datos);
        System.out.println("Solicitante rechazado por FondoDePensiones: " + datos.getFondoDePensiones()+", Semanas: "+datos.getSemanasCotizadas());
        System.out.println("Solicitante: " + datos);
    }
    
    // Filtrar por FondoDePensiones: Old Mutual && emanasCotizadas > 100
    else if (datos.getFondoDePensiones().equalsIgnoreCase("Old Mutual") && datos.getSemanasCotizadas() > 70) {
        rechazados.add(datos);
        System.out.println("Solicitante rechazado por FondoDePensiones: " + datos.getFondoDePensiones()+", Semanas: "+datos.getSemanasCotizadas());
        System.out.println("Solicitante: " + datos);
    }

    else{
        aceptados.add(datos);
        datos.setFondoDePensiones("Colpensiones");
        datos.setEstadoSolicitud("Aprobado");
    }
        
        /*Pendiente Realizar la Prioriti Queue*/
    }

    public LinkedList<Solicitante> getAceptados() {
        return aceptados;
    }

    public LinkedList<Solicitante> getRechazados() {
        return rechazados;
    }

    public LinkedList<Solicitante> getProcesarCivil() {
        return procesarCivil;
    }

    public LinkedList<Solicitante> getListaNegra() {
        return listaNegra;
    }

    public void imprimirResultados() {
        System.out.println("Cotizantes Aceptados: " + aceptados.size());
        System.out.println("Cotizantes Rechazados: " + rechazados.size());
        System.out.println("Cotizantes a Procesar como Civil: " + procesarCivil.size());
        System.out.println("Lista Negra: " + listaNegra.size());

        // Detalles sobre aceptados
        System.out.println("Cotizantes Aceptados:");
        for (Solicitante aceptado : aceptados) {
            System.out.println(" - " + aceptado);
        }

        // Detalles sobre rechazados
        System.out.println("Cotizantes Rechazados:");
        for (Solicitante rechazado : rechazados) {
            System.out.println(" - " + rechazado);
        }

        // Detalles sobre procesar como civil
        System.out.println("Cotizantes a Procesar como Civil:");
        for (Solicitante civil : procesarCivil) {
            System.out.println(" - " + civil);
        }

        // Detalles sobre lista negra
        System.out.println("Lista Negra:");
        for (Solicitante negra : listaNegra) {
            System.out.println(" - " + negra);
        }
    }
}
