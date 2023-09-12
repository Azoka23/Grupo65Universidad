package grupo65universidad.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

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
            conexion = DriverManager.getConnection(URL+DB+"?useSSL=false&serverTimezone=UTC", USUARIO, PASSWORD);
            JOptionPane.showMessageDialog(null, "Se conecto a la base de datos : "+DB);
        } catch (ClassNotFoundException | SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error al conectarse");
            throw ex ;
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

    protected void insertarModificarEliminar(String sql) throws ClassNotFoundException {
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
    
    protected void consultarBase(String sql) throws Exception{
    try{
    conectarBase();
    //JOptionPane.showMessageDialog(null, "Estamos despues de conectar la base"+sql);
    sentencia=conexion.createStatement();
    //JOptionPane.showMessageDialog(null, "Estamos despues de la sentencia"+sql);
    resultado=sentencia.executeQuery(sql);
    }catch(Exception e){
       // JOptionPane.showMessageDialog(null, "consulta fallida");
    throw e;
    }
    }

}
