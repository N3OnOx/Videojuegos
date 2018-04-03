import java.util.ArrayList;
import java.util.Scanner;

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

    public void altaProducto(){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        Producto producto = new Producto();
        int cod_prod;
        System.out.println("Dime el código del producto: ");
        cod_prod = sn.nextInt();
        if (!productocontroler.existeProducto(cod_prod)){
            producto.setCod_prod(cod_prod);
            System.out.println("Dime la descripcion del producto: ");
            producto.setDescripcion(sc.nextLine());
            System.out.println("Dime el importe del producto: ");
            producto.setImporte(sn.nextInt());
            this.productocontroler.altaProducto(producto);
        }else {
            System.out.println("Ya existe un producto con ese codigo");
        }

    }
}
