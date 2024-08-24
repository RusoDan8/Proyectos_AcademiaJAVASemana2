import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {
        List<Empleado> empleados = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int id = 1;
        int Pr_id =1;
        empleados.add(new Empleado(id++,"Lizeth", "Gerente" , 800));
        empleados.add(new Empleado(id++,"Arnold", "Contador" , 400));
        empleados.add(new Empleado(id++,"Gabriel", "Albanil" , 200));
        empleados.add(new Empleado(id++,"Ana", "Secretaria" , 350));
        empleados.add(new Empleado(id++,"Sofia", "Secretaria" , 350));
        List<Productos> productos = new ArrayList<>();
        productos.add(new Productos(Pr_id++, "libretas", 35));
        productos.add(new Productos(Pr_id++, "Libros de Geometria", 500));
        productos.add(new Productos(Pr_id++, "Calculadora", 87));
        productos.add(new Productos(Pr_id++, "Lapices de colores", 89));
        productos.add(new Productos(Pr_id++, "Lapices", 75));
        int opc =0;
        int menu_principal_opc;
        do
        {
            System.out.println("Ingrese el valor de la opcion que desea realizar");
            System.out.println("1 - Empleados");
            System.out.println("2 - Productos ");
            System.out.println("3-  Registro de ventas");
            System.out.println("4-  Asignar bono a todos los empleados");
            menu_principal_opc=scan.nextInt();
            scan.nextLine();
            switch (menu_principal_opc)
            {
                case 1:
                    do
                    {

                    System.out.println("Ingrese el valor de la opcion que desea realizar");
                    System.out.println("1 - Aumentar salario de un empleado en especifico");
                    System.out.println("2 - Establecer un nuevo puesto a un empleado en especifico ");
                    System.out.println("3-  Asignar un nuevo salario a todos los empleado de un departamento");
                    System.out.println("4-  Asignar bono a todos los empleados");
                    opc=scan.nextInt();
                    scan.nextLine();
                    switch (opc)
                    {
                        case 1:
                            System.out.println("Ingrese el ID del empleado para aumentar el salario:");
                            int idEmpleado = scan.nextInt();
                            System.out.println("Ingrese el monto del aumento:");
                            double aumento = scan.nextDouble();
                            BiConsumer<Empleado, Double> aumentarSalario = (empleado, monto) ->
                                    empleado.setSalario(empleado.getSalario() + monto);
                            empleados.stream()
                                    .filter(e -> e.getId() == idEmpleado)
                                    .forEach(e -> aumentarSalario.accept(e, aumento));
                            empleados.forEach(System.out::println); // Imprime los empleados actualizados
                            break;
                        case 2:
                            System.out.println("Ingrese el ID del empleado para cambiar el puesto:");
                            idEmpleado = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Ingrese el nuevo puesto:");
                            String nuevoPuesto = scan.nextLine();
                            BiConsumer<Empleado, String> cambiarPuesto = (empleado, puesto) ->
                                    empleado.setPuesto(puesto);
                            empleados.stream()
                                    .filter(e -> e.getId() == idEmpleado)
                                    .forEach(e -> cambiarPuesto.accept(e, nuevoPuesto));
                            empleados.forEach(System.out::println); // Imprime los empleados actualizados
                            break;
                        case 3:
                            System.out.println("Ingrese el departamento (puesto) para cambiar el salario:");
                            String departamento = scan.nextLine();
                            System.out.println("Ingrese el nuevo salario para el departamento:");
                            double nuevoSalario = scan.nextDouble();
                            BiConsumer<Empleado, Double> asignarNuevoSalario = (empleado, salario) ->
                                    empleado.setSalario(salario);
                            empleados.stream()
                                    .filter(e -> e.getPuesto().equalsIgnoreCase(departamento))
                                    .forEach(e -> asignarNuevoSalario.accept(e, nuevoSalario));
                            empleados.forEach(System.out::println);
                            break;
                        case 4:
                            System.out.println("Ingrese el monto del bono:");
                            double bono = scan.nextDouble();
                            BiConsumer<Empleado, Double> asignarBono = (empleado, cantidad) ->
                                    empleado.setSalario(empleado.getSalario() + cantidad);
                            empleados.forEach(e -> asignarBono.accept(e, bono));
                            empleados.forEach(System.out::println);
                            break;
                    }
                }while (opc != 5);
                case 2:
                    do
                    {
                        System.out.println("Ingrese el valor de la opcion que desea realizar");
                        System.out.println("1 - Buscar producto");
                        System.out.println("2 - Realizar una compra");
                        System.out.println("3 - Manejar inventario de productos");
                        System.out.println("4 - Aplicar oferta de 10% de descuento");
                        System.out.println("5 - Salir del menú de productos");
                        opc=scan.nextInt();
                        scan.nextLine();
                        switch (opc)
                        {
                            case 1: //predicate de busqueda
                                System.out.println("Ingrese el nombre del producto que desea buscar");
                                String findProducto = scan.nextLine();

                                // Crear el Predicate para buscar un producto por nombre
                                Predicate<Productos> buscarProducto = producto -> producto.getNombre().equalsIgnoreCase(findProducto);

                                // Buscar el producto usando el Predicate
                                Optional<Productos> resultadoProducto = productos.stream()
                                        .filter(buscarProducto)
                                        .findFirst();

                                if (resultadoProducto.isPresent()) {
                                    System.out.println("Producto encontrado: " + resultadoProducto.get());
                                } else {
                                    System.out.println("Producto no encontrado.");
                                }
                            case 2:
                                System.out.println("Ingrese el nombre del producto que desea comprar:");
                                String productoCompra = scan.nextLine();

                                // Crear el Predicate para buscar un producto por nombre
                                Predicate<Productos> buscarProductoCompra = producto -> producto.getNombre().equalsIgnoreCase(productoCompra);

                                // Buscar el producto usando el Predicate
                                Optional<Productos> resultadoProductoCompra = productos.stream()
                                        .filter(buscarProductoCompra)
                                        .findFirst();

                                if (resultadoProductoCompra.isPresent()) {
                                    Productos productoEncontrado = resultadoProductoCompra.get();
                                    System.out.println("Producto encontrado: " + productoEncontrado);

                                    // Solicitar la cantidad del producto que el cliente desea comprar
                                    System.out.println("Ingrese la cantidad que desea comprar:");
                                    int cantidad = scan.nextInt();
                                    scan.nextLine(); // Limpiar el buffer del scanner

                                    // Calcular el total
                                    double total = productoEncontrado.getPrecio() * cantidad;
                                    System.out.println("Cantidad solicitada: " + cantidad);
                                    System.out.println("Total a pagar: $" + total);

                                    // Simulación de la compra (ejemplo básico)
                                    System.out.println("Compra realizada. Gracias por su compra.");
                                } else {
                                    System.out.println("Producto no encontrado.");
                                }
                                break;
                            case 3:
                                System.out.println("Ingrese el nombre del producto para verificar el inventario:");
                                String productoInventario = scan.nextLine();

                                // Predicate para verificar si hay suficiente inventario (en este ejemplo, asumimos que hay un stock mínimo de 50 unidades)
                                Predicate<Productos> verificarInventario = producto -> producto.getNombre().equalsIgnoreCase(productoInventario) && producto.getPrecio() > 50;

                                // Buscar el producto usando el Predicate
                                Optional<Productos> resultadoProductoInventario = productos.stream()
                                        .filter(verificarInventario)
                                        .findFirst();

                                if (resultadoProductoInventario.isPresent()) {
                                    Productos productoEncontradoInventario = resultadoProductoInventario.get();
                                    System.out.println("Producto en inventario: " + productoEncontradoInventario);
                                    // Aquí podrías añadir más lógica para manejar el inventario, como actualizar el stock
                                } else {
                                    System.out.println("Producto no disponible en inventario o no cumple con los requisitos.");
                                }
                                break;
                            case 4:
                                System.out.println("Ingrese el nombre del producto para aplicar la oferta:");
                                String productoOferta = scan.nextLine();

                                // Crear el Predicate para buscar un producto por nombre
                                Predicate<Productos> buscarProductoOferta = producto -> producto.getNombre().equalsIgnoreCase(productoOferta);

                                // Buscar el producto usando el Predicate
                                Optional<Productos> resultadoProductoOferta = productos.stream()
                                        .filter(buscarProductoOferta)
                                        .findFirst();

                                if (resultadoProductoOferta.isPresent()) {
                                    Productos productoEncontradoOferta = resultadoProductoOferta.get();
                                    System.out.println("Producto encontrado: " + productoEncontradoOferta);

                                    // Solicitar la cantidad del producto que el cliente desea comprar
                                    System.out.println("Ingrese la cantidad que desea comprar:");
                                    int cantidadOferta = scan.nextInt();
                                    scan.nextLine(); // Limpiar el buffer del scanner

                                    // Calcular el total con descuento
                                    double precioOriginal = productoEncontradoOferta.getPrecio();
                                    double totalOriginal = precioOriginal * cantidadOferta;
                                    double totalDescuento = totalOriginal * 0.9; // Aplicar el 10% de descuento

                                    System.out.println("Cantidad solicitada: " + cantidadOferta);
                                    System.out.println("Total original: $" + totalOriginal);
                                    System.out.println("Total con descuento: $" + totalDescuento);

                                    // Simulación de la compra con descuento
                                    System.out.println("Compra con descuento realizada. Gracias por su compra.");
                                } else {
                                    System.out.println("Producto no encontrado.");
                                }
                                break;



                        }
                    }while (opc!=5);

                case 3:
                case 4:
            }

        }while(menu_principal_opc!=3);




    }
}