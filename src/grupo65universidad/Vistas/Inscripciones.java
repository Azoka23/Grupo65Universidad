package grupo65universidad.Vistas;

import grupo65universidad.AccesoADatos.AlumnoDAO;
import grupo65universidad.AccesoADatos.InscripcionDAO;
import grupo65universidad.Entidades.Alumno;
import grupo65universidad.Entidades.Materia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Inscripciones extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {

        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    /**
     * Creates new form Inscripciones
     */
    public Inscripciones() {
        initComponents();
        armarCabecera();
        jRBMNoInscriptas.setSelected(true);
        try {
            cargarCombo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLSeleccionAlumno = new javax.swing.JLabel();
        jCBSeleccionAlumno = new javax.swing.JComboBox<>();
        jLListadoMaterias = new javax.swing.JLabel();
        jRBMInscriptas = new javax.swing.JRadioButton();
        jRBMNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMaterias = new javax.swing.JTable();
        jBInscribir = new javax.swing.JButton();
        jBAnularInscripcion = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 51));
        setClosable(true);
        setTitle("Formulario de Inscripcion");

        jLSeleccionAlumno.setForeground(new java.awt.Color(255, 255, 255));
        jLSeleccionAlumno.setText("Seleccione un alumno :");

        jCBSeleccionAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSeleccionAlumnoActionPerformed(evt);
            }
        });

        jLListadoMaterias.setForeground(new java.awt.Color(255, 255, 255));
        jLListadoMaterias.setText("Listado de Materias");

        jRBMInscriptas.setBackground(new java.awt.Color(0, 51, 51));
        jRBMInscriptas.setForeground(new java.awt.Color(255, 255, 255));
        jRBMInscriptas.setText("Materias Inscriptas");
        jRBMInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMInscriptasActionPerformed(evt);
            }
        });

        jRBMNoInscriptas.setBackground(new java.awt.Color(0, 51, 51));
        jRBMNoInscriptas.setForeground(new java.awt.Color(255, 255, 255));
        jRBMNoInscriptas.setText("Materias no Inscriptas");
        jRBMNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMNoInscriptasActionPerformed(evt);
            }
        });

        TablaMaterias.setForeground(new java.awt.Color(0, 0, 0));
        TablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaMaterias);

        jBInscribir.setText("Inscribir");

        jBAnularInscripcion.setText("Anular Inscripcion");

        jBSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLSeleccionAlumno)
                        .addGap(36, 36, 36)
                        .addComponent(jCBSeleccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jRBMInscriptas)
                        .addGap(143, 143, 143)
                        .addComponent(jRBMNoInscriptas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLListadoMaterias))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBInscribir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAnularInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jBSalir)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCBSeleccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSeleccionAlumno))
                .addGap(27, 27, 27)
                .addComponent(jLListadoMaterias)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRBMNoInscriptas)
                    .addComponent(jRBMInscriptas))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInscribir)
                    .addComponent(jBAnularInscripcion)
                    .addComponent(jBSalir))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBMNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMNoInscriptasActionPerformed
        Alumno selectedAlumno = (Alumno) jCBSeleccionAlumno.getSelectedItem();
        jRBMInscriptas.setSelected(false);
        jRBMNoInscriptas.setSelected(true);

        try {
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            cargarTabla(selectedAlumno.getIdAlumno());
        } catch (Exception ex) {
            Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRBMNoInscriptasActionPerformed

    private void jRBMInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMInscriptasActionPerformed
               Alumno selectedAlumno = (Alumno) jCBSeleccionAlumno.getSelectedItem();
        jRBMInscriptas.setSelected(true);
        jRBMNoInscriptas.setSelected(false);
        try {
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            cargarTabla(selectedAlumno.getIdAlumno());
        } catch (Exception ex) {
            Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        

    }//GEN-LAST:event_jRBMInscriptasActionPerformed

    private void jCBSeleccionAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSeleccionAlumnoActionPerformed
                Alumno selectedAlumno = (Alumno) jCBSeleccionAlumno.getSelectedItem();
        if (selectedAlumno != null) {
            // Realiza la carga de la tabla según el ítem seleccionado
            // Por ejemplo, llama a un método cargarTabla(selectedItem)
            //JOptionPane.showMessageDialog(null, "Por favor seleccione una fila");
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            try {
                cargarTabla(selectedAlumno.getIdAlumno());
            } catch (Exception ex) {
                Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jCBSeleccionAlumnoActionPerformed





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMaterias;
    private javax.swing.JButton jBAnularInscripcion;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBSeleccionAlumno;
    private javax.swing.JLabel jLListadoMaterias;
    private javax.swing.JLabel jLSeleccionAlumno;
    private javax.swing.JRadioButton jRBMInscriptas;
    private javax.swing.JRadioButton jRBMNoInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        //TablaMaterias.addColumn(aColumn);
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Year");
        TablaMaterias.setModel(modelo);
    }

    private void cargarCombo() throws ClassNotFoundException, SQLException {

        AlumnoDAO alumnoDao = new AlumnoDAO();

        Collection<Alumno> alumnos;
        alumnos = new ArrayList<>();

        try {
            alumnos = alumnoDao.listarAlumnos();
        } catch (Exception ex) {
            Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Llena el JComboBox con los valores del enum Categoria
        //JComboBox tiene que ser tipo Categoria
        for (Alumno alumno : alumnos) {
            jCBSeleccionAlumno.addItem(alumno);
        }
    }

    private void cargarTabla(int idAlumno) throws Exception {
        //listaProductos.add(new Producto(25, "Jabon", 250.25, 5, Rubro.Limpieza));
        //JOptionPane.showMessageDialog(null, idAlumno);
        InscripcionDAO cursadas = new InscripcionDAO();
        Collection<Materia> listaMaterias = new ArrayList<>(); // Inicialización predeterminada

        if (jRBMInscriptas.isSelected() && !jRBMNoInscriptas.isSelected()) {
            listaMaterias = cursadas.obtenerMateriaCursada(idAlumno);
        } else if (!jRBMInscriptas.isSelected() && jRBMNoInscriptas.isSelected()) {
            listaMaterias = cursadas.obtenerMateriaNOCursada(idAlumno);
        }

        for (Materia tipo : listaMaterias) {

            modelo.addRow(new Object[]{tipo.getIdMateria(), tipo.getNombre(), tipo.getAnio()});

        }
        //modelo.addRow(new Object[]{producto.getNombre(), producto.getCategoria(), producto.getPrecio()});

    }

}
