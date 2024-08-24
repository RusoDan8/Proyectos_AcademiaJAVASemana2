import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
//import java.io.FileWriter;
//import java.io.IOException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int id = 1;
        empleados.add( new Empleado(id++,"Ana Prado", "Gerente", 500));
        empleados.add( new Empleado(id++,"Fabian", "contador", 300));
        empleados.add( new Empleado(id++,"Toribio", "Albanil", 100));
        empleados.add( new Empleado(id++,"Rita", "Secretaria", 200));
        empleados.add( new Empleado(id++,"Javier", "Ingeniero", 400));


        String Nombre_emp1;
        String p1;
        double sal1;
        int opc1;
        do {
            System.out.println("Menu de opciones\n 1- Ingresar nuevas incorporaciones \n 2- Ver incorporaciones <SUPPLIER>");
            System.out.println("Menu de opciones\n 3- Editar empleado <CONSUMER> \n 4- Ver incorporaciones <BI CONSUME>");
            System.out.println("Ingrese el numero de la opcion que desea realizar");
            opc1 = scan.nextInt();
            scan.nextLine();


            switch (opc1) {
                case 0:
                    break;

                case 1:

                    System.out.println("ingrese nombre de el empleado");
                    Nombre_emp1 = scan.nextLine();

                    System.out.println("ingrese puesto de el empleado");
                    p1 = scan.nextLine();

                    System.out.println("ingrese sueldo de el empleado");
                    sal1 = scan.nextInt();
                    scan.nextLine();
                    System.out.println("ingrese valor  de la opcion \n 0 - salir al menu pricipal \n 3 - salir");
                    opc1 = scan.nextInt();
                    scan.nextLine();
                    empleados.add(new Empleado(id++,Nombre_emp1,p1,sal1));
                    break;
                case 2:
                    int opc2;
                    System.out.println("Menu de busquedad de empleados:" + " Supplier ");
                    System.out.println("1 - Por nombre");
                    System.out.println("2 - Imprimir salarios de más alto a más bajo");
                    System.out.println("3 - Ver todos los empleados");
                    System.out.println("4 - Calcular salario promedio de los empleados");
                    System.out.println("5 - Salir");
                    System.out.println("Seleccione una opción:");

                    opc2 = scan.nextInt();
                    scan.nextLine();
                    switch (opc2){
                        case 1: //supplier1 Supplier<String>
                            System.out.println("Case1 supplier1 Supplier<String>");
                            int aux_id;
                            System.out.println("Ingrese el id del empleado");
                            aux_id = scan.nextInt();
                            scan.nextLine();

                            if (aux_id >= 0 && aux_id < empleados.size()) {
                                Supplier<String> primerEmpleadoNombre = () -> empleados.get(aux_id).getNombre();
                                System.out.println("El empleado es: " + primerEmpleadoNombre.get());
                            } else {
                                System.out.println("ID inválido. Intente de nuevo.");
                            }
                            break;
                        case 2: // Supplier<Double>
                            System.out.println("Case 2 Supplier<Double>");
                            if (empleados.isEmpty()) {
                                System.out.println("No hay empleados registrados.");
                            } else {
                                System.out.println("Lista de empleados:");
                                empleados.forEach(System.out::println);
                            }
                            Supplier<Double> salarioMayorID = () -> empleados.stream()
                                    .max((e1, e2) -> Integer.compare(e1.getId(), e2.getId()))
                                    .map(Empleado::getSalario)
                                    .orElse(0.0);
                            System.out.println("Salario del empleado con mayor ID: " + salarioMayorID.get());
                            break;
                        case 3:
                            System.out.println("Case3");
                            Supplier<List<String>> infoEmpleados = () -> {
                                List<String> nombres = new ArrayList<>();
                                for(Empleado empleado : empleados)
                                {
                                    nombres.add(empleado.getNombre());

                                }
                                return nombres;
                            };
                            System.out.println("Nombres de todos los empleados:" + infoEmpleados);
                            break;
                        case 4:
                           Supplier<Double> Salario_Promedio = () -> empleados.stream()
                                   .mapToDouble(Empleado::getSalario)
                                   .average()
                                   .orElse(0.0);
                           System.out.println("El salario promedio de tus empleado es" + Salario_Promedio.get());
                        case 5:
                            System.out.println("Saliendo...");

                            break;

                        default:
                            System.out.println("Opción no válida, intenta de nuevo.");
                            break;


                    }
                case 3:
                    int opc3;
                    System.out.println("Menu de Edicion de empleados:" + " Consumer ");
                    System.out.println("1 - Editar nombre");
                    System.out.println("2 - Editar puesto");
                    System.out.println("3 - Aumentar Salario");
                    System.out.println("4 - Registrar en un txt");
                    System.out.println("5 - Salir");
                    System.out.println("Seleccione una opción:");
                    opc3 = scan.nextInt();
                    scan.nextLine();
                    switch (opc3)
                    {
                        case 1:
                            System.out.println("ingrese el id del empleado al que desea actualizar");
                            int aux_id = scan.nextInt();
                            scan.nextLine();

                            System.out.println("ingrese el nuevo nombre del empleado");
                            String nuevo_nombre = scan.nextLine();

                            //consumer
                            Consumer<Empleado> actulizar_nombre = empleado -> {
                                if(empleado.getId()==aux_id){
                                    empleado.setNombre(nuevo_nombre);
                                }
                            };
                            empleados.forEach(actulizar_nombre);
                            empleados.forEach(e -> System.out.println("ID: " + e.getId() + "Nombre actualizado" + e.getNombre()+ "Puesto : " +e.getPuesto()));
                            break;
                        case 2:
                            System.out.println("ingrese el id del empleado al que desea actualizar");
                            int aux_id2 = scan.nextInt();
                            scan.nextLine();

                            System.out.println("ingrese el nuevo puesto del empleado");
                            String nuevo_puesto = scan.nextLine();

                            //consumer
                            Consumer<Empleado> actulizar_puesto = empleado -> {
                                if(empleado.getId()==aux_id2){
                                    empleado.setPuesto(nuevo_puesto);
                                }
                            };
                            empleados.forEach(actulizar_puesto);
                            empleados.forEach(e -> System.out.println("ID: " + e.getId() + "Nombre " + e.getNombre()+ "Puesto actualizado : " +e.getPuesto()));
                        case 3:
                            System.out.println("Aumento de salarios");
                            int aux_id3 = scan.nextInt();
                            scan.nextLine();
                            System.out.println("ingrese el % de aumento");
                            double porcentaje_aumento = scan.nextDouble();
                            scan.nextLine();

                            Consumer<Empleado> aumentarSalario = empleado -> {
                              if (empleado.getId()== aux_id3)
                              {
                                  double nuevo_salario = empleado.getSalario() * (1 + porcentaje_aumento);
                                  empleado.setSalario(nuevo_salario);
                              }
                            };
                            empleados.forEach(aumentarSalario);
                            empleados.forEach(e -> System.out.println("ID: " + e.getId() + "Nombre " + e.getNombre()+ "Salario actualizado  : " +e.getSalario()));
                            break;
                        case 4:
                            Consumer<Empleado> registrarEmpleado = empleado ->
                                    System.out.println("ID: " + empleado.getId() + "Nombre " + empleado.getNombre()+ "Puesto actualizado : " +empleado.getPuesto() + "Salario actualizado  : " +empleado.getSalario());
                                empleados.forEach(registrarEmpleado);


                    }
            }
        }while (opc1 < 4 );








    }
}