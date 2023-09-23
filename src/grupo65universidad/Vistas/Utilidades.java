
package grupo65universidad.Vistas;

import javax.swing.JOptionPane;

public class Utilidades {
    
        public static boolean confirmarSalida() {
        int confirmacion = JOptionPane.showOptionDialog(
            null,
            "¿Estás seguro que quieres salir de la aplicación?",
            "Salir de la aplicación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Sí", "No"},
            "No"
        );

        return confirmacion == JOptionPane.YES_OPTION;
    }
    
        public static void limpiarSetText(javax.swing.JTextField... campos) {
        for (javax.swing.JTextField campo : campos) {
            campo.setText("");
        }
    }
}
