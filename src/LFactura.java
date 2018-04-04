public class LFactura {
    private int cod_factura;
    private int cod_lfactura;
    private int cod_prod;
    private int importe;

    public LFactura() {
    }

    public LFactura(int cod_factura, int cod_lfactura, int cod_prod, int importe) {
        this.cod_factura = cod_factura;
        this.cod_lfactura = cod_lfactura;
        this.cod_prod = cod_prod;
        this.importe = importe;
    }

    public int getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    public int getCod_lfactura() {
        return cod_lfactura;
    }

    public void setCod_lfactura(int cod_lfactura) {
        this.cod_lfactura = cod_lfactura;
    }

    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_cli) {
        this.cod_prod = cod_cli;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }
}
