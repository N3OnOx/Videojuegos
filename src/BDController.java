import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDController {
    private Connection conexion;
    private PreparedStatement existeCliente;
    BDController(){
        try {
            this.conexion = DriverManager.getConnection("jdbc:mysql://192.168.10.252:3306/videojuegos", "1GS","Nelson2000");
            String SQLExisteCliente = "SELECT cod_cli from clientes where cod_cli = ?";
            this.existeCliente = conexion.prepareStatement(SQLExisteCliente);
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
}
