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
}
