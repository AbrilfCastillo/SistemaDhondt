package sistemadhondt;

public class Partido {
    private int id;
    private String nombre;
    private int votos;

    public Partido(int id, String nombre, int votos) {
        this.id = id;
        this.nombre = nombre;
        this.votos = votos;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public String toString() {
        if ("(Seleccionar)".equals(nombre)){
            return nombre;
        } else {
            return nombre + " - " + votos;
        }
        
    }
    
    
}