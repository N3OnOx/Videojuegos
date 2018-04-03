public class ProductoController {
    private BDController productocontroler;

    public ProductoController() {
        this.productocontroler = new BDController();
    }

    public BDController getProductocontroler() {
        return productocontroler;
    }

    public void setProductocontroler(BDController productocontroler) {
        this.productocontroler = productocontroler;
    }
}
