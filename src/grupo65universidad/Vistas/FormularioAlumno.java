package grupo65universidad.Vistas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import grupo65universidad.AccesoADatos.AlumnoDAO;
import grupo65universidad.Entidades.Alumno;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class FormularioAlumno extends javax.swing.JInternalFrame {

    private JButton botonAnterior = null; // Variable para almacenar el botón anterior

    /**
     * Creates new form InfoAlumno
     */
    public FormularioAlumno() {
        initComponents();
        
        setTitle("Cargar Alumno");
        editarAlumno(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLDocumento = new javax.swing.JLabel();
        jTDocumento = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jLApellido = new javax.swing.JLabel();
        jTApellido = new javax.swing.JTextField();
        jLNombre = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jLEstado = new javax.swing.JLabel();
        jRBEstado = new javax.swing.JRadioButton();
        jLFechaNacimiento = new javax.swing.JLabel();
        jBNuevo = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jDCHFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(0, 51, 51));
        setClosable(true);
        setTitle("Alumno");
        setFocusable(false);

        jLDocumento.setForeground(new java.awt.Color(255, 255, 255));
        jLDocumento.setText("Documento");

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grupo65universidad/Vistas/Imagenes/search_find_lupa_21889.png"))); // NOI18N
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLApellido.setForeground(new java.awt.Color(255, 255, 255));
        jLApellido.setText("Apellido");

        jTApellido.setEditable(false);

        jLNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLNombre.setText("Nombre");

        jTNombre.setEditable(false);

        jLEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLEstado.setText("Estado");

        jRBEstado.setBackground(new java.awt.Color(0, 51, 51));

        jLFechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        jLFechaNacimiento.setText("Fecha de Nacimiento");

        jBNuevo.setText("Nuevo");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLFechaNacimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDCHFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLApellido)
                            .addComponent(jLNombre)
                            .addComponent(jLEstado))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jRBEstado)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(jTApellido)
                                    .addComponent(jTNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBBuscar)
                                .addGap(59, 59, 59))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBBuscar))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellido)
                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLEstado)
                    .addComponent(jRBEstado))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLFechaNacimiento)
                    .addComponent(jDCHFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNuevo)
                    .addComponent(jBEliminar)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        limpiar();
        botonAnterior = jBNuevo;
        editarAlumno(true);
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        try {
            eliminadologico();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormularioAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed

        if (jTDocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes escribir un documento");

        } else {
            botonAnterior = jBBuscar;
            try {
                buscarxDni();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormularioAlumno.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FormularioAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
            editarAlumno(true);

        }

    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        try {
            if (jTDocumento.getText().isEmpty() || jTApellido.getText().isEmpty() || jTNombre.getText().isEmpty() || jDCHFechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(null, "No debe dejar algun dato vacio");
            } else {
                guardar();
                limpiar();
                editarAlumno(false);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "exception " + ex);
        }


    }//GEN-LAST:event_jBGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBSalir;
    private com.toedter.calendar.JDateChooser jDCHFechaNacimiento;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLDocumento;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLFechaNacimiento;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JRadioButton jRBEstado;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTDocumento;
    private javax.swing.JTextField jTNombre;
    // End of variables declaration//GEN-END:variables

    private void salirAplicacion() {
        int respuesta = JOptionPane.showConfirmDialog(this, "Estas seguro que quieres salir?", "Salir de la aplicacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);//cierra la aplicacion
        }
    }

    private void limpiar() {
        jTDocumento.setText("");
        jTApellido.setText("");
        jTNombre.setText("");
        jDCHFechaNacimiento.setCalendar(null);
        jRBEstado.setSelected(false);
        //jRBEstado.setDisabledIcon(null);
        botonAnterior = null;

    }

    private void eliminadologico() throws ClassNotFoundException, SQLException {

        if (botonAnterior == jBBuscar) {
            AlumnoDAO alumnoD = new AlumnoDAO();
            //Alumno alumno = new Alumno();
            int dni = Integer.parseInt(jTDocumento.getText());

            try {
                alumnoD.eliminarLogico(dni);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "exception " + ex);
            }
        }
    }

    private void editarAlumno(boolean editar) {

        jTDocumento.setEditable(true);
        jTApellido.setEditable(editar);
        jTNombre.setEditable(editar);
        jDCHFechaNacimiento.setEnabled(editar);
        //el boton enable es verdadero cuando boton anterior es JBNuevo falso lo contrario
        jRBEstado.setEnabled(botonAnterior == jBNuevo);

    }

    private void buscarxDni() throws ClassNotFoundException, SQLException {
        //Alumno alumno = new Alumno();
        AlumnoDAO alumnoDao = new AlumnoDAO();

        int dni = Integer.parseInt(jTDocumento.getText());
        try {
            //alumno = null;
            Alumno alumno = alumnoDao.buscarListaAlumnoxDni(dni);
            //System.out.println(alumno);
            jTApellido.setText(alumno.getApellido());
            jTNombre.setText(alumno.getNombre());
            jDCHFechaNacimiento.setDate(Date.valueOf(alumno.getFechaNacimiento()));
            if (alumno.isEstado()) {
                setTitle("Cargar Alumno");
                jRBEstado.setSelected(alumno.isEstado());
            }else{
                setTitle("Cargar Alumno -- DNI dado de Baja");
                jRBEstado.setSelected(alumno.isEstado());
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el DNI");
            //JOptionPane.showMessageDialog(null, "exception " + ex);
        }
    }

    private void guardar() throws Exception {
        AlumnoDAO alumnoD = new AlumnoDAO();
        Alumno alumno = new Alumno();

        try {
            int documento = Integer.parseInt(jTDocumento.getText());
            String apellido = jTApellido.getText();
            String nombre = jTNombre.getText();
            LocalDate fechaNacimiento = jDCHFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            boolean estado = jRBEstado.isSelected();

            // Asignar los valores al objeto alumno
            alumno.setDni(documento);
            alumno.setApellido(apellido);
            alumno.setNombre(nombre);
            alumno.setFechaNacimiento(fechaNacimiento);
            alumno.setEstado(estado);

            // Llamar al método para guardar el alumno en la base de datos
            //solo grabar si fue elegida la opcion Nuevo - boton
            if (botonAnterior == jBNuevo) {

                alumnoD.guardarAlumno(alumno);
            } else {

                alumnoD.modificarAlumno(alumno);
            }

        } catch (NumberFormatException e) {
            // Manejar una excepción si no se pudo convertir el número
            e.printStackTrace();
        }
    }
        
       
    }

