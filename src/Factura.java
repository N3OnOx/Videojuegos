import java.util.ArrayList;

public class Factura {
    private int cod_factura;
    private int cod_cli;
    private String fecha;
    private int importe;

    public Factura() {
    }

    public Factura(int cod_factura, int cod_cli, String fecha, int importe) {
        this.cod_factura = cod_factura;
        this.cod_cli = cod_cli;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }
}
