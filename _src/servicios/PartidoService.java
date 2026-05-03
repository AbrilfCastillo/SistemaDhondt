package servicios;

import modelo.Partido;
import dao.PartidoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que centraliza la lógica de negocio relacionada a los partidos políticos.
 * Valida los datos antes de delegarlos al DAO para su persistencia.
 */
public class PartidoService {
    
    /**
     * Valida y crea un nuevo partido en la base de datos.
     * @param nombre nombre del partido
     * @param votosT cantidad de votos como String, puede tener separadores de miles
     * @throws Exception si algún campo está vacío, el formato es inválido, o los votos son 0 o negativos
     */
    public static void crearPartido(String nombre, String votosT) throws Exception{
        
        // Validando que no estén vacíos
        if (nombre.isEmpty() || votosT.isEmpty()){
            throw new Exception("No puede haber casillas vacías.");
        }
        
        int votos;
        try{// try-catch en caso de que valor no sea válido
            votos = Integer.parseInt(votosT.replace(".", ""));
            
        } catch (NumberFormatException e){
            throw new Exception("No es un número válido.");
            
        }
        
        // Si los votos son 0 o menos lanza una excepción
        if (votos <= 0){
                throw new Exception("La cantidad de votos no puede ser 0 o menor.");
            }
        
        PartidoDAO.crearPartido(nombre, votos);
    }
    
    /**
     * Obtiene la lista completa de partidos desde la base de datos.
     * @return lista de partidos, vacía si no hay ninguno
     */
    public static List<Partido> obtenerPartidos() {
        return PartidoDAO.mostrarPartidos();
    }
    
    /**
     * Valida y actualiza los datos de un partido existente.
     * @param id identificador del partido a actualizar
     * @param nombre nuevo nombre del partido
     * @param votos nueva cantidad de votos
     * @throws Exception si el nombre está vacío o los votos son 0 o negativos
     */
    public static void actualizarPartido(int id, String nombre, long votos) throws Exception {

        if (nombre.isEmpty()) {
            throw new Exception("El nombre no puede estar vacío");
        }

        if (votos <= 0) {
            throw new Exception("Los votos deben ser mayores a 0");
        }

        PartidoDAO.actualizarPartido(id, nombre, (int) votos);
    }
    
    /**
     * Filtra una lista de partidos buscando coincidencias en nombre o votos.
     * La búsqueda por nombre no es sensible a mayúsculas y minúsculas.
     * @param partidos lista de partidos a filtrar
     * @param texto texto a buscar
     * @return lista de partidos que coinciden con el texto
     */
    public static List<Partido> filtrar(List<Partido> partidos, String texto) {
        List<Partido> filtrados = new ArrayList<>();
        for (Partido p : partidos) {
            boolean coincideNombre = p.getNombre().toLowerCase().contains(texto.toLowerCase());
            boolean coincideVotos = String.valueOf(p.getVotos()).contains(texto);

            if (coincideNombre || coincideVotos) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }
    
    /**
     * Elimina un partido de la base de datos por su identificador.
     * @param id identificador del partido a eliminar
     */
    public static void eliminarPartido(int id){
        PartidoDAO.eliminarPartido(id);
    }
}