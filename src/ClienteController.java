import java.util.Scanner;

public class ClienteController {
    private BDController clientecontroler;

    public ClienteController(){
        this.clientecontroler = new BDController();
    }

    public BDController getClientecontroler() {
        return clientecontroler;
    }

    public void setClientecontroler(BDController clientecontroler) {
        this.clientecontroler = clientecontroler;
    }

    public void altaCliente(){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        Cliente cliente = new Cliente();
        int cod_cli;
        System.out.println("Dime el código del cliente: ");
        cod_cli = sn.nextInt();
        if (!clientecontroler.existeCliente(cod_cli)){
            cliente.setCod_cli(cod_cli);
            System.out.println("Dime el nombre del cliente: ");
            cliente.setNombre(sc.nextLine());
            System.out.println("Dime la direccion del cliente: ");
            cliente.setDireccion(sc.nextLine());
            System.out.println("Dime el teléfono del cliente: ");
            cliente.setTelefono(sc.nextLine());
            System.out.println("Dime el NIF del cliente: ");
            cliente.setNif(sc.nextLine());
            this.clientecontroler.altaCliente(cliente);
        }else{
            System.out.println("Ya existe un cliente con ese codigo");
        }
    }

    public void eliminarCliente(){
        Scanner sn = new Scanner(System.in);
        int codCliente;
        System.out.println("Dime el cliente a eliminar");
        codCliente = sn.nextInt();
        if (clientecontroler.existeCliente(codCliente)){
            clientecontroler.eliminarCliente(codCliente);
        }else{
            System.out.println("No existe ese cliente");
        }
    }
}
