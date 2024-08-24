import java.util.Scanner;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Definir UnaryOperator para cada operación
        UnaryOperator<Integer> cuadrado = x -> x * x;
        UnaryOperator<Integer> raizCuadrada = x -> (int) Math.sqrt(x);
        UnaryOperator<Integer> incrementar = x -> x + 1;
        UnaryOperator<Integer> decrementar = x -> x - 1;

        int opcion = 0;

        do {
            // Mostrar menú
            System.out.println("Seleccione una opción:");
            System.out.println("1. Elevar al cuadrado");
            System.out.println("2. Calcular la raíz cuadrada");
            System.out.println("3. Incrementar en uno");
            System.out.println("4. Decrementar en uno");
            System.out.println("5. Salir");

            // Leer la opción del usuario
            opcion = scanner.nextInt();

            // Leer el número sobre el que operar
            if (opcion >= 1 && opcion <= 4) {
                System.out.println("Ingrese un número:");
                int num = scanner.nextInt();

                // Variable para almacenar el resultado
                Integer resultado = null;

                // Ejecutar la operación seleccionada
                switch (opcion) {
                    case 1:
                        resultado = cuadrado.apply(num);
                        break;
                    case 2:
                        resultado = raizCuadrada.apply(num);
                        break;
                    case 3:
                        resultado = incrementar.apply(num);
                        break;
                    case 4:
                        resultado = decrementar.apply(num);
                        break;
                }

                // Mostrar el resultado
                System.out.println("Resultado: " + resultado);
            } else if (opcion != 5) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 5);


        System.out.println("¡Programa terminado!");
    }
}
