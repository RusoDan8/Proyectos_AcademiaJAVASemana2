public class Empleado extends Viaje {
    private String nombre;
    private String numeroLicencia;
    private double calificacion;

    public Empleado(int id, String nombre, String numeroLicencia, double calificacion) {
        super(id);
        this.nombre = nombre;
        this.numeroLicencia = numeroLicencia;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + getId() + ", nombre='" + nombre + '\'' +
                ", numeroLicencia='" + numeroLicencia + '\'' +
                ", calificacion=" + calificacion + '}';
    }
}
