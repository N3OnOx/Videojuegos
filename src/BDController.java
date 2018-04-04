import java.sql.*;

public class BDController {
    private Connection conexion;
    private PreparedStatement existeCliente;
    private PreparedStatement existeProducto;
    private PreparedStatement existeLfactura;
    BDController(){
        try {
            this.conexion = DriverManager.getConnection("jdbc:mysql://192.168.10.252:3306/videojuegos", "1GS","Nelson2000");
            String SQLExisteCliente = "SELECT * from clientes where cod_cli = ?";
            this.existeCliente = conexion.prepareStatement(SQLExisteCliente);
            String SQLExisteProducto = "SELECT * from productos where cod_prod = ?";
            this.existeProducto = conexion.prepareStatement(SQLExisteProducto);
            String SQLExisteLfactura = "SELECT * from lfactura where cod_lfactura = ?";
            this.existeLfactura = conexion.prepareStatement(SQLExisteLfactura);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void altaCliente(Cliente cliente){
        String insert ="INSERT INTO clientes VALUES('" + cliente.getCod_cli() + "','" + cliente.getNombre() + "','" + cliente.getDireccion() + "','" + cliente.getTelefono() + "','" + cliente.getNif() + "');";
        try {
            Statement myStatement = this.conexion.createStatement();
            myStatement.executeUpdate(insert);
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void altaProducto(Producto producto){
        String insert ="INSERT INTO productos VALUES('" + producto.getCod_prod() + "','" + producto.getDescripcion() + "','" + producto.getImporte() + "');";
        try {
            System.out.print("");
            Statement myStatement = this.conexion.createStatement();
            myStatement.executeUpdate(insert);
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void realizarVenta(Factura factura){
        String insert ="INSERT INTO facturas VALUES(\'" + factura.getCod_factura() + "\',\'" + factura.getCod_cli() + "\',\'" + factura.getFecha() + "\',\'" + factura.getImporte() + "\');";
        try {
            System.out.println("---");
            Statement myStatement = this.conexion.createStatement();
            myStatement.executeUpdate(insert);
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarLFactura(LFactura lFactura){
        String insert ="INSERT INTO lfactura VALUES(\'" + lFactura.getCod_lfactura() + "\',\'" + lFactura.getCod_factura() + "\',\'" + lFactura.getImporte() + "\',\'" + lFactura.getCod_prod() + "\');";
        try {
            System.out.println("----");
            Statement myStatement = this.conexion.createStatement();
            myStatement.executeUpdate(insert);
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean existeLfactura(int codigo){
        boolean existe = true;
        try {
            System.out.println(" ");
            existeLfactura.setInt(1, codigo);
            ResultSet rs = existeLfactura.executeQuery();
            if (rs.first() == true){
                existe = true;
            }else{
                existe = false;
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return existe;
    }

    public boolean existeCliente(int cod_cli){
        boolean existe = true;
        try {
            existeCliente.setInt(1, cod_cli);
            ResultSet rs = existeCliente.executeQuery();
            if (rs.first() == true){
                existe = true;
            }else{
                existe = false;
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return existe;
    }

    public boolean existeProducto(int cod_prod){
        boolean existe = true;
        try {
            System.out.print("");
            existeProducto.setInt(1, cod_prod);
            ResultSet rs = existeProducto.executeQuery();
            if (rs.first() == true){
                existe = true;
            }else{
                existe = false;
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return existe;
    }
}
