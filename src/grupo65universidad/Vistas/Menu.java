/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package grupo65universidad.Vistas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author wbasa
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Menu() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jDatosAlumnos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jDatosMaterias = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jManejoInscripciones = new javax.swing.JMenuItem();
        jManipulacionNotas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jConsultasMaterias = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jEscritorio.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jEscritorioLayout = new javax.swing.GroupLayout(jEscritorio);
        jEscritorio.setLayout(jEscritorioLayout);
        jEscritorioLayout.setHorizontalGroup(
            jEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
        );
        jEscritorioLayout.setVerticalGroup(
            jEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumno");

        jDatosAlumnos.setText("Formulario Alumno");
        jDatosAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDatosAlumnosActionPerformed(evt);
            }
        });
        jMenu1.add(jDatosAlumnos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        jDatosMaterias.setText("Formulario Materia");
        jDatosMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDatosMateriasActionPerformed(evt);
            }
        });
        jMenu2.add(jDatosMaterias);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Administracion");

        jManejoInscripciones.setText("Manejo de Inscripciones ");
        jManejoInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jManejoInscripcionesActionPerformed(evt);
            }
        });
        jMenu3.add(jManejoInscripciones);

        jManipulacionNotas.setText("Manipulacion de Notas");
        jManipulacionNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jManipulacionNotasActionPerformed(evt);
            }
        });
        jMenu3.add(jManipulacionNotas);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Consultas");

        jConsultasMaterias.setText("Alumnos por Materia");
        jConsultasMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultasMateriasActionPerformed(evt);
            }
        });
        jMenu5.add(jConsultasMaterias);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Salir");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jEscritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDatosAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatosAlumnosActionPerformed
        jEscritorio.removeAll();
        jEscritorio.repaint();

        FormularioAlumno cargarAlumnoProbandoVista = new FormularioAlumno();
        cargarAlumnoProbandoVista.setVisible(true);
        jEscritorio.add(cargarAlumnoProbandoVista);
        jEscritorio.moveToFront(cargarAlumnoProbandoVista);


    }//GEN-LAST:event_jDatosAlumnosActionPerformed

    private void jConultaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConultaEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jConultaEmpleadoActionPerformed

    private void jManejoInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jManejoInscripcionesActionPerformed

        jEscritorio.removeAll();
        jEscritorio.repaint();

        Inscripciones cargarIncrpcion = new Inscripciones();
        cargarIncrpcion.setVisible(true);
        jEscritorio.add(cargarIncrpcion);
        jEscritorio.moveToFront(cargarIncrpcion);
    }//GEN-LAST:event_jManejoInscripcionesActionPerformed

    private void jDatosMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatosMateriasActionPerformed

        jEscritorio.removeAll();
        jEscritorio.repaint();

        FormularioMateria cargarMateria = new FormularioMateria();
        cargarMateria.setVisible(true);
        jEscritorio.add(cargarMateria);
        jEscritorio.moveToFront(cargarMateria);


    }//GEN-LAST:event_jDatosMateriasActionPerformed

    private void jManipulacionNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jManipulacionNotasActionPerformed


            jEscritorio.removeAll();
        jEscritorio.repaint();

        ActualizacionNotas cargarNotas = new ActualizacionNotas();
        cargarNotas.setVisible(true);
        jEscritorio.add(cargarNotas);
        jEscritorio.moveToFront(cargarNotas);
    }//GEN-LAST:event_jManipulacionNotasActionPerformed

    private void jConsultasMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultasMateriasActionPerformed


            jEscritorio.removeAll();
        jEscritorio.repaint();

        ConsultaAlumnosxMateria alumnosxMateria = new ConsultaAlumnosxMateria();
        alumnosxMateria.setVisible(true);
        jEscritorio.add(alumnosxMateria);
        jEscritorio.moveToFront(alumnosxMateria);
    }//GEN-LAST:event_jConsultasMateriasActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed

 dispose();  

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jConsultasMaterias;
    private javax.swing.JMenuItem jDatosAlumnos;
    private javax.swing.JMenuItem jDatosMaterias;
    private javax.swing.JDesktopPane jEscritorio;
    private javax.swing.JMenuItem jManejoInscripciones;
    private javax.swing.JMenuItem jManipulacionNotas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
