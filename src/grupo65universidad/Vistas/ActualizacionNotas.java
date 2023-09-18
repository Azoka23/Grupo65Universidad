package grupo65universidad.Vistas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import grupo65universidad.AccesoADatos.AlumnoDAO;
import grupo65universidad.AccesoADatos.InscripcionDAO;
import grupo65universidad.Entidades.Alumno;
import grupo65universidad.Entidades.Materia;

public class ActualizacionNotas extends javax.swing.JInternalFrame {

    //private DefaultTableModel modelo;
    private JSpinner spinner;
    private JButton guardarButton;
    private int selectedRow;
    private int selectedColumn;
    private Alumno selectedAlumno = null;
    private int idMateria = 0;
    private int idAlumno = 0;
    //private int firstName = 0;
// Define una variable de instancia para almacenar el valor original de la celda
    private int originalNota = 0;
// Define una variable de instancia para almacenar el valor actual de la celda
    private int currentNota = 0;
    private DefaultTableModel modelo = new DefaultTableModel() {

        public boolean isCellEditable(int fila, int columna) {

            // Habilitar la edición solo en la tercera columna (columna índice 2)
            return columna == 2;
            //return false;
        }
    };

    /**
     * Creates new form ActualizacionNotas
     */
    public ActualizacionNotas() {
        initComponents();
        armarCabecera();
        try {
            cargarCombo();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "erro, driver " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error,sql " + ex);
        }
////        // Agregar un oyente para manejar la edición de celdas
////        jTNotas.addMouseListener(new MouseAdapter() {
////            @Override
////            public void mouseClicked(MouseEvent e) {
////                int selectedRow = jTNotas.getSelectedRow();
////                int selectedColumn = jTNotas.getSelectedColumn();
////
////                if (selectedRow != -1 && selectedColumn == 2) {
////                    Object currentNotaObj = jTNotas.getValueAt(selectedRow, selectedColumn);
////                    Object columna0Obj = jTNotas.getValueAt(selectedRow, 0);
////
////                if (currentNotaObj instanceof Integer && columna0Obj instanceof Integer) {
////                    currentNota = (int) currentNotaObj;
////                    idMateria = (int) columna0Obj;
////                    
////                        if (originalNota == 0) {
////                            originalNota = currentNota;
////                        }
////                    } else {
////                        // Manejar el caso en que los valores no sean enteros válidos
////                        JOptionPane.showMessageDialog(null, "El valor no es un número entero válido.");
////                    }
////                }
////            }
////        });
////
////        // Agregar un oyente para manejar la edición de celdas con Enter
////        jTNotas.addKeyListener(new java.awt.event.KeyAdapter() {
////            @Override
////            public void keyPressed(java.awt.event.KeyEvent evt) {
////                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
////                    int selectedRow = jTNotas.getSelectedRow();
////                    int selectedColumn = jTNotas.getSelectedColumn();
////
////                    if (selectedRow != -1 && selectedColumn == 2) {
////                        try {
////                            String newCellValue = JOptionPane.showInputDialog("Ingrese la nueva nota:");
////                            int newNota = Integer.parseInt(newCellValue);
////
////                            // Actualizar la celda y el valor actual
////                            jTNotas.setValueAt(newNota, selectedRow, selectedColumn);
////                            currentNota = newNota;
////                        } catch (NumberFormatException ex) {
////                            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entero válido.");
////                        }
////                    }
////                }
////            }
////        });

        // Agregar un oyente para manejar la edición de celdas
        jTNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTNotas.getSelectedRow();
                int selectedColumn = jTNotas.getSelectedColumn();

                if (selectedRow != -1 && selectedColumn == 2) {
                    int originalValue = (int) jTNotas.getValueAt(selectedRow, selectedColumn);
                    // Obtener idMateria de la columna 0
                    idMateria = (int) jTNotas.getValueAt(selectedRow, 0);
                    // Mostrar el JSpinner con el valor original y idMateria
                    showSpinner(originalValue, selectedRow, selectedColumn, idMateria);
                }
            }
        });

    }

    private void showSpinner(int initialValue, int row, int column, int idMateria) {
        // Crear un JDialog para mostrar el JSpinner
        JDialog dialog = new JDialog();
        dialog.setTitle("Editar Nota");
        dialog.setSize(200, 100);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setLayout(new FlowLayout());

        // Configurar el JSpinner
        SpinnerModel spinnerModel = new SpinnerNumberModel(initialValue, 0, 10, 1);
        spinner = new JSpinner(spinnerModel);

        // Botón "Guardar" para confirmar la selección
        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newValue = (int) spinner.getValue();
                currentNota=newValue;
                // Actualizar la celda en la tabla con el nuevo valor
                jTNotas.setValueAt(newValue, row, column);
//                // También tienes acceso a idMateria aquí
//                JOptionPane.showMessageDialog(null, "idMateria: " + idMateria);

                // Cerrar el diálogo
                dialog.dispose();
            }
        });

        // Agregar componentes al diálogo
        dialog.add(spinner);
        dialog.add(guardarButton);

        // Mostrar el diálogo centrado
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLSeleccionarAlumno = new javax.swing.JLabel();
        jCBSeleccionarAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTNotas = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 51));
        setClosable(true);
        setTitle("Carga de notas");

        jLSeleccionarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        jLSeleccionarAlumno.setText("Seleccione un alumno");

        jCBSeleccionarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSeleccionarAlumnoActionPerformed(evt);
            }
        });

        jTNotas.setForeground(new java.awt.Color(0, 0, 0));
        jTNotas.setModel(new javax.swing.table.DefaultTableModel(
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
        jTNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTNotas);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLSeleccionarAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBSeleccionarAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalir)
                        .addGap(78, 78, 78)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSeleccionarAlumno)
                    .addComponent(jCBSeleccionarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCBSeleccionarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSeleccionarAlumnoActionPerformed
        selectedAlumno = (Alumno) jCBSeleccionarAlumno.getSelectedItem();
//        flagCombo = true;
        if (selectedAlumno != null) {
            // Realiza la carga de la tabla según el ítem seleccionado
            // Por ejemplo, llama a un método cargarTabla(selectedItem)
            //JOptionPane.showMessageDialog(null, "Por favor seleccione una fila");
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            try {
                idAlumno = selectedAlumno.getIdAlumno();
                cargarTabla(selectedAlumno.getIdAlumno());
            } catch (Exception ex) {
                Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jCBSeleccionarAlumnoActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

// Si el valor actual es igual al valor original, no realizar la operación de guardado
//        if (currentNota == originalNota) {
//            //System.out.println("La nota no ha cambiado. No se realizará el guardado.");
//            JOptionPane.showMessageDialog(null, "La nota no ha cambiado. No se realizara el guardado.");
//        } else {
            // Realiza la operación de guardado porque la nota ha cambiado
            //System.out.println("Valor de la nota modificada: " + currentNota);
            // Llama a tu método de guardar y pasa currentNota como parámetro
            // guardarValorNota(currentNota);

            try {
                InscripcionDAO actualizarNota = null;
                actualizarNota = new InscripcionDAO();
                //JOptionPane.showMessageDialog(null, "no se rompe");
                //JOptionPane.showMessageDialog(null, idAlumno + "--" + idMateria + "--" + currentNota);
                actualizarNota.actualizarNota(idAlumno, idMateria, currentNota);
                originalNota = currentNota; // Actualiza el valor original después del guardado
                //JOptionPane.showMessageDialog(null, "Guardado exitosamente.");
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "error "+ex);
            }
        //}


    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jTNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNotasMouseClicked


    }//GEN-LAST:event_jTNotasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBSeleccionarAlumno;
    private javax.swing.JLabel jLSeleccionarAlumno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTNotas;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        jTNotas.setModel(modelo);
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
            jCBSeleccionarAlumno.addItem(alumno);
        }
    }

    private void cargarTabla(int idAlumno) throws Exception {
        int nota;
        //JOptionPane.showMessageDialog(null, idAlumno);
        InscripcionDAO cursadas = new InscripcionDAO();
        Collection<Materia> listaMaterias = new ArrayList<>(); // Inicialización predeterminada

        //if (jRBMInscriptas.isSelected() && !jRBMNoInscriptas.isSelected()) {
        listaMaterias = cursadas.obtenerMateriaCursada(idAlumno);
        // } else if (!jRBMInscriptas.isSelected() && jRBMNoInscriptas.isSelected()) {
        //    listaMaterias = cursadas.obtenerMateriaNOCursada(idAlumno);
        // }

        for (Materia tipo : listaMaterias) {

            //JOptionPane.showMessageDialog(null, idAlumno+"--"+tipo.getIdMateria());
            nota = cursadas.buscarNota(idAlumno, tipo.getIdMateria());
            modelo.addRow(new Object[]{tipo.getIdMateria(), tipo.getNombre(), nota});

        }
        //modelo.addRow(new Object[]{producto.getNombre(), producto.getCategoria(), producto.getPrecio()});

    }
}
