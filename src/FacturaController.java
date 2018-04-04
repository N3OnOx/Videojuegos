public class FacturaController {
    private BDController facturacontroller;

    public FacturaController() {
        this.facturacontroller = new BDController();
    }

    public BDController getFacturacontroller() {
        return facturacontroller;
    }

    public void setFacturacontroller(BDController facturacontroller) {
        this.facturacontroller = facturacontroller;
    }

    public void realizarVenta(){

    }
}
