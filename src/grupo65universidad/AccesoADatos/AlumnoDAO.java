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

    
    

    public void modificarAlumno(Alumno alumno) throws Exception {
        try {
            if (alumno == null) {
                throw new Exception("Debes indicar un alumno");
            }

            String sql = "UPDATE alumnos SET (apellido=?,nombre=?,fechaNacimiento=?,estado=?)"
                    + " WHERE dni=?";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, alumno.getApellido());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(4, alumno.isEstado());
            ps.setInt(5, alumno.getDni());
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
        }
    
    
    public void eliminarAlumnoLogico(Alumno alumno) throws Exception{
    try {
            if (alumno == null) {
                throw new Exception("Debes indicar un alumno");
            }
            String sql = "UPDATE alumnos SET (estado=?)"
                    + " WHERE dni=?";
            PreparedStatement ps = conexion.prepareStatement(sql);

          
            ps.setBoolean(1, false);
            ps.setInt(2, alumno.getDni());
            insertarModificarEliminar(sql);
            
        }catch(Exception e){
        throw e;
        }
    }
    
    
    
    public void buscarAlumnoxDni(int dni ) {
        try {
            if (alumno == null) {
                throw new Exception("Debes indicar un alumno");
            }
        }
    }
    
    }

