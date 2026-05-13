package modelo;

/**
 * Representa un cociente del cálculo D'Hondt que ocupó un cargo.
 * Almacena el resultado de dividir los votos de un partido por un índice,
 * junto con su posición en el ranking global.
 */
public class ResultadoVotos {
    private int id;
    private int fk_idPartido;
    private int cantidadVotos;
    private int orden;
    private int indice;
    private double porcentaje;
    private int totalVotos;
    private int votosPartido;

    public ResultadoVotos(int id, int fk_idPartido, int cantidadVotos, int orden, int indice, double porcentaje, int totalVotos, int votosPartido) {
        this.id = id;
        this.fk_idPartido = fk_idPartido;
        this.cantidadVotos = cantidadVotos;
        this.orden = orden;
        this.indice = indice;
        this.porcentaje = porcentaje;
        this.totalVotos = totalVotos;
        this.votosPartido = votosPartido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_idPartido() {
        return fk_idPartido;
    }

    public void setFk_idPartido(int fk_idPartido) {
        this.fk_idPartido = fk_idPartido;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    public int getVotosPartido() {
        return votosPartido;
    }

    public void setVotosPartido(int votosPartido) {
        this.votosPartido = votosPartido;
    }
    
    

}