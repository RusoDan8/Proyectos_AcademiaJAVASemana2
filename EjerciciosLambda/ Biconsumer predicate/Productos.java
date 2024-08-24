public class Productos {
    int id;
    String nombre;
    double precio;



    public Productos( int id, String nombre, double precio){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }
    @Override
    public String toString(){
        return  "id: " + id + " " +"Producto es " + nombre + "  " + precio;
    }
}
