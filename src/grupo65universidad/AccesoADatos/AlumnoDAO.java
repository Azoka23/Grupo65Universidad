package grupo65universidad.AccesoADatos;

import grupo65universidad.Entidades.Alumno;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AlumnoDAO extends DAO {

    public void guardarAlumno(Alumno alumno) throws Exception {
        try {
            if (alumno == null) {
                throw new Exception("Debes indicar un alumno");
            }
            String sql = "INSERT INTO alumnos (dni,apellido,nombre,fechaNacimiento,estado)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
