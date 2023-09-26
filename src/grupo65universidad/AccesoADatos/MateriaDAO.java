package grupo65universidad.AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import grupo65universidad.Entidades.Materia;

public class MateriaDAO extends DAO {

    public MateriaDAO() throws ClassNotFoundException, SQLException {
        conectarBase();
    }

    public void guardarMateria(Materia materia) throws Exception {
        validarMateria(materia);

        String sql = "INSERT INTO materias (nombre, year, estado) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, materia.getNombre());
            preparedStatement.setInt(2, materia.getAnio());
            preparedStatement.setBoolean(3, materia.isEstado());

            insertarModificarEliminar(preparedStatement);

        } catch (SQLException ex) {
            // Manejar la excepción si es necesario
            throw ex;
        } finally {
            desconectarBase(); // Asegura que la desconexión se realice incluso en caso de excepción.
        }
    }

    public void modificarMateria(Materia materia) throws Exception {
        validarMateria(materia);

        String sql = "UPDATE materias SET nombre=?, year=? WHERE idMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, materia.getNombre());
            preparedStatement.setInt(2, materia.getAnio());
            preparedStatement.setInt(3, materia.getIdMateria());

            insertarModificarEliminar(preparedStatement);
        } catch (SQLException ex) {
            // Manejar la excepción si es necesario
            throw ex;
        } finally {
            desconectarBase(); // Asegura que la desconexión se realice incluso en caso de excepción.
        }
    }

    public void eliminarLogico(int codigo) throws Exception {
        String sql = "UPDATE materias SET estado=? WHERE idMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, codigo);

            insertarModificarEliminar(preparedStatement);

        } catch (SQLException ex) {
            // Manejar la excepción si es necesario
            throw ex;
        } finally {
            desconectarBase(); // Asegura que la desconexión se realice incluso en caso de excepción.
        }
    }

    public int contarTotalRegistros() throws Exception {
        //Cuenta la cantidad de registros y cuando devuelvo el entero necesito sumar 1
        String sql = "SELECT COUNT(*) FROM materias";
        //Obtengo el idMateria max, cuando devuelvo el entero sumo 1 --
        //y en este caso si por algun motivo manualmente borre un registro de la tabla, de esta forma siempre obtengo el numero correcto
        //String sql = "SELECT MAX(idMateria) FROM materias" 
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count + 1;
            }
        } catch (SQLException ex) {
            // Manejar la excepción si es necesario
            throw ex;
        } finally {
            desconectarBase(); // Asegura que la desconexión se realice incluso en caso de excepción.
        }
        return 0; // Devuelve 0 si no se encontraron registros
    }

    public Materia buscarListaMateriaxDni(int idMateria) throws Exception {
        String sql = "SELECT * FROM `materias` WHERE idMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idMateria);

            resultado = consultarBase(preparedStatement);
            
            Materia materia = null;

            if (resultado.next()) {

                materia = obtenerMateriaDesdeResultado(resultado);
            }
            return materia;


        }
    }

    public Materia obtenerMateriaPorId(int idMateria) throws Exception {
        String sql = "SELECT * FROM `materias` WHERE idMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idMateria);
            resultado = consultarBase(preparedStatement);
            
            Materia materia = null;

            if (resultado.next()) {

                materia = obtenerMateriaDesdeResultado(resultado);

            }

            return materia;

        }
    }

    public Collection<Materia> listarMaterias() throws Exception {
        String sql = "SELECT * FROM `materias`";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            resultado = consultarBase(preparedStatement);
            
            Collection<Materia> materias = new ArrayList();

            while (resultado.next()) {
                materias.add(obtenerMateriaDesdeResultado(resultado));
            }

            return materias;

        }
    }

    private void validarMateria(Materia materia) throws Exception {
        if (materia == null) {
            throw new Exception("Debe indicar una Materia");
        }
    }

    private Materia obtenerMateriaDesdeResultado(ResultSet result) throws SQLException {

        Materia materia = new Materia();
        materia.setIdMateria(result.getInt("idMateria"));

        materia.setNombre(result.getString("nombre"));
        materia.setAnio(result.getInt("year"));
        materia.setEstado(result.getBoolean("estado"));

        return materia;
    }
}
