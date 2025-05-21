import java.util.Scanner;

public class BankBoston {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion = scanner.nextInt();

        do{
            mostrarMenu();




        }while(opcion!=6);
    }

    public static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Ver datos de cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Girar");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Salir");
    }
}
