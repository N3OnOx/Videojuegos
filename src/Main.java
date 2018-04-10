import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sn = new Scanner(System.in);
    int opcion;
    ClienteController clienteController = new ClienteController();
    ProductoController productoController = new ProductoController();
    FacturaController facturaController = new FacturaController();
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
                    facturaController.realizarVenta();
                    break;
                case 4:
                    facturaController.buscarFacturaN();
                    break;
                case 5:
                    facturaController.mostrarFacturasCliente();
                    break;
                case 6:
                    facturaController.realizarDescuentoC();
                    break;
                case 7:
                    facturaController.realizarDescuentoF();
                    break;
                case 8:
                    clienteController.eliminarCliente();
                    break;
                case 9:
                    System.out.println("Has elegido salir");
                    break;
                    default:
                        System.out.println("Opción inválida");
                        break;
            }
        }while (opcion!=9);
    }
    private static void mostrarMenu(){
        System.out.println("1.  Crear nuevo cliente");
        System.out.println("2.  Crear nuevo producto");
        System.out.println("3.  Realizar venta");
        System.out.println("4.  Consulta de factura por nº de factura");
        System.out.println("5.  Consulta de Facturas de 1 cliente.");
        System.out.println("6.  Aplicar descuento de 10€ a facturas de cliente.");
        System.out.println("7.  Aplicar un descuento de 10€ en todas las facturas que se hayan emitido en un año pedido por el usuario.");
        System.out.println("8.  Eliminar un cliente");
        System.out.println("9.  Salir");
    }
}
