public class Cliente extends Viaje{
    private String destino;
    private double calificacion;

    public Cliente(int id, String destino, double calificacion) {
        super(id);
        this.destino = destino;
        this.calificacion = calificacion;
    }

    public String getDestino() {
        return destino;
    }

    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + getId() + ", destino='" + destino + '\'' +
                ", calificacion=" + calificacion + '}';
    }

}
