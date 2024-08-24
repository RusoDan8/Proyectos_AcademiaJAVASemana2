import java.util.*;
import java.util.function.Function;

public class MenuFuncion {
    public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, "Ana", 5000),
                new Empleado(2, "Luis", 6000),
                new Empleado(3, "Marta", 7000)
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona una opción:");
        System.out.println("1. Obtener el nombre del empleado con id 1");
        System.out.println("2. Obtener el salario del empleado con id 2");
        System.out.println("3. Obtener una cadena con todos los nombres de empleados");
        System.out.println("4. Obtener el empleado con el salario más alto");

        int opcion = scanner.nextInt();

        Function<List<Empleado>, Object> funcion;

        switch (opcion) {
            case 1:
                funcion = lista -> lista.stream()
                        .filter(e -> e.getId() == 1)
                        .map(Empleado::getNombre)
                        .findFirst()
                        .orElse("Empleado no encontrado");
                break;

            case 2:
                funcion = lista -> lista.stream()
                        .filter(e -> e.getId() == 2)
                        .map(Empleado::getSalario)
                        .findFirst()
                        .orElse(0.0);
                break;

            case 3:
                funcion = lista -> lista.stream()
                        .map(Empleado::getNombre)
                        .reduce("", (a, b) -> a + b + ", ");
                break;

            case 4:
                funcion = lista -> lista.stream()
                        .max(Comparator.comparingDouble(Empleado::getSalario))
                        .orElse(new Empleado(0, "N/A", 0));
                break;

            default:
                System.out.println("Opción no válida");
                return;
        }

        Object resultado = funcion.apply(empleados);
        System.out.println("Resultado: " + resultado);
    }
}
