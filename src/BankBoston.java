import java.util.Scanner;

public class BankBoston {
    private static Cliente clienteActual = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    verDatosCliente();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    girar();
                    break;
                case 5:
                    consultarSaldo();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Bank Boston:");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Ver datos de cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Girar");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Salir");
        System.out.print("Ingrese opción: ");
    }

    private static void registrarCliente() {
        System.out.println("Ingrese Rut:");
        String rut = scanner.nextLine();
        if (rut.length() < 11 || rut.length() > 12) {
            System.out.println("Error: El Rut debe tener entre 11 y 12 caracteres.");
            return;
        }

        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese apellido paterno:");
        String apellidoPaterno = scanner.nextLine();

        System.out.println("Ingrese apellido materno:");
        String apellidoMaterno = scanner.nextLine();

        System.out.println("Ingrese domicilio:");
        String domicilio = scanner.nextLine();

        System.out.println("Ingrese comuna:");
        String comuna = scanner.nextLine();

        System.out.println("Ingrese teléfono:");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese número de cuenta:");
        String numeroCuentaStr = scanner.nextLine();
        if (numeroCuentaStr.length() != 9 || !numeroCuentaStr.matches("\\d+")) {
            System.out.println("Error: El número de cuenta debe tener 9 dígitos.");
            return;
        }
        int numeroCuenta = Integer.parseInt(numeroCuentaStr);

        // Selección de tipo de cuenta
        System.out.println("Seleccione tipo de cuenta:");
        System.out.println("1. Cuenta Corriente");
        System.out.println("2. Cuenta de Ahorro");
        System.out.println("3. Cuenta de Crédito");
        System.out.print("Opción: ");
        int tipoCuenta = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Cuenta cuenta;
        switch (tipoCuenta) {
            case 1:
                cuenta = new CuentaCorriente(numeroCuenta);
                break;
            case 2:
                System.out.println("Ingrese tasa de interés (%):");
                double tasa = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer
                cuenta = new CuentaAhorro(numeroCuenta, tasa);
                break;
            case 3:
                System.out.println("Ingrese límite de crédito:");
                int limite = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                cuenta = new CuentaCredito(numeroCuenta, limite);
                break;
            default:
                System.out.println("Opción inválida, se creará Cuenta Corriente");
                cuenta = new CuentaCorriente(numeroCuenta);
        }

        clienteActual = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno,
                domicilio, comuna, telefono, cuenta);
        System.out.println("¡Cliente registrado exitosamente!");
    }

    private static void verDatosCliente() {
        if (clienteActual == null) {
            System.out.println("Error: No hay cliente registrado.");
        } else {
            clienteActual.mostrarInfo(); // Uso de interfaz
        }
    }

    private static void depositar() {
        if (clienteActual == null) {
            System.out.println("Error: Primero registre un cliente.");
            return;
        }

        System.out.println("Ingrese un monto para depositar:");
        int monto = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        clienteActual.getCuenta().depositar(monto);
    }

    private static void girar() {
        if (clienteActual == null) {
            System.out.println("Error: Primero registre un cliente.");
            return;
        }

        System.out.println("Ingrese un monto para girar:");
        int monto = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        clienteActual.getCuenta().girar(monto);
    }

    private static void consultarSaldo() {
        if (clienteActual == null) {
            System.out.println("Error: Primero registre un cliente.");
        } else {
            System.out.println("Saldo actual: " + clienteActual.getCuenta().getSaldo() + " pesos");
        }
    }
}
