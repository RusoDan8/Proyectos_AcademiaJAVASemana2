import java.util.Scanner;
import java.util.function.BinaryOperator;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        BinaryOperator<Integer> operacion = null;

        do {
            // Mostrar el menú
            System.out.println("Elige una opción:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");

            // Leer la opción del usuario
            opcion = scanner.nextInt();

            // Seleccionar la operación basada en la opción
            switch (opcion) {
                case 1:
                    operacion = (a, b) -> a + b;
                    break;
                case 2:
                    operacion = (a, b) -> a - b;
                    break;
                case 3:
                    operacion = (a, b) -> a * b;
                    break;
                case 4:
                    operacion = (a, b) -> a / b;
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    continue;
            }

            // Si la opción es para hacer una operación
            if (opcion >= 1 && opcion <= 4) {
                // Leer dos números del usuario
                System.out.print("Ingresa el primer número: ");
                int num1 = scanner.nextInt();
                System.out.print("Ingresa el segundo número: ");
                int num2 = scanner.nextInt();

                // Ejecutar la operación y mostrar el resultado
                int resultado = operacion.apply(num1, num2);
                System.out.println("El resultado es: " + resultado);
            }

        } while (opcion != 5);  // Salir del bucle cuando la opción es 5

        scanner.close();
    }
}
