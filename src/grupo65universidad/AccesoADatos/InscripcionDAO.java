package grupo65universidad.AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import grupo65universidad.Entidades.Alumno;
import grupo65universidad.Entidades.Materia;

public class InscripcionDAO extends DAO {

    public InscripcionDAO() throws ClassNotFoundException, SQLException {
        conectarBase();
    }

    public void guardarInscripcion(int idAlumno, int idMateria, JInternalFrame internalFrame) throws Exception {

        String sql = "INSERT INTO inscripciones (nota, idAlumno, idMateria)"
                + "VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setDouble(1, 0.0);
            preparedStatement.setInt(2, idAlumno);
            preparedStatement.setInt(3, idMateria);
            insertarModificarEliminar(preparedStatement);

            if (filasAfectadas > 0) {
                // Se eliminaron registros exitosamente
                JOptionPane.showMessageDialog(internalFrame, "Se guardaron");
            } else {
                // No se encontraron registros para eliminar
                JOptionPane.showMessageDialog(internalFrame, "No se pudo guadar");
            }
        } catch (SQLException ex) {
            // Manejar la excepción si es necesario
            throw ex;
        } finally {
            desconectarBase(); // Asegura que la desconexión se realice incluso en caso de excepción.
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota, JInternalFrame internalFrame) throws Exception {

        String sql = "UPDATE inscripciones SET nota=? WHERE idAlumno=? AND idMateria=? ";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setDouble(1, nota);
            preparedStatement.setInt(2, idAlumno);
            preparedStatement.setInt(3, idMateria);

            insertarModificarEliminar(preparedStatement);
            if (filasAfectadas > 0) {
                // Se eliminaron registros exitosamente
                JOptionPane.showMessageDialog(internalFrame, "Nota actualizada");
            } else {
                // No se encontraron registros para eliminar
                JOptionPane.showMessageDialog(internalFrame, "No se pudo actualizar la nota");
            }
        } catch (SQLException ex) {
            // Manejar la excepción si es necesario
            throw ex;
        //} finally {
         //   desconectarBase(); // Asegura que la desconexión se realice incluso en caso de excepción.
        }

    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria, JInternalFrame internalFrame) throws Exception {

        String sql = "DELETE FROM inscripciones WHERE idAlumno = ? AND idMateria = ? AND (nota = 0 OR nota IS NULL)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idAlumno);
            preparedStatement.setInt(2, idMateria);
            insertarModificarEliminar(preparedStatement);
            if (filasAfectadas > 0) {
                // Se eliminaron registros exitosamente
                JOptionPane.showMessageDialog(internalFrame, "Se eliminaron registros exitosamente");
            } else {
                // No se encontraron registros para eliminar
                JOptionPane.showMessageDialog(internalFrame, "No se encontraron registros para eliminar, Nota distinto de 0");
            }
        } catch (SQLException ex) {
            // Manejar la excepción si es necesario
            throw ex;
        } finally {
            desconectarBase(); // Asegura que la desconexión se realice incluso en caso de excepción.
        }

    }

    public void eliminarInscripto(int idInscripto) throws Exception {
        String sql = "DELETE FROM inscripciones WHERE idInscripto=?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idInscripto);
            insertarModificarEliminar(preparedStatement);
        } catch (SQLException ex) {
            // Manejar la excepción si es necesario
            throw ex;
        } finally {
            desconectarBase(); // Asegura que la desconexión se realice incluso en caso de excepción.
        }

    }

    public Collection<Materia> obtenerMateriaCursada(int idAlumno) throws Exception {

        MateriaDAO materiaDAO = new MateriaDAO();

        String sql = "SELECT DISTINCT m.idMateria, m.nombre "
                + "FROM materias m "
                + "JOIN inscripciones i ON m.idMateria = i.idMateria "
                + "WHERE i.idAlumno = ? ";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idAlumno);
            resultado = consultarBase(preparedStatement);
            
            Collection<Materia> materias = new ArrayList();
            while (resultado.next()) {
                int idMateria = resultado.getInt("idMateria");
                materias.add(materiaDAO.obtenerMateriaPorId(idMateria));
            }
            return materias;
        }
    }

    public Collection<Materia> obtenerMateriaNOCursada(int idAlumno) throws Exception {

        // Crear una instancia de MateriaDAO
        MateriaDAO materiaDAO = new MateriaDAO();

        String sql = "SELECT m.idMateria, m.nombre "
                + "FROM materias m "
                + "LEFT JOIN inscripciones i ON m.idMateria = i.idMateria AND i.idAlumno = ? "
                + "WHERE i.idMateria IS NULL ";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAlumno);

            resultado = consultarBase(preparedStatement);
            
            Collection<Materia> materias = new ArrayList();

            while (resultado.next()) {

                int idMateria = resultado.getInt("idMateria");

                materias.add(materiaDAO.obtenerMateriaPorId(idMateria));
            }

            return materias;
        }

    }

    public Collection<Alumno> obtenerAlumnoxMateria(int idMateria) throws Exception {

        // Crear una instancia de AlumnoDAO
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        String sql = "SELECT a.idAlumno, a.dni, a.apellido, a.nombre "
                + "FROM alumnos a "
                + "INNER JOIN inscripciones i ON a.idAlumno = i.idAlumno "
                + "WHERE i.idMateria = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idMateria);
            resultado = consultarBase(preparedStatement);
           
            Collection<Alumno> alumnos = new ArrayList();

            while (resultado.next()) {
                int idAlumno = resultado.getInt("idAlumno");
                alumnos.add(alumnoDAO.obtenerAlumnoPorId(idAlumno));
            }
            return alumnos;
        }

    }

    public double buscarNota(int idAlumno, int idMateria) throws Exception {
        double nota = 0.0;
        MateriaDAO materiaDAO = new MateriaDAO();

        String sql = "SELECT i.nota FROM inscripciones i "
                + "WHERE i.idAlumno=? AND i.idMateria=? ";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAlumno);
            preparedStatement.setInt(2, idMateria);

            resultado = consultarBase(preparedStatement);
           

            while (resultado.next()) {

                nota = resultado.getDouble("nota");
            }

            return nota;
        }

    }
}
