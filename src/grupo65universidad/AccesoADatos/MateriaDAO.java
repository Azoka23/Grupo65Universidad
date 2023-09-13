package grupo65universidad.AccesoADatos;

import grupo65universidad.Entidades.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;




public class MateriaDAO extends DAO {

    public MateriaDAO() throws ClassNotFoundException, SQLException {
        conectarBase();
    }

    public void guardarMateria(Materia materia) throws Exception {

        try {
            validarMateria(materia);

            String sql = "INSERT INTO materias (nombre, year, estado)"
                    + "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, materia.getNombre());
            preparedStatement.setInt(2, materia.getAnio());
            preparedStatement.setBoolean(3, materia.isEstado());

            insertarModificarEliminar(preparedStatement);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarMateria(Materia materia) throws Exception {

        try {
            validarMateria(materia);

            String sql = "UPDATE materias SET nombre=?, year=? WHERE idMateria=?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, materia.getNombre());
            preparedStatement.setInt(2, materia.getAnio());
            //preparedStatement.setBoolean(3, materia.isEstado());
            preparedStatement.setInt(3, materia.getIdMateria());

            insertarModificarEliminar(preparedStatement);

        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminarLogico(int codigo) throws Exception {
        String sql = "UPDATE materias SET estado=? WHERE idMateria=?";

        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, codigo);

            insertarModificarEliminar(preparedStatement);

        } catch (Exception e) {
            throw e;
        }

    }

    public Materia buscarListaMateriaxDni(int idMateria) throws Exception {
        String sql = "SELECT * FROM `materias` WHERE idMateria=?";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idMateria);

            ResultSet resultado = consultarBase(preparedStatement);
            //consultarBase(sql);
            Materia materia = null;

            if (resultado.next()) {

                materia = obtenerMateriaDesdeResultado(resultado);
            }
            return materia;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    public Materia obtenerMateriaPorId(int idMateria) throws Exception {
        String sql = "SELECT * FROM `alumnos` WHERE idAlumno=?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idMateria);

            ResultSet resultado = consultarBase(preparedStatement);
            Materia materia = null;

            if (resultado.next()) {
                materia = obtenerMateriaDesdeResultado(resultado);
            }

            return materia;
        }
    }
    public Collection<Materia> listarMaterias() throws Exception {

        try {

            String sql = "SELECT * FROM `materias`";
            consultarBase(sql);
            Materia materia = null;
            Collection<Materia> materias = new ArrayList();

            while (resultado.next()) {

                materia = new Materia();

                materia.setIdMateria(resultado.getInt("idMateria"));
                materia.setNombre(resultado.getString("nombre"));
                materia.setAnio(resultado.getInt("year"));
                materia.setEstado(resultado.getBoolean("estado"));

                materias.add(materia);

            }
            return materias;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    private void validarMateria(Materia materia) throws Exception {
        if (materia == null) {
            throw new Exception("Debe indicar una Materia");
        }
    }

    private Materia obtenerMateriaDesdeResultado(ResultSet resultado) throws SQLException {

        Materia materia = new Materia();

        materia.setIdMateria(resultado.getInt("idMateria"));
        materia.setNombre(resultado.getString("nombre"));
        materia.setAnio(resultado.getInt("year"));
        materia.setEstado(resultado.getBoolean("estado"));

        return materia;
    }
}
