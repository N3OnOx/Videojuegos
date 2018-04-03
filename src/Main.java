import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sn = new Scanner(System.in);
    //Scanner sc = new Scanner(System.in);
    int opcion;
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Cliente> productos = new ArrayList<>();
    do {
        mostrarMenu();
        opcion = sn.nextInt();
        switch (opcion){
            case 1:
                break;
            case 2:
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

    private static void altaCliente(ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println("Dime el código del cliente: ");
        cliente.setCod_cli(sn.nextInt());
        System.out.println("Dime el nombre del cliente: ");
        cliente.setNombre(sc.nextLine());
        System.out.println("Dime la direccion del cliente: ");
        cliente.setDireccion(sc.nextLine());
        System.out.println("Dime el teléfono del cliente: ");
        cliente.setTelefono(sc.nextLine());
        System.out.println("Dime el NIF del cliente: ");
        cliente.setNif(sc.nextLine());
        clientes.add(cliente);
    }
    private static void altaProducto(ArrayList<Producto> productos){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        Producto producto = new Producto();
        System.out.println("Dime el código del producto: ");
        producto.setCod_prod(sn.nextInt());
        System.out.println("Dime la descripcion del producto: ");
        producto.setDescripcion(sc.nextLine());
        System.out.println("Dime el importe del producto: ");
        producto.setImporte(sn.nextInt());
        productos.add(producto);
    }
}
