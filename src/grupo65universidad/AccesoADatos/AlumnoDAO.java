package grupo65universidad.AccesoADatos;

import grupo65universidad.Entidades.Alumno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AlumnoDAO extends DAO {

    public AlumnoDAO() throws ClassNotFoundException, SQLException {
        conectarBase();
    }

    public void guardarAlumno(Alumno alumno) throws Exception {
        validarAlumno(alumno);

        String sql = "INSERT INTO alumnos (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, alumno.getDni());
            preparedStatement.setString(2, alumno.getApellido());
            preparedStatement.setString(3, alumno.getNombre());
            preparedStatement.setDate(4, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
            preparedStatement.setBoolean(5, alumno.isEstado());

            insertarModificarEliminar(preparedStatement);
        }
    }

    public void modificarAlumno(Alumno alumno) throws Exception {
        validarAlumno(alumno);

        String sql = "UPDATE alumnos SET apellido=?, nombre=?, fechaNacimiento=? WHERE dni=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, alumno.getApellido());
            preparedStatement.setString(2, alumno.getNombre());
            preparedStatement.setDate(3, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
            preparedStatement.setInt(4, alumno.getDni());

            insertarModificarEliminar(preparedStatement);
        }
    }

    public void eliminarLogico(int dni) throws Exception {
        String sql = "UPDATE alumnos SET estado=? WHERE dni=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, dni);

            insertarModificarEliminar(preparedStatement);
        }
    }

    public Alumno buscarListaAlumnoxDni(int dni) throws Exception {
        String sql = "SELECT * FROM `alumnos` WHERE dni=?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, dni);

            ResultSet resultado = consultarBase(preparedStatement);
            Alumno alumno = null;

            if (resultado.next()) {
                alumno = obtenerAlumnoDesdeResultado(resultado);
            }

            return alumno;
        }
    }

    public Alumno obtenerAlumnoPorId(int idAlumno) throws Exception {
        String sql = "SELECT * FROM `alumnos` WHERE idAlumno=?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idAlumno);

            ResultSet resultado = consultarBase(preparedStatement);
            Alumno alumno = null;

            if (resultado.next()) {
                alumno = obtenerAlumnoDesdeResultado(resultado);
            }

            return alumno;
        }
    }

    public Collection<Alumno> listarAlumnos() throws Exception {
        String sql = "SELECT * FROM `alumnos`";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            ResultSet resultado = consultarBase(preparedStatement);
            Collection<Alumno> alumnos = new ArrayList<>();

            while (resultado.next()) {
                alumnos.add(obtenerAlumnoDesdeResultado(resultado));
            }

            return alumnos;
        }
    }

    private void validarAlumno(Alumno alumno) throws Exception {
        if (alumno == null) {
            throw new Exception("Debe indicar un Alumno");
        }
    }

    private Alumno obtenerAlumnoDesdeResultado(ResultSet resultado) throws SQLException {
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(resultado.getInt("idAlumno"));
        alumno.setDni(resultado.getInt("dni"));
        alumno.setApellido(resultado.getString("apellido"));
        alumno.setNombre(resultado.getString("nombre"));
        alumno.setFechaNacimiento(resultado.getDate("fechaNacimiento").toLocalDate());
        alumno.setEstado(resultado.getBoolean("estado"));
        return alumno;
    }
}
