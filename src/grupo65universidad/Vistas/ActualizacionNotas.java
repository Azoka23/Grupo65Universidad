
package grupo65universidad.Vistas;

import javax.swing.table.DefaultTableModel;


public class ActualizacionNotas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ActualizacionNotas
     */
    public ActualizacionNotas() {
        initComponents();
        armarCabecera();
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

        setBackground(new java.awt.Color(102, 153, 0));
        setClosable(true);
        setTitle("Carga de notas");

        jLSeleccionarAlumno.setText("Seleccione un alumno");

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
        jScrollPane1.setViewportView(jTNotas);

        jBGuardar.setText("Guardar");

        jBSalir.setText("Salir");

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCBSeleccionarAlumno;
    private javax.swing.JLabel jLSeleccionarAlumno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTNotas;
    // End of variables declaration//GEN-END:variables

private DefaultTableModel modelo=new DefaultTableModel()
{public boolean isCellEditable(int fila,int columna){
return true;//o return false
// o if(columna==2){}
}
};

private void armarCabecera(){
modelo.addColumn("Codigo");
modelo.addColumn("Nombre");
modelo.addColumn("Nota");
}

}
