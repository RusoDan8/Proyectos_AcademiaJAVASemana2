import java.util.Scanner;
import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Definir las BiFunction para cada operación
        BiFunction<Integer, Integer, Integer> suma = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> resta = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> multiplicacion = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> division = (a, b) -> b != 0 ? a / b : null;

        // Mostrar menú
        System.out.println("Seleccione una opción:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        // Leer la opción del usuario
        int opcion = scanner.nextInt();

        // Leer los números sobre los que operar
        System.out.println("Ingrese el primer número:");
        int num1 = scanner.nextInt();
        System.out.println("Ingrese el segundo número:");
        int num2 = scanner.nextInt();

        // Variable para almacenar el resultado
        Integer resultado = null;

        // Ejecutar la operación seleccionada
        switch (opcion) {
            case 1:
                resultado = suma.apply(num1, num2);
                break;
            case 2:
                resultado = resta.apply(num1, num2);
                break;
            case 3:
                resultado = multiplicacion.apply(num1, num2);
                break;
            case 4:
                resultado = division.apply(num1, num2);
                if (resultado == null) {
                    System.out.println("Error: División por cero.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        // Mostrar el resultado
        if (resultado != null) {
            System.out.println("Resultado: " + resultado);
        }
    }
}
