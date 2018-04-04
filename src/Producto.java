public class Producto {
    private int cod_prod;
    private String descripcion;
    private double importe;

    public Producto() {
    }

    public Producto(int cod_prod, String descripcion, double importe) {
        this.cod_prod = cod_prod;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
