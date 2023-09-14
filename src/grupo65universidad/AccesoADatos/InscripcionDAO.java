package grupo65universidad.AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import grupo65universidad.Entidades.Alumno;
import grupo65universidad.Entidades.Inscripcion;
import grupo65universidad.Entidades.Materia;

public class InscripcionDAO extends DAO {

    public InscripcionDAO() throws ClassNotFoundException, SQLException {
        conectarBase();
    }

    public void guardarMovimiento(Inscripcion inscripcion) throws Exception {
        if (inscripcion == null) {
            throw new Exception("Debe indicar una Inscripcion");
        }
        String sql = "INSERT INTO inscripciones (nota, idAlumno, idMateria)"
                + "VALUES (?, ?, ?)";

        // PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, inscripcion.getNota());
            preparedStatement.setInt(2, inscripcion.getIdAlumno().getIdAlumno());
            preparedStatement.setInt(3, inscripcion.getIdMateria().getIdMateria());

            insertarModificarEliminar(preparedStatement);

//        } catch (Exception e) {
//            throw e;
        }
    }

    public void modificarMovimientoId(Inscripcion inscripcion) throws Exception {
        if (inscripcion == null) {
            throw new Exception("Debe indicar el movimiento que deses modificar");
        }
        String sql = "UPDATE inscripciones SET nota=?, idAlumno=?, idMateria=? WHERE idInscripcion=?";

        //try {
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            //PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, inscripcion.getNota());
            preparedStatement.setInt(2, inscripcion.getIdAlumno().getIdAlumno());
            preparedStatement.setInt(3, inscripcion.getIdMateria().getIdMateria());
            preparedStatement.setInt(4, inscripcion.getIdInscripto());
            //insertarModificarEliminar(sql);

//        } catch (Exception e) {
//            throw e;
        }

    }

    public void eliminarInscripto(int idInscripto) throws Exception {
        String sql = "DELETE FROM inscripciones WHERE idInscripto=?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            //PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idInscripto);
            insertarModificarEliminar(preparedStatement);

//        } catch (Exception e) {
//            throw e;
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

        //Materia materia = new Materia();
        // Crear una instancia de EmpleadoDAO
        //AlumnoDAO alumnoDAO = new AlumnoDAO();
        // Crear una instancia de HerramientaDAO
        MateriaDAO materiaDAO = new MateriaDAO();

//        String sql = "SELECT * FROM alumnos a"
//                + "JOIN inscripciones i ON(a.idAlumno=i.idAlumno)"
//                + "JOIN materias m ON (i.idMateria=m.idMateria)"
//                + "WHERE i.idAlumno=?";
        String sql = "SELECT DISTINCT m.idMateria, m.nombre "
                + "FROM materias m "
                + "JOIN inscripciones i ON m.idMateria = i.idMateria "
                + "WHERE i.idAlumno = ? ";
//JOptionPane.showMessageDialog(null, idAlumno);

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAlumno);

            //ResultSet 
            resultado = consultarBase(preparedStatement);

            Collection<Materia> materias = new ArrayList();

            while (resultado.next()) {

                int idMateria = resultado.getInt("idMateria");
                //materia.setIdMateria(resultado.getInt("idMateria"));

                //  JOptionPane.showMessageDialog(null, idMateria);
                materias.add(materiaDAO.obtenerMateriaPorId(idMateria));
            }

            //JOptionPane.showMessageDialog(null, resultado);
            return materias;
        }
    }
//        SELECT * FROM alumnos a 
//JOIN inscripciones i ON(a.idAlumno=i.idAlumno)
//JOIN materias m ON (i.idMateria=m.idMateria)
//WHERE i.idAlumno=1;

    public Collection<Materia> obtenerMateriaNOCursada(int idAlumno) throws Exception {

        // Materia materia = new Materia();
        // Crear una instancia de EmpleadoDAO
        //AlumnoDAO alumnoDAO = new AlumnoDAO();
        // Crear una instancia de HerramientaDAO
        MateriaDAO materiaDAO = new MateriaDAO();

        String sql = "SELECT m.idMateria, m.nombre "
                + "FROM materias m "
                + "LEFT JOIN inscripciones i ON m.idMateria = i.idMateria AND i.idAlumno = ? "
                + "WHERE i.idMateria IS NULL ";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAlumno);

            //ResultSet 
            resultado = consultarBase(preparedStatement);
            Collection<Materia> materias = new ArrayList();

            while (resultado.next()) {

                int idMateria = resultado.getInt("idMateria");
                //materia.setIdMateria(resultado.getInt("idMateria"));

                materias.add(materiaDAO.obtenerMateriaPorId(idMateria));
            }

            return materias;
        }

    }

}
