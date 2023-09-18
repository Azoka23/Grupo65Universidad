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

            preparedStatement.setInt(1, 0);
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
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, int nota, JInternalFrame internalFrame) throws Exception {

        String sql = "UPDATE inscripciones SET nota=? WHERE idAlumno=? AND idMateria=? ";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql) ;

            preparedStatement.setInt(1, nota);
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(internalFrame, "error: "+ex);
        }

    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria,JInternalFrame internalFrame) throws Exception {

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
        }

    }

    public void eliminarInscripto(int idInscripto) throws Exception {
        String sql = "DELETE FROM inscripciones WHERE idInscripto=?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idInscripto);
            insertarModificarEliminar(preparedStatement);
        }

    }

//    public Collection<Inscripcion> listarInscripcionesPorAlumno() throws Exception {
//        // Crear una instancia de EmpleadoDAO
//
//        AlumnoDAO alumnoDAO = new AlumnoDAO();
//        // Crear una instancia de HerramientaDAO
//        MateriaDAO materiaDAO = new MateriaDAO();
//        String sql = "SELECT * FROM `inscriptiones` WHERE idAlumno=?";
//
//        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
//
//            // consultarBase(sql);
//            Inscripcion inscripcion = null;
//            Collection<Inscripcion> inscripciones = new ArrayList();
//
//            while (resultado.next()) {
//
//                inscripcion = new Inscripcion();
//
//                inscripcion.setIdInscripto(resultado.getInt("idInscripto"));
//                inscripcion.setNota(resultado.getInt("nota"));
//
//                int idAlumno = resultado.getInt("idAlumno");
//                int idMateria = resultado.getInt("idMateria");
//
//                //otra forma es hacerlo mas robusto cambiando el contructor y instanciarlo en el main
//                Alumno alumno = alumnoDAO.obtenerAlumnoPorId(idAlumno);
//                Materia materia = materiaDAO.obtenerMateriaPorId(idMateria);
//
//                inscripcion.setIdAlumno(alumno);
//                inscripcion.setIdMateria(materia);
//
//                inscripciones.add(inscripcion);
//            }
//            return inscripciones;
//
//        } catch (Exception e) {
//            desconectarBase();
//            throw e;
//        }
//    }
    public Collection<Materia> obtenerMateriaCursada(int idAlumno) throws Exception {
        //Materia materia = new MateriaDAO();

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

    public int buscarNota(int idAlumno, int idMateria) throws Exception {
        int nota = 0;
        // Materia materia = new Materia();
        // Crear una instancia de EmpleadoDAO
        //AlumnoDAO alumnoDAO = new AlumnoDAO();
        // Crear una instancia de HerramientaDAO
        MateriaDAO materiaDAO = new MateriaDAO();

        String sql = "SELECT i.nota FROM inscripciones i "
                + "WHERE i.idAlumno=? AND i.idMateria=? ";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAlumno);
            preparedStatement.setInt(2, idMateria);

            resultado = consultarBase(preparedStatement);

            while (resultado.next()) {

                nota = resultado.getInt("nota");
            }

            return nota;
        }

    }
}
