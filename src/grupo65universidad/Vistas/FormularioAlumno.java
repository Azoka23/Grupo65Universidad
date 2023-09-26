package grupo65universidad.Vistas;


import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import grupo65universidad.AccesoADatos.AlumnoDAO;
import grupo65universidad.Entidades.Alumno;
import java.sql.Date;
import javax.swing.JButton;

public class FormularioAlumno extends javax.swing.JInternalFrame {

    private JButton botonAnterior = null; // Variable para almacenar el botón anterior

    /**
     * Creates new form InfoAlumno
     */
    public FormularioAlumno() {
        initComponents();
        setTitle("Cargar Alumno");
        // Establecer el foco en jTDocumento
        jTDocumento.requestFocusInWindow();

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
        setVisible(false);

        jLDocumento.setText("Documento");

        jTDocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grupo65universidad/Vistas/Imagenes/search_find_lupa_21889.png"))); // NOI18N
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLApellido.setText("Apellido");

        jLNombre.setText("Nombre");

        jLEstado.setText("Estado");

        jRBEstado.setBackground(new java.awt.Color(0, 51, 51));

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLApellido)
                            .addComponent(jLNombre)
                            .addComponent(jLEstado))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(jTApellido)
                                    .addComponent(jTNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBBuscar)
                                .addGap(59, 59, 59))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jDCHFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jRBEstado))
                                .addGap(0, 0, Short.MAX_VALUE))))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLEstado)
                        .addGap(7, 7, 7)
                        .addComponent(jLFechaNacimiento))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBEstado))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDCHFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
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
        salirAplicacion();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        limpiar();
        botonAnterior = jBNuevo;

    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed

        eliminadologico();


    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        String documento = jTDocumento.getText().trim();

        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes escribir un documento");
            return;
        } else {
            limpiarBuscar();
            botonAnterior = jBBuscar;
            try {
                buscarxDni();
            } catch (ClassNotFoundException ex) {
                Utilidades.mostrarError(ex,this);
            } catch (SQLException ex) {
                Utilidades.mostrarError(ex,this);
            }

        }


    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        try {
            if (jTDocumento.getText().isEmpty() || jTApellido.getText().isEmpty() || jTNombre.getText().isEmpty() || jDCHFechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(this, "No debe dejar algun dato vacio");
            } else {
               if (botonAnterior == jBNuevo||botonAnterior==jBBuscar) {

                    guardar();
                    limpiar();

                } else {

                    JOptionPane.showMessageDialog(this, "Elija buscar o Nuevo DNI");
                    limpiar();
                }

            }

        } catch (Exception ex) {
            Utilidades.mostrarError(ex,this);
          //  JOptionPane.showMessageDialog(this, "exception " + ex);
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
        if (Utilidades.confirmarSalida(this)) {
            dispose();
        }
    }

    private void limpiar() {
    
        Utilidades.limpiarSetText(jTDocumento, jTApellido, jTNombre);
        jDCHFechaNacimiento.setCalendar(null);
        jRBEstado.setSelected(false);

        botonAnterior = null;

    }

    private void limpiarBuscar() {
        Utilidades.limpiarSetText(jTApellido, jTNombre);
        jDCHFechaNacimiento.setCalendar(null);

    }

    private void eliminadologico() {
        if (botonAnterior == jBBuscar) {
            try {
                int dni = Integer.parseInt(jTDocumento.getText());
                AlumnoDAO alumnoD = new AlumnoDAO();
                alumnoD.eliminarLogico(dni);
                JOptionPane.showMessageDialog(this, "El alumno fue dado de baja");
                limpiar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de documento válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Se produjo un error al eliminar el alumno.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de documento que exista.");
        }
    }

    private void buscarxDni() throws ClassNotFoundException, SQLException {

        AlumnoDAO alumnoDao = new AlumnoDAO();
        int dni = 0;
        try {
            dni = Integer.parseInt(jTDocumento.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Debes ingresar un número de documento válido.");
            return;
        }

        try {

            Alumno alumno = alumnoDao.buscarListaAlumnoxDni(dni);
            if (alumno == null) {
                botonAnterior = jBNuevo;
            }

            mostrarAlumnoEnFormulario(alumno);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se encontro el DNI");
        }
    }

    private void guardar() throws Exception {
        AlumnoDAO alumnoD = new AlumnoDAO();
        Alumno alumno = new Alumno();
        int documento;
        try {
            try {
                documento = Integer.parseInt(jTDocumento.getText());
                alumno = alumnoD.buscarListaAlumnoxDni(documento);
                
                if (alumno != null && botonAnterior == jBNuevo) {
                    JOptionPane.showMessageDialog(this, "El Documento ya existe, no puede darlo de Alta.");
                    return;
                }else{
                    alumno = new Alumno();
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: Debes ingresar un número de documento válido.");
                return;
            }
  
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
                try {
                    alumno.setEstado(true);
                    alumnoD.guardarAlumno(alumno);
                } catch (Exception ex) {
                    Utilidades.mostrarError(ex,this);
                }

           } else if ((botonAnterior == jBBuscar)) {
 
                alumnoD.modificarAlumno(alumno);
            }

        } catch (NumberFormatException ex) {
           Utilidades.mostrarError(ex,this);
        }
    }

    private void mostrarAlumnoEnFormulario(Alumno alumno) {

        jTApellido.setText(alumno.getApellido());
        jTNombre.setText(alumno.getNombre());
        jDCHFechaNacimiento.setDate(Date.valueOf(alumno.getFechaNacimiento()));

        if (alumno.isEstado()) {
            setTitle("Cargar Alumno");
        } else {
            setTitle("Cargar Alumno -- DNI dado de Baja");
        }

        jRBEstado.setSelected(alumno.isEstado());
    }
}
