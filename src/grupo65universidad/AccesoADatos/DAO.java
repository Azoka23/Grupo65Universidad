package grupo65universidad.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import javax.swing.JOptionPane;

public class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    private final String USUARIO = "root";
    private final String PASSWORD = "";
    private final String DB = "Universidad";
    private final String DRIVER = "org.mariadb.jdbc.Driver";
    private final String URL = "jdbc:mariadb://Localhost:3306/DataBase";

    protected void conectarBase() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse");
        }
    }

    protected void desconectarBase()  {
        try{
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

    protected void insertarModificarEliminar(String sql) {
        try {
            conectarBase();
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            //conexion.rollback();//vuelve atras y omite todo
            //set.autocommit = 1;
            //Commit;
            JOptionPane.showMessageDialog(null, "Ejecucion satisfactoria");
            
        } finally {
            desconectarBase();
        }
    }
    
    protected void consultarBase(String sql){
    try{
    conectarBase();
    sentencia=conexion.createStatement();
    resultado=sentencia.executeQuery(sql);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "consulta exitosa");
    }
    }

}
