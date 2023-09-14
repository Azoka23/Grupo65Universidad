package grupo65universidad.AccesoADatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Set;
import javax.swing.JOptionPane;

public class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USUARIO = "root";
    private final String PASSWORD = "";
    private final String DB = "universidad";
    private final String DRIVER = "org.mariadb.jdbc.Driver";
    private final String URL = "jdbc:mariadb://Localhost:3306/";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL + DB + "?useSSL=false&serverTimezone=UTC", USUARIO, PASSWORD);
           
        } catch (ClassNotFoundException | SQLException ex) {
 
            throw ex;
        }
    }

    protected void desconectarBase() {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al desconectarse");
        }
    }

    protected void insertarModificarEliminar(String sql) throws ClassNotFoundException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ejecucion satisfactoria");

        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "consulta exitosa");
        }
    }

    protected ResultSet consultarBase(PreparedStatement preparedStatement) {
        try {
            // Ejecutar la consulta
            ResultSet resultado = preparedStatement.executeQuery();
            return resultado;
        } catch (SQLException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No encontro el DNI");
            return null; // Devuelve null en caso de error
        }
    }

    protected void insertarModificarEliminar(PreparedStatement preparedStatement) throws ClassNotFoundException {
        try {

            // En su lugar, ejecuta la PreparedStatement que recibiste como argumento
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se ejecuto");

        } finally {
            desconectarBase();
        }
    }

}