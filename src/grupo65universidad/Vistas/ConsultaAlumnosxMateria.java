package grupo65universidad.Vistas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import grupo65universidad.AccesoADatos.InscripcionDAO;
import grupo65universidad.AccesoADatos.MateriaDAO;
import grupo65universidad.Entidades.Alumno;
import grupo65universidad.Entidades.Materia;

public class ConsultaAlumnosxMateria extends javax.swing.JInternalFrame {

    private Materia selectedMateria = null;
    private int idMateria = 0;
    private int idAlumno = 0;
    private MateriaDAO materiaDao;
    private InscripcionDAO inscripcionDao;
    private DefaultTableModel modelo = new DefaultTableModel() {

        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    /**
     * Creates new form ConsultaAlumnosxMateria
     */
    public ConsultaAlumnosxMateria() {
        try {
            initComponents();
            materiaDao = new MateriaDAO();
            inscripcionDao = new InscripcionDAO();

           armarCabecera();
            cargarCombo();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "error: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "error: " + ex);
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

        jLSeleccionarMateria = new javax.swing.JLabel();
        jCBSeleccionarMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaterias = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 51));
        setClosable(true);
        setTitle("Listado de alumnos por materia");

        jLSeleccionarMateria.setForeground(new java.awt.Color(0, 0, 0));
        jLSeleccionarMateria.setText("Seleccione una materia");

        jCBSeleccionarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSeleccionarMateriaActionPerformed(evt);
            }
        });

        jTMaterias.setForeground(new java.awt.Color(0, 0, 0));
        jTMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTMaterias);

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
                .addGap(32, 32, 32)
                .addComponent(jLSeleccionarMateria)
                .addGap(18, 18, 18)
                .addComponent(jCBSeleccionarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBSalir)
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSeleccionarMateria)
                    .addComponent(jCBSeleccionarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBSeleccionarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSeleccionarMateriaActionPerformed

        selectedMateria = (Materia) jCBSeleccionarMateria.getSelectedItem();
        if (selectedMateria != null) {
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            try {
                idMateria = selectedMateria.getIdMateria();
                cargarTabla(selectedMateria.getIdMateria());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "error: " + ex);
            }
        }


    }//GEN-LAST:event_jCBSeleccionarMateriaActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        salirAplicacion();
    }//GEN-LAST:event_jBSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Materia> jCBSeleccionarMateria;
    private javax.swing.JLabel jLSeleccionarMateria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMaterias;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("Id");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        jTMaterias.setModel(modelo);
    }

    private void cargarCombo() throws ClassNotFoundException, SQLException {

        try {
            Collection<Materia> materias = materiaDao.listarMaterias();
            for (Materia materia : materias) {
                jCBSeleccionarMateria.addItem(materia);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void cargarTabla(int idMateria) throws Exception {
        try {
            Collection<Alumno> listaAlumno = inscripcionDao.obtenerAlumnoxMateria(idMateria);
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            for (Alumno alumno : listaAlumno) {
                modelo.addRow(new Object[]{alumno.getIdAlumno(), alumno.getDni(), alumno.getApellido(), alumno.getNombre()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }

    }

    private void salirAplicacion() {
        if (confirmarSalida()) {
            dispose();
        }
    }

    private boolean confirmarSalida() {
        int confirmacion = JOptionPane.showOptionDialog(
                this,
                "¿Estás seguro que quieres salir de la aplicación?",
                "Salir de la aplicación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Sí", "No"},
                "No" // Botón por defecto
        );

        return confirmacion == JOptionPane.YES_OPTION;
    }
}
