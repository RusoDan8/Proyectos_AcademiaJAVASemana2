public class Taxi extends Viaje{
    private int numeroViaje;
    private double kilometraje;
    private String modelo;
    private String marca;
    private String placas;

    public Taxi(int id, int numeroViaje, double kilometraje, String modelo, String marca, String placas) {
        super(id);
        this.numeroViaje = numeroViaje;
        this.kilometraje = kilometraje;
        this.modelo = modelo;
        this.marca = marca;
        this.placas = placas;
    }

    public int getNumeroViaje() {
        return numeroViaje;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlacas() {
        return placas;
    }

    @Override
    public String toString() {
        return "Taxi{" + "id=" + getId() + ", numeroViaje=" + numeroViaje +
                ", kilometraje=" + kilometraje + ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' + ", placas='" + placas + '\'' + '}';
    }
}
