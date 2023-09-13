package grupo65universidad.AccesoADatos;

import grupo65universidad.Entidades.Alumno;
import grupo65universidad.Entidades.Inscripcion;
import grupo65universidad.Entidades.Materia;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class InscripcionDAO extends DAO {

    public void guardarMovimiento(Inscripcion inscripcion) throws Exception {

        try {
            if (inscripcion == null) {
                throw new Exception("Debe indicar una Inscripcion");
            }

            String sql = "INSERT INTO inscripciones (nota, idAlumno, idMateria)"
                    + "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setInt(1, inscripcion.getNota());
            preparedStatement.setInt(2, inscripcion.getIdAlumno().getIdAlumno());
            preparedStatement.setInt(3, inscripcion.getIdMateria().getIdMateria());

            insertarModificarEliminar(preparedStatement);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarMovimientoId(Inscripcion inscripcion) throws Exception {

        try {
            if (inscripcion == null) {
                throw new Exception("Debe indicar el movimiento que deses modificar");
            }

            String sql = "UPDATE inscripciones SET nota=?, idAlumno=?, idMateria=? WHERE idInscripcion=?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setInt(1, inscripcion.getNota());
            preparedStatement.setInt(2, inscripcion.getIdAlumno().getIdAlumno());
            preparedStatement.setInt(3, inscripcion.getIdMateria().getIdMateria());
            preparedStatement.setInt(4, inscripcion.getIdInscripto());
            insertarModificarEliminar(preparedStatement);

        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminarInscripto(int idInscripto) throws Exception {

        try {

            String sql = "DELETE FROM inscripciones WHERE idInscripto=?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idInscripto);
            insertarModificarEliminar(preparedStatement);

        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Inscripcion> listarInscripcionesPorAlumno() throws Exception {
        // Crear una instancia de EmpleadoDAO

        AlumnoDAO alumnoDAO = new AlumnoDAO();
        // Crear una instancia de HerramientaDAO
        MateriaDAO materiaDAO = new MateriaDAO();

        try {

            String sql = "SELECT * FROM `inscriptiones` WHERE idAlumno=?";

            consultarBase(sql);
            Inscripcion inscripcion = null;
            Collection<Inscripcion> inscripciones = new ArrayList();

            while (resultado.next()) {

                inscripcion = new Inscripcion();

                inscripcion.setIdInscripto(resultado.getInt("idInscripto"));
                inscripcion.setNota(resultado.getInt("nota"));

                int idAlumno = resultado.getInt("idAlumno");
                int idMateria = resultado.getInt("idMateria");

                //otra forma es hacerlo mas robusto cambiando el contructor y instanciarlo en el main
                Alumno alumno = alumnoDAO.obtenerAlumnoPorId(idAlumno);
                Materia materia = materiaDAO.obtenerMateriaPorId(idMateria);

                inscripcion.setIdAlumno(alumno);
                inscripcion.setIdMateria(materia);

                inscripciones.add(inscripcion);
            }
            return inscripciones;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Inscripcion> listarMateriasInscriptasxAlumno() throws Exception {
        // Crear una instancia de EmpleadoDAO

        AlumnoDAO alumnoDAO = new AlumnoDAO();
        // Crear una instancia de HerramientaDAO
        MateriaDAO materiaDAO = new MateriaDAO();

        try {

            String sql = "SELECT  FROM alumnos a JOIN incripciones i ON(a.idAlumno=i.idAlumno) "
                    + "JOIN materias m ON (i.idMateria=m.idMateria)";
 try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            ResultSet resultado = consultarBase(preparedStatement);
            Collection<Alumno> alumnos = new ArrayList<>();
//            consultarBase(sql);

            Inscripcion inscripcion = null;
            Collection<Inscripcion> inscripciones = new ArrayList();

            while (resultado.next()) {

                inscripcion = new Inscripcion();

                inscripcion.setIdInscripto(resultado.getInt("idInscripto"));
                inscripcion.setNota(resultado.getInt("nota"));

                int idAlumno = resultado.getInt("idAlumno");
                int idMateria = resultado.getInt("idMateria");

                //otra forma es hacerlo mas robusto cambiando el contructor y instanciarlo en el main
                Alumno alumno = alumnoDAO.obtenerAlumnoPorId(idAlumno);
                Materia materia = materiaDAO.obtenerMateriaPorId(idMateria);

                inscripcion.setIdAlumno(alumno);
                inscripcion.setIdMateria(materia);

                inscripciones.add(inscripcion);
            }
            return inscripciones;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Materia> materiasInscriptas() {
        ArrayList<Materia> listaMaterias = new ArrayList<>();

       
        "SELECT  FROM alumnos a JOIN incripciones i ON(a.idAlumno=i.idAlumno)
   JOIN materias m ON (i.idMateria = m.idMateria
    

    )"
    }
    
    
    public Collection<Materia> materiasNoInscriptas() {
    }
}
