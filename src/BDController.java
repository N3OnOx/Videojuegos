import java.sql.*;
import java.util.ArrayList;

public class BDController {
    private Connection conexion;
    private PreparedStatement existeCliente;
    private PreparedStatement existeProducto;
    private PreparedStatement existeLfactura;
    private PreparedStatement existeFactura;
    private PreparedStatement existeAnnoFactura;
    private PreparedStatement existeFacturaC;

    BDController(){
        try {
            //this.conexion = DriverManager.getConnection("jdbc:mysql://192.168.10.252:3306/videojuegos", "1GS","Nelson2000");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root","");
            String SQLExisteCliente = "SELECT * from clientes where cod_cli = ?";
            this.existeCliente = conexion.prepareStatement(SQLExisteCliente);
            String SQLExisteProducto = "SELECT * from productos where cod_prod = ?";
            this.existeProducto = conexion.prepareStatement(SQLExisteProducto);
            String SQLExisteLfactura = "SELECT * from lfactura where cod_lfactura = ?";
            this.existeLfactura = conexion.prepareStatement(SQLExisteLfactura);
            String SQLExisteFactura = "SELECT * from facturas where cod_factura = ?";
            this.existeFactura = conexion.prepareStatement(SQLExisteFactura);
            String SQLExisteAnnoFactura = "select * from facturas where fecha LIKE ?";
            this.existeAnnoFactura = conexion.prepareStatement(SQLExisteAnnoFactura);
            String SQLExisteFacturaC = "SELECT * from facturas where cod_cli = ?";
            this.existeFacturaC = conexion.prepareStatement(SQLExisteFacturaC);
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
            Statement myStatement = this.conexion.createStatement();
            myStatement.executeUpdate(insert);
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Factura> buscarFacturaN(int codigo){
        String sql="select * from facturas where cod_factura = "+codigo+"";
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            Statement myStatement = this.conexion.createStatement();
            ResultSet rs = myStatement.executeQuery(sql);
            while (rs.next()){
                facturas.add(new Factura(rs.getInt("cod_factura"),rs.getInt("cod_cli"),rs.getString("fecha"),rs.getInt("importe")));
            }
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return facturas;
    }

    public ArrayList<LFactura> buscarLfacturaN(int codigo){
        String sql="select * from lfactura where cod_factura = "+codigo+"";
        ArrayList<LFactura> lfacturas = new ArrayList<>();
        try {
            Statement myStatement = this.conexion.createStatement();
            ResultSet rs = myStatement.executeQuery(sql);
            while (rs.next()){
                lfacturas.add(new LFactura(rs.getInt("cod_lfactura"),rs.getInt("cod_factura"),rs.getInt("importe"),rs.getInt("cod_prod")));
            }
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lfacturas;
    }

    public ArrayList<Factura> buscarFacturaC(int codigo){
        String sql="select * from facturas where cod_cli = "+codigo+"";
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            Statement myStatement = this.conexion.createStatement();
            ResultSet rs = myStatement.executeQuery(sql);
            while (rs.next()){
                facturas.add(new Factura(rs.getInt("cod_factura"),rs.getInt("cod_cli"),rs.getString("fecha"),rs.getInt("importe")));
            }
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return facturas;
    }

    public int buscarImporte(int codigo){
        int importe = 0;
        try {
            Statement miStatement = this.conexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT importe FROM productos where cod_prod=" + codigo + "");
            while (rs.next()){
                importe = rs.getInt(1);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return importe;
    }

    public String buscarClienteN(int codigo){
        String nombreCliente = "";
        try {
            Statement miStatement = this.conexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT nombre FROM clientes where cod_cli=" + codigo + "");
            while (rs.next()){
                nombreCliente = rs.getString(1);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return nombreCliente;
    }

    public String buscarNombreProd(int codProd){
        String nombreProd = "";
        try {
            Statement miStatement = this.conexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT descripcion FROM productos where cod_prod=" + codProd + "");
            while (rs.next()){
                nombreProd = rs.getString(1);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return nombreProd;
    }

    public void eliminarCliente(int codCliente){
        String cliente = "delete c, f, l from clientes as c inner join facturas as f on c.cod_cli = f.cod_cli inner join lfactura as l on l.cod_factura = f.cod_factura where c.cod_cli = "+codCliente+"";
        try {
            Statement myStatement = this.conexion.createStatement();
            if (!existeFacturaC(codCliente)){
                myStatement.executeUpdate("delete from clientes where cod_cli = "+codCliente+";");
            }else{
                myStatement.executeUpdate(cliente);
            }

            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void insertarLFactura(LFactura lFactura){
        String insert ="INSERT INTO lfactura VALUES(\'" + lFactura.getCod_lfactura() + "\',\'" + lFactura.getCod_factura() + "\',\'" + lFactura.getImporte() + "\',\'" + lFactura.getCod_prod() + "\');";
        try {
            Statement myStatement = this.conexion.createStatement();
            myStatement.executeUpdate(insert);
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void actualizarFactura(int importe, int codFactura){
        String insert ="UPDATE facturas set importe = "+importe+" where cod_factura = "+codFactura+";";
        try {
            Statement myStatement = this.conexion.createStatement();
            myStatement.executeUpdate(insert);
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Factura> mostrarFacturasAnno(String anno){
        ArrayList<Factura> facturasAnno = new ArrayList<>();
        String sql = "select * from facturas where fecha LIKE '%"+anno+"'";
        try {
            Statement myStatement = this.conexion.createStatement();
            ResultSet rs = myStatement.executeQuery(sql);
            while (rs.next()){
                facturasAnno.add(new Factura(rs.getInt("cod_factura"),rs.getInt("cod_cli"),rs.getString("fecha"),rs.getInt("importe")));
            }
            myStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return facturasAnno;
    }

    public boolean existeLfactura(int codigo){
        boolean existe = true;
        try {
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

    public boolean existeFactura(int codigo){
        boolean existe = true;
        try {
            existeFactura.setInt(1, codigo);
            ResultSet rs = existeFactura.executeQuery();
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

    public boolean existeAnnoFactura(String anno){
        boolean existe = true;
        try {
            existeAnnoFactura.setString(1, "%"+anno);
            ResultSet rs = existeAnnoFactura.executeQuery();
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
    public boolean existeFacturaC(int codCliente){
        boolean existe = true;
        try {
            existeFacturaC.setInt(1, codCliente);
            ResultSet rs = existeFacturaC.executeQuery();
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
