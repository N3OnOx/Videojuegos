import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner sn = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        ArrayList<LFactura> lineas = new ArrayList<>();
        int codigo;
        String resp;
        boolean checkProd = false;
        boolean checkCodLF = false;
        int importeTotal = 0;
        int codFactura;
        int contProductos = 0;
        System.out.println("Dime el codigo de factura: ");
        codFactura = sn.nextInt();
        if (!facturacontroller.existeFactura(codFactura)) {
            do {
                LFactura lFactura = new LFactura();
                lFactura.setCod_factura(codFactura);
                System.out.println("Dime el codigo de producto: ");
                codigo = sn.nextInt();
                if (facturacontroller.existeProducto(codigo)) {
                    lFactura.setCod_prod(codigo);
                    checkProd = true;
                }
                if (checkProd) {
                    System.out.println("Dime el codigo de linea de factura: ");
                    codigo = sn.nextInt();
                    if (!facturacontroller.existeLfactura(codigo)) {
                        checkCodLF = true;
                    }
                    if (checkCodLF) {
                        lFactura.setCod_lfactura(codigo);
                        codigo = facturacontroller.buscarImporte(lFactura.getCod_prod());
                        lFactura.setImporte(codigo);
                        lineas.add(lFactura);
                        contProductos++;
                        this.facturacontroller.insertarLFactura(lFactura);
                    } else {
                        System.out.println("La linea de factura ya existe");
                    }
                }else{
                    System.out.println("No existe ningun producto con ese código");
                }
                System.out.println("Desea introducir mas productos?");
                resp = sc.nextLine();
            } while (resp.equalsIgnoreCase("si"));

            if (contProductos > 0) {
                Factura factura = new Factura();
                factura.setCod_factura(codFactura);
                System.out.println("Dime el codigo de cliente:");
                codigo = sn.nextInt();
                if (facturacontroller.existeCliente(codigo)) {
                    factura.setCod_cli(codigo);
                    System.out.println("Dime la fecha de la factura: ");
                    factura.setFecha(sc.nextLine());
                    for (LFactura linea : lineas) {
                        importeTotal = importeTotal + linea.getImporte();
                    }
                    factura.setImporte(importeTotal);
                    this.facturacontroller.realizarVenta(factura);
                } else {
                    System.out.println("No existe el cliente");
                }
            }else{
                System.out.println("No ha escrito ningun producto, no se generará la factura");
            }
        }else{
            System.out.println("Ya existe ese código de factura");
        }
    }
}
