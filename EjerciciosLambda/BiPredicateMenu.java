import java.util.Scanner;
import java.util.function.BiPredicate;

public class BiPredicateMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir los BiPredicate
        BiPredicate<String, Integer> isLengthGreaterThan = (str, length) -> str.length() > length;
        BiPredicate<Integer, Double> isWithinRange = (num, range) -> num >= 0 && num <= range;
        BiPredicate<String, String> startsWith = (str, prefix) -> str.startsWith(prefix);
        BiPredicate<Integer, Integer> isEven = (num, dummy) -> num % 2 == 0;

        while (true) {
            // Mostrar menú
            System.out.println("Elige una opción:");
            System.out.println("1. Verificar longitud de cadena");
            System.out.println("2. Verificar si número está dentro del rango");
            System.out.println("3. Verificar si cadena empieza con un prefijo");
            System.out.println("4. Verificar si número es par");
            System.out.println("5. Salir");

            // Leer opción
            int choice = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (choice) {
                case 1:
                    // Opción 1: Verificar longitud de cadena
                    System.out.print("Introduce una cadena: ");
                    String str1 = scanner.nextLine();
                    System.out.print("Introduce la longitud mínima: ");
                    int length = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    boolean result1 = isLengthGreaterThan.test(str1, length);
                    System.out.println("¿La longitud es mayor que " + length + "? " + result1);
                    break;

                case 2:
                    // Opción 2: Verificar si número está dentro del rango
                    System.out.print("Introduce un número: ");
                    int num1 = scanner.nextInt();
                    System.out.print("Introduce el rango máximo: ");
                    double range = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    boolean result2 = isWithinRange.test(num1, range);
                    System.out.println("¿El número está dentro del rango de 0 a " + range + "? " + result2);
                    break;

                case 3:
                    // Opción 3: Verificar si cadena empieza con un prefijo
                    System.out.print("Introduce una cadena: ");
                    String str2 = scanner.nextLine();
                    System.out.print("Introduce el prefijo: ");
                    String prefix = scanner.nextLine();
                    boolean result3 = startsWith.test(str2, prefix);
                    System.out.println("¿La cadena empieza con el prefijo \"" + prefix + "\"? " + result3);
                    break;

                case 4:
                    // Opción 4: Verificar si número es par
                    System.out.print("Introduce un número: ");
                    int num2 = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    boolean result4 = isEven.test(num2, 0);  // El segundo parámetro no se usa en este caso
                    System.out.println("¿El número es par? " + result4);
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 5.");
                    break;
            }
        }
    }
}
