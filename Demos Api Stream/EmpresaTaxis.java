// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.util.stream.Collectors;
public class EmpresaTaxis {
    public static void main(String[] args) {
        // Crear lista de empleados
        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, "Juan", "ABC123", 4.7),
                new Empleado(2, "Maria", "XYZ987", 4.9),
                new Empleado(3, "Carlos", "LMN456", 4.3)
        );

        // Crear lista de taxis
        List<Taxi> taxis = Arrays.asList(
                new Taxi(1, 100, 12000.5, "Modelo1", "MarcaA", "AAA-123"),
                new Taxi(2, 101, 18000.2, "Modelo2", "MarcaB", "BBB-456"),
                new Taxi(3, 102, 9000.1, "Modelo3", "MarcaC", "CCC-789")
        );

        // Crear lista de clientes
        List<Cliente> clientes = Arrays.asList(
                new Cliente(1, "Centro", 4.5),
                new Cliente(2, "Aeropuerto", 4.8),
                new Cliente(3, "Estación", 4.2)
        );
        // 1. Filtrar taxis con kilometraje mayor a 10,000
        List<Taxi> taxisConAltoKilometraje = taxis.stream()
                .filter(t -> t.getKilometraje() > 10000)
                .collect(Collectors.toList());
        // 2. Mapear nombres de empleados a una lista de Strings
        List<String> nombresEmpleados = empleados.stream()
                .map(Empleado::getNombre)
                .collect(Collectors.toList());
        // 3. Obtener destinos únicos de los clientes (uso de distinct)
        List<String> destinosUnicos = clientes.stream()
                .map(Cliente::getDestino)
                .distinct()
                .collect(Collectors.toList());
        // 1. Contar el número de taxis con alto kilometraje
        long countTaxisConAltoKilometraje = taxisConAltoKilometraje.size();
        // 2. Imprimir nombres de empleados
        System.out.println("Nombres de empleados:");
        nombresEmpleados.forEach(System.out::println);

        // 3. Imprimir destinos únicos de los clientes
        System.out.println("\nDestinos únicos:");
        destinosUnicos.forEach(System.out::println);

        // Mostrar resultados
        System.out.println("\nTaxis con alto kilometraje:");
        taxisConAltoKilometraje.forEach(System.out::println);

        System.out.println("\nCantidad de taxis con alto kilometraje: " + countTaxisConAltoKilometraje);
    }
}