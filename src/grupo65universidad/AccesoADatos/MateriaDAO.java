package grupo65universidad.AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import grupo65universidad.Entidades.Materia;//corregir

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

//        } catch (Exception e) {
//            throw e;
        }
    }

    public void modificarMateria(Materia materia) throws Exception {
        validarMateria(materia);

        String sql = "UPDATE materias SET nombre=?, year=? WHERE idMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            //PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, materia.getNombre());
            preparedStatement.setInt(2, materia.getAnio());
            //preparedStatement.setBoolean(3, materia.isEstado());
            preparedStatement.setInt(3, materia.getIdMateria());

            insertarModificarEliminar(preparedStatement);

//        } catch (Exception e) {
//            throw e;
        }

    }

    public void eliminarLogico(int codigo) throws Exception {
        String sql = "UPDATE materias SET estado=? WHERE idMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, codigo);

            insertarModificarEliminar(preparedStatement);

//        } catch (Exception e) {
//            throw e;
        }

    }

    public Materia buscarListaMateriaxDni(int idMateria) throws Exception {
        String sql = "SELECT * FROM `materias` WHERE idMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idMateria);

            //ResultSet 
            resultado = consultarBase(preparedStatement);
            //consultarBase(sql);
            Materia materia = null;

            if (resultado.next()) {

                materia = obtenerMateriaDesdeResultado(resultado);
            }
            return materia;

//        } catch (Exception e) {
//            desconectarBase();
//            throw e;
        }
    }

    public Materia obtenerMateriaPorId(int idMateria) throws Exception {
        String sql = "SELECT * FROM `materias` WHERE idMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idMateria);
            //JOptionPane.showMessageDialog(null, resultado+"antes de consultar");
            //ResultSet 
            resultado = consultarBase(preparedStatement);
            // JOptionPane.showMessageDialog(null, resultado+"despues de consultar");
            Materia materia = null;

            if (resultado.next()) {

                materia = obtenerMateriaDesdeResultado(resultado);

            }

            return materia;
        }
    }

    public Collection<Materia> listarMaterias() throws Exception {
        String sql = "SELECT * FROM `materias`";
        //Materia materia = null;

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            //ResultSet 
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
        //JOptionPane.showMessageDialog(null, result);
        materia.setIdMateria(result.getInt("idMateria"));

        materia.setNombre(result.getString("nombre"));
        materia.setAnio(result.getInt("year"));
        materia.setEstado(result.getBoolean("estado"));

        return materia;
    }
}
