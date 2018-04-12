import java.util.Scanner;

public class ProductoController {
    private BDController productocontroler;

    public ProductoController() {
        this.productocontroler = new BDController();
    }

    public void altaProducto(){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        Producto producto = new Producto();
        int cod_prod;
        double importe;
        boolean checkImporte = false;
        System.out.println("Dime el código del producto: ");
        cod_prod = sn.nextInt();
        if (!productocontroler.existeProducto(cod_prod)){
            producto.setCod_prod(cod_prod);
            System.out.println("Dime la descripcion del producto: ");
            producto.setDescripcion(sc.nextLine());
            System.out.println("Dime el importe del producto: ");
            importe = sn.nextDouble();
            if (importe > 0 && importe < 10000){
                checkImporte = true;
            }
            if (checkImporte){
                producto.setImporte(importe);
                this.productocontroler.altaProducto(producto);
            }else {
                System.out.println("El importe debe ser mayor que 0 y menor que 1000");
            }
        }else {
            System.out.println("Ya existe un producto con ese codigo");
        }

    }
}
