import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sn = new Scanner(System.in);
    //Scanner sc = new Scanner(System.in);
    int opcion;
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Cliente> productos = new ArrayList<>();
    ClienteController clienteController = new ClienteController();
    ProductoController productoController = new ProductoController();
    do {
        mostrarMenu();
        opcion = sn.nextInt();
        switch (opcion){
            case 1:
                clienteController.altaCliente();
                break;
            case 2:
                productoController.altaProducto();
                break;
            case 3:
                System.out.println("Has elegido salir");
                break;
                default:
                    System.out.println("Opción inválida");
                    break;
        }
    }while (opcion!=3);
    }
    private static void mostrarMenu(){
        System.out.println("1.  Crear nuevo cliente");
        System.out.println("2.  Crear nuevo producto");
        System.out.println("3.  Salir");
    }
}
